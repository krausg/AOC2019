package aoc.puzzle03;

import java.awt.Point;
import java.util.Objects;

public class DirectionPoint extends Point implements Comparable<DirectionPoint> {

	private static final long serialVersionUID = 7678036635035955377L;

	private int stepsFromStart = 0;

	public DirectionPoint(int stepsFromStart, Point p) {
		super(p);
		this.stepsFromStart = stepsFromStart;
	}

	public DirectionPoint(int stepsFromStart) {
		super();
		this.stepsFromStart = stepsFromStart;
	}

	public void setStepsFromStart(int stepsFromStart) {
		this.stepsFromStart = stepsFromStart;
	}

	public DirectionPoint(int stepsFromStart, int x, int y) {
		super(x, y);
		this.stepsFromStart = stepsFromStart;
	}

	public int getStepsFromStart() {
		return stepsFromStart;
	}

	public boolean equalsWithoutSteps(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(stepsFromStart);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof DirectionPoint)) {
			return false;
		}
		DirectionPoint other = (DirectionPoint) obj;
		return stepsFromStart == other.stepsFromStart;
	}

	public int getManhattenDistanceFromStart() {
		return (int) (Math.abs(0 - getX()) + Math.abs(0 - getY()));
	}

	@Override
	public String toString() {
		return "DirectionPoint [stepsFromStart=" + stepsFromStart + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public int compareTo(DirectionPoint o) {
		int oDistance = Math.abs(o.x) + Math.abs(o.y);
		int distance = Math.abs(x) + Math.abs(y);
		if (oDistance == distance) {
			if (o.stepsFromStart == stepsFromStart) {
				return 0;
			} else {
				return o.stepsFromStart < stepsFromStart ? 1 : -1;
			}
		}
		return oDistance < distance ? 1 : -1;
	}

}
