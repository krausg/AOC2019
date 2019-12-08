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
	static {
		OPCODE_CMD_LENGTH.put(1, 4);
		OPCODE_CMD_LENGTH.put(2, 4);
		OPCODE_CMD_LENGTH.put(3, 2);
		OPCODE_CMD_LENGTH.put(4, 2);
		OPCODE_CMD_LENGTH.put(9, 1);
	}
	static {
		// true erlaubt position position mode
		OPCODE_CMD_PARAM_MODES.put(1, new Boolean[] { true, true, false });
		OPCODE_CMD_PARAM_MODES.put(2, new Boolean[] { true, true, false });
		OPCODE_CMD_PARAM_MODES.put(3, new Boolean[] { false });
		OPCODE_CMD_PARAM_MODES.put(4, new Boolean[] { true });
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
			System.out.printf("mempos:%03d opCode: %05d params:%-20s params_before: %s%n", memPos, memory[memPos],
					Arrays.toString(params), Arrays.toString(copyOfRange(memory, memPos + 1, memPos + opLength)));

			// process methode oder teil von enum
			switch (opCodeNums[opCodeNums.length - 1]) {
			case 1:
				memory[params[2]] = params[0] + params[1];
				break;
			case 2:
				memory[params[2]] = params[0] * params[1];
				break;
			case 3:
				memory[params[0]] = new Scanner(System.in).nextInt();
				break;
			case 4:
				output.append(memory[params[0]]);
				break;
			case 9:
				break program;
			}

			memPos += opLength;
		}

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
			return 1;
		}

		if (opCodeNums.length - 2 - parameterPos >= 0) {
			return opCodeNums[opCodeNums.length - 2 - parameterPos];
		}
		return 0;
	}

	// kann teil von memory klasse sein
	private Integer value(int[] memory, int memPos, int paramFlag) {
		if (paramFlag == 0) {
			return memory[memory[memPos]];
		} else {
			return memory[memPos];
		}

	}

	public static void main(String[] args) throws IOException {
		System.out.println(new MainPuzzleA().start());
	}

}
