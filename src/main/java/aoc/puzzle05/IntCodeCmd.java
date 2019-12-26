package aoc.puzzle05;

import static aoc.puzzle05.IntCodeMemory.IMMEDIATE_MODE;
import static java.util.Arrays.copyOf;

public interface IntCodeCmd {

	default IntCodeValue[] getParameterValues(IntCodeMemory memory, int intPointer) {
		int[] opCodeNums = getOpCodeNumbers(memory, intPointer);
		int[] paramFlags = opCodeNums.length > 2 ? copyOf(opCodeNums, opCodeNums.length - 2) : new int[] {};
		IntCodeValue[] param = memory.valuesAt(intPointer + 1, intPointer + getOpCodeLength(), paramFlags);
		return param;
	}

	default int[] getOpCodeNumbers(IntCodeMemory memory, int intPointer) {
		return (memory.valueAt(intPointer, IMMEDIATE_MODE) + "").chars().map(x -> x - '0').toArray();
	}

	default public void execute(IntCodeController program) {
		int intPointer = program.getIntPointer();
		IntCodeValue[] params = getParameterValues(program.getMemory(), intPointer);
		IntCodeLoggerUtils.loggerDebug(program, this, params);
		execute(program, params);
		if (program.getIntPointer() == intPointer) {
			program.setIntPointer(intPointer + getOpCodeLength());
		}
	}

	default public void destroy() {

	}

	void execute(IntCodeController pgm, IntCodeValue[] params);

	int getOpCodeLength();
}
