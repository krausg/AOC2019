package aoc.puzzle05;

import static aoc.FileLoader.findFile;
import static java.nio.file.Files.lines;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainPuzzleB {

	public static final Map<Integer, IntCodeCmd> cmdMap = new HashMap<>();
	static {
		cmdMap.put(1, new OpCodeAdd());
		cmdMap.put(2, new OpCodeMult());
		cmdMap.put(3, new OpCodeRead(System.in));
		cmdMap.put(4, new OpCodeWrite());
		cmdMap.put(5, new OpCodeJumpIfNotNull());
		cmdMap.put(6, new OpCodeJumpIfNull());
		cmdMap.put(7, new OpCodeExprLessThan());
		cmdMap.put(8, new OpCodeExprEquals());
		cmdMap.put(99, new OpCodeExit());
	}

	public static void main(String[] args) throws IOException {
		System.out.println(run("p5.txt", cmdMap));
	}

	public static String run(String dateiname, Map<Integer, IntCodeCmd> cmdMap) throws IOException {
		IntCodeMemory memory = new IntCodeMemory(lines(findFile(dateiname)).map(line -> line.split(","))
				.flatMap(Arrays::stream).map(IntCodeValue::new).toArray(IntCodeValue[]::new));
		return new IntCodeProgram(memory, cmdMap).run();

	}
}
