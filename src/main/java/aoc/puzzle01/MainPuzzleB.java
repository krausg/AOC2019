package aoc.puzzle01;

import java.io.IOException;

import aoc.AOCPuzzle;
import time.projects.fileconverter.reader.LineScanner;

public class MainPuzzleB extends AOCPuzzle<NumberLine> {

	@Override
	public void setup() {
		this.setEingabeDateiName("p1.txt");
		this.setConverterReader(new LineScanner<>(NumberLine.class));
		this.addLineProcessors(new RecursiveFuelRequirementsLineProcessor());
		this.addPostConverters(new SumFuelPostConvert());
	}

	public static void main(String[] args) throws IOException {
		startSolving(new MainPuzzleB()).forEach(System.out::println);
	}
}
