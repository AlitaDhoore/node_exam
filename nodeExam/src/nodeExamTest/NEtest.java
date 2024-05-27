package nodeExamTest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.Set;

import org.junit.jupiter.api.Test;

import nodeExam.Link;
import nodeExam.Node;
import nodeExam.circleNode;
import nodeExam.squareNode;

class NEtest {

	@Test
	void test() {
		Node mynode = new squareNode(4, Color.black);
		Link mylink = new Link();
		
		mylink.addLink(mynode);
		assertThrows(IllegalStateException.class, () -> mylink.addLink(mynode));

		assertNotNull(mynode.getLinks());
		assertNotNull(mylink.getNodes());
		assertEquals(mynode.getLinks(), Set.of(mylink));
		assertEquals(mylink.getNodes(), Set.of(mynode));
				
		Node yournode = new circleNode(3, Color.red);
		mylink.addLink(yournode);
		assertNotNull(yournode.getLinks());
		assertEquals(mylink.getNodes(), Set.of(mynode, yournode));

		mylink.removeLink(mynode);
		assertEquals(mynode.getLinks(), Set.of());
		
		mylink.removeLink(yournode);
		assertEquals(yournode.getLinks(), Set.of());
		assertEquals(mylink.getNodes(), Set.of());
		
		assertFalse(mynode.sameApp(yournode));
		
		Node hernode = new circleNode(3, Color.red);
		Node hisnode = new squareNode(4, Color.black);
		
		assertTrue(yournode.sameApp(hernode));
		assertTrue(mynode.sameApp(hisnode));
		
		
		

	}

}
