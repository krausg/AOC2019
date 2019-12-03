package aoc.puzzle03;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import time.projects.fileconverter.LineProcessor;

public class DirectionCmdProcessor implements LineProcessor<DirectionCmd> {

	DirectionPlotData directionPlotData;

	public DirectionCmdProcessor() {
		this(new DirectionPlotData());
	}

	public DirectionCmdProcessor(DirectionPlotData directionPlotData) {
		super();
		this.directionPlotData = directionPlotData;
	}

	@Override
	public DirectionCmd process(DirectionCmd element) {
		int directionId = element.getLineCounter();
		Point curPlotPoint = directionPlotData.getPlotPoint(directionId);
		directionPlotData.addPlotData(directionId,
				generierePlotData(curPlotPoint, element.getDirectionEnum(), element.getDirectionAmount()));
		return element;
	}

	private Collection<Point> generierePlotData(Point startPlotPoint, DirectionEnum directionEnum,
			int directionAmount) {
		List<Point> plotData = new ArrayList<>();
		Point curPlotPoint = startPlotPoint;
		for (int i = 0; i < directionAmount; i++) {
			curPlotPoint = clonePointToDirection(directionEnum, curPlotPoint);
			plotData.add(curPlotPoint);
		}
		return plotData;
	}

	private Point clonePointToDirection(DirectionEnum directionEnum, Point curPlotPoint) {
		switch (directionEnum) {
		case D:
			return new Point(curPlotPoint.x, curPlotPoint.y - 1);
		case L:
			return new Point(curPlotPoint.x - 1, curPlotPoint.y);
		case R:
			return new Point(curPlotPoint.x + 1, curPlotPoint.y);
		case U:
			return new Point(curPlotPoint.x, curPlotPoint.y + 1);
		default:
			throw new RuntimeException("unknown direction: " + directionEnum);
		}
	}

}
