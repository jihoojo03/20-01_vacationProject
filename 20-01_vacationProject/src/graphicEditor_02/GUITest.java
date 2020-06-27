package graphicEditor_02;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.*;

import calculator_01.CalculatorMain;

public class GUITest extends JFrame {
	
	private Graphics screenGraphic;
	Graphics2D g2;
	
	private ImageIcon lineButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/line.png"));
	private ImageIcon circleButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/circle.png"));
	private ImageIcon squareButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/square.png"));
	private ImageIcon triangleButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/triangle.png"));
	private ImageIcon starButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/star.png"));
	private ImageIcon heartButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/heart.png"));
	private ImageIcon horizontalArrowButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/horizontalArrow.png"));
	private ImageIcon verticalArrowButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/verticalArrow.png"));
	private ImageIcon eraserBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/eraser.png"));
	
	private JButton numButton01 = new JButton(lineButtonBasicImage);
	private JButton numButton02 = new JButton(circleButtonBasicImage);
	private JButton numButton03 = new JButton(squareButtonBasicImage);
	private JButton numButton04 = new JButton(triangleButtonBasicImage);
	private JButton numButton05 = new JButton(starButtonBasicImage);
	private JButton numButton06 = new JButton(heartButtonBasicImage);
	private JButton numButton07 = new JButton(horizontalArrowButtonBasicImage);
	private JButton numButton08 = new JButton(verticalArrowButtonBasicImage);
	private JButton colorButton = new JButton();
	private JButton boldButton = new JButton("10");
	private JButton fillButton = new JButton();
	private JButton eraserButton = new JButton();
	private JButton clearButton = new JButton();
	private JButton rangeSelectButton = new JButton();
	
	private JPanel buttonPanel = new JPanel();
	
	private JLabel shapeBox = new JLabel();
	private JLabel colorBox = new JLabel();
	private JLabel boldBox = new JLabel();
	private JLabel fillBox = new JLabel();
	private JLabel eraserBox = new JLabel();
	private JLabel clearBox = new JLabel();
	
	Point startP = null;
	Point endP = null;
	
	EdgeColor edgeColor = new EdgeColor();
	FillColor fillColor = new FillColor();
	Bold bold = new Bold();
	Control control = new Control();
	Control copyControl = new Control();
	
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Image image = toolkit.getImage(CalculatorMain.class.getResource("../images/eraser.png"));
	

	
	
	GUITest() {
		setTitle("Graphic Editor");
		setSize(GraphicEditorMain.SCREEN_WIDTH, GraphicEditorMain.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		
		createMenuBar();
		makeCanvas();
		makeShapeBox();
		makeProperty();
		makeDelete();
		makeRangeSelect();
		makePanel();
		setText();

	}
	
	public void makeCanvas() {			// 캔버스에 패널 추가
		add(control.getP());
//		add(copyControl.getP());
	}

	public void createMenuBar() {		// 메뉴바 만들기
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu01 = new JMenu("파일");

		JMenuItem item01 = new JMenuItem(new ImageIcon(CalculatorMain.class.getResource("../images/newMakeButton.png")));
		JMenuItem item02 = new JMenuItem(new ImageIcon(CalculatorMain.class.getResource("../images/saveButton.png")));
		JMenuItem item03 = new JMenuItem(new ImageIcon(CalculatorMain.class.getResource("../images/openButton.png")));
		JMenuItem item04 = new JMenuItem(new ImageIcon(CalculatorMain.class.getResource("../images/exitButton.png")));
		
		item01.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}

		});
		
		item02.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}

		});
		
		item03.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}

		});
		
		item04.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(500);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		screenMenu01.add(item01);
		screenMenu01.add(item02);
		screenMenu01.add(item03);
		screenMenu01.addSeparator();
		screenMenu01.add(item04);

		mb.add(screenMenu01);

		setJMenuBar(mb);
	}
	
	public void makePanel() {		// 패널 만들기
		buttonPanel.setBackground(new Color(224, 224, 224));
		buttonPanel.setBounds(0, 0, GraphicEditorMain.SCREEN_WIDTH, 105);
		buttonPanel.setVisible(true);
		add(buttonPanel);
	}
	
	public void makeShapeBox() {	// 도형 파트 만들기
		
		numButton01.setBounds(10, 5, 35, 35);
		numButton01.setBorderPainted(false);
		numButton01.setContentAreaFilled(false);
		numButton01.setFocusPainted(false);
		numButton01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton01.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton01.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				control.setCurrentStatus(1);
				
				control.getP().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						control.getP().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						control.setStartP(e.getPoint());
					}
					
					@Override
					public void mouseReleased(MouseEvent e) {
						if(control.getCurrentStatus() == 1) {
							Graphics g = getGraphics();
							control.setEndP(e.getPoint());
							control.drawLine(control.getStartP().x, control.getStartP().y, control.getEndP().x, control.getEndP().x, g);
//							copyControl.drawLine(control.getStartP().x, control.getStartP().y, control.getEndP().x, control.getEndP().x, g);
//							control.hidePanel();
						}
						
					}
				});
				
				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					repaint();
					Graphics g = getGraphics();
					control.setEndP(e.getPoint());
					control.drawLine(control.getStartP().x, control.getStartP().y, control.getEndP().x, control.getEndP().x, g);
					
				}
			});
