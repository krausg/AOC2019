package aoc.puzzle05;

import static java.lang.String.format;
import static java.util.Arrays.stream;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntCodeLoggerUtils {

	private static final String INTCODE_CONTROLLER_FORMAT = "[%12s//%03d]: %s";
	private static final String INTCODE_CMD_FORMAT = "[%10s//%03d+%02d]: %15s -- [FLAGS] ( %10s) [PARAMS]( %-55s )";
	private final static Logger logger = LogManager.getLogger();

	public static void loggerDebug(IntCodeController controller, IntCodeCmd cmd, IntCodeValue[] params) {
		if (logger.isDebugEnabled()) {
			logger.debug(format(INTCODE_CMD_FORMAT, controller.getName(), controller.getIntPointer(),
					cmd.getOpCodeLength(), normalizeOpCodeName(cmd), normalizeOpCodeFlags(controller, cmd),
					normalizeParameters(params)));
		}
	}

	public static void loggerDebug(IntCodeController controller, String string) {
		if (logger.isDebugEnabled()) {
			logger.debug(format(INTCODE_CONTROLLER_FORMAT, controller.getName(), controller.getIntPointer(), string));
		}
	}

	private static String normalizeOpCodeFlags(IntCodeController controller, IntCodeCmd cmd) {
		int[] opCodeNumbers = cmd.getOpCodeNumbers(controller.getMemory(), controller.getIntPointer());
		return stream(opCodeNumbers).mapToObj(x -> format("%d ", x)).collect(Collectors.joining());
	}

	private static <T> String normalizeParameters(T[] params) {
		IntCodeValue temp = new IntCodeValue(0);
		return stream(params).map(x -> {
			temp.value = temp.value + 1;
			return format("%-17s", x.toString());
		}).collect(Collectors.joining());

	}

	private static String normalizeOpCodeName(IntCodeCmd cmd) {
		return cmd.getClass().getSimpleName().replaceAll("^OpCode", "");
	}

}
