package aoc.puzzle03;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class MainPuzzleB2IT extends MainPuzzleB {

	@Override
	public void setup() {
		super.setup();
		this.setEingabeDateiName("p33.txt");
	}

	@Test
	public void aocTest() throws IOException {
		Assert.assertEquals(12, this.start());
	}

}
