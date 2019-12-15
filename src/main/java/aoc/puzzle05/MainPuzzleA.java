package aoc.puzzle05;

import static aoc.FileLoader.findFile;
import static java.nio.file.Files.lines;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainPuzzleA {

	private static final Map<Integer, IntCodeCmd> cmdMap = new HashMap<>();
	static {
		cmdMap.put(1, new OpCodeAdd());
		cmdMap.put(2, new OpCodeMult());
		cmdMap.put(3, new OpCodeRead());
		cmdMap.put(4, new OpCodeWrite());
		cmdMap.put(99, new OpCodeExit());
	}

	public static void main(String[] args) throws IOException {
		IntCodeValue[] memory = lines(findFile("p5.txt")).map(line -> line.split(",")).flatMap(Arrays::stream)
				.map(IntCodeValue::new).toArray(IntCodeValue[]::new);

		System.out.println(new IntCodeProgram(new IntCodeMemory(memory), cmdMap).start());
	}

}
