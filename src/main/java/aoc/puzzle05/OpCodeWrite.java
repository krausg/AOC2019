package aoc.puzzle05;

public class OpCodeWrite implements IntCodeCmd {

	private String delimiter;

	public OpCodeWrite(String delimiter) {
		super();
		this.delimiter = delimiter;
	}

	public OpCodeWrite() {
		this("");
	}

	@Override
	public void execute(IntCodeController pgm, IntCodeValue[] params) {
		pgm.getOutput().append(delimiter).append(params[0].value);
	}

	@Override
	public int getOpCodeLength() {
		return 2;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

}
