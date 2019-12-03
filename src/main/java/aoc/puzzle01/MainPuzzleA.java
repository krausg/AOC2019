package aoc.puzzle01;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import aoc.FileLoader;
import time.projects.fileconverter.FileConverter;
import time.projects.fileconverter.LineProcessor;
import time.projects.fileconverter.postconvert.FilePostConvert;
import time.projects.fileconverter.reader.LineScanner;

public class MainPuzzleA {

	public static final String PUZZLE_NAME = "p1.txt";
	final static List<FilePostConvert<?>> puzzlePostConvert = Arrays.asList(/**/
			new SumFuelPostConvert()
	/**/);

	final static List<LineProcessor<NumberLine>> puzzleLineProcessor = Arrays.asList(/**/
			new FuelRequirementsLineProcessor()
	/**/);

	public static void main(String[] args) throws IOException {
		FileConverter<NumberLine> conv = new FileConverter<>();
		conv.getPostConverter().addAll(puzzlePostConvert);
		conv.getLineProcessors().addAll(puzzleLineProcessor);
		conv.setScanner(new LineScanner<>(NumberLine.class));
		conv.getFiles().addAll(FileLoader.listAllFiles(PUZZLE_NAME));
		Collection<NumberLine> convert = conv.convert();
		convert.forEach(System.out::println);
	}

}
