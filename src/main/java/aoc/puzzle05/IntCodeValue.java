package aoc.puzzle05;

public class IntCodeValue {

	public long value = 0;

	public IntCodeValue(IntCodeValue value) {
		this(value.value);
	}

	public IntCodeValue(String value) {
		this(Long.parseLong(value));
	}

	public IntCodeValue(long value) {
		super();
		this.value = value;
	}

	public long[] valueArray() {
		return (value + "").chars().mapToLong(x -> x - '0').toArray();
	}

	@Override
	public String toString() {
		return "" + value;
	}
}
