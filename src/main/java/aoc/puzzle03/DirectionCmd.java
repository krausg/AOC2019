package aoc.puzzle03;

import java.util.Objects;

import time.projects.fileconverter.entities.Line;

public class DirectionCmd extends Line {

	private int lineCounter;
	private DirectionEnum directionEnum;
	private int directionAmount;

	public DirectionCmd(String line, int lineCounter, DirectionEnum directionEnum, int directionAmount) {
		super(line);
		this.lineCounter = lineCounter;
		this.directionEnum = directionEnum;
		this.directionAmount = directionAmount;
	}

	@Override
	public String toString() {
		return "DirectionCmd [lineCounter=" + lineCounter + ", directionEnum=" + directionEnum + ", directionAmount="
				+ directionAmount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(directionAmount, directionEnum, lineCounter);
		return result;
	}

	public int getLineCounter() {
		return lineCounter;
	}

	public DirectionEnum getDirectionEnum() {
		return directionEnum;
	}

	public int getDirectionAmount() {
		return directionAmount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof DirectionCmd)) {
			return false;
		}
		DirectionCmd other = (DirectionCmd) obj;
		return directionAmount == other.directionAmount && directionEnum == other.directionEnum
				&& lineCounter == other.lineCounter;
	}

}
