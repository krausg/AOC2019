package aoc.puzzle05;

import java.util.Scanner;

public class OpCodeRead implements IntCodeCmd {

	@Override
	public void execute(IntCodeProgram pgm, IntCodeValue[] params) {
		Scanner scanner = new Scanner(System.in);
		params[0].value = scanner.nextInt();
		scanner.close();
	}

	@Override
	public int getOpCodeLength() {
		return 2;
	}

}
