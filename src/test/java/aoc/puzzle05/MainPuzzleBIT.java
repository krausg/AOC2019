package aoc.puzzle05;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class MainPuzzleBIT {

	@Test
	public void testAOCAMain() throws IOException {
		MainPuzzleB.cmdMap.put(3, new OpCodeRead("5"));
		assertEquals("15586959", MainPuzzleB.run("p5.txt", MainPuzzleB.cmdMap));
	}

}
