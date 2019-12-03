package aoc.puzzle02;

import static java.util.Arrays.stream;
import static time.projects.fileconverter.errortypes.IOError.PATH_DOES_NOT_EXIST;
import static time.projects.fileconverter.errortypes.IOError.PATH_IS_NULL;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import time.projects.fileconverter.reader.ConverterScanner;

public class IntCodeCmdScanner implements ConverterScanner<IntCodeCmd> {

	@Override
	public Collection<IntCodeCmd> scan(Path directory) {
		PATH_IS_NULL.requireNonNull(directory);
		PATH_DOES_NOT_EXIST.requireTrue(() -> Files.exists(directory));

		try {
			List<IntCodeCmd> intCodes = new ArrayList<>();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(directory.toFile()), "UTF-8"));
			String line = null;
			int cmdPosition = 0;
			List<Integer> memory = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				Integer[] integers = stream(line.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
				intCodes.addAll(createIntCodeCmds(cmdPosition, memory, integers));
			}

			reader.close();
			return intCodes;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static List<IntCodeCmd> createIntCodeCmds(Integer... codes) {
		return createIntCodeCmds(0, new ArrayList<>(), codes);
	}

	public static List<IntCodeCmd> createIntCodeCmds(int cmdPosition, List<Integer> memory, Integer... codes) {
		List<IntCodeCmd> intCodes = new ArrayList<>();
		for (int i = 0; i < codes.length; i++) {
			if ((i + 4) % 4 == 0) {
				IntCodeCmd intcode = new IntCodeCmd(memory, cmdPosition);
				cmdPosition += 4;
				intCodes.add(intcode);
			}
			memory.add(codes[i]);
		}
		return intCodes;
	}

}
