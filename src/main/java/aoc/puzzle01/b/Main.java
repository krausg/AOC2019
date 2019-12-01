package aoc.puzzle01.b;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import aoc.NumberLine;
import aoc.puzzle01.RecursiveFuelRequirementsLineProcessor;
import aoc.puzzle01.SumFuelPostConvert;
import time.projects.fileconverter.FileConverter;
import time.projects.fileconverter.LineProcessor;
import time.projects.fileconverter.postconvert.FilePostConvert;
import time.projects.fileconverter.reader.LineScanner;

public class Main {

	public static final String PUZZLE_DIR = "p1";
	final static List<FilePostConvert<?>> puzzlePostConvert = Arrays.asList(/**/
			new SumFuelPostConvert()
	/**/);

	final static List<LineProcessor<NumberLine>> puzzleLineProcessor = Arrays.asList(/**/
			new RecursiveFuelRequirementsLineProcessor()
	/**/);

	public static void main(String[] args) throws IOException {
		FileConverter<NumberLine> conv = new FileConverter<>();
		conv.getPostConverter().addAll(puzzlePostConvert);
		conv.getLineProcessors().addAll(puzzleLineProcessor);
		conv.setScanner(new LineScanner<>(NumberLine.class));
		conv.getFiles().addAll(listAllFiles(PUZZLE_DIR));
		Collection<NumberLine> convert = conv.convert();
		convert.forEach(System.out::println);
	}

	private static Collection<? extends Path> listAllFiles(String ordner) throws IOException {
		try {
			return Files.list(Paths.get(Main.class.getClassLoader().getResource(ordner).toURI()))
					.filter(p -> !Files.isDirectory(p)).collect(Collectors.toList());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
}
