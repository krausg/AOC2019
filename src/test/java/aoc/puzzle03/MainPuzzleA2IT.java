package aoc.puzzle03;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class MainPuzzleA2IT extends MainPuzzleA {

	@Override
	public void setup() {
		super.setup();
		this.setEingabeDateiName("p32.txt");
	}

	@Test
	public void aocTest() throws IOException {
		Assert.assertEquals(135, this.start());

	}

}
