package aoc.puzzle07;

import aoc.puzzle05.IntCodeValue;
import aoc.puzzle05.OpCodeWrite;

public class OpCodeWriteAndPause extends OpCodeWrite {

	@Override
	public void execute(aoc.puzzle05.IntCodeController pgm, IntCodeValue[] params) {
		super.execute(pgm, params);
		pgm.setPaused(true);
	}

}
