package nodeExam;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
/**
 * Each instance of this represents a node in the node-link graph
 * @invar | getLinks() == null || getLinks().stream().allMatch(l->l.getNodes().contains(this))
 */
public abstract class Node {
	/**
	 * @invar | links == null || links.stream().allMatch(l->l.nodes.contains(this))
	 * @representationObjects
	 * @peerObjects
	 */
	Set<Link> links;
	
	/**
	 * @peerObjects
	 */
	public Set<Link> getLinks(){
		return Set.copyOf(links);
	}
	
	/**
	 * @creates | this
	 * @post | getLinks().isEmpty()
	 */
	public Node() {
		links = new HashSet<>();
	}
	
	public abstract Color getColor();
	
	public abstract int getWidth();
	
	public abstract boolean sameApp(Node other);
}
