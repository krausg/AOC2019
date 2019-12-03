package aoc.puzzle02;

import java.util.Objects;

public class IntCode {

	private Long code;

	public IntCode(Long code) {
		super();
		this.code = code;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof IntCode)) {
			return false;
		}
		IntCode other = (IntCode) obj;
		return Objects.equals(code, other.code);
	}

	@Override
	public String toString() {
		return "I:[" + code + "]";
	}

}