//				
//				copyControl.getP().addMouseListener(new MouseAdapter() {
//					@Override
//					public void mousePressed(MouseEvent e) {
//						control.showPanel();
//					}
//				});
				
			}
		});
		add(numButton01);
		
		numButton02.setBounds(10, 45, 35, 35);
		numButton02.setBorderPainted(false);
		numButton02.setContentAreaFilled(false);
		numButton02.setFocusPainted(false);
		numButton02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton02.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton02.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				control.setCurrentStatus(2);
				
				control.getP().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						control.getP().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						startP = e.getPoint();
						
					}
					
					@Override
					public void mouseReleased(MouseEvent e) {
						
						if(control.getCurrentStatus() == 2) {
							endP = e.getPoint();
							Graphics g = getGraphics();
							rePaint(g);
							
							if(FillColor.isFill()) {
								if(startP.x <= endP.x && startP.y <= endP.y) g.fillOval(startP.x + 13, startP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));		// 4사분면
								else if(startP.x <= endP.x && startP.y > endP.y) g.fillOval(startP.x + 13, endP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));	    // 1사분면
								else if(startP.x > endP.x && startP.y <= endP.y) g.fillOval(endP.x + 13, startP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));		// 3사분면
								else g.fillOval(endP.x + 13, endP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));													// 2사분면
								
							}
							else {
								if(startP.x <= endP.x && startP.y <= endP.y) g.drawOval(startP.x + 13, startP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));		// 4사분면
								else if(startP.x <= endP.x && startP.y > endP.y) g.drawOval(startP.x + 13, endP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));	    // 1사분면
								else if(startP.x > endP.x && startP.y <= endP.y) g.drawOval(endP.x + 13, startP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));		// 3사분면
								else g.drawOval(endP.x + 13, endP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));													// 2사분면
							}
						}
					
					}
				});
				
//				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
//				@Override
//				public void mouseDragged(MouseEvent e) {
//					if(control.getCurrentStatus() == 2) {
//						endP = e.getPoint();
//						Graphics g = getGraphics();
//						rePaint(g);
//						
//						if(FillColor.isFill()) {
//							if(startP.x <= endP.x && startP.y <= endP.y) g.fillOval(startP.x + 13, startP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));		// 4사분면
//							else if(startP.x <= endP.x && startP.y > endP.y) g.fillOval(startP.x + 13, endP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));	    // 1사분면
//							else if(startP.x > endP.x && startP.y <= endP.y) g.fillOval(endP.x + 13, startP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));		// 3사분면
//							else g.fillOval(endP.x + 13, endP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));													// 2사분면
//							
//						}
//						else {
//							if(startP.x <= endP.x && startP.y <= endP.y) g.drawOval(startP.x + 13, startP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));		// 4사분면
//							else if(startP.x <= endP.x && startP.y > endP.y) g.drawOval(startP.x + 13, endP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));	    // 1사분면
//							else if(startP.x > endP.x && startP.y <= endP.y) g.drawOval(endP.x + 13, startP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));		// 3사분면
//							else g.drawOval(endP.x + 13, endP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));													// 2사분면
//						}
//						
//					}
//					
//				}
//				
//			});
				

			}
		});
		add(numButton02);

		numButton03.setBounds(50, 5, 35, 35);
		numButton03.setBorderPainted(false);
		numButton03.setContentAreaFilled(false);
		numButton03.setFocusPainted(false);
		numButton03.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton03.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton03.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				control.setCurrentStatus(3);
				
				
				control.getP().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						control.getP().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						startP = e.getPoint();
					}
					
					@Override
					public void mouseReleased(MouseEvent e) {
						if(control.getCurrentStatus() == 3) {
							endP = e.getPoint();
							Graphics g = getGraphics();
							rePaint(g);
							
							int[] x = new int[4];
							int[] y = new int[4];
							
							x[0] = startP.x + 13;		y[0] = startP.y + 166;	
							x[1] = startP.x + 13;		y[1] = endP.y + 166;	
							x[2] = endP.x + 13;			y[2] = endP.y + 166;	
							x[3] = endP.x + 13;			y[3] = startP.y + 166;	
									
							
							if(FillColor.isFill()) {
								g.fillPolygon(x, y, y.length);
							
							}
							else {
								g.drawPolygon(x, y, y.length);
							
							}
						}

					}
				});
				
