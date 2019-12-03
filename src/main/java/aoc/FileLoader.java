package aoc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;

import aoc.puzzle01.MainPuzzleA;

public class FileLoader {
	public static Collection<? extends Path> listAllFiles(String ordner) throws IOException {
		try {
			return Files.list(Paths.get(MainPuzzleA.class.getClassLoader().getResource("./").toURI()))
					.filter(f -> f.endsWith(ordner)).collect(Collectors.toList());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
}
