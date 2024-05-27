package nodeExam;
import java.awt.Color;
import java.awt.color.*;

public class squareNode extends Node {
	
	private int width;
	private Color color;
	
	public int getWidth() {
		return width;
	}
	public Color getColor() {
		return color;
	}
	
	public squareNode(int iniwidth, Color inicolor) {
		this.color = inicolor;
		this.width = iniwidth;
	}
	
	@Override
	public boolean sameApp(Node other) {
		if (other instanceof squareNode)
			if (this.getColor() == other.getColor() && this.getWidth() == other.getWidth())
				return true;
		return false;
	}
	
}
