package aoc.puzzle09;

import aoc.puzzle05.IntCodeCmd;
import aoc.puzzle05.IntCodeController;
import aoc.puzzle05.IntCodeValue;

public class OpCodeChgRelBase implements IntCodeCmd {

	@Override
	public void execute(IntCodeController pgm, IntCodeValue[] params) {
		pgm.getMemory().adjustRelativeBase(params[0]);
	}

	@Override
	public int getOpCodeLength() {
		return 2;
	}

}
