package aoc.puzzle03;

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
		DirectionPoint curPlotPoint = directionPlotData.getPlotPoint(directionId);
		directionPlotData.addPlotData(directionId,
				generierePlotData(curPlotPoint, element.getDirectionEnum(), element.getDirectionAmount()));
		return element;
	}

	private Collection<DirectionPoint> generierePlotData(DirectionPoint startPlotPoint, DirectionEnum directionEnum,
			int directionAmount) {
		List<DirectionPoint> plotData = new ArrayList<>();
		DirectionPoint curPlotPoint = startPlotPoint;
		for (int i = 0; i < directionAmount; i++) {
			curPlotPoint = clonePointToDirection(directionEnum, curPlotPoint);
			plotData.add(curPlotPoint);
		}
		return plotData;
	}

	private DirectionPoint clonePointToDirection(DirectionEnum directionEnum, DirectionPoint curPlotPoint) {
		DirectionPoint directionPoint = new DirectionPoint(curPlotPoint.getStepsFromStart(), curPlotPoint);
		switch (directionEnum) {
		case D:
			directionPoint.move(curPlotPoint.x, curPlotPoint.y - 1);
			return new DirectionPoint(ok(directionEnum, directionPoint), directionPoint);
		case L:
			directionPoint.move(curPlotPoint.x - 1, curPlotPoint.y);
			return new DirectionPoint(ok(directionEnum, directionPoint), directionPoint);
		case R:
			directionPoint.move(curPlotPoint.x + 1, curPlotPoint.y);
			return new DirectionPoint(ok(directionEnum, directionPoint), directionPoint);
		case U:
			directionPoint.move(curPlotPoint.x, curPlotPoint.y + 1);
			return new DirectionPoint(ok(directionEnum, directionPoint), directionPoint);
		default:
			throw new RuntimeException("unknown direction: " + directionEnum);
		}
	}

	private int ok(DirectionEnum directionEnum, DirectionPoint curPlotPoint) {

		int indicator = 1;
		// switch (directionEnum) {
		// case D:
		// if (curPlotPoint.y > 0) {
		// indicator -= 1;
		// } else if (curPlotPoint.y < 0) {
		// indicator += 1;
		// }
		// break;
		// case L:
		// if (curPlotPoint.x > 0) {
		// indicator -= 1;
		// } else if (curPlotPoint.x < 0) {
		// indicator += 1;
		// }
		// break;
		// case R:
		// if (curPlotPoint.x < 0) {
		// indicator -= 1;
		// } else if (curPlotPoint.x > 0) {
		// indicator += 1;
		// }
		// break;
		// case U:
		// if (curPlotPoint.y < 0) {
		// indicator -= 1;
		// } else if (curPlotPoint.y > 0) {
		// indicator += 1;
		// }
		// break;
		// default:
		// throw new RuntimeException("unknown direction: " + directionEnum);
		// }
		return curPlotPoint.getStepsFromStart() + indicator;
	}

}
