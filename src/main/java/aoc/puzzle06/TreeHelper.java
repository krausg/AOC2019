package aoc.puzzle06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeHelper {

	public int countAllConnections(Map<String, List<String>> nodeEdges, String rootNode) {
		return createNodeDepthMap(nodeEdges, rootNode).values().stream().mapToInt(Integer::intValue).sum();
	}

	private Map<String, Integer> createNodeDepthMap(Map<String, List<String>> nodeEdges, String node) {
		return createNodeDepthMap(nodeEdges, node, new HashMap<>(), 0);
	}

	private Map<String, Integer> createNodeDepthMap(Map<String, List<String>> nodeEdges, String node,
			Map<String, Integer> nodeDepthMap, int currentDepth) {
		nodeDepthMap.putIfAbsent(node, currentDepth);
		nodeEdges.getOrDefault(node, new ArrayList<>())
				.forEach(nodeChild -> createNodeDepthMap(nodeEdges, nodeChild, nodeDepthMap, currentDepth + 1));
		return nodeDepthMap;
	}

	public int findClosestConnection(Map<String, List<String>> edgeConnections, String start, String ende) {
		Map<String, Node> nodePool = new HashMap<>();

		// erstellt nodes im Pool
		edgeConnections.forEach((nodeValue, cons) -> {
			Map<String, Node> result = new HashMap<>();
			result.put(nodeValue, new Node(nodeValue));
			cons.forEach(element -> result.put(element, new Node(element)));
			nodePool.putAll(result);
		});

		// setzt relationen zwischen Nodes
		edgeConnections.forEach((nodeValue, cons) -> {
			Node node = nodePool.get(nodeValue);
			cons.forEach(con -> {
				Node conNode = nodePool.get(con);
				conNode.parent = node;
				node.children.add(conNode);
			});
		});
		return calcMinConnection(start, ende, nodePool);
	}

	private int calcMinConnection(String start, String ende, Map<String, Node> nodePool) {
		return calcMinConnection(nodePool.get(start), nodePool.get(ende), nodePool, new ArrayList<>(), -1);
	}

	private int calcMinConnection(Node curNode, Node string2, Map<String, Node> nodes, List<Node> alreadyUsed,
			int counter) {
		alreadyUsed.add(curNode);
		if (string2.equals(curNode)) {
			return counter - 1;
		}

		// traversiere kinder egal welche richtung, hauptsache noch nicht besucht
		for (Node node : curNode.children) {
			if (alreadyUsed.contains(node)) {
				continue;
			}
			alreadyUsed.add(node);
			int tmpCounter = calcMinConnection(node, string2, nodes, alreadyUsed, counter + 1);
			if (tmpCounter != -1) {
				return tmpCounter;
			}
		}

		// traversiere eltern
		Node parent = curNode.parent;
		return alreadyUsed.contains(parent) ? -1 : calcMinConnection(parent, string2, nodes, alreadyUsed, counter + 1);
	}
}
