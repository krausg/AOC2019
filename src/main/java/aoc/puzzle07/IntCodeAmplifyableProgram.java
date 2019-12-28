package aoc.puzzle07;

import static java.util.Collections.singletonMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.puzzle05.IntCodeCmd;
import aoc.puzzle05.IntCodeController;
import aoc.puzzle05.IntCodeLoggerUtils;
import aoc.puzzle05.IntCodeMemory;
import aoc.puzzle05.IntCodeProgram;

public class IntCodeAmplifyableProgram extends IntCodeProgram implements IntCodeAmplifyableController {

	private List<Integer> amplifierPhaseSettings = new ArrayList<>(0);

	private String firstInput;

	private Map<Integer, IntCodeController> phaseAmplifierMap = new HashMap<>();

	private boolean feedbackLoopMode = false;

	public IntCodeAmplifyableProgram(IntCodeMemory memory, Map<Integer, IntCodeCmd> cmdMap,
			List<Integer> phaseSettings) {
		super(memory, cmdMap);
		this.setName("Main");
		this.amplifierPhaseSettings.clear();
		this.amplifierPhaseSettings.addAll(phaseSettings);
	}

	public IntCodeAmplifyableProgram(IntCodeAmplifyableController copyPgm) {
		super(copyPgm);
		this.feedbackLoopMode = copyPgm.isFeedbackLoopMode();
	}

	@Override
	public String run() {
		IntCodeLoggerUtils.loggerDebug(this, "Starting Program");
		String result = getFirstInput();
		boolean isComplete = false;
		do {
			result = runAllAmplifier(result);
			isComplete = phaseAmplifierMap.values().parallelStream().allMatch(IntCodeController::isHalted);
		} while (feedbackLoopMode && !isComplete);

		IntCodeLoggerUtils.loggerDebug(this, "Stop Program, returning result");
		return result;
	}

	private String runAllAmplifier(String firstInput) {
		String result = firstInput;
		for (Integer phaseSetting : amplifierPhaseSettings) {
			IntCodeController amplifier = loadAmplifier(result, phaseSetting);
			if (!amplifier.isHalted()) {
				IntCodeLoggerUtils.loggerDebug(this, "Switch Amplifier to: " + amplifier.getName());
				amplifier.resetOutputCache();
				amplifier.setPaused(false);
				String ampOutput = amplifier.run();
				result = ampOutput.isEmpty() ? result : ampOutput;
			}
		}
		return result;
	}

	private IntCodeController loadAmplifier(String input, Integer phaseSetting) {
		IntCodeController amplifier = phaseAmplifierMap.computeIfAbsent(phaseSetting, (x) -> {
			IntCodeProgram intCodePGM = new IntCodeProgram(this);
			intCodePGM.setName(String.format("Amplifier-%02d", phaseSetting));
			IntCodeLoggerUtils.loggerDebug(this, "Creating new Amplifier: " + intCodePGM.getName());
			return intCodePGM;
		});
		amplifier.getCmdMap().put(3, new OpCodePresetableRead(input, singletonMap(0, phaseSetting)));
		return amplifier;
	}

	@Override
	public List<Integer> getAmplifierPhaseSettings() {
		return amplifierPhaseSettings;
	}

	@Override
	public void setAmplifierPhaseSettings(List<Integer> amplifierPhaseSettings) {
		this.amplifierPhaseSettings = amplifierPhaseSettings;
	}

	@Override
	public IntCodeAmplifyableController klon() {
		return new IntCodeAmplifyableProgram(this);
	}

	@Override
	public boolean isFeedbackLoopMode() {
		return feedbackLoopMode;
	}

	@Override
	public void setFeedbackLoopMode(boolean feedbackLoopMode) {
		this.feedbackLoopMode = feedbackLoopMode;
	}

	@Override
	public void setFirstInput(String input) {
		this.firstInput = input;
	}

	@Override
	public String getFirstInput() {
		return firstInput;
	}

}
