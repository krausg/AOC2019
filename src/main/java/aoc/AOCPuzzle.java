package aoc;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import time.projects.fileconverter.FileConverter;
import time.projects.fileconverter.LineProcessor;
import time.projects.fileconverter.entities.Line;
import time.projects.fileconverter.postconvert.CollectionConverter;
import time.projects.fileconverter.reader.ConverterScanner;

public abstract class AOCPuzzle<T extends Line> {
	private static String PUZZLE_NAME = "";
	private FileConverter<T> conv = new FileConverter<T>();

	public void setEingabeDateiName(String eingabeDateiName) {
		PUZZLE_NAME = eingabeDateiName;
	}

	public void addPostConverters(CollectionConverter<?>... postConverters) {
		conv.getPostConverter().addAll(Arrays.asList(postConverters));
	}

	public void addPreConverters(CollectionConverter<T>... postConverters) {
		conv.getPreConverter().addAll(Arrays.asList(postConverters));
	}

	public void setConverterReader(ConverterScanner<T> scanner) {
		conv.setScanner(scanner);
	}

	public void addLineProcessors(LineProcessor<T>... lineProcessors) {
		conv.getLineProcessors().addAll(Arrays.asList(lineProcessors));
	}

	public abstract void setup();

	protected static <T extends Line> Collection<T> startSolving(AOCPuzzle<T> aocPuzzle) throws IOException {
		aocPuzzle.setup();
		aocPuzzle.conv.getFiles().addAll(FileLoader.findFiles(PUZZLE_NAME));
		return aocPuzzle.conv.convert();
	}
}
