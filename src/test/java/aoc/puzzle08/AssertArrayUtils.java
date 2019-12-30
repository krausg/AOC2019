package aoc.puzzle08;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.ListIterator;

public class AssertArrayUtils {

	public static void assertListArrayEquals(List<int[]> expected, List<int[]> real) {
		assertNotNull(real);
		assertEquals(expected.size(), real.size());
		ListIterator<int[]> expectedIt = expected.listIterator();
		while (expectedIt.hasNext()) {
			assertArrayEquals(expectedIt.next(), real.get(expectedIt.previousIndex()));
		}
	}

	public static void assertList2DArrayEquals(List<int[][]> expected, List<int[][]> real) {
		assertNotNull(real);
		assertEquals(expected.size(), real.size());
		ListIterator<int[][]> expectedIt = expected.listIterator();
		while (expectedIt.hasNext()) {
			assertArrayEquals(expectedIt.next(), real.get(expectedIt.previousIndex()));
		}
	}

}
