package aoc.puzzle02;

import java.util.List;
import java.util.Objects;

import time.projects.fileconverter.entities.Line;

public class IntCodeCmd extends Line {

	private List<Integer> memory;
	private int opCodeIndex;

	public IntCodeCmd(List<Integer> memory, int opCodeIndex) {
		super("");
		this.memory = memory;
		this.opCodeIndex = opCodeIndex;
	}

	public List<Integer> getMemory() {
		return memory;
	}

	public Integer getOpcode() {
		if (memory.size() > opCodeIndex) {
			return memory.get(opCodeIndex);
		} else {
			return null;
		}
	}

	public Integer getPos1() {
		int pos1Index = opCodeIndex + 1;
		if (memory.size() > pos1Index) {
			return memory.get(pos1Index);
		} else {
			return null;
		}
	}

	public int getPos1Value() {
		return memory.get(getPos1());
	}

	public Integer getPos2() {
		int pos2Index = opCodeIndex + 2;
		if (memory.size() > pos2Index) {
			return memory.get(pos2Index);
		} else {
			return null;
		}
	}

	public int getPos2Value() {
		return memory.get(getPos2());
	}

	public Integer getSaveTo() {
		int saveToIndex = opCodeIndex + 3;
		if (memory.size() > saveToIndex) {
			return memory.get(saveToIndex);
		} else {
			return null;
		}
	}

	public int getOpCodeIndex() {
		return opCodeIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(memory, opCodeIndex);
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
		if (!(obj instanceof IntCodeCmd)) {
			return false;
		}
		IntCodeCmd other = (IntCodeCmd) obj;
		return Objects.equals(memory, other.memory) && opCodeIndex == other.opCodeIndex;
	}

}
