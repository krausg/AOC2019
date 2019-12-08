package aoc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import aoc.puzzle01.MainPuzzleA;

public class FileLoader {
	public static List<Path> findFiles(String file) throws IOException {
		try {
			return Files.list(Paths.get(MainPuzzleA.class.getClassLoader().getResource("./").toURI()))
					.filter(f -> f.endsWith(file)).collect(Collectors.toList());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public static Path findFile(String file) throws IOException {
		try {
			return Files.list(Paths.get(MainPuzzleA.class.getClassLoader().getResource("./").toURI()))
					.filter(f -> f.endsWith(file)).collect(Collectors.toList()).get(0);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
}
