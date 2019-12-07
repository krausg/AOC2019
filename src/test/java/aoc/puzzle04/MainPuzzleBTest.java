package aoc.puzzle04;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MainPuzzleBTest {

	MainPuzzleB puzzle = new MainPuzzleB();

	@Test
	public void aocTest1() {
		assertTrue(puzzle.isPasswordInCriteria("112233"));
	}

	@Test
	public void aocTest2() {
		assertFalse(puzzle.isPasswordInCriteria("123444"));
	}

	@Test
	public void aocTest3() {
		assertTrue(puzzle.isPasswordInCriteria("111122"));
	}
}
