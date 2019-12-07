package aoc.puzzle03;

import java.awt.Point;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
		Set<DirectionPoint> directionId0 = new HashSet<>(directionPlotData.getDirectionIdPlotDataMap().get(0));
		Set<DirectionPoint> directionId1 = new HashSet<>(directionPlotData.getDirectionIdPlotDataMap().get(1));

		Set<Point> collect = directionId1.stream().map(p -> new Point(p.x, p.y)).collect(Collectors.toSet());

		return directionId0.stream().filter(p -> collect.contains(new Point(p)))
				.filter(p -> !new DirectionPoint(0, 0, 0).equals(p)).map(DirectionPoint::getManhattenDistanceFromStart).sorted()
				.findFirst().orElse(-1);
	}

	public static void main(String[] args) throws IOException {
		System.out.println(new MainPuzzleA().start());
	}

}
