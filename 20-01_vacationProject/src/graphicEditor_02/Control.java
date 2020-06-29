package graphicEditor_02;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Control extends JPanel {
	private int currentStatus;	// 0 : default, 1 : 선 , 2 : 원, 3 : 사각형, 4 : 세모, 5 : 별, 6 : 하트, 7 : 좌우화살표, 8 : 상하화살표, 9 : 지우개, 10 : 범위선택
	private JPanel p;
	private Color currentColor;
	private int lineSize;
	private int shapeAmount;
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
		shapeAmount = 0;
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
	
	
	public int getShapeAmount() {
		return shapeAmount;
	}

	public void setShapeAmount(int shapeAmount) {
		this.shapeAmount = shapeAmount;
	}

	public void drawLine(int x[], int y[], Graphics g) {
		super.paintComponent(g);
		rePaint(g, lineSize, currentColor);
		g.drawLine(x[0], y[0], x[1], y[1]);
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
	
	}
	
	
	public void rePaint(Graphics g, int lineSize, Color currentColor) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(lineSize, BasicStroke.CAP_ROUND, 0));
		g2.setPaint(currentColor);
	}
	
	public void rePaintForChoice(Graphics g, int lineSize, Color currentColor) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(lineSize, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
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
		shapeAmount = 0;
		return p;
	}
	
	public void drawShape(ArrayList<VarietyShape> list, Graphics g) {
		
	
		for(int i = 0; i < list.size(); i++) {
			
			if(list.get(i).isFill()) {
				
				if(list.get(i).getPentagon() == 2) {
					super.paintComponent(g);
					rePaint(g, list.get(i).getEdgeSize(), list.get(i).getColor());
//					g.fillOval(list.get(i).getX()[0], list.get(i).getY()[0], list.get(i).getX()[2], list.get(i).getY()[2]);
					
					if(list.get(i).getX()[0] <= list.get(i).getX()[1] && list.get(i).getY()[0] <= list.get(i).getY()[1]) g.fillOval(list.get(i).getX()[0], list.get(i).getY()[0], list.get(i).getX()[2], list.get(i).getY()[2]);		// 4사분면
					else if(list.get(i).getX()[0] <= list.get(i).getX()[1] && list.get(i).getY()[0] > list.get(i).getY()[1]) g.fillOval(list.get(i).getX()[0], list.get(i).getY()[1], list.get(i).getX()[2], list.get(i).getY()[2]);	// 1사분면
					else if(list.get(i).getX()[0] > list.get(i).getX()[1] && list.get(i).getY()[0] <= list.get(i).getY()[1]) g.fillOval(list.get(i).getX()[1], list.get(i).getY()[0], list.get(i).getX()[2], list.get(i).getY()[2]);	// 3사분면
					else g.fillOval(list.get(i).getX()[1], list.get(i).getY()[1], list.get(i).getX()[2], list.get(i).getY()[2]);																										// 2사분면
					
				}
				else if(list.get(i).getPentagon() == 3 || list.get(i).getPentagon() == 4 || list.get(i).getPentagon() == 5 || list.get(i).getPentagon() == 7 || list.get(i).getPentagon() == 8) {
					super.paintComponent(g);
					rePaint(g, list.get(i).getEdgeSize(), list.get(i).getColor());
					g.fillPolygon(list.get(i).getX(), list.get(i).getY(), list.get(i).getY().length);
					
				}	
				else if(list.get(i).getPentagon() == 6) {
					super.paintComponent(g);
					rePaint(g, list.get(i).getEdgeSize(), list.get(i).getColor());
					g.fillArc(list.get(i).getX()[0], list.get(i).getY()[0], list.get(i).getX()[1], list.get(i).getY()[1], 0, 180);
					g.fillArc(list.get(i).getX()[2], list.get(i).getY()[0], list.get(i).getX()[1], list.get(i).getY()[1], 0, 180);
					g.fillArc(list.get(i).getX()[0], list.get(i).getY()[2], list.get(i).getX()[3], list.get(i).getY()[3], 0, -180);
					
				}	
				
			}
			else {
				
				if(list.get(i).getPentagon() == 1) {
					super.paintComponent(g);
					rePaint(g, list.get(i).getEdgeSize(), list.get(i).getColor());
					g.drawLine(list.get(i).getX()[0], list.get(i).getY()[0], list.get(i).getX()[1], list.get(i).getY()[1]);
					
				}
				else if(list.get(i).getPentagon() == 2) {
					super.paintComponent(g);
					rePaint(g, list.get(i).getEdgeSize(), list.get(i).getColor());
					
					if(list.get(i).getX()[0] <= list.get(i).getX()[1] && list.get(i).getY()[0] <= list.get(i).getY()[1]) g.drawOval(list.get(i).getX()[0], list.get(i).getY()[0], list.get(i).getX()[2], list.get(i).getY()[2]);		// 4사분면
					else if(list.get(i).getX()[0] <= list.get(i).getX()[1] && list.get(i).getY()[0] > list.get(i).getY()[1]) g.drawOval(list.get(i).getX()[0], list.get(i).getY()[1], list.get(i).getX()[2], list.get(i).getY()[2]);	// 1사분면
					else if(list.get(i).getX()[0] > list.get(i).getX()[1] && list.get(i).getY()[0] <= list.get(i).getY()[1]) g.drawOval(list.get(i).getX()[1], list.get(i).getY()[0], list.get(i).getX()[2], list.get(i).getY()[2]);	// 3사분면
					else g.drawOval(list.get(i).getX()[1], list.get(i).getY()[1], list.get(i).getX()[2], list.get(i).getY()[2]);																										// 2사분면
								
				}
				else if(list.get(i).getPentagon() == 3 || list.get(i).getPentagon() == 4 || list.get(i).getPentagon() == 5 || list.get(i).getPentagon() == 7 || list.get(i).getPentagon() == 8 || list.get(i).getPentagon() == 9) {
					super.paintComponent(g);
					rePaint(g, list.get(i).getEdgeSize(), list.get(i).getColor());
					g.drawPolygon(list.get(i).getX(), list.get(i).getY(), list.get(i).getY().length);
					
				}	
				else if(list.get(i).getPentagon() == 6) {
					super.paintComponent(g);
					rePaint(g, list.get(i).getEdgeSize(), list.get(i).getColor());
					g.drawArc(list.get(i).getX()[0], list.get(i).getY()[0], list.get(i).getX()[1], list.get(i).getY()[1], 0, 180);
					g.drawArc(list.get(i).getX()[2], list.get(i).getY()[0], list.get(i).getX()[1], list.get(i).getY()[1], 0, 180);
					g.drawArc(list.get(i).getX()[0], list.get(i).getY()[2], list.get(i).getX()[3], list.get(i).getY()[3], 0, -180);	
				}
				else if(list.get(i).getPentagon() == 10) {
					super.paintComponent(g);
					rePaintForChoice(g, list.get(i).getEdgeSize(), list.get(i).getColor());
					g.drawRect(list.get(i).getX()[0], list.get(i).getY()[0], list.get(i).getX()[1] - list.get(i).getX()[0], list.get(i).getY()[1] - list.get(i).getY()[0]);
				}
				
			}
			
			
		}
		
	}
	

	
	
}
