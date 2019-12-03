package aoc.puzzle01;

import static java.util.Arrays.asList;

import java.util.Collection;

import time.projects.fileconverter.postconvert.FilePostConvert;

public class SumFuelPostConvert implements FilePostConvert<NumberLine> {

	@Override
	public Collection<NumberLine> postConvert(Collection<NumberLine> elements) {
		long sum = (long) elements.stream().mapToDouble(NumberLine::getLineAsDouble).sum();
		return asList(new NumberLine("" + sum));
	}

}
