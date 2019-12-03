package aoc.puzzle02;

import java.io.IOException;

import aoc.AOCPuzzle;

public class MainPuzzleA extends AOCPuzzle<IntCodeCmd> {

	@Override
	public void setup() {
		this.setEingabeDateiName("p2.txt");
		this.setConverterReader(new IntCodeCmdScanner());
		this.addPreConverters(new SetupIntCodeCmdsPuzzle2(12, 2));
		this.addLineProcessors(new PrintIntCodeCmds(), new IntCodeCmdProcessor(true));
		this.addPostConverters(new PrintFirstOpCodePostConverter());
	}

	public static void main(String[] args) throws IOException {
		startSolving(new MainPuzzleA());
	}

}
