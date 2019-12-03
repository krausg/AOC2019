package aoc.puzzle02;

import java.io.IOException;

import aoc.AOCPuzzle;

public class MainPuzzleA extends AOCPuzzle<IntCodeCmd> {

	@Override
	protected void setup() {
		this.setEingabeDateiName("p2.txt");
		this.setConverterReader(new IntCodeCmdScanner());
		this.addLineProcessors(new PrintIntCodeCmds(), new IntCodeCmdProcessor(true));
		this.addPostConverters(new PrintFirstOpCodePostConverter(), new PrintIntCodeCmds());
	}

	public static void main(String[] args) throws IOException {
		startSolving(new MainPuzzleA());
	}

}
