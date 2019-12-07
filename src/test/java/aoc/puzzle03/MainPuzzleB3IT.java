package aoc.puzzle03;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class MainPuzzleB3IT extends MainPuzzleB {

	@Override
	public void setup() {
		super.setup();
		this.setEingabeDateiName("p31.txt");
	}

	@Test
	public void aocTest() throws IOException {
		Assert.assertEquals(610, this.start());
	}

}
