package nodeExam;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.*;

/**
 * each instance of the class represents a link in the node-link graph
 * @invar | getNodes() == null || getNodes().stream().allMatch(n->n.getLinks().contains(this))
 */
public class Link {
	
	/**
	 * @invar | nodes == null || nodes.stream().allMatch(n->n.links.contains(this))
	 * @representationObjects
	 * @peerObjects
	 */
	Set<Node> nodes;
	/**
	 * @peerObjects
	 */
	public Set<Node> getNodes(){
		return Set.copyOf(nodes);
	}
	
	/**
	 * @creates | this
	 * @post | getNodes().isEmpty()
	 */
	public Link() {
		nodes = new HashSet<>();
	}
	
	/**
	 * @throws IllegalStateException | node.getLinks().contains(this)
	 * @mutates_properties | getNodes(), node.getLinks()
	 * @post | getNodes().equals(LogicalSet.plus(old(getNodes()), node))
	 * @post | node.getLinks().equals(LogicalSet.plus(old(node.getLinks()), this))
	 */
	public void addLink(Node node) {
		if (node.getLinks().contains(this))
			throw new IllegalStateException("Link already exists.");
		node.links.add(this);
		this.nodes.add(node);
	}
	
	/**
	 * @pre | node.getLinks().contains(this)
	 * @mutates_properties | getNodes(), node.getLinks()
	 * @post | getNodes().equals(LogicalSet.minus(old(getNodes()), node))
	 * @post | node.getLinks().equals(LogicalSet.minus(old(node.getLinks()), this))
	 */
	public void removeLink(Node node) {
		node.links.remove(this);
		this.nodes.remove(node);
	}
}
