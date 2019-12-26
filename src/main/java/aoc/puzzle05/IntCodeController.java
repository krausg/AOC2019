package aoc.puzzle05;

import java.util.Map;

public interface IntCodeController {

	void setRunning(boolean isRunning);

	StringBuilder getOutput();

	IntCodeMemory getMemory();

	void setIntPointer(int intPointer);

	int getIntPointer();

	String run();

	Map<Integer, IntCodeCmd> getCmdMap();

	void setCmdMap(Map<Integer, IntCodeCmd> cmdMap);

	String getName();

}
