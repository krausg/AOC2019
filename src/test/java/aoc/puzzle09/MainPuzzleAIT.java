package aoc.puzzle09;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainPuzzleAIT {

	@Test
	public void testAOCA1() throws Exception {
		assertEquals("1091204-1100110011001008100161011006101099", MainPuzzleA.run("p91.txt", ""));
	}

	@Test
	public void testAOCA2() throws Exception {
		assertEquals("1219070632396864", MainPuzzleA.run("p92.txt", ""));
	}

	@Test
	public void testAOCA3() throws Exception {
		assertEquals("1125899906842624", MainPuzzleA.run("p93.txt", ""));
	}

}
