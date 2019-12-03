package aoc.puzzle03;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
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

public class DirectionCmdScanner implements ConverterScanner<DirectionCmd> {

	@Override
	public Collection<DirectionCmd> scan(Path directory) {
		PATH_IS_NULL.requireNonNull(directory);
		PATH_DOES_NOT_EXIST.requireTrue(() -> Files.exists(directory));

		try {
			List<DirectionCmd> intCodes = new ArrayList<>();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(directory.toFile()), "UTF-8"));
			String line = null;
			int lineCounter = 0;
			while ((line = reader.readLine()) != null) {
				final String lambdaLine = line;
				final int lambdaLineCounter = lineCounter;
				intCodes.addAll(stream(line.split(",")).map(p -> createDirectionCmd(lambdaLineCounter, lambdaLine, p))
						.collect(toList()));
				lineCounter++;
			}

			reader.close();
			return intCodes;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private DirectionCmd createDirectionCmd(int lineCounter, final String line, String directionCmdString) {
		return new DirectionCmd(line, lineCounter, DirectionEnum.valueOf(directionCmdString.substring(0, 1)),
				Integer.parseInt(directionCmdString.substring(1)));
	}

}
