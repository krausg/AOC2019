package aoc.puzzle02;

import java.util.Collection;

import time.projects.fileconverter.postconvert.CollectionConverter;

public class PrintFirstOpCodePostConverter implements CollectionConverter<IntCodeCmd> {

	@Override
	public Collection<IntCodeCmd> convert(Collection<IntCodeCmd> elements) {
		System.out.println(elements.iterator().next().getOpcode());
		return elements;
	}

}
