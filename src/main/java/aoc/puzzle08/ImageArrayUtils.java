package aoc.puzzle08;

import static aoc.FileLoader.findFile;
import static java.nio.file.Files.lines;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageArrayUtils {

	private static final char UNKNOWN = '?';
	private static final char EMPTY = ':';
	private static final char BLACK_BLOCK = '⬛';

	public static char[][] decodeImage2DArray(int[][] encImgArr) {
		char[][] decImgArr = new char[encImgArr.length][encImgArr[0].length];
		for (int i = 0; i < decImgArr.length; i++) {
			for (int e = 0; e < decImgArr[i].length; e++) {
				int encPixel = encImgArr[i][e];
				decImgArr[i][e] = encPixel == 0 ? BLACK_BLOCK : (encPixel == 1 ? EMPTY : UNKNOWN);
			}
		}
		return decImgArr;
	}

	public static int[] mergeArrayLayers(List<int[]> imageLayers) {
		return imageLayers.stream().reduce(new int[] {}, ImageArrayUtils::mergeImageLayers);
	}

	public static int[] mergeImageLayers(int[] x, int[] y) {
		for (int i = 0; i < x.length; i++) {
			y[i] = x[i] == y[i] || x[i] != 2 ? x[i] : y[i];
		}
		return y;
	}

	public static List<int[]> arrayToLayerArray(int[] imageArray, int width, int tall) {
		List<int[]> imageLayers = new ArrayList<>();

		int arrayOffSet = width * tall;
		for (int i = 0; i <= imageArray.length - arrayOffSet; i += arrayOffSet) {
			imageLayers.add(Arrays.copyOfRange(imageArray, i, i + arrayOffSet));
		}
		return imageLayers;
	}

	public static int[][] splitArrayTo2DArray(int[] imageArray, int width, int tall) {
		int[][] image = new int[tall][width];
		for (int i = 0, img1 = 0; i < imageArray.length; i++, img1++) {
			image[img1 / width][img1 % width] = imageArray[i];
		}
		return image;
	}

	public static long countOccurences(int[] array, int occurence) {
		return Arrays.stream(array).filter(xy -> xy == occurence).count();
	}

	public static int[] loadImageArrayOfFile(String dateiName) {
		try {
			return lines(findFile(dateiName)).map(x -> x.split("")).flatMap(Arrays::stream).mapToInt(Integer::new)
					.toArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
