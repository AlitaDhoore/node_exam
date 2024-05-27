package nodeExam;
import java.awt.Color;
import java.awt.color.*;

public class circleNode extends Node {
	
	private int radius;
	private Color color;
	
	public int getWidth() {
		return radius;
	}
	public Color getColor() {
		return color;
	}
	
	public circleNode(int iniwidth, Color inicolor) {
		this.color = inicolor;
		this.radius = iniwidth;
	}
	
	@Override
	public boolean sameApp(Node other) {
		if (other instanceof circleNode)
			if (this.getColor() == other.getColor() && this.getWidth() == other.getWidth())
				return true;
		return false;
	}
}
