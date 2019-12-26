package aoc.puzzle05;

public class OpCodeExprLessThan implements IntCodeCmd {

	@Override
	public void execute(IntCodeController pgm, IntCodeValue[] params) {
		params[2].value = params[0].value < params[1].value ? 1 : 0;
	}

	@Override
	public int getOpCodeLength() {
		return 4;
	}

}
