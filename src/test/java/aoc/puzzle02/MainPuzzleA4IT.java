package aoc.puzzle02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import aoc.FileLoader;
import aoc.entities.IntCodeCmd;
import time.projects.fileconverter.FileConverter;
import time.projects.fileconverter.LineProcessor;
import time.projects.fileconverter.postconvert.FilePostConvert;

public class MainPuzzleA4IT {

	public static final String PUZZLE_NAME = "p24.txt";
	final static List<FilePostConvert<?>> puzzlePostConvert = Arrays.asList(/**/
	/**/);

	final static List<LineProcessor<IntCodeCmd>> puzzleLineProcessor = Arrays.asList(/**/
			new IntCodeProcessor()
	/**/);

	@Test
	public void testIT() throws IOException {
		FileConverter<IntCodeCmd> conv = new FileConverter<>();
		conv.getPostConverter().addAll(puzzlePostConvert);
		conv.getLineProcessors().addAll(puzzleLineProcessor);
		conv.setScanner(new IntCodeScanner());
		conv.getFiles().addAll(FileLoader.listAllFiles(PUZZLE_NAME));
		List<IntCodeCmd> convert = new ArrayList<>(conv.convert());
		Assert.assertEquals(30, convert.get(0).getOpcodeCode());
	}
}
