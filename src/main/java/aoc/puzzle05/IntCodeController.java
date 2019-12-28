package aoc.puzzle05;

import java.util.Map;

public interface IntCodeController {

	void setPaused(boolean isRunning);

	StringBuilder getOutput();

	IntCodeMemory getMemory();

	void setIntPointer(int intPointer);

	int getIntPointer();

	String run();

	Map<Integer, IntCodeCmd> getCmdMap();

	void setCmdMap(Map<Integer, IntCodeCmd> cmdMap);

	String getName();

	void setName(String name);

	IntCodeController klon();

	void setHalted(boolean isHalted);

	boolean isHalted();

	void resetOutputCache();

}
