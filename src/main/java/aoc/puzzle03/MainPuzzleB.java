package aoc.puzzle03;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.concat;

import java.awt.Point;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import aoc.AOCPuzzle;

public class MainPuzzleB extends AOCPuzzle<DirectionCmd> {

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

		Set<Point> punkte0 = directionId0.stream().map(p -> new Point(p.x, p.y)).collect(Collectors.toSet());
		Set<Point> punkte1 = directionId1.stream().map(p -> new Point(p.x, p.y)).collect(Collectors.toSet());

		List<DirectionPoint> direction0GleichPunkte1 = directionId0.stream()
				.filter(p -> punkte1.contains(new Point(p.x, p.y))).filter(p -> !new Point(0, 0).equals(p))
				.collect(Collectors.toList());
		List<DirectionPoint> direction1GleichPunkte0 = directionId1.stream()
				.filter(p -> punkte0.contains(new Point(p.x, p.y))).filter(p -> !new Point(0, 0).equals(p))
				.collect(Collectors.toList());

		return concat(direction0GleichPunkte1.stream(), direction1GleichPunkte0.stream())
				.collect(toMap(Point::new, DirectionPoint::getStepsFromStart, (x1, x2) -> (x1 + x2))).values().stream()
				.sorted().findFirst().orElse(null);
	}

	public static void main(String[] args) throws IOException {
		System.out.println(new MainPuzzleB().start());
	}

}
