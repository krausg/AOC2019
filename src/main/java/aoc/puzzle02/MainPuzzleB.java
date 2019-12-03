package aoc.puzzle02;

import java.io.IOException;

import aoc.AOCPuzzle;

public class MainPuzzleB extends AOCPuzzle<IntCodeCmd> {

	int noun = 0;
	int verb = 0;

	public MainPuzzleB(int noun, int verb) {
		super();
		this.noun = noun;
		this.verb = verb;
	}

	@Override
	protected void setup() {
		this.setEingabeDateiName("p2.txt");
		this.setConverterReader(new IntCodeCmdScanner());
		this.addPreConverters(new SetupIntCodeCmdsPuzzle2(noun, verb));
		this.addLineProcessors(new IntCodeCmdProcessor(true));
	}

	public static void main(String[] args) throws IOException {
		for (int noun = 0; noun < 100; noun++) {
			for (int verb = 0; verb < 100; verb++) {
				Integer result = startSolving(new MainPuzzleB(noun, verb)).iterator().next().getMemory().get(0);
				if (result == 19690720) {
					System.out.printf("FOUND\t: noun:%d verb:%d puzzle-result: %d%n", noun, verb, (100 * noun + verb));
					break;
				}
			}
		}

	}
}
