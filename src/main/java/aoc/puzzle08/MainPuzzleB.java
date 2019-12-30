package aoc.puzzle08;

import static aoc.puzzle08.ImageArrayUtils.arrayToLayerArray;
import static aoc.puzzle08.ImageArrayUtils.decodeImage2DArray;
import static aoc.puzzle08.ImageArrayUtils.loadImageArrayOfFile;
import static aoc.puzzle08.ImageArrayUtils.mergeArrayLayers;
import static aoc.puzzle08.ImageArrayUtils.splitArrayTo2DArray;

import java.io.IOException;
import java.util.List;

public class MainPuzzleB {

	private static final int[] IMAGE_ARRAY = loadImageArrayOfFile("p8.txt");
	private static final int IMAGE_WIDTH = 25;
	private static final int IMAGE_TALL = 6;

	public static void main(String[] args) throws IOException {
		List<int[]> imageLayers = arrayToLayerArray(IMAGE_ARRAY, IMAGE_WIDTH, IMAGE_TALL);
		int[] encodedImage = mergeArrayLayers(imageLayers);
		int[][] image2DArray = splitArrayTo2DArray(encodedImage, IMAGE_WIDTH, IMAGE_TALL);
		for (char[] imgLine : decodeImage2DArray(image2DArray)) {
			System.out.print("[");
			for (char imgPixel : imgLine) {
				System.out.print(imgPixel);
			}
			System.out.println("]");
		}
	}

}
