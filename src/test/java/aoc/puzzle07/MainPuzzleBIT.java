package aoc.puzzle07;

import static aoc.puzzle07.IntCodeProgramOutputMaximizer.run;
import static aoc.puzzle07.MainPuzzleB.createIntCodeProgram;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class MainPuzzleBIT {

	@Test
	public void testAOCB1() throws Exception {
		assertEquals("139629729", MainPuzzleB.run("p74.txt", new ArrayList<>(asList(9, 8, 7, 6, 5)), "0"));
	}

	@Test
	public void testAOCA2() throws Exception {
		assertEquals("18216", MainPuzzleB.run("p75.txt", new ArrayList<>(asList(9, 7, 8, 5, 6)), "0"));
	}

	@Test
	public void testAOCAMain() throws Exception {
		assertEquals(19539216,
				run(createIntCodeProgram("p7.txt", new ArrayList<Integer>(), "0"), asList(5, 6, 7, 8, 9)));
	}

}
