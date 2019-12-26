package aoc.puzzle05;

import java.io.InputStream;
import java.util.Scanner;

public class OpCodeRead implements IntCodeCmd {

	protected final Scanner scanner;

	public OpCodeRead(InputStream inputStream) {
		super();
		scanner = new Scanner(inputStream);
	}

	@Override
	public void execute(IntCodeController pgm, IntCodeValue[] params) {
		params[0].value = scanner.nextInt();

	}

	@Override
	public void destroy() {
		scanner.close();
	}

	@Override
	public int getOpCodeLength() {
		return 2;
	}

}
