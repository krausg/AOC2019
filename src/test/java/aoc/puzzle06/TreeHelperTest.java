package aoc.puzzle06;

import static aoc.FileLoader.findFile;
import static java.nio.file.Files.lines;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class TreeHelperTest {

	TreeHelper counter = new TreeHelper();

	@Test
	public void testAOCA1() throws IOException {
		Map<String, List<String>> edgeConnections = lines(findFile("p61.txt")).map(line -> line.split("\\)"))
				.collect(Collectors.toMap(x -> x[0], x -> new ArrayList<>(Arrays.asList(x[1])), (x, y) -> {
					x.addAll(y);
					return x;
				}));
		assertEquals(42, counter.countAllConnections(edgeConnections, "COM"));

	}

	@Test
	public void testAOCB1() throws IOException {
		Map<String, List<String>> edgeConnections = lines(findFile("p62.txt")).map(line -> line.split("\\)"))
				.collect(Collectors.toMap(x -> x[0], x -> new ArrayList<>(Arrays.asList(x[1])), (x, y) -> {
					x.addAll(y);
					return x;
				}));
		assertEquals(4, counter.findClosestConnection(edgeConnections, "YOU", "SAN"));

	}

}