//				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
//				@Override
//				public void mouseDragged(MouseEvent e) {
//					if(control.getCurrentStatus() == 3) {
//						endP = e.getPoint();
//						Graphics g = getGraphics();
//						rePaint(g);
//						
//						int[] x = new int[4];
//						int[] y = new int[4];
//						
//						x[0] = startP.x + 13;		y[0] = startP.y + 166;	
//						x[1] = startP.x + 13;		y[1] = endP.y + 166;	
//						x[2] = endP.x + 13;			y[2] = endP.y + 166;	
//						x[3] = endP.x + 13;			y[3] = startP.y + 166;	
//								
//						
//						if(FillColor.isFill()) {
//							g.fillPolygon(x, y, y.length);
//						
//						}
//						else {
//							g.drawPolygon(x, y, y.length);					
//						}
//					}	
//				}
//				
//			});
				
				
			}
		});
		add(numButton03);
		
		numButton04.setBounds(50, 45, 35, 35);
		numButton04.setBorderPainted(false);
		numButton04.setContentAreaFilled(false);
		numButton04.setFocusPainted(false);
		numButton04.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton04.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton04.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				control.setCurrentStatus(4);
		
				
				control.getP().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						control.getP().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						startP = e.getPoint();
					}
					
					@Override
					public void mouseReleased(MouseEvent e) {
						
						if(control.getCurrentStatus() == 4) {
							endP = e.getPoint();
							Graphics g = getGraphics();
							rePaint(g);
							
							int[] x = new int[3];
							int[] y = new int[3];
							
							x[0] = startP.x + 13;					y[0] = endP.y + 166;
							x[1] = (endP.x + startP.x + 26) / 2;	y[1] = startP.y + 166;
							x[2] = endP.x + 13;						y[2] = endP.y + 166;
							
							if(FillColor.isFill()) {
								g.fillPolygon(x, y, y.length);
							
							}
							else {
								g.drawPolygon(x, y, y.length);
							}
						}
						
						
					}
				});
				
