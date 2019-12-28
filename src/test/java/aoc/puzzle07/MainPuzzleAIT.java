package aoc.puzzle07;

import static aoc.puzzle07.IntCodeProgramOutputMaximizer.run;
import static aoc.puzzle07.MainPuzzleA.createIntCodeProgram;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class MainPuzzleAIT {

	@Test
	public void testAOCA1() throws Exception {
		assertEquals("43210", MainPuzzleA.run("p71.txt", new ArrayList<>(asList(4, 3, 2, 1, 0)), "0"));
	}

	@Test
	public void testAOCA2() throws Exception {
		assertEquals("54321", MainPuzzleA.run("p72.txt", new ArrayList<>(asList(0, 1, 2, 3, 4)), "0"));
	}

	@Test
	public void testAOCA3() throws Exception {
		assertEquals("65210", MainPuzzleA.run("p73.txt", new ArrayList<>(asList(1, 0, 4, 3, 2)), "0"));
	}

	@Test
	public void testAOCAMain() throws Exception {
		assertEquals(51679, run(createIntCodeProgram("p7.txt", new ArrayList<Integer>(), "0"), asList(0, 1, 2, 3, 4)));
	}

}
