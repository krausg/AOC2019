package aoc.puzzle02;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import aoc.FileLoader;
import aoc.entities.IntCodeCmd;
import time.projects.fileconverter.FileConverter;
import time.projects.fileconverter.LineProcessor;
import time.projects.fileconverter.postconvert.FilePostConvert;

public class MainPuzzleA {

	public static final String PUZZLE_NAME = "p2.txt";
	final static List<FilePostConvert<?>> puzzlePostConvert = Arrays.asList(/**/
	// new SumFuelPostConvert()
	/**/);

	final static List<LineProcessor<IntCodeCmd>> puzzleLineProcessor = Arrays.asList(/**/
			new IntCodeProcessor()
	/**/);

	public static void main(String[] args) throws IOException {
		FileConverter<IntCodeCmd> conv = new FileConverter<>();
		conv.getPostConverter().addAll(puzzlePostConvert);
		conv.getLineProcessors().addAll(puzzleLineProcessor);
		conv.setScanner(new IntCodeScanner());
		conv.getFiles().addAll(FileLoader.listAllFiles(PUZZLE_NAME));
		Collection<IntCodeCmd> convert = conv.convert();
		convert.forEach(System.out::println);
	}
}
