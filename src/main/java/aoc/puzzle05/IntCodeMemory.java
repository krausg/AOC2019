package aoc.puzzle05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntCodeMemory {

	public final static int IMMEDIATE_MODE = 1;
	public final static int POSITION_MODE = 0;
	public final static int RELATIVE_MODE = 2;

	private List<IntCodeValue> memory = new ArrayList<>();

	private IntCodeValue relativeBase = new IntCodeValue(0);

	public IntCodeMemory(IntCodeValue[] memory) {
		super();
		this.memory.addAll(Arrays.asList(memory));
	}

	public IntCodeMemory(IntCodeMemory copyMemory) {
		super();
		copyMemory.memory.forEach(value -> memory.add(new IntCodeValue(value)));
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
		Integer memoryPosition = positionAt(position, accessFlag);
		ensureMemorySpace(memoryPosition);
		return memory.get(memoryPosition);
	}

	private void ensureMemorySpace(int testingPosition) {
		if (memory.size() <= testingPosition) {
			for (int i = (testingPosition * 2) - memory.size(); i >= 0; i--) {
				memory.add(new IntCodeValue(0));
			}
		}
	}

	private Integer positionAt(int position, int accessFlag) {
		switch (accessFlag) {
		case POSITION_MODE:
			ensureMemorySpace(position);
			return (int) memory.get(position).value;
		case IMMEDIATE_MODE:
			return position;
		case RELATIVE_MODE:
			ensureMemorySpace(position);
			return (int) (memory.get(position).value + getRelativeBase().value);
		default:
			throw new RuntimeException("Unknown Memory Access Flag: " + accessFlag);
		}
	}

	public IntCodeValue getRelativeBase() {
		return relativeBase;
	}

	public void adjustRelativeBase(IntCodeValue relativeBase) {
		this.relativeBase.value += relativeBase.value;
	}

}
