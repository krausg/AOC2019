package aoc.puzzle02;

import static aoc.puzzle02.IntCodeCmdScanner.createIntCodeCmds;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class IntCodeProcessorTest {

	IntCodeCmdProcessor processor = new IntCodeCmdProcessor();

	@Test
	public void aocTest1() {
		List<IntCodeCmd> intCodeCmd = createIntCodeCmds(1, 0, 0, 0, 99);
		for (IntCodeCmd intCodeCmd2 : intCodeCmd) {
			processor.process(intCodeCmd2);
		}
		assertEquals(createIntCodeCmds(2, 0, 0, 0, 99), intCodeCmd);
	}

	@Test
	public void aocTest2() {
		List<IntCodeCmd> intCodeCmd = createIntCodeCmds(2, 3, 0, 3, 99);
		for (IntCodeCmd intCodeCmd2 : intCodeCmd) {
			processor.process(intCodeCmd2);
		}
		assertEquals(createIntCodeCmds(2, 3, 0, 6, 99), intCodeCmd);
	}

	@Test
	public void aocTest3() {
		List<IntCodeCmd> intCodeCmd = createIntCodeCmds(2, 4, 4, 5, 99, 0);
		for (IntCodeCmd intCodeCmd2 : intCodeCmd) {
			processor.process(intCodeCmd2);
		}
		assertEquals(createIntCodeCmds(2, 4, 4, 5, 99, 9801), intCodeCmd);
	}

	@Test
	public void aocTest4() {
		List<IntCodeCmd> intCodeCmd = createIntCodeCmds(1, 1, 1, 4, 99, 5, 6, 0, 99);
		for (IntCodeCmd intCodeCmd2 : intCodeCmd) {
			processor.process(intCodeCmd2);
		}

		assertEquals(createIntCodeCmds(30, 1, 1, 4, 2, 5, 6, 0, 99), intCodeCmd);
	}

}
