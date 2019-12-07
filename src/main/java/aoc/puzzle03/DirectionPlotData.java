package aoc.puzzle03;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DirectionPlotData {

	private Map<Integer, Deque<DirectionPoint>> directionIdPlotDataMap = new HashMap<>();

	public void addPlotData(int directionId, Collection<DirectionPoint> plotDatas) {
		// System.out.println("fuege punkte hinzu: " + plotDatas);
		directionIdPlotDataMap.computeIfPresent(directionId, (k, v) -> {
			v.addAll(plotDatas);
			return v;
		});
		directionIdPlotDataMap.putIfAbsent(directionId, new ArrayDeque<>(plotDatas));
	}

	public DirectionPoint getPlotPoint(int directionId) {
		if (!directionIdPlotDataMap.containsKey(directionId)) {
			directionIdPlotDataMap.put(directionId, new ArrayDeque<>(Arrays.asList(new DirectionPoint(0, 0, 0))));
		}
		// System.out.println("letzter punkt:" +
		// directionIdPlotDataMap.get(directionId).getLast());
		return directionIdPlotDataMap.get(directionId).getLast();
	}

	public Map<Integer, Deque<DirectionPoint>> getDirectionIdPlotDataMap() {
		return directionIdPlotDataMap;
	}
}
