package aoc.puzzle02;

import java.util.Collection;
import java.util.List;

import time.projects.fileconverter.postconvert.CollectionConverter;

public class SetupIntCodeCmdsPuzzle2 implements CollectionConverter<IntCodeCmd> {

	int noun;
	int verb;

	public SetupIntCodeCmdsPuzzle2(int noun, int verb) {
		super();
		this.noun = noun;
		this.verb = verb;
	}

	@Override
	public Collection<IntCodeCmd> convert(Collection<IntCodeCmd> elements) {
		if (!elements.isEmpty()) {
			List<Integer> memory = elements.iterator().next().getMemory();
			memory.set(1, noun);
			memory.set(2, verb);
		}
		return elements;
	}

}
