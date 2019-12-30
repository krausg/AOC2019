package aoc.puzzle08;

import static aoc.FileLoader.findFile;
import static java.nio.file.Files.lines;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageArrayUtils {

	public static List<int[]> arrayToLayerArray(int[] imageArray, int width, int tall) {
		List<int[]> imageLayers = new ArrayList<>();
	
		int arrayOffSet = width * tall;
		for (int i = 0; i <= imageArray.length - arrayOffSet; i += arrayOffSet) {
			imageLayers.add(Arrays.copyOfRange(imageArray, i, i + arrayOffSet));
		}
		return imageLayers;
	}

	public static List<int[][]> arrayTo2DLayerArray(int[] imageArray, int width, int tall) {
		List<int[][]> imageLayers = new ArrayList<>();
		int[][] image = new int[tall][width];
		for (int i = 0, img1 = 0; i < imageArray.length; i++, img1++) {
			if (img1 / width == tall) {
				imageLayers.add(image);
				image = new int[tall][width];
				img1 = 0;
			}
			image[img1 / width][img1 % width] = imageArray[i];
		}
		imageLayers.add(image);
		return imageLayers;
	}

	public static long countOccurences(int[] array, int occurence) {
		return Arrays.stream(array).filter(xy -> xy == occurence).count();
	}

	public static int[] loadImageArrayOfFile(String dateiName) throws IOException {
		return lines(findFile(dateiName)).map(x -> x.split("")).flatMap(Arrays::stream).mapToInt(Integer::new)
				.toArray();
	}

}
