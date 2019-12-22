package aoc.puzzle05;

import java.util.Arrays;

public class IntCodeMemory {

	public final static int IMMEDIATE_MODE = 1;
	public final static int POSITION_MODE = 0;

	private IntCodeValue[] memory = new IntCodeValue[0];

	public IntCodeMemory(IntCodeValue[] memory) {
		super();
		this.memory = memory;
	}

	public IntCodeMemory(IntCodeMemory copyMemory) {
		super();
		memory = Arrays.copyOf(copyMemory.memory, copyMemory.memory.length);
	}

	public IntCodeValue[] valuesAt(int start, int end, int[] accessFlags) {
		IntCodeValue[] result = new IntCodeValue[end - start];

		for (int i = 0; i < result.length; i++) {
			int accessMode = accessFlags.length - i > 0 ? accessFlags[accessFlags.length - (i + 1)] : POSITION_MODE;
			result[i] = valueAt(start + i, accessMode);
		}

		return result;
	}

	public IntCodeValue valueAt(int position, int accessFlag) {
		return accessFlag == POSITION_MODE ? memory[memory[position].value] : memory[position];
	}

}
