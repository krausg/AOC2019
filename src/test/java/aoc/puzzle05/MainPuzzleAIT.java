package aoc.puzzle05;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class MainPuzzleAIT {

	@Test
	public void testAOCAMain() throws IOException {
		MainPuzzleA.cmdMap.put(3, new OpCodeRead("1"));
		assertEquals("0000000009775037", MainPuzzleA.run("p5.txt", MainPuzzleA.cmdMap));
	}

}
