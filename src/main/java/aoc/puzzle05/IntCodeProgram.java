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

	private boolean isPaused = false;

	private boolean isHalted = false;

	public IntCodeProgram(IntCodeMemory memory, Map<Integer, IntCodeCmd> cmdMap) {
		super();
		this.setName("Main");
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
		while (!isPaused && !isHalted) {
			IntCodeValue opCode = memory.valueAt(intPointer, IMMEDIATE_MODE);
			cmdMap.get((int) opCode.value % 100).execute(this);
		}
		return output.toString();
	}

	@Override
	public void resetOutputCache() {
		output = new StringBuilder();
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
	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
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

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public IntCodeController klon() {
		return new IntCodeProgram(this);
	}

	@Override
	public boolean isHalted() {
		return isHalted;
	}

	@Override
	public void setHalted(boolean isHalted) {
		this.isHalted = isHalted;
	}

}
