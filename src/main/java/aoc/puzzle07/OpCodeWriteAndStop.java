package aoc.puzzle07;

import aoc.puzzle05.IntCodeCmd;
import aoc.puzzle05.IntCodeValue;

public class OpCodeWriteAndStop implements IntCodeCmd {

	@Override
	public void execute(aoc.puzzle05.IntCodeController pgm, IntCodeValue[] params) {
		pgm.getOutput().append(params[0].value);
		pgm.setRunning(false);
	}

	@Override
	public int getOpCodeLength() {
		return 2;
	}

}
