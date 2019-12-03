package aoc.puzzle02;

import java.util.List;

import aoc.entities.IntCodeCmd;
import time.projects.fileconverter.LineProcessor;

public class IntCodeProcessor implements LineProcessor<IntCodeCmd> {

	@Override
	public IntCodeCmd process(IntCodeCmd element) {
		switch (element.getOpcode().getCode().intValue()) {
		case 1:
			plusOp(element);
			break;
		case 2:
			multiplicateOp(element);
			break;
		case 99:
			break;
		default:
			throw new RuntimeException();
		}
		return element;
	}

	private void plusOp(IntCodeCmd element) {
		List<IntCode> memory = element.getMemory();
		IntCode saveTo = memory.get(element.getSaveToCode().intValue());
		Long val1 = memory.get(element.getPos1Code().intValue()).getCode();
		Long val2 = memory.get(element.getPos2Code().intValue()).getCode();
		saveTo.setCode(val1 + val2);
	}

	private void multiplicateOp(IntCodeCmd element) {
		List<IntCode> memory = element.getMemory();
		IntCode saveTo = memory.get(element.getSaveToCode().intValue());
		Long val1 = memory.get(element.getPos1Code().intValue()).getCode();
		Long val2 = memory.get(element.getPos2Code().intValue()).getCode();
		saveTo.setCode(val1 * val2);
	}

}
