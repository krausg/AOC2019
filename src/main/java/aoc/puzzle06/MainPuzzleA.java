package aoc.puzzle06;

import static aoc.FileLoader.findFile;
import static java.nio.file.Files.lines;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainPuzzleA {

	public static void main(String[] args) throws IOException {
		Map<String, List<String>> edgeConnections = lines(findFile("p6.txt")).map(line -> line.split("\\)"))
				.collect(Collectors.toMap(x -> x[0], x -> new ArrayList<>(Arrays.asList(x[1])), (x, y) -> {
					x.addAll(y);
					return x;
				}));

		System.out.println(new TreeHelper().countAllConnections(edgeConnections, "COM"));
	}

}
