package aoc.puzzle05;

import static java.lang.String.format;
import static java.util.Arrays.stream;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntCodeLoggerUtils {

	private static final String INTCODE_CONTROLLER_FORMAT = "[%12s//%03d]: %s";
	private static final String INTCODE_CMD_FORMAT = "[%10s//%03d+%02d]: %15s -- [AFTER]( %20s ) -- [BEFORE]( %20s )";
	private final static Logger logger = LogManager.getLogger();

	public static void loggerDebug(IntCodeController controller, IntCodeCmd cmd, IntCodeValue[] params) {
		logger.debug(format(INTCODE_CMD_FORMAT, controller.getName(), controller.getIntPointer(), cmd.getOpCodeLength(),
				getNameNormalized(cmd), normalizeParameters(params),
				normalizeIntParameters(cmd.getOpCodeNumbers(controller.getMemory(), controller.getIntPointer()))));
	}

	public static void loggerDebug(IntCodeController controller, String string) {
		logger.debug(format(INTCODE_CONTROLLER_FORMAT, controller.getName(), controller.getIntPointer(), string));
	}

	private static String normalizeIntParameters(int[] params) {
		return stream(params).mapToObj(x -> String.format("%5s", x)).collect(Collectors.joining());
	}

	private static <T> String normalizeParameters(T[] params) {
		return stream(params).map(x -> format("%5s", x.toString())).collect(Collectors.joining());
	}

	private static String getNameNormalized(IntCodeCmd cmd) {
		String simpleName = cmd.getClass().getSimpleName();
		return simpleName.replaceAll("^OpCode", "");
	}

}
