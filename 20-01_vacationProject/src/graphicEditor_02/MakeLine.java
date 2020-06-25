package graphicEditor_02;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;

import javax.swing.*;


public class MakeLine extends JFrame {
	
	Point startP = null;
	Point endP = null;
	
	MakeLine(){
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		makeUI();
		setVisible(true);
	}
	
	private void makeUI() {
		MyPanel p = new MyPanel();
		
		
		p.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startP = e.getPoint();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				endP = e.getPoint();
				Graphics g = getGraphics();
				g.drawLine(startP.x, startP.y + 30, endP.x, endP.y + 30);
			}
		});
//		p.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseDragged(MouseEvent e) {
//				int x = e.getXOnScreen();
//				int y = e.getYOnScreen();
//				g.drawLine(startP.x, startP.y, x, y);
//			
//			}
//			
//		});
		add(p, BorderLayout.CENTER);
	}
	
	class MyPanel extends JPanel{
		protected void paintComponent(Graphics g) {

			Graphics2D g2 = (Graphics2D)g;
			g2.setStroke(new BasicStroke(30,BasicStroke.CAP_SQUARE,0));
		    g2.draw(new Line2D.Double(100,100,200,100));
			
		}
	}
	
}
