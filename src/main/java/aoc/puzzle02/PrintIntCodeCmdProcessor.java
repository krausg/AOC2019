package aoc.puzzle02;

import time.projects.fileconverter.LineProcessor;

public class PrintIntCodeCmdProcessor implements LineProcessor<IntCodeCmd> {

	@Override
	public IntCodeCmd process(IntCodeCmd element) {
		System.out.printf("%03d: %03d, %03d, %03d, %03d", element.getOpCodeIndex(), element.getOpcode(),
				element.getPos1(), element.getPos2(), element.getSaveTo());
		System.out.println();
		return element;
	}

}
