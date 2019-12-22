package aoc.puzzle05;

import static aoc.puzzle05.IntCodeMemory.IMMEDIATE_MODE;

import java.util.HashMap;
import java.util.Map;

public class IntCodeProgram {

	private final IntCodeMemory memory;

	private int intPointer = 0;

	private StringBuilder output = new StringBuilder();

	private Map<Integer, IntCodeCmd> cmdMap = new HashMap<>();

	private boolean isRunning = false;

	public IntCodeProgram(IntCodeMemory memory, Map<Integer, IntCodeCmd> cmdMap) {
		super();
		this.memory = memory;
		this.cmdMap = cmdMap;
	}

	public IntCodeProgram(IntCodeProgram copyPgm) {
		super();
		this.memory = new IntCodeMemory(copyPgm.memory);
		this.cmdMap = new HashMap<>(copyPgm.cmdMap);
		this.intPointer = copyPgm.intPointer;
	}

	public String start() {
		isRunning = true;
		while (isRunning) {
			IntCodeValue opCode = memory.valueAt(intPointer, IMMEDIATE_MODE);
			cmdMap.get(opCode.value % 100).execute(this);
		}
		return output.toString();
	}

	public int getIntPointer() {
		return intPointer;
	}

	public void setIntPointer(int intPointer) {
		this.intPointer = intPointer;
	}

	public IntCodeMemory getMemory() {
		return memory;
	}

	public StringBuilder getOutput() {
		return output;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

}
