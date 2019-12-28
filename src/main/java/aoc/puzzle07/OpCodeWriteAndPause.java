package aoc.puzzle07;

import aoc.puzzle05.IntCodeCmd;
import aoc.puzzle05.IntCodeValue;

public class OpCodeWriteAndPause implements IntCodeCmd {

	@Override
	public void execute(aoc.puzzle05.IntCodeController pgm, IntCodeValue[] params) {
		// pgm.resetOutputCache();
		pgm.getOutput().append(params[0].value);
		pgm.setPaused(true);
	}

	@Override
	public int getOpCodeLength() {
		return 2;
	}

}
