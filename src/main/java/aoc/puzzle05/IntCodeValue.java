package aoc.puzzle05;

public class IntCodeValue {

	public int value = 0;

	public IntCodeValue(String value) {
		this(Integer.parseInt(value));
	}

	public IntCodeValue(int value) {
		super();
		this.value = value;
	}

	public int[] valueArray() {
		return (value + "").chars().map(x -> x - '0').toArray();
	}

	@Override
	public String toString() {
		return "" + value;
	}
}
