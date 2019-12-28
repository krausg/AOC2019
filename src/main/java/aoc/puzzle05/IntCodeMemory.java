package aoc.puzzle05;

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
		memory = new IntCodeValue[copyMemory.memory.length];
		for (int i = 0; i < copyMemory.memory.length; i++) {
			memory[i] = new IntCodeValue(copyMemory.memory[i].value);
		}
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
