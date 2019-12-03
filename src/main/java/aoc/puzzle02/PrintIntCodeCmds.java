package aoc.puzzle02;

import java.util.Collection;

import time.projects.fileconverter.LineProcessor;
import time.projects.fileconverter.postconvert.CollectionConverter;

public class PrintIntCodeCmds implements LineProcessor<IntCodeCmd>, CollectionConverter<IntCodeCmd> {

	@Override
	public IntCodeCmd process(IntCodeCmd element) {
		System.out.printf("%03d: %03d, %03d, %03d, %03d", element.getOpCodeIndex(), element.getOpcode(),
				element.getPos1(), element.getPos2(), element.getSaveTo());
		System.out.println();
		return element;
	}

	@Override
	public Collection<IntCodeCmd> convert(Collection<IntCodeCmd> elements) {
		elements.forEach(this::process);
		return elements;
	}

}