//				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
//					@Override
//					public void mouseDragged(MouseEvent e) {
//						
//						if(control.getCurrentStatus() == 4) {
//							endP = e.getPoint();
//							Graphics g = getGraphics();
//							rePaint(g);
//							
//							int[] x = new int[3];
//							int[] y = new int[3];
//							
//							x[0] = startP.x + 13;					y[0] = endP.y + 166;
//							x[1] = (endP.x + startP.x + 26) / 2;	y[1] = startP.y + 166;
//							x[2] = endP.x + 13;						y[2] = endP.y + 166;
//							
//							if(FillColor.isFill()) {
//								g.fillPolygon(x, y, y.length);
//							
//							}
//							else {
//								g.drawPolygon(x, y, y.length);
//							}
//							
//						}
//									
//					}
//					
//				});
				
			}
		});
		add(numButton04);
		
		numButton05.setBounds(90, 5, 35, 35);
		numButton05.setBorderPainted(false);
		numButton05.setContentAreaFilled(false);
		numButton05.setFocusPainted(false);
		numButton05.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton05.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton05.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				control.setCurrentStatus(5);
				
				control.getP().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						control.getP().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						startP = e.getPoint();
					}
					
					@Override
					public void mouseReleased(MouseEvent e) {
						
						if(control.getCurrentStatus() == 5) {
							endP = e.getPoint();
							Graphics g = getGraphics();
							rePaint(g);
							
							int[] x = new int[5];
							int[] y = new int[5];
							
							x[0] = (endP.x + startP.x + 26) / 2; 						y[0] = startP.y + 166;
							x[3] = startP.x + 13; 										y[3] = (int)(startP.y + (endP.y - startP.y) * 0.38) + 166;
							x[1] = (int)(startP.x + (endP.x - startP.x) * 0.19) + 13; 	y[1] = endP.y + 166;
							x[4] = (int)(startP.x + (endP.x - startP.x) * 0.81) + 13; 	y[4] = endP.y + 166;
							x[2] = endP.x + 13; 										y[2] = (int)(startP.y + (endP.y - startP.y) * 0.38) + 166;
							
							
							if(FillColor.isFill()) {
								g.fillPolygon(x, y, y.length);    
							}
							else {
								g.drawLine(x[0], y[0], x[1], y[1]);
								g.drawLine(x[1], y[1], x[2], y[2]);
								g.drawLine(x[2], y[2], x[3], y[3]);
								g.drawLine(x[3], y[3], x[4], y[4]);
								g.drawLine(x[4], y[4], x[0], y[0]);
							}	
						}
						
					}
				});
				
//				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
//				@Override
//				public void mouseDragged(MouseEvent e) {
//					endP = e.getPoint();
//					Graphics g = getGraphics();
//					rePaint(g);
//
//					int[] x = new int[5];
//					int[] y = new int[5];
//					
//					x[0] = (endP.x + startP.x + 26) / 2; 						y[0] = startP.y + 166;
//					x[3] = startP.x + 13; 										y[3] = (int)(startP.y + (endP.y - startP.y) * 0.38) + 166;
//					x[1] = (int)(startP.x + (endP.x - startP.x) * 0.19) + 13; 	y[1] = endP.y + 166;
//					x[4] = (int)(startP.x + (endP.x - startP.x) * 0.81) + 13; 	y[4] = endP.y + 166;
//					x[2] = endP.x + 13; 										y[2] = (int)(startP.y + (endP.y - startP.y) * 0.38) + 166;
//					
//					if(FillColor.isFill()) {
//						g.fillPolygon(x, y, y.length);
//					}
//					else {
//						g.drawPolygon(x, y, y.length);
//					}
//					
//					repaint();
//				}
//				
//			});
//				
		
			}
		});
		add(numButton05);
		
		numButton06.setBounds(90, 45, 35, 35);
		numButton06.setBorderPainted(false);
		numButton06.setContentAreaFilled(false);
		numButton06.setFocusPainted(false);
		numButton06.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton06.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton06.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				control.setCurrentStatus(6);
				
				control.getP().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						control.getP().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						startP = e.getPoint();
					}
					
					@Override
					public void mouseReleased(MouseEvent e) {
						if(control.getCurrentStatus() == 6) {
							endP = e.getPoint();
							Graphics g = getGraphics();
							rePaint(g);
							
							if(FillColor.isFill()) {
								g.fillArc(startP.x + 13, startP.y + 166, (endP.x - startP.x) / 2, (int)((endP.y - startP.y) * 0.33) * 2, 0, 180);
								g.fillArc((endP.x + startP.x + 26) / 2, startP.y + 166, (endP.x - startP.x) / 2, (int)((endP.y - startP.y) * 0.33) * 2, 0, 180);
								g.fillArc(startP.x + 13, startP.y + 166 - (int)((endP.y - startP.y) * 0.33), endP.x - startP.x, (int)((endP.y - startP.y) * 0.33) * 4, 0, -180);
							}
							else {
								g.drawArc(startP.x + 13, startP.y + 166, (endP.x - startP.x) / 2, (int)((endP.y - startP.y) * 0.33) * 2, 0, 180);
								g.drawArc((endP.x + startP.x + 26) / 2, startP.y + 166, (endP.x - startP.x) / 2, (int)((endP.y - startP.y) * 0.33) * 2, 0, 180);
								g.drawArc(startP.x + 13, startP.y + 166 - (int)((endP.y - startP.y) * 0.33), endP.x - startP.x, (int)((endP.y - startP.y) * 0.33) * 4, 0, -180);
							}
						}
					}
				});
				
