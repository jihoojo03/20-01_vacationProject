package graphicEditor_02;

import java.awt.Color;
import java.awt.Point;

public class VarietyShape {
	private int x[];
	private int y[];
	private int pentagon;	// 1 : 선 , 2 : 원, 3 : 사각형, 4 : 세모, 5 : 별, 6 : 하트, 7 : 좌우화살표, 8 : 상하화살표, 9 : 지우개, 10 : 범위 선택
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
