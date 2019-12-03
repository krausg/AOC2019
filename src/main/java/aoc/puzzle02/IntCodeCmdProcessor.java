package aoc.puzzle02;

import time.projects.fileconverter.LineProcessor;

public class IntCodeCmdProcessor implements LineProcessor<IntCodeCmd> {

	@Override
	public IntCodeCmd process(IntCodeCmd element) {
		switch (element.getOpcode()) {
		case 1:
			element.getMemory().set(element.getSaveTo(), element.getPos1Value() + element.getPos2Value());
			break;
		case 2:
			element.getMemory().set(element.getSaveTo(), element.getPos1Value() * element.getPos2Value());
			break;
		case 99:
			break;
		default:
			throw new RuntimeException();
		}
		return element;
	}

}
