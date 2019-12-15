package aoc.puzzle05;

public class OpCodeWrite implements IntCodeCmd {

	@Override
	public void execute(IntCodeProgram pgm, IntCodeValue[] params) {
		pgm.getOutput().append(params[0].value);
	}

	@Override
	public int getOpCodeLength() {
		return 2;
	}

}
