package graphicEditor_02;

import java.awt.Color;
import java.awt.Point;

public class VarietyShape {
	private int x[];
	private int y[];
	private int pentagon;	// 1 : �� , 2 : ��, 3 : �簢��, 4 : ����, 5 : ��, 6 : ��Ʈ, 7 : �¿�ȭ��ǥ, 8 : ����ȭ��ǥ, 9 : ���찳, 10 : ���� ����
	private boolean isFill;
	private int edgeSize;
	private Color color;
	private Point startP;
	private Point endP;
	
	VarietyShape(){
		this.x = new int[5];
		this.y = new int[5];
		pentagon = 0;
		isFill = false;
		edgeSize = 10;
		color = Color.BLACK;
		startP = null;
		endP = null;
	}
	
	VarietyShape(int x[], int y[], int pentagon, boolean isFill, int edgeSize, Color color, Point startP, Point endP){
		this.pentagon = pentagon;
		this.x = x;
		this.y = y;
		this.isFill = isFill;
		this.edgeSize = edgeSize;
		this.color = color;
		this.startP = startP;
		this.endP = endP;
	}

	public int[] getX() {
		return x;
	}

	public void setX(int[] x) {
		this.x = x;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}

	public int getPentagon() {
		return pentagon;
	}

	public void setPentagon(int pentagon) {
		this.pentagon = pentagon;
	}

	public boolean isFill() {
		return isFill;
	}

	public void setFill(boolean isFill) {
		this.isFill = isFill;
	}

	public int getEdgeSize() {
		return edgeSize;
	}

	public void setEdgeSize(int edgeSize) {
		this.edgeSize = edgeSize;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Point getStartP() {
		return startP;
	}

	public void setStartP(Point startP) {
		this.startP = startP;
	}

	public Point getEndP() {
		return endP;
	}

	public void setEndP(Point endP) {
		this.endP = endP;
	}
	
	
	
	

}
