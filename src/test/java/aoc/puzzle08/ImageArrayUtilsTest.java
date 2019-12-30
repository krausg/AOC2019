package aoc.puzzle08;

import static aoc.puzzle08.AssertArrayUtils.assertListArrayEquals;
import static aoc.puzzle08.ImageArrayUtils.arrayToLayerArray;
import static aoc.puzzle08.ImageArrayUtils.loadImageArrayOfFile;
import static aoc.puzzle08.ImageArrayUtils.mergeArrayLayers;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class ImageArrayUtilsTest {

	@Test
	public void testMergeArrayLayers() throws IOException {
		List<int[]> real = asList(new int[] { 0, 2, 2, 2 }, new int[] { 1, 1, 2, 2 }, new int[] { 2, 2, 1, 2 },
				new int[] { 0, 0, 0, 0 });
		assertArrayEquals(new int[] { 0, 1, 1, 0 }, mergeArrayLayers(real));
	}

	@Test
	public void testArrayToLayerArray1() throws IOException {
		List<int[]> expected = asList(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 7, 8, 9, 0, 1, 2 });
		List<int[]> real = arrayToLayerArray(loadImageArrayOfFile("p81.txt"), 3, 2);
		assertListArrayEquals(expected, real);
	}

	@Test
	public void testLoadImageArrayOfFile1() throws IOException {
		int[] expected = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2 };
		int[] real = ImageArrayUtils.loadImageArrayOfFile("p81.txt");
		assertArrayEquals(expected, real);
	}

}
