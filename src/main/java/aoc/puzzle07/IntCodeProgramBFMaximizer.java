package aoc.puzzle07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import aoc.puzzle05.IntCodeController;

public class IntCodeProgramBFMaximizer {

	public static int run(IntCodeController intCodePGM, List<Integer> phaseNumbers) throws IOException {
		List<List<Integer>> phaseSettingsPool = generatePhaseSettingsPool(phaseNumbers);

		int highestNumber = 0;
		for (List<Integer> phaseSettings : phaseSettingsPool) {
			IntCodeAmplifyableProgram tmpPGM = new IntCodeAmplifyableProgram(intCodePGM);
			tmpPGM.setName("Main-" + phaseSettings.toString());
			tmpPGM.setAmplifierPhaseSettings(phaseSettings);

			int resultOuput = Integer.parseInt(tmpPGM.run());
			highestNumber = highestNumber > resultOuput ? resultOuput : highestNumber;
		}
		return highestNumber;
	}

	private static ArrayList<List<Integer>> generatePhaseSettingsPool(List<Integer> phaseNumbers) {
		return new ArrayList<>();
	}

}
