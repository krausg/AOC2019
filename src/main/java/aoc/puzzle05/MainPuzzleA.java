package aoc.puzzle05;

import static aoc.FileLoader.findFile;
import static java.nio.file.Files.lines;
import static java.util.Arrays.copyOfRange;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainPuzzleA {

	// koennte durch ein enum ersetzt werden
	final static Map<Integer, Integer> OPCODE_CMD_LENGTH = new HashMap<>();
	final static Map<Integer, Boolean[]> OPCODE_CMD_PARAM_MODES = new HashMap<>();

	private static final int IMMEDIATE_MODE = 1;
	private static final int POSITION_MODE = 0;
	private static final boolean POSITION_MODE_ALLOWED = true;
	static {
		OPCODE_CMD_LENGTH.put(1, 4);
		OPCODE_CMD_LENGTH.put(2, 4);
		OPCODE_CMD_LENGTH.put(3, 2);
		OPCODE_CMD_LENGTH.put(4, 2);
		OPCODE_CMD_LENGTH.put(9, 1);
	}
	static {
		// true erlaubt position position mode
		OPCODE_CMD_PARAM_MODES.put(1,
				new Boolean[] { POSITION_MODE_ALLOWED, POSITION_MODE_ALLOWED, !POSITION_MODE_ALLOWED });
		OPCODE_CMD_PARAM_MODES.put(2,
				new Boolean[] { POSITION_MODE_ALLOWED, POSITION_MODE_ALLOWED, !POSITION_MODE_ALLOWED });
		OPCODE_CMD_PARAM_MODES.put(3, new Boolean[] { !POSITION_MODE_ALLOWED });
		OPCODE_CMD_PARAM_MODES.put(4, new Boolean[] { POSITION_MODE_ALLOWED });
		OPCODE_CMD_PARAM_MODES.put(9, new Boolean[] {});
	}

	public String start() throws IOException {
		int[] memory = lines(findFile("p5.txt")).map(line -> line.split(",")).flatMap(Arrays::stream)
				.mapToInt(Integer::new).toArray();
		StringBuilder output = new StringBuilder();
		program: for (int memPos = 0; memPos < memory.length;) {
			int[] opCodeNums = (memory[memPos] + "").chars().map(x -> x - '0').toArray();
			Integer opLength = OPCODE_CMD_LENGTH.get(opCodeNums[opCodeNums.length - 1]);
			int[] params = params(memory, memPos, opLength, opCodeNums);
			System.out.printf("mempos:%03d opCode: %05d params:%-20s params_before: %s", memPos, memory[memPos],
					Arrays.toString(params), Arrays.toString(copyOfRange(memory, memPos + 1, memPos + opLength)));

			// process methode oder teil von enum
			switch (opCodeNums[opCodeNums.length - 1]) {
			case 1:
				System.out.printf(" vorher: %05d ", memory[params[2]]);
				memory[params[2]] = params[0] + params[1];
				System.out.printf(" nachher: %05d %n", memory[params[2]]);
				break;
			case 2:
				System.out.printf(" vorher: %05d ", memory[params[2]]);
				memory[params[2]] = params[0] * params[1];
				System.out.printf(" nachher: %05d %n", memory[params[2]]);
				break;
			case 3:
				System.out.printf(" vorher: %05d ", memory[params[0]]);
				memory[params[0]] = new Scanner(System.in).nextInt();
				System.out.printf(" nachher: %05d %n", memory[params[0]]);
				break;
			case 4:
				output.append(params[0]);
				System.out.printf(" ausgabe: '%d' %n", params[0]);
				break;
			case 9:
				break program;
			}

			memPos += opLength;
		}

		System.out.println();
		return output.toString();
	}

	// util methode oder teil einer IntCodeCmd Klasse
	private int[] params(int[] memory, int memPos, int opLength, int[] opCodeNums) {
		int[] params = new int[opLength - 1];
		for (int i = 0; i < params.length; i++) {
			params[i] = value(memory, memPos + (i + 1), paramFlag(opCodeNums, (i + 1)));
		}
		return params;
	}

	// teil von enum
	private int paramFlag(int[] opCodeNums, int parameterPos) {
		if (!OPCODE_CMD_PARAM_MODES.get(opCodeNums[opCodeNums.length - 1])[parameterPos - 1]) {
			return IMMEDIATE_MODE;
		}

		if (opCodeNums.length - 2 - parameterPos >= 0) {
			return opCodeNums[opCodeNums.length - 2 - parameterPos];
		}
		return POSITION_MODE;
	}

	// kann teil von memory klasse sein
	private Integer value(int[] memory, int memPos, int paramFlag) {
		if (paramFlag == POSITION_MODE) {
			return memory[memory[memPos]];
		} else {
			return memory[memPos];
		}

	}

	public static void main(String[] args) throws IOException {
		System.out.println(new MainPuzzleA().start());
	}

}
