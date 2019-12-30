package aoc.puzzle08;

import static aoc.puzzle08.ImageArrayUtils.arrayToLayerArray;
import static aoc.puzzle08.ImageArrayUtils.countOccurences;
import static aoc.puzzle08.ImageArrayUtils.loadImageArrayOfFile;
import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MainPuzzleA {

	public static void main(String[] args) throws IOException {
		List<int[]> imageLayers = arrayToLayerArray(loadImageArrayOfFile("p8.txt"), 25, 6);
		Map<Long, Long> zeroCountMultiplicatedMap = imageLayers.parallelStream().collect(
				toMap(x -> countOccurences(x, 0), x -> countOccurences(x, 1) * countOccurences(x, 2), (x, y) -> x));
		System.out.println(zeroCountMultiplicatedMap
				.get(zeroCountMultiplicatedMap.keySet().parallelStream().min(Long::compare).orElse((long) -1)));
	}

}