//				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
//				@Override
//				public void mouseDragged(MouseEvent e) {
//					endP = e.getPoint();
//					Graphics g = getGraphics();
//					rePaint(g);
//					
//					if(FillColor.isFill()) {
//						g.fillArc(startP.x + 13, startP.y + 166, (endP.x - startP.x) / 2, (int)((endP.y - startP.y) * 0.33) * 2, 0, 180);
//						g.fillArc((endP.x + startP.x + 26) / 2, startP.y + 166, (endP.x - startP.x) / 2, (int)((endP.y - startP.y) * 0.33) * 2, 0, 180);
//						g.fillArc(startP.x + 13, startP.y + 166 - (int)((endP.y - startP.y) * 0.33), endP.x - startP.x, (int)((endP.y - startP.y) * 0.33) * 4, 0, -180);
//					}
//					else {
//						g.drawArc(startP.x + 13, startP.y + 166, (endP.x - startP.x) / 2, (int)((endP.y - startP.y) * 0.33) * 2, 0, 180);
//						g.drawArc((endP.x + startP.x + 26) / 2, startP.y + 166, (endP.x - startP.x) / 2, (int)((endP.y - startP.y) * 0.33) * 2, 0, 180);
//						g.drawArc(startP.x + 13, startP.y + 166 - (int)((endP.y - startP.y) * 0.33), endP.x - startP.x, (int)((endP.y - startP.y) * 0.33) * 4, 0, -180);
//					}
//					
//					repaint();
//					
//				}
//				
//			});
					
			}
		});
		add(numButton06);
		
		numButton07.setBounds(130, 5, 35, 35);
		numButton07.setBorderPainted(false);
		numButton07.setContentAreaFilled(false);
		numButton07.setFocusPainted(false);
		numButton07.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton07.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton07.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				control.setCurrentStatus(7);
				
				control.getP().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						control.getP().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						startP = e.getPoint();
					}
					
					@Override
					public void mouseReleased(MouseEvent e) {
						if(control.getCurrentStatus() == 7) {
							endP = e.getPoint();
							Graphics g = getGraphics();
							rePaint(g);

							int[] x = new int[7];
							int[] y = new int[7];
							
							x[0] = (endP.x + startP.x + 26) / 2; 	y[0] = startP.y + 166;
							x[1] = (endP.x + startP.x + 26) / 2; 	y[1] = (int)(startP.y * 0.75 + endP.y  * 0.25) + 166;
							x[2] = startP.x + 13; 					y[2] = (int)(startP.y * 0.75 + endP.y  * 0.25) + 166;
							x[3] = startP.x + 13;  					y[3] = (int)(startP.y * 0.25 + endP.y  * 0.75) + 166;
							x[4] = (endP.x + startP.x + 26) / 2; 	y[4] = (int)(startP.y * 0.25 + endP.y  * 0.75) + 166;
							x[5] = (endP.x + startP.x + 26) / 2;	y[5] = endP.y + 166;
							x[6] = endP.x + 13;						y[6] = (endP.y + startP.y) / 2 + 166;
							
							if(FillColor.isFill()) {
								g.fillPolygon(x, y, y.length);
							}
							else {
								g.drawPolygon(x, y, y.length);
							}
						}
					}
				});
				
