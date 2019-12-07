package aoc.puzzle04;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MainPuzzleATest {

	MainPuzzleA puzzle = new MainPuzzleA();

	@Test
	public void aocTest1() {
		assertTrue(puzzle.isPasswordInCriteria("111111"));
	}

	@Test
	public void aocTest2() {
		assertFalse(puzzle.isPasswordInCriteria("223450"));
	}

	@Test
	public void aocTest3() {
		assertFalse(puzzle.isPasswordInCriteria("123789"));
	}
}
