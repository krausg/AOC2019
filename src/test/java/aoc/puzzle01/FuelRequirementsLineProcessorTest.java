package aoc.puzzle01;

import org.junit.Assert;
import org.junit.Test;

public class FuelRequirementsLineProcessorTest {

	FuelRequirementsLineProcessor processor = new FuelRequirementsLineProcessor();

	@Test
	public void aocTest1() {
		Assert.assertEquals(2, processor.process(new NumberLine(12)).getLineAsInt());
	}

	@Test
	public void aocTest2() {
		Assert.assertEquals(2, processor.process(new NumberLine(14)).getLineAsInt());
	}

	@Test
	public void aocTest3() {
		Assert.assertEquals(654, processor.process(new NumberLine(1969)).getLineAsInt());
	}

	@Test
	public void aocTest4() {
		Assert.assertEquals(33583, processor.process(new NumberLine(100756)).getLineAsInt());
	}

}
