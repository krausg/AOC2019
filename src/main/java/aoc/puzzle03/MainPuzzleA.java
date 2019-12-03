package aoc.puzzle03;

import java.awt.Point;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import aoc.AOCPuzzle;

public class MainPuzzleA extends AOCPuzzle<DirectionCmd> {

	private DirectionPlotData directionPlotData = new DirectionPlotData();

	@Override
	public void setup() {
		this.setEingabeDateiName("p3.txt");
		this.setConverterReader(new DirectionCmdScanner());
		this.addLineProcessors(new DirectionCmdProcessor(directionPlotData));
	}

	public int start() throws IOException {
		startSolving(this);
		Set<Point> directionId0 = new HashSet<>(directionPlotData.getDirectionIdPlotDataMap().get(0));
		Set<Point> directionId1 = new HashSet<>(directionPlotData.getDirectionIdPlotDataMap().get(1));
		return directionId0.stream().filter(directionId1::contains).filter(p -> !new Point(0, 0).equals(p))
				.map(x -> Math.abs(x.x) + Math.abs(x.y)).sorted().findFirst().orElse(-1);
	}

	public static void main(String[] args) throws IOException {
		System.out.println(new MainPuzzleA().start());
	}

}
