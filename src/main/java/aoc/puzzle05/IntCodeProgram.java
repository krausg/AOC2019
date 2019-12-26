package aoc.puzzle05;

import static aoc.puzzle05.IntCodeMemory.IMMEDIATE_MODE;

import java.util.HashMap;
import java.util.Map;

public class IntCodeProgram implements IntCodeController {

	private String name;

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

	public IntCodeProgram(IntCodeController copyPgm) {
		super();
		this.memory = new IntCodeMemory(copyPgm.getMemory());
		this.cmdMap = new HashMap<>(copyPgm.getCmdMap());
		this.intPointer = copyPgm.getIntPointer();
	}

	@Override
	public String run() {
		isRunning = true;
		while (isRunning) {
			IntCodeValue opCode = memory.valueAt(intPointer, IMMEDIATE_MODE);
			cmdMap.get(opCode.value % 100).execute(this);
		}
		return output.toString();
	}

	@Override
	public int getIntPointer() {
		return intPointer;
	}

	@Override
	public void setIntPointer(int intPointer) {
		this.intPointer = intPointer;
	}

	@Override
	public IntCodeMemory getMemory() {
		return memory;
	}

	@Override
	public StringBuilder getOutput() {
		return output;
	}

	@Override
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	@Override
	public Map<Integer, IntCodeCmd> getCmdMap() {
		return cmdMap;
	}

	@Override
	public void setCmdMap(Map<Integer, IntCodeCmd> cmdMap) {
		this.cmdMap = cmdMap;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
