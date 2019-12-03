package aoc.puzzle02;

import static aoc.puzzle02.IntCodeCmdScanner.createIntCodeCmds;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import aoc.FileLoader;
import time.projects.fileconverter.FileConverter;
import time.projects.fileconverter.LineProcessor;
import time.projects.fileconverter.postconvert.FilePostConvert;

public class MainPuzzleA5IT {

	public static final String PUZZLE_NAME = "p25.txt";
	final static List<FilePostConvert<?>> puzzlePostConvert = Arrays.asList(/**/
	/**/);

	final static List<LineProcessor<IntCodeCmd>> puzzleLineProcessor = Arrays.asList(/**/
			new IntCodeCmdProcessor()
	/**/);

	@Test
	public void testIT() throws IOException {
		FileConverter<IntCodeCmd> conv = new FileConverter<>();
		conv.getPostConverter().addAll(puzzlePostConvert);
		conv.getLineProcessors().addAll(puzzleLineProcessor);
		conv.setScanner(new IntCodeCmdScanner());
		conv.getFiles().addAll(FileLoader.listAllFiles(PUZZLE_NAME));
		List<IntCodeCmd> convert = new ArrayList<>(conv.convert());
		assertEquals(createIntCodeCmds(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50), convert);
	}
}
