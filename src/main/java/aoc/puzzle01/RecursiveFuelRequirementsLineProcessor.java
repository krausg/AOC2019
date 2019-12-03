package aoc.puzzle01;

import aoc.entities.NumberLine;
import time.projects.fileconverter.LineProcessor;

public class RecursiveFuelRequirementsLineProcessor implements LineProcessor<NumberLine> {

	FuelRequirementsLineProcessor proc = new FuelRequirementsLineProcessor();

	@Override
	public NumberLine process(NumberLine resultElement) {
		NumberLine result = proc.process(resultElement);
		if (result.getLineAsInt() > 3) {
			result = new NumberLine((result.getLineAsInt() + process(result).getLineAsInt()));
		}
		return result;
	}

}
