package aoc.puzzle01;

import aoc.entities.NumberLine;
import time.projects.fileconverter.LineProcessor;

public class FuelRequirementsLineProcessor implements LineProcessor<NumberLine> {

	@Override
	public NumberLine process(NumberLine resultElement) {
		double dividiertdurch3 = resultElement.getLineAsDouble() / 3.0;
		double abgerundet = Math.abs(dividiertdurch3);
		double minus2 = abgerundet - 2.0;
		return new NumberLine((int) minus2);
	}

}
