package aoc.puzzle05;

public class OpCodeMult implements IntCodeCmd {

	@Override
	public void execute(IntCodeController pgm, IntCodeValue[] params) {
		params[2].value = params[0].value * params[1].value;
	}

	@Override
	public int getOpCodeLength() {
		return 4;
	}

}
