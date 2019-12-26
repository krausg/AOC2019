package aoc.puzzle07;

import static java.util.Collections.singletonMap;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import aoc.puzzle05.IntCodeCmd;
import aoc.puzzle05.IntCodeController;
import aoc.puzzle05.IntCodeLoggerUtils;
import aoc.puzzle05.IntCodeMemory;
import aoc.puzzle05.IntCodeProgram;

public class IntCodeAmplifyableProgram extends IntCodeProgram {

	private List<Integer> amplifierPhaseSettings = new ArrayList<>(0);

	private InputStream firstInput = System.in;

	public IntCodeAmplifyableProgram(IntCodeMemory memory, Map<Integer, IntCodeCmd> cmdMap,
			List<Integer> phaseSettings) {
		super(memory, cmdMap);
		this.setName("Main");
		this.amplifierPhaseSettings.clear();
		this.amplifierPhaseSettings.addAll(phaseSettings);
	}

	public IntCodeAmplifyableProgram(IntCodeController copyPgm) {
		super(copyPgm);
	}

	@Override
	public String run() {
		IntCodeLoggerUtils.loggerDebug(this, "Starting Program");
		IntCodeController intCodeProgram = createNewAmplifier(getFirstInput(), amplifierPhaseSettings.remove(0));
		String ampOutput = intCodeProgram.run();
		for (Integer phaseSetting : amplifierPhaseSettings) {
			intCodeProgram = createNewAmplifier(new ByteArrayInputStream(ampOutput.getBytes()), phaseSetting);
			ampOutput = intCodeProgram.run();
		}
		IntCodeLoggerUtils.loggerDebug(this, "Stop Program, returning result");
		return ampOutput;
	}

	private IntCodeController createNewAmplifier(InputStream input, Integer phaseSetting) {
		IntCodeProgram intCodeProgram = new IntCodeProgram(this);
		intCodeProgram.setName(String.format("Amplifier-%02d", phaseSetting));
		IntCodeLoggerUtils.loggerDebug(this, "Creating new Amplifier: " + intCodeProgram.getName());
		intCodeProgram.getCmdMap().put(3, new OpCodePresetableRead(input, singletonMap(0, phaseSetting)));
		return intCodeProgram;
	}

	public InputStream getFirstInput() {
		return firstInput;
	}

	public void setFirstInput(InputStream firstInput) {
		this.firstInput = firstInput;
	}

	public List<Integer> getAmplifierPhaseSettings() {
		return amplifierPhaseSettings;
	}

	public void setAmplifierPhaseSettings(List<Integer> amplifierPhaseSettings) {
		this.amplifierPhaseSettings = amplifierPhaseSettings;
	}

}
