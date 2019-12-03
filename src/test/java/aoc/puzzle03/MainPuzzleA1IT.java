package aoc.puzzle03;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class MainPuzzleA1IT extends MainPuzzleA {

	@Override
	public void setup() {
		super.setup();
		this.setEingabeDateiName("p31.txt");
	}

	@Test
	public void aocTest() throws IOException {
		Assert.assertEquals(159, this.start());
	}

}
