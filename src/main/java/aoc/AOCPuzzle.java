package aoc;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import time.projects.fileconverter.FileConverter;
import time.projects.fileconverter.LineProcessor;
import time.projects.fileconverter.entities.Line;
import time.projects.fileconverter.postconvert.FilePostConvert;
import time.projects.fileconverter.reader.ConverterScanner;

public abstract class AOCPuzzle<T extends Line> {
	private static String PUZZLE_NAME = "";
	private FileConverter<T> conv = new FileConverter<T>();

	protected void setEingabeDateiName(String eingabeDateiName) {
		PUZZLE_NAME = eingabeDateiName;
	}

	protected void addPostConverters(FilePostConvert<?>... postConverters) {
		conv.getPostConverter().addAll(Arrays.asList(postConverters));
	}

	protected void setConverterReader(ConverterScanner<T> scanner) {
		conv.setScanner(scanner);
	}

	protected void addLineProcessors(LineProcessor<T>... lineProcessors) {
		conv.getLineProcessors().addAll(Arrays.asList(lineProcessors));

	}

	protected abstract void setup();

	protected static <T extends Line> Collection<T> startSolving(AOCPuzzle<T> aocPuzzle) throws IOException {
		aocPuzzle.setup();
		aocPuzzle.conv.getFiles().addAll(FileLoader.listAllFiles(PUZZLE_NAME));
		return aocPuzzle.conv.convert();
	}
}
