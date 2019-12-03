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
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

import aoc.entities.IntCodeCmd;
import time.projects.fileconverter.reader.ConverterReader;

public class IntCodeScanner implements ConverterReader<IntCodeCmd> {

	@Override
	public Collection<IntCodeCmd> scan(Path directory) {
		PATH_IS_NULL.requireNonNull(directory);
		PATH_DOES_NOT_EXIST.requireTrue(() -> Files.exists(directory));

		try {
			List<IntCodeCmd> intCodes = new ArrayList<>();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(directory.toFile()), "UTF-8"));
			String line = null;
			List<IntCode> memory = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				Long[] longs = stream(line.split(",")).map(Long::parseLong).toArray(Long[]::new);
				intCodes.addAll(createIntCodeCmds(memory, longs));

				// Deque<IntCode> codes = new
				// ArrayDeque<>(Arrays.asList(line.split(","))).stream().map(Integer::parseInt)
				// .map(IntCode::new).collect(Collectors.toCollection(ArrayDeque::new));
				// if (codes.isEmpty()) {
				// continue;
				// }
				//
				// memory.addAll(codes);
				// while (!codes.isEmpty()) {
				// IntCodeCmd intcode = new IntCodeCmd(line, memory, codes.poll(), codes.poll(),
				// codes.poll(),
				// codes.poll());
				// if (intcode.getSaveTo() == null || intcode.getOpcode().getCode() == 99) {
				// break line_while;
				// }
				// intCodes.add(intcode);
				// }
			}

			reader.close();
			return intCodes;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static List<IntCodeCmd> createIntCodeCmds(List<IntCode> memory, Integer... codes2) {
		return createIntCodeCmds(memory, Arrays.stream(codes2).map(Long::new).toArray(Long[]::new));
	}

	public static List<IntCodeCmd> createIntCodeCmds(List<IntCode> memory, Long... codes2) {
		List<IntCodeCmd> intCodes = new ArrayList<>();
		Deque<IntCode> codes = new ArrayDeque<>(Arrays.asList(codes2)).stream().map(IntCode::new)
				.collect(Collectors.toCollection(ArrayDeque::new));

		memory.addAll(codes);
		while (!codes.isEmpty()) {
			IntCodeCmd intcode = new IntCodeCmd("", memory, codes.poll(), codes.poll(), codes.poll(), codes.poll());
			if (intcode.getSaveTo() == null) {
				break;
			}
			intCodes.add(intcode);
		}
		return intCodes;
	}

}
