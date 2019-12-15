package aoc.puzzle05;

import static aoc.puzzle05.IntCodeMemory.IMMEDIATE_MODE;
import static java.util.Arrays.copyOf;

public interface IntCodeCmd {

	default IntCodeValue[] getParameterValues(IntCodeMemory memory, int intPointer) {
		int[] opCodeNums = (memory.valueAt(intPointer, IMMEDIATE_MODE) + "").chars().map(x -> x - '0').toArray();
		int[] paramFlags = opCodeNums.length > 2 ? copyOf(opCodeNums, opCodeNums.length - 2) : new int[] {};
		IntCodeValue[] param = memory.valuesAt(intPointer + 1, intPointer + getOpCodeLength(), paramFlags);
		return param;
	}

	default void execute(IntCodeProgram program) {
		int intPointer = program.getIntPointer();
		program.setIntPointer(intPointer + getOpCodeLength());
		execute(program, getParameterValues(program.getMemory(), intPointer));
	}

	void execute(IntCodeProgram pgm, IntCodeValue[] params);

	int getOpCodeLength();
}
