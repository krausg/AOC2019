package aoc.puzzle02;

import java.util.Collection;

import time.projects.fileconverter.postconvert.FilePostConvert;

public class PrintFirstOpCodePostConverter implements FilePostConvert<IntCodeCmd> {

	@Override
	public Collection<IntCodeCmd> postConvert(Collection<IntCodeCmd> elements) {
		System.out.println(elements.iterator().next().getOpcode());
		return elements;
	}

}