//				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
//				@Override
//				public void mouseDragged(MouseEvent e) {
//					endP = e.getPoint();
//					Graphics g = getGraphics();
//					rePaint(g);
//					
//					int[] x = new int[7];
//					int[] y = new int[7];
//					
//					x[0] = (endP.x + startP.x + 26) / 2; 	y[0] = startP.y + 166;
//					x[1] = (endP.x + startP.x + 26) / 2; 	y[1] = (int)(startP.y * 0.75 + endP.y  * 0.25) + 166;
//					x[2] = startP.x + 13; 					y[2] = (int)(startP.y * 0.75 + endP.y  * 0.25) + 166;
//					x[3] = startP.x + 13;  					y[3] = (int)(startP.y * 0.25 + endP.y  * 0.75) + 166;
//					x[4] = (endP.x + startP.x + 26) / 2; 	y[4] = (int)(startP.y * 0.25 + endP.y  * 0.75) + 166;
//					x[5] = (endP.x + startP.x + 26) / 2;	y[5] = endP.y + 166;
//					x[6] = endP.x + 13;						y[6] = (endP.y + startP.y) / 2 + 166;
//					
//					if(FillColor.isFill()) {
//						g.fillPolygon(x, y, y.length);
//					}
//					else {
//						g.drawPolygon(x, y, y.length);
//					}
//					repaint();
//				}
//				
//			});
		
			}
		});
		add(numButton07);
		
		numButton08.setBounds(130, 45, 35, 35);
		numButton08.setBorderPainted(false);
		numButton08.setContentAreaFilled(false);
		numButton08.setFocusPainted(false);
		numButton08.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton08.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton08.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				control.setCurrentStatus(8);
				
				control.getP().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						control.getP().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						startP = e.getPoint();
					}
					
					@Override
					public void mouseReleased(MouseEvent e) {
						if(control.getCurrentStatus() == 8) {
							endP = e.getPoint();
							Graphics g = getGraphics();
							rePaint(g);
							
							int[] x = new int[7];
							int[] y = new int[7];
							
							x[0] = (endP.x + startP.x + 26) / 2; 					y[0] = startP.y + 166;
							x[1] = startP.x + 13; 									y[1] = (startP.y + endP.y) / 2 + 166;
							x[2] = (int)(startP.x * 0.75 + endP.x  * 0.25) + 13; 	y[2] = (startP.y + endP.y) / 2 + 166;
							x[3] = (int)(startP.x * 0.75 + endP.x  * 0.25) + 13;   	y[3] = endP.y + 166;
							x[4] = (int)(startP.x * 0.25 + endP.x  * 0.75) + 13;  	y[4] = endP.y + 166;
							x[5] = (int)(startP.x * 0.25 + endP.x  * 0.75) + 13; 	y[5] = (startP.y + endP.y) / 2 + 166;
							x[6] = endP.x + 13;										y[6] = (startP.y + endP.y) / 2 + 166;
							
							if(FillColor.isFill()) {
								g.fillPolygon(x, y, y.length);
							}
							else {
								g.drawPolygon(x, y, y.length);
							}
						}

					}
				});
				
