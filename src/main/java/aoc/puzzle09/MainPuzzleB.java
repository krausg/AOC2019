package aoc.puzzle09;

import static aoc.FileLoader.findFile;
import static java.nio.file.Files.lines;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import aoc.puzzle05.IntCodeCmd;
import aoc.puzzle05.IntCodeController;
import aoc.puzzle05.IntCodeMemory;
import aoc.puzzle05.IntCodeProgram;
import aoc.puzzle05.IntCodeValue;
import aoc.puzzle05.OpCodeAdd;
import aoc.puzzle05.OpCodeExit;
import aoc.puzzle05.OpCodeExprEquals;
import aoc.puzzle05.OpCodeExprLessThan;
import aoc.puzzle05.OpCodeJumpIfFNull;
import aoc.puzzle05.OpCodeJumpIfNotNull;
import aoc.puzzle05.OpCodeMult;
import aoc.puzzle05.OpCodeRead;
import aoc.puzzle05.OpCodeWrite;

public class MainPuzzleB {

	private static final Map<Integer, IntCodeCmd> cmdMap = new HashMap<>();
	static {
		cmdMap.put(1, new OpCodeAdd());
		cmdMap.put(2, new OpCodeMult());
		cmdMap.put(4, new OpCodeWrite());
		cmdMap.put(3, new OpCodeRead(System.in));
		cmdMap.put(5, new OpCodeJumpIfNotNull());
		cmdMap.put(6, new OpCodeJumpIfFNull());
		cmdMap.put(7, new OpCodeExprLessThan());
		cmdMap.put(8, new OpCodeExprEquals());
		cmdMap.put(9, new OpCodeChgRelBase());
		cmdMap.put(99, new OpCodeExit());
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Output: " + run("p9.txt", "1"));
	}

	public static String run(String dateiName, String firstInput) throws IOException {
		return createIntCodeProgram(dateiName, firstInput).run();
	}

	public static IntCodeController createIntCodeProgram(String dateiName, String firstInput) throws IOException {
		IntCodeMemory memory = new IntCodeMemory(lines(findFile(dateiName)).map(line -> line.split(","))
				.flatMap(Arrays::stream).map(IntCodeValue::new).toArray(IntCodeValue[]::new));
		IntCodeProgram mainPGM = new IntCodeProgram(memory, cmdMap);
		mainPGM.getCmdMap().put(3, new OpCodeRead(firstInput));
		return mainPGM;
	}

}
