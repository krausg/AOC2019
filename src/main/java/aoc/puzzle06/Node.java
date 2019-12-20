package aoc.puzzle06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Node {

	public Node parent = null;
	public final String value;
	public final List<Node> children = new ArrayList<>();

	public Node(String value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [parent=" + (parent != null ? parent.value : "null") + ", value=" + value + ", children="
				+ getChildrenValues() + "]";
	}

	private List<String> getChildrenValues() {
		return children.stream().map(x -> x.value).collect(Collectors.toList());
	}

	@Override
	public int hashCode() {
		return Objects.hash(children, parent, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Node)) {
			return false;
		}
		Node other = (Node) obj;
		return Objects.equals(getChildrenValues(), other.getChildrenValues()) && Objects.equals(parent, other.parent)
				&& Objects.equals(value, other.value);
	}

}