//				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
//				@Override
//				public void mouseDragged(MouseEvent e) {
//					endP = e.getPoint();
//					Graphics g = getGraphics();
//					rePaint(g);
//
//					int[] x = new int[7];
//					int[] y = new int[7];
//					
//					x[0] = (endP.x + startP.x + 26) / 2; 					y[0] = startP.y + 166;
//					x[1] = startP.x + 13; 									y[1] = (startP.y + endP.y) / 2 + 166;
//					x[2] = (int)(startP.x * 0.75 + endP.x  * 0.25) + 13; 	y[2] = (startP.y + endP.y) / 2 + 166;
//					x[3] = (int)(startP.x * 0.75 + endP.x  * 0.25) + 13;   	y[3] = endP.y + 166;
//					x[4] = (int)(startP.x * 0.25 + endP.x  * 0.75) + 13;  	y[4] = endP.y + 166;
//					x[5] = (int)(startP.x * 0.25 + endP.x  * 0.75) + 13; 	y[5] = (startP.y + endP.y) / 2 + 166;
//					x[6] = endP.x + 13;										y[6] = (startP.y + endP.y) / 2 + 166;
//					
//					if(FillColor.isFill()) {
//						g.fillPolygon(x, y, y.length);
//					}
//					else {
//						g.drawPolygon(x, y, y.length);
//					}
//					
//					repaint();
//					
//				}
//				
//			});
				
				
		
			}
		});
		add(numButton08);
		
		
		shapeBox.setText("도형");
		shapeBox.setVerticalAlignment(SwingConstants.CENTER);
		shapeBox.setHorizontalAlignment(SwingConstants.RIGHT);
		shapeBox.setBounds(20, 85, 80, 15);
		shapeBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		shapeBox.setForeground(Color.BLACK);
		add(shapeBox);
		
	}
	
	public void makeProperty() {	// 속성 파트 만들기
		colorButton.setBounds(190, 10, 60, 60);
		colorButton.setBorderPainted(false);
		colorButton.setContentAreaFilled(true);
		colorButton.setFocusPainted(false);
		colorButton.setBackground(edgeColor.getEdgeColor());
		colorButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				colorButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				colorButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				edgeColor.changeEdgeColor();
				colorButton.setBackground(edgeColor.getEdgeColor());
				control.setCurrentColor(edgeColor.getEdgeColor());
			}
		});
		add(colorButton);
		
		colorBox.setText("색상");
		colorBox.setVerticalAlignment(SwingConstants.CENTER);
		colorBox.setHorizontalAlignment(SwingConstants.RIGHT);
		colorBox.setBounds(151, 85, 80, 15);
		colorBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		colorBox.setForeground(Color.BLACK);
		add(colorBox);
		
		boldButton.setBounds(260, 10, 60, 60);
		boldButton.setBorderPainted(false);
		boldButton.setContentAreaFilled(true);
		boldButton.setFocusPainted(false);
		boldButton.setBackground(Color.WHITE);
		boldButton.setFont(bold.getFont());
		boldButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boldButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boldButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				bold.changeBoldSize();
				bold.showFont();
				boldButton.setFont(bold.getFont());
				boldButton.setText(Integer.toString(bold.getBoldSize()));
				control.setLineSize(bold.getBoldSize());
			}
		});
		add(boldButton);
		
		boldBox.setText("굵기");
		boldBox.setVerticalAlignment(SwingConstants.CENTER);
		boldBox.setHorizontalAlignment(SwingConstants.RIGHT);
		boldBox.setBounds(221, 85, 80, 15);
		boldBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		boldBox.setForeground(Color.BLACK);
		add(boldBox);
		
		fillButton.setBounds(330, 10, 60, 60);
		fillButton.setBorderPainted(false);
		fillButton.setContentAreaFilled(true);
		fillButton.setFocusPainted(false);
		fillButton.setFont(FillColor.getFont());
		fillButton.setFont(new Font("나눔바른고딕", Font.BOLD, 18));
		fillButton.setText("Off");
		fillButton.setBackground(Color.WHITE);
		fillButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				fillButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				fillButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				FillColor.changeIsFill();
				FillColor.changeOnOff();
				fillButton.setText(FillColor.getOnOff());
			}
		});
		add(fillButton);
		
		fillBox.setText("채우기");
		fillBox.setVerticalAlignment(SwingConstants.CENTER);
		fillBox.setHorizontalAlignment(SwingConstants.RIGHT);
		fillBox.setBounds(297, 85, 80, 15);
		fillBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		fillBox.setForeground(Color.BLACK);
		add(fillBox);
	}
	
	public void makeDelete() {		// 지우개 & Clear 만들기
		Cursor c = toolkit.createCustomCursor(image, new Point(15, 15), "png");
		
		eraserButton.setBounds(410, 10, 60, 60);
		eraserButton.setBorderPainted(false);
		eraserButton.setContentAreaFilled(true);
		eraserButton.setFocusPainted(false);
		eraserButton.setBackground(Color.WHITE);
		eraserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				eraserButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				eraserButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				control.setCurrentStatus(9);
				
				control.getP().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						control.getP().setCursor(c);
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						control.setStartP(e.getPoint());
					}
					

				});
				
				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					if(control.getCurrentStatus() == 9) {
						Graphics g = getGraphics();
						control.setEndP(e.getPoint());
						control.eraseLine(control.getStartP().x, control.getStartP().y, control.getEndP().x, control.getEndP().x, g);
						control.setStartP(control.getEndP());
					}
				}
			});
			}

			
			});
		add(eraserButton);
			
		
		eraserBox.setText("지우개");
		eraserBox.setVerticalAlignment(SwingConstants.CENTER);
		eraserBox.setHorizontalAlignment(SwingConstants.RIGHT);
		eraserBox.setBounds(377, 85, 80, 15);
		eraserBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		eraserBox.setForeground(Color.BLACK);
		add(eraserBox);
		
		clearButton.setBounds(480, 10, 60, 60);
		clearButton.setBorderPainted(false);
		clearButton.setContentAreaFilled(true);
		clearButton.setFocusPainted(false);
		clearButton.setBackground(Color.WHITE);
		clearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				clearButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				add(control.resetPanel());

			}
			
			});
		add(clearButton);
		
		clearBox.setText("클리어");
		clearBox.setVerticalAlignment(SwingConstants.CENTER);
		clearBox.setHorizontalAlignment(SwingConstants.RIGHT);
		clearBox.setBounds(448, 85, 80, 15);
		clearBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		clearBox.setForeground(Color.BLACK);
		add(clearBox);
		
		
		}
	
	
	public void makeRangeSelect() {		
		rangeSelectButton.setBounds(550, 10, 60, 60);
		rangeSelectButton.setBorderPainted(false);
		rangeSelectButton.setContentAreaFilled(true);
		rangeSelectButton.setFocusPainted(false);
		rangeSelectButton.setBackground(Color.WHITE);
		rangeSelectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rangeSelectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rangeSelectButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				control.setCurrentStatus(10);

				control.getP().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						control.getP().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						startP = e.getPoint();
					}
					
					@Override
					public void mouseReleased(MouseEvent e) {
						if(control.getCurrentStatus() == 10) {
							endP = e.getPoint();
							Graphics g = getGraphics();
							Control ct = new Control();
//							rePaint(g);
							
							int[] x = new int[4];
							int[] y = new int[4];
							
							x[0] = startP.x + 13;		y[0] = startP.y + 166;	
							x[1] = startP.x + 13;		y[1] = endP.y + 166;	
							x[2] = endP.x + 13;			y[2] = endP.y + 166;	
							x[3] = endP.x + 13;			y[3] = startP.y + 166;	
							
							control.selectSection(x, y, g);
//							control.cutSection();
							ct.getP().setBounds(0, 30, 300, 500);
							ct.getP().setBackground(new Color(253, 253, 253));
							ct.getP().setVisible(true);
							System.out.println(ct.getBounds());
							add(ct.getP());
						}

					}
				});
				
