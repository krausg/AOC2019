package aoc.puzzle07;

import static aoc.FileLoader.findFile;
import static java.nio.file.Files.lines;
import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.puzzle05.IntCodeCmd;
import aoc.puzzle05.IntCodeMemory;
import aoc.puzzle05.IntCodeValue;
import aoc.puzzle05.OpCodeAdd;
import aoc.puzzle05.OpCodeExit;
import aoc.puzzle05.OpCodeExprEquals;
import aoc.puzzle05.OpCodeExprLessThan;
import aoc.puzzle05.OpCodeJumpIfNull;
import aoc.puzzle05.OpCodeJumpIfNotNull;
import aoc.puzzle05.OpCodeMult;

public class MainPuzzleB {

	private static final Map<Integer, IntCodeCmd> cmdMap = new HashMap<>();
	static {
		cmdMap.put(1, new OpCodeAdd());
		cmdMap.put(2, new OpCodeMult());
		cmdMap.put(4, new OpCodeWriteAndPause());
		cmdMap.put(5, new OpCodeJumpIfNotNull());
		cmdMap.put(6, new OpCodeJumpIfNull());
		cmdMap.put(7, new OpCodeExprLessThan());
		cmdMap.put(8, new OpCodeExprEquals());
		cmdMap.put(99, new OpCodeExit());
	}

	public static void main(String[] args) throws IOException {
		System.out.println(IntCodeProgramOutputMaximizer
				.run(createIntCodeProgram("p7.txt", new ArrayList<Integer>(), "0"), asList(5, 6, 7, 8, 9)));
	}

	public static String run(String dateiName, List<Integer> phaseSettings, String firstInput) throws IOException {
		return createIntCodeProgram(dateiName, phaseSettings, firstInput).run();
	}

	public static IntCodeAmplifyableController createIntCodeProgram(String dateiName, List<Integer> phaseSettings,
			String firstInput) throws IOException {
		IntCodeMemory memory = new IntCodeMemory(lines(findFile(dateiName)).map(line -> line.split(","))
				.flatMap(Arrays::stream).map(IntCodeValue::new).toArray(IntCodeValue[]::new));
		IntCodeAmplifyableController mainPGM = new IntCodeAmplifyableProgram(memory, cmdMap, phaseSettings);
		mainPGM.setFeedbackLoopMode(true);
		mainPGM.setFirstInput(firstInput);
		return mainPGM;
	}

}
