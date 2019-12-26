package aoc.puzzle05;

public class OpCodeExit implements IntCodeCmd {

	@Override
	public void execute(IntCodeController pgm, IntCodeValue[] params) {
		pgm.setRunning(false);
	}

	@Override
	public int getOpCodeLength() {
		return 1;
	}

}
