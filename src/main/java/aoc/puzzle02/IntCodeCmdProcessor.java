package aoc.puzzle02;

import time.projects.fileconverter.LineProcessor;

public class IntCodeCmdProcessor implements LineProcessor<IntCodeCmd> {

	boolean stopProcessAfter99Flag = false;
	boolean stopIntCodeProgrammOccurred = false;

	public IntCodeCmdProcessor(boolean stopProcessAfter99Flag) {
		super();
		this.stopProcessAfter99Flag = stopProcessAfter99Flag;
	}

	@Override
	public IntCodeCmd process(IntCodeCmd element) {
		if (stopProcessAfter99Flag && stopIntCodeProgrammOccurred) {
			return element;
		}

		switch (element.getOpcode()) {
		case 1:
			element.getMemory().set(element.getSaveTo(), element.getPos1Value() + element.getPos2Value());
			break;
		case 2:
			element.getMemory().set(element.getSaveTo(), element.getPos1Value() * element.getPos2Value());
			break;
		case 99:
			stopIntCodeProgrammOccurred = true;
			break;
		default:
			throw new RuntimeException();
		}
		return element;
	}

}
