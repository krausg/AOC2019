package aoc.puzzle05;

public class OpCodeJumpIfTrue implements IntCodeCmd {

	@Override
	public void execute(IntCodeProgram pgm, IntCodeValue[] params) {
		if (params[0].value != 0) {
			pgm.setIntPointer(params[1].value);
		}
	}

	@Override
	public int getOpCodeLength() {
		return 3;
	}

}