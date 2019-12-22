package aoc.puzzle07;

import static aoc.FileLoader.findFile;
import static java.nio.file.Files.lines;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import aoc.puzzle05.IntCodeCmd;
import aoc.puzzle05.IntCodeMemory;
import aoc.puzzle05.IntCodeProgram;
import aoc.puzzle05.IntCodeValue;
import aoc.puzzle05.OpCodeAdd;
import aoc.puzzle05.OpCodeExit;
import aoc.puzzle05.OpCodeMult;
import aoc.puzzle05.OpCodeRead;
import aoc.puzzle05.OpCodeWrite;

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
		IntCodeMemory memory = new IntCodeMemory(lines(findFile("p7.txt")).map(line -> line.split(","))
				.flatMap(Arrays::stream).map(IntCodeValue::new).toArray(IntCodeValue[]::new));

		System.out.println(new IntCodeProgram(memory, cmdMap).start());
	}

}
