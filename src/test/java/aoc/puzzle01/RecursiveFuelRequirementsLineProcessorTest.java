package aoc.puzzle01;

import org.junit.Assert;
import org.junit.Test;

import aoc.puzzle01.RecursiveFuelRequirementsLineProcessor;

public class RecursiveFuelRequirementsLineProcessorTest {

	RecursiveFuelRequirementsLineProcessor processor = new RecursiveFuelRequirementsLineProcessor();

	@Test
	public void aocTest1() {
		Assert.assertEquals(2, processor.process(new NumberLine(14)).getLineAsInt());
	}

	@Test
	public void aocTest2() {
		Assert.assertEquals(966, processor.process(new NumberLine(1969)).getLineAsInt());
	}

	@Test
	public void aocTest3() {
		Assert.assertEquals(50346, processor.process(new NumberLine(100756)).getLineAsInt());
	}

}