//				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
//				@Override
//				public void mouseDragged(MouseEvent e) {
//					if(control.getCurrentStatus() == 3) {
//						endP = e.getPoint();
//						Graphics g = getGraphics();
//						rePaint(g);
//						
//						int[] x = new int[4];
//						int[] y = new int[4];
//						
//						x[0] = startP.x + 13;		y[0] = startP.y + 166;	
//						x[1] = startP.x + 13;		y[1] = endP.y + 166;	
//						x[2] = endP.x + 13;			y[2] = endP.y + 166;	
//						x[3] = endP.x + 13;			y[3] = startP.y + 166;	
//								
//						
//						if(FillColor.isFill()) {
//							g.fillPolygon(x, y, y.length);
//						
//						}
//						else {
//							g.drawPolygon(x, y, y.length);					
//						}
//					}	
//				}
//				
//			});
				
			}
			
			});
		add(rangeSelectButton);
	}
	
		
	public void setText() {		// 글자 정리
		colorButton.setVerticalTextPosition(JButton.CENTER);
		colorButton.setHorizontalTextPosition(JButton.CENTER);
		colorButton.setFont(new Font("Arial", Font.BOLD, 20));
	}
	
//	public void paint(Graphics g) {
//		screenImage = createImage(GraphicEditorMain.SCREEN_WIDTH, GraphicEditorMain.SCREEN_HEIGHT);
//		screenGraphic = screenImage.getGraphics();
//		screenDraw(screenGraphic);
//		g.drawImage(screenImage, 0, 0, null);
//	}
	
//	public void paint(Graphics g){
//		screenImage = createImage(GraphicEditorMain.SCREEN_WIDTH, GraphicEditorMain.SCREEN_HEIGHT);
//		screenGraphic = screenImage.getGraphics();
//		screenDraw(screenGraphic);
//		g.drawImage(screenImage, 0, 0, null);
//	}  
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	
	public void rePaint(Graphics g) {
		g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(control.getLineSize(), BasicStroke.CAP_ROUND, 0));
		g2.setPaint(control.getCurrentColor());
	}

	public void screenDraw(Graphics g) {
		paintComponents(g);
//		this.repaint();
	}
	
	public void screenReDraw(Graphics g) {
		paintComponents(g);
		this.repaint();
	}
	
}
