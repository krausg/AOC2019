package aoc.entities;

import time.projects.fileconverter.entities.Line;

public class NumberLine extends Line {

	public NumberLine(Integer number) {
		super("" + number);
	}

	public NumberLine(String line) {
		super(line);
	}

	public int getLineAsInt() {
		return Integer.parseInt(line);
	}

	public double getLineAsDouble() {
		return Double.parseDouble(line);
	}

	public long getLineAsLong() {
		return Long.parseLong(line);
	}

}
