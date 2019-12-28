package aoc.puzzle07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntCodeProgramOutputMaximizer {

	public static int run(IntCodeAmplifyableController intCodePGM, List<Integer> phaseNumbers) throws IOException {
		List<List<Integer>> phaseSettingsPool = generatePhaseSettingsPool(phaseNumbers);

		int highestNumber = 0;
		for (List<Integer> phaseSettings : phaseSettingsPool) {
			IntCodeAmplifyableController tmpPGM = intCodePGM.klon();
			tmpPGM.setFirstInput("0");
			tmpPGM.setName("Main-" + phaseSettings.toString());
			tmpPGM.setAmplifierPhaseSettings(phaseSettings);

			int resultOuput = Integer.parseInt(tmpPGM.run());
			highestNumber = highestNumber < resultOuput ? resultOuput : highestNumber;
		}
		return highestNumber;
	}

	private static List<List<Integer>> generatePhaseSettingsPool(List<Integer> phaseNumbers) {
		List<List<Integer>> phaseSettingsPool = new ArrayList<>();

		if (phaseNumbers.size() > 2) {
			for (Integer integer : phaseNumbers) {
				ArrayList<Integer> tmpNumbers = new ArrayList<>(phaseNumbers);
				tmpNumbers.remove(integer);
				generatePhaseSettingsPool(tmpNumbers).forEach(x -> {
					x.add(0, integer);
					phaseSettingsPool.add(x);
				});
			}
		} else {
			phaseSettingsPool.add(new ArrayList<>(phaseNumbers));
			phaseSettingsPool.add(new ArrayList<>(Arrays.asList(phaseNumbers.get(1), phaseNumbers.get(0))));
		}
		return phaseSettingsPool;
	}

}
