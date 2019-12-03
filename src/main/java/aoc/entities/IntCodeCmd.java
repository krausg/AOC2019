package aoc.entities;

import java.util.List;
import java.util.Objects;

import aoc.puzzle02.IntCode;
import time.projects.fileconverter.entities.Line;

public class IntCodeCmd extends Line {

	private List<IntCode> memory;
	private IntCode opcode;
	private IntCode pos1;
	private IntCode pos2;
	private IntCode saveTo;

	public IntCodeCmd(String line, List<IntCode> memory2, IntCode intCode, IntCode intCode2, IntCode intCode3,
			IntCode intCode4) {
		super(line);
		this.memory = memory2;
		this.opcode = intCode;
		this.pos1 = intCode2;
		this.pos2 = intCode3;
		this.saveTo = intCode4;
	}

	public List<IntCode> getMemory() {
		return memory;
	}

	public IntCode getOpcode() {
		return opcode;
	}

	public long getOpcodeCode() {
		return opcode.getCode();
	}

	public Long getPos1Code() {
		return pos1.getCode();
	}

	public Long getPos2Code() {
		return pos2.getCode();
	}

	public Long getSaveToCode() {
		return saveTo.getCode();
	}

	public IntCode getPos1() {
		return pos1;
	}

	public IntCode getPos2() {
		return pos2;
	}

	public IntCode getSaveTo() {
		return saveTo;
	}

	@Override
	public String toString() {
		return "IntCodeCmd [memory=" + memory + ", opcode=" + opcode + ", pos1=" + pos1 + ", pos2=" + pos2 + ", saveTo="
				+ saveTo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(memory, opcode, pos1, pos2, saveTo);
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
		return Objects.equals(memory, other.memory) && Objects.equals(opcode, other.opcode)
				&& Objects.equals(pos1, other.pos1) && Objects.equals(pos2, other.pos2)
				&& Objects.equals(saveTo, other.saveTo);
	}

}
