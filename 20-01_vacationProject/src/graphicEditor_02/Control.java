package graphicEditor_02;

import java.awt.*;

import javax.swing.JPanel;


public class Control extends JPanel {
	private int currentStatus;	// 0 : default, 1 : 선 , 2 : 원, 3 : 사각형, 4 : 세모, 5 : 별, 6 : 하트, 7 : 좌우화살표, 8 : 상하화살표, 9 : 지우개, 10 : 범위선택
	private JPanel p;
	private Color currentColor;
	private int lineSize;
	private Graphics g = getGraphics();

	private Point startP = null;
	private Point endP = null;
	
	EdgeColor color = new EdgeColor();
	Bold bold = new Bold();
	
//	MakeLine makeLine = new MakeLine();
	
	Control(){
		currentStatus = GraphicEditorMain.DEFAULT;
		p = new JPanel();
		p.setBounds(10, 115, GraphicEditorMain.SCREEN_WIDTH - 25, GraphicEditorMain.SCREEN_HEIGHT - 180);
		p.setBackground(new Color(253, 253, 253));
		p.setVisible(true);
		currentColor = color.getEdgeColor();
		lineSize = bold.getBoldSize();
	}

	public int getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(int currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public JPanel getP() {
		return p;
	}

	public void setP(JPanel p) {
		this.p = p;
	}
	
	public Color getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}

	public int getLineSize() {
		return lineSize;
	}

	public void setLineSize(int lineSize) {
		this.lineSize = lineSize;
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
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
	
	public void drawLine(int x1, int y1, int x2, int y2, Graphics g) {
		super.paintComponent(g);
		rePaint(g);
		g.drawLine(startP.x + 13, startP.y + 166, endP.x + 13, endP.y + 166);
	}
	
	public void eraseLine(int x1, int y1, int x2, int y2, Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(30, BasicStroke.CAP_ROUND, 0));
		g2.setPaint(new Color(253, 253, 253));		// 투명도도 한번 처리해보자
		g.drawLine(startP.x + 13, startP.y + 166, endP.x + 13, endP.y + 166);
	}
	
	public void selectSection(int[] x, int[] y, Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
		g2.setPaint(new Color(153, 217, 234));		
		g.drawPolygon(x, y, y.length);
		System.out.println("yea");
	}
	
	
	public void rePaint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(lineSize, BasicStroke.CAP_ROUND, 0));
		g2.setPaint(currentColor);
	}

	public void hidePanel() {
		p.setVisible(false);
	}
	
	public void showPanel() {
		p.setVisible(true);
	}
	
	public JPanel resetPanel() {
		p.setVisible(false);
		p = new JPanel();
		p.setBounds(10, 115, GraphicEditorMain.SCREEN_WIDTH - 25, GraphicEditorMain.SCREEN_HEIGHT - 180);
		p.setBackground(new Color(253, 253, 253));
		p.setVisible(true);
		currentColor = color.getEdgeColor();
		lineSize = bold.getBoldSize();
		return p;
	}
	



	public void changeCurrentStatus(int num) {
		if(num != currentStatus) {
			if(num == GraphicEditorMain.DEFAULT) {
				
			}
			else if(num == GraphicEditorMain.LINE) {
			
				
			}
			else if(num == GraphicEditorMain.SQUARE) {
				
			}
		}
	}

	
	
}
