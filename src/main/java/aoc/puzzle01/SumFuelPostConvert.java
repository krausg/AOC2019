package aoc.puzzle01;

import static java.util.Arrays.asList;

import java.util.Collection;

import time.projects.fileconverter.postconvert.CollectionConverter;

public class SumFuelPostConvert implements CollectionConverter<NumberLine> {

	@Override
	public Collection<NumberLine> convert(Collection<NumberLine> elements) {
		long sum = (long) elements.stream().mapToDouble(NumberLine::getLineAsDouble).sum();
		return asList(new NumberLine("" + sum));
	}

}
