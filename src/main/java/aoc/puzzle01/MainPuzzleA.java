package aoc.puzzle01;

import java.io.IOException;

import aoc.AOCPuzzle;
import time.projects.fileconverter.reader.LineScanner;

public class MainPuzzleA extends AOCPuzzle<NumberLine> {

	@Override
	public void setup() {
		this.setEingabeDateiName("p1.txt");
		this.setConverterReader(new LineScanner<>(NumberLine.class));
		this.addLineProcessors(new FuelRequirementsLineProcessor());
		this.addPostConverters(new SumFuelPostConvert());
	}

	public static void main(String[] args) throws IOException {
		startSolving(new MainPuzzleA()).forEach(System.out::println);
	}

}
