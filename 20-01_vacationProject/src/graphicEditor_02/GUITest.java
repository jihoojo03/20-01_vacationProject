package graphicEditor_02;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.*;

import calculator_01.CalculatorMain;

public class GUITest extends JFrame {
	
	private Graphics2D g2;
	
	private ImageIcon lineButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/line.png"));
	private ImageIcon circleButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/circle.png"));
	private ImageIcon squareButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/square.png"));
	private ImageIcon triangleButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/triangle.png"));
	private ImageIcon starButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/star.png"));
	private ImageIcon heartButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/heart.png"));
	private ImageIcon horizontalArrowButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/horizontalArrow.png"));
	private ImageIcon verticalArrowButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/verticalArrow.png"));
	private ImageIcon undoBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/undo.png"));
	private ImageIcon redoBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/redo.png"));
	private ImageIcon enlargementBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/enlargement.png"));
	private ImageIcon reductionBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/reduction.png"));
	private ImageIcon upBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/up.png"));
	private ImageIcon downBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/down.png"));
	private ImageIcon eraserButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/eraserButton.png"));
	
	private JButton numButton01 = new JButton(lineButtonBasicImage);
	private JButton numButton02 = new JButton(circleButtonBasicImage);
	private JButton numButton03 = new JButton(squareButtonBasicImage);
	private JButton numButton04 = new JButton(triangleButtonBasicImage);
	private JButton numButton05 = new JButton(starButtonBasicImage);
	private JButton numButton06 = new JButton(heartButtonBasicImage);
	private JButton numButton07 = new JButton(horizontalArrowButtonBasicImage);
	private JButton numButton08 = new JButton(verticalArrowButtonBasicImage);
	private JButton colorButton = new JButton();
	private JButton boldButton = new JButton("6");
	private JButton fillButton = new JButton();
	private JButton eraserButton = new JButton(eraserButtonBasicImage);
	private JButton clearButton = new JButton("C");
	private JButton rangeSelectButton = new JButton("Off");
	private JButton undoButton = new JButton(undoBasicImage);
	private JButton redoButton = new JButton(redoBasicImage);
	private JButton enlargementButton = new JButton(enlargementBasicImage);
	private JButton reductionButton = new JButton(reductionBasicImage);
	private JButton upButton = new JButton(upBasicImage);
	private JButton downButton = new JButton(downBasicImage);
	
	private JPanel buttonPanel = new JPanel();
	
	private JLabel shapeBox = new JLabel();
	private JLabel colorBox = new JLabel();
	private JLabel boldBox = new JLabel();
	private JLabel fillBox = new JLabel();
	private JLabel eraserBox = new JLabel();
	private JLabel clearBox = new JLabel();
	private JLabel choiceBox = new JLabel();
	private JLabel undoRedoBox = new JLabel();

	private Point startP = null;
	private Point endP = null;
	
	private int selectStatus = 0;
	
	EdgeColor edgeColor = new EdgeColor();
	FillColor fillColor = new FillColor();
	Bold bold = new Bold();
	Control control = new Control();
	Control copyControl = new Control();
	VarietyShape varietyShape = new VarietyShape();
	
	ArrayList<VarietyShape> shapeList = new ArrayList<VarietyShape>();
	Stack<VarietyShape> shapeStack = new Stack<VarietyShape>();
	
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Image image = toolkit.getImage(CalculatorMain.class.getResource("../images/eraser.png"));
	
	BufferedImage bi = new BufferedImage(GraphicEditorMain.SCREEN_WIDTH, GraphicEditorMain.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB );
	
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
		makeRedoUndo();
		makeAdjustment();
		makeUpDown();
		makePanel();
		setText();
		
	}
	
	public void makeCanvas() {			// 캔버스에 패널 추가
		add(control.getP());
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
				
				try {
					save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		item03.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 try {
					load();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
	
	public void save() throws IOException
	{
		JFrame f = new JFrame();
		f.setSize(350, 250);
		f.setLayout(null);
		f.setVisible(true);
		
		FileDialog dialog = new FileDialog(f, "저장", FileDialog.SAVE);
		dialog.setVisible(true);
		
		String path = dialog.getDirectory() + dialog.getFile(); 
        System.out.println(path);
        
        try {
        	BufferedImage image = new BufferedImage(900, 700, BufferedImage.TYPE_INT_ARGB);
			Graphics2D gg = image.createGraphics(); 
			         
            
        } catch(Exception e) {
        	
        }
        
		
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = filechooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) 
		{
			BufferedImage image = new BufferedImage(900, 700, BufferedImage.TYPE_INT_ARGB);
			Graphics2D gg = image.createGraphics(); 
			
			File fileName = filechooser.getSelectedFile();
			ImageIO.write(image, "PNG", fileName);
			}
		}
	

	public void load() throws IOException
	{
		JFileChooser filechooser = new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = filechooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) 
		{
			File fileName = filechooser.getSelectedFile();
			bi = ImageIO.read(fileName);
			System.out.println("Load Path: " + fileName.getPath());
			
			int w = bi.getWidth(null);
			int h = bi.getHeight(null);
			
			this.bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			
			Graphics g = bi.getGraphics();
			g.drawImage(bi, 10, 110, this);
			g.setColor(Color.RED);
			g.drawRect(10, 10, 300, 300);
			g.drawString("asdf", 150, 30);
			g.dispose();
			repaint();
			
			
		}
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
						startP = e.getPoint();
						control.setStartP(startP);
					}
					
					@Override
					public void mouseReleased(MouseEvent e) {
						if(!shapeStack.isEmpty()) {
							shapeStack.clear();
						}
						
						if(control.getCurrentStatus() == 1) {
							Graphics g = getGraphics();
							endP = e.getPoint();
							control.setEndP(endP);
							
							int x[] = new int[2];
							int y[] = new int[2];
							
							x[0] = control.getStartP().x + 13;		y[0] = control.getStartP().y + 166;
							x[1] = control.getEndP().x + 13;		y[1] = control.getEndP().y + 166;
							
							shapeList.add(new VarietyShape(x, y, 1, false, control.getLineSize() ,control.getCurrentColor(), startP, endP));
							control.drawShape(shapeList, g);
							
						}
						
					}
				});
				
				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					
					if(control.getCurrentStatus() == 1) {
						Graphics g = getGraphics();
						control.setEndP(e.getPoint());
						rePaint(g);
						
						int x[] = new int[2];
						int y[] = new int[2];
						
						x[0] = control.getStartP().x + 13;		y[0] = control.getStartP().y + 166;
						x[1] = control.getEndP().x + 13;		y[1] = control.getEndP().y + 166;
						
						control.getP().repaint();
						g.drawLine(x[0], y[0], x[1], y[1]);
						control.drawShape(shapeList, g);
					}
					
				}
			});
				
				
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
						control.setStartP(e.getPoint());
						
					}
					
					@Override
					public void mouseReleased(MouseEvent e) {
						if(!shapeStack.isEmpty()) {
							shapeStack.clear();
						}
						
						if(control.getCurrentStatus() == 2) {
							endP = e.getPoint();
							control.setEndP(e.getPoint());
							Graphics g = getGraphics();
							rePaint(g);
							
							int x[] = new int[3];
							int y[] = new int[3];
							
							x[0] = startP.x + 13;		
							x[1] = endP.x + 13;	
							x[2] = Math.abs(startP.x - endP.x);
							y[0] = startP.y + 166;
							y[1] = endP.y + 166;
							y[2] = Math.abs(startP.y - endP.y);
							
							if(FillColor.isFill()) {
								shapeList.add(new VarietyShape(x, y, 2, true, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g);
								
							}
							else {
								shapeList.add(new VarietyShape(x, y, 2, false, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g);
							}
						}
					
					}
				});
				
				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					if(control.getCurrentStatus() == 2) {
						endP = e.getPoint();
						Graphics g = getGraphics();
						rePaint(g);
						control.getP().repaint();
						
						if(FillColor.isFill()) {
							if(startP.x <= endP.x && startP.y <= endP.y) g.fillOval(startP.x + 13, startP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));		// 4사분면
							else if(startP.x <= endP.x && startP.y > endP.y) g.fillOval(startP.x + 13, endP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));	    // 1사분면
							else if(startP.x > endP.x && startP.y <= endP.y) g.fillOval(endP.x + 13, startP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));		// 3사분면
							else g.fillOval(endP.x + 13, endP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));													// 2사분면
							control.drawShape(shapeList, g);
						}
						else {
							if(startP.x <= endP.x && startP.y <= endP.y) g.drawOval(startP.x + 13, startP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));		// 4사분면
							else if(startP.x <= endP.x && startP.y > endP.y) g.drawOval(startP.x + 13, endP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));	    // 1사분면
							else if(startP.x > endP.x && startP.y <= endP.y) g.drawOval(endP.x + 13, startP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));		// 3사분면
							else g.drawOval(endP.x + 13, endP.y + 160, Math.abs(endP.x - startP.x), Math.abs(endP.y - startP.y));													// 2사분면
							control.drawShape(shapeList, g);
						}
						
					}
					
				}
				
			});
				

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
						if(!shapeStack.isEmpty()) {
							shapeStack.clear();
						}
						
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
								shapeList.add(new VarietyShape(x, y, 3, true, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g);
							
							}
							else {
								shapeList.add(new VarietyShape(x, y, 3, false, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g);
							}
						}

					}
				});
				
				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
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
								
						
						control.getP().repaint();
						if(FillColor.isFill()) {
							g.fillPolygon(x, y, y.length);
						}
						else {
							g.drawPolygon(x, y, y.length);
						}
						control.drawShape(shapeList, g);
					}	
				}
				
			});
						
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
						if(!shapeStack.isEmpty()) {
							shapeStack.clear();
						}
						
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
								shapeList.add(new VarietyShape(x, y, 4, true, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g);
							
							}
							else {
								shapeList.add(new VarietyShape(x, y, 4, false, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g);
							}
						}
						
						
					}
				});
				
				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						
						if(control.getCurrentStatus() == 4) {
							endP = e.getPoint();
							Graphics g = getGraphics();
							rePaint(g);
							
							int[] x = new int[3];
							int[] y = new int[3];
							
							x[0] = startP.x + 13;					y[0] = endP.y + 166;
							x[1] = (endP.x + startP.x + 26) / 2;	y[1] = startP.y + 166;
							x[2] = endP.x + 13;						y[2] = endP.y + 166;
							
							control.getP().repaint();
							if(FillColor.isFill()) {
								g.fillPolygon(x, y, y.length);
							}
							else {
								g.drawPolygon(x, y, y.length);
							}
							control.drawShape(shapeList, g);
							
						}
									
					}
					
				});
				
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
						if(!shapeStack.isEmpty()) {
							shapeStack.clear();
						}
						
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
								shapeList.add(new VarietyShape(x, y, 5, true, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g);  
							}
							else {
								shapeList.add(new VarietyShape(x, y, 5, false, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g);
							}	
						}
						
					}
				});
				
				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
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
						
						control.getP().repaint();
						if(FillColor.isFill()) {
							g.fillPolygon(x, y, y.length);
						}
						else {
							g.drawPolygon(x, y, y.length);
						}
						control.drawShape(shapeList, g);
					}

				}
				
			});
				
		
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
						if(!shapeStack.isEmpty()) {
							shapeStack.clear();
						}
						
						if(control.getCurrentStatus() == 6) {
							endP = e.getPoint();
							Graphics g = getGraphics();
							rePaint(g);
							
							int x[] = new int[4];
							int y[] = new int[4];
							
							x[0] = startP.x + 13;						y[0] = startP.y + 166;
							x[1] = (endP.x - startP.x) / 2; 			y[1] = (int)((endP.y - startP.y) * 0.33) * 2;
							x[2] = (endP.x + startP.x + 26) / 2; 		y[2] = startP.y + 166 - (int)((endP.y - startP.y) * 0.33);
							x[3] = endP.x - startP.x; 					y[3] = (int)((endP.y - startP.y) * 0.33) * 4;
																	
							
							if(FillColor.isFill()) {
								shapeList.add(new VarietyShape(x, y, 6, true, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g2);
							}
							else {
								shapeList.add(new VarietyShape(x, y, 6, false, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g2);
							}
						}
					}
				});
				
				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					if(control.getCurrentStatus() == 6) {
						endP = e.getPoint();
						Graphics g = getGraphics();
						rePaint(g);
						
						control.getP().repaint();
						if(FillColor.isFill()) {
							g.fillArc(startP.x + 13, startP.y + 166, (endP.x - startP.x) / 2, (int)((endP.y - startP.y) * 0.33) * 2, 0, 180);
							g.fillArc((endP.x + startP.x + 26) / 2, startP.y + 166, (endP.x - startP.x) / 2, (int)((endP.y - startP.y) * 0.33) * 2, 0, 180);
							g.fillArc(startP.x + 13, startP.y + 166 - (int)((endP.y - startP.y) * 0.33), endP.x - startP.x, (int)((endP.y - startP.y) * 0.33) * 4, 0, -180);
							control.drawShape(shapeList, g);
						}
						else {
							g.drawArc(startP.x + 13, startP.y + 166, (endP.x - startP.x) / 2, (int)((endP.y - startP.y) * 0.33) * 2, 0, 180);
							g.drawArc((endP.x + startP.x + 26) / 2, startP.y + 166, (endP.x - startP.x) / 2, (int)((endP.y - startP.y) * 0.33) * 2, 0, 180);
							g.drawArc(startP.x + 13, startP.y + 166 - (int)((endP.y - startP.y) * 0.33), endP.x - startP.x, (int)((endP.y - startP.y) * 0.33) * 4, 0, -180);
							control.drawShape(shapeList, g);
						}
					}
					

				}
				
			});
					
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
						if(!shapeStack.isEmpty()) {
							shapeStack.clear();
						}
						
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
								shapeList.add(new VarietyShape(x, y, 7, true, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g);
							}
							else {
								shapeList.add(new VarietyShape(x, y, 7, false, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g);
							}
						}
					}
				});
				
				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
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
						
						control.getP().repaint();
						if(FillColor.isFill()) {
							g.fillPolygon(x, y, y.length);
						}
						else {
							g.drawPolygon(x, y, y.length);
						}
						control.drawShape(shapeList, g);
					}
				}
				
			});
		
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
						if(!shapeStack.isEmpty()) {
							shapeStack.clear();
						}
						
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
								shapeList.add(new VarietyShape(x, y, 8, true, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g);
							}
							else {
								shapeList.add(new VarietyShape(x, y, 8, false, control.getLineSize() ,control.getCurrentColor(), startP, endP));
								control.drawShape(shapeList, g);
							}
						}

					}
				});
				
				control.getP().addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
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
						
						control.getP().repaint();
						if(FillColor.isFill()) {
							g.fillPolygon(x, y, y.length);
						}
						else {
							g.drawPolygon(x, y, y.length);
						}
						control.drawShape(shapeList, g);
					}
					
				}
				
			});
				
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
	
	public void makeRedoUndo() {	// Redo / Undo 만들기
		undoButton.setBounds(810, 5, 35, 35);
		undoButton.setBorderPainted(false);
		undoButton.setContentAreaFilled(false);
		undoButton.setFocusPainted(false);
		undoButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				undoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				undoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(!shapeList.isEmpty()) {
					int endValue = shapeList.size() - 1;
					Graphics g = getGraphics();
					update(g);
					
					shapeStack.push(shapeList.remove(endValue));
					control.drawShape(shapeList, g);
				}
			}
		});
		add(undoButton);
		
		redoButton.setBounds(850, 5, 35, 35);
		redoButton.setBorderPainted(false);
		redoButton.setContentAreaFilled(false);
		redoButton.setFocusPainted(false);
		redoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				redoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				redoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(!shapeStack.isEmpty()) {
					VarietyShape vs = shapeStack.pop();
					shapeList.add(vs);
					
					Graphics g = getGraphics();
					control.drawShape(shapeList, g);
				}
			}
		});
		add(redoButton);
		
		undoRedoBox.setText("실행");
		undoRedoBox.setVerticalAlignment(SwingConstants.CENTER);
		undoRedoBox.setHorizontalAlignment(SwingConstants.RIGHT);
		undoRedoBox.setBounds(778, 85, 80, 15);
		undoRedoBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		undoRedoBox.setForeground(Color.BLACK);
		add(undoRedoBox);
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
				if(control.getCurrentStatus() == 10) {
					control.setCurrentStatus(0);
					int lastValue = shapeList.size() - 1;
					shapeList.remove(lastValue);
					VarietyShape vs2 = shapeList.remove(lastValue - 1);
					
					shapeStack.add(vs2);
					
					Graphics g = getGraphics();
					update(g);
					control.drawShape(shapeList, g);
				}
				else {
					control.setCurrentStatus(9);
					ArrayList<Integer> x = new ArrayList<Integer>();
					ArrayList<Integer> y = new ArrayList<Integer>();
				
					control.getP().addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							if(control.getCurrentStatus() == 9) control.getP().setCursor(c);
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							if(control.getCurrentStatus() == 9) {
								control.setStartP(e.getPoint());
								control.getP().setCursor(c);
							}
						}
						
						@Override
						public void mouseReleased(MouseEvent e) {
							if(!shapeStack.isEmpty()) {
								shapeStack.clear();
							}
							
							Graphics g = getGraphics();
							rePaint(g);
							
							Integer[] xArray = x.toArray(new Integer [x.size()]);
							Integer[] yArray = y.toArray(new Integer [y.size()]);
							
							int a[] = Arrays.stream(xArray).mapToInt(Integer::intValue).toArray(); 
							int b[] = Arrays.stream(yArray).mapToInt(Integer::intValue).toArray(); 
							
							shapeList.add(new VarietyShape(a, b, 9, false, 30 ,new Color(253, 253, 253), startP, endP));
							control.drawShape(shapeList, g);
							x.clear();
							y.clear();
						}
						

					});
					
					control.getP().addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						
						if(control.getCurrentStatus() == 9) {
							Graphics g1 = getGraphics();
							endP = e.getPoint();
							control.setEndP(endP);
							control.eraseLine(control.getStartP().x, control.getStartP().y, control.getEndP().x, control.getEndP().x, g1);
							x.add(control.getStartP().x + 13);
							y.add(control.getStartP().y + 166);
							startP = endP;
							control.setStartP(startP);	
						}
					}
					

				});
				}
				

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
		clearButton.setFont(new Font("나눔바른고딕", Font.BOLD, 24));
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
				shapeList.clear();
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
	
	public void makeAdjustment() {
		enlargementButton.setBounds(810, 45, 35, 35);
		enlargementButton.setBorderPainted(false);
		enlargementButton.setContentAreaFilled(false);
		enlargementButton.setFocusPainted(false);
		enlargementButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				enlargementButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				enlargementButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				g2.scale(2, 2);
				update(g2);
				control.drawShape(shapeList, g2);
			}
		});
		add(enlargementButton);
		
		reductionButton.setBounds(850, 45, 35, 35);
		reductionButton.setBorderPainted(false);
		reductionButton.setContentAreaFilled(false);
		reductionButton.setFocusPainted(false);
		reductionButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				reductionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				reductionButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				g2.scale(0.5, 0.5);
				update(g2);
				control.drawShape(shapeList, g2);
			}
		});
		add(reductionButton);
	}
	
	public void makeUpDown() {
		upButton.setBounds(615, 5, 35, 35);
		upButton.setBorderPainted(false);
		upButton.setContentAreaFilled(false);
		upButton.setFocusPainted(false);
		upButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				upButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				upButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(control.getCurrentStatus() == 10) {
					Graphics g = getGraphics();
					rePaint(g);
					update(g);
					
					int choiceValue = shapeList.size() - 1;
					
					VarietyShape vs1 = shapeList.remove(choiceValue);			// 점선
					VarietyShape vs2 = shapeList.remove(choiceValue - 1);		// 도형
					
					int newX1[] = new int[vs1.getX().length];
					int newY1[] = new int[vs1.getY().length];
					
					int xlen = Math.abs(vs1.getEndP().x - vs1.getStartP().x);
					int ylen = Math.abs(vs1.getEndP().y - vs1.getStartP().y);
				
					
					newX1[0] = vs1.getX()[0];											newY1[0] = vs1.getY()[0];
					newX1[1] = vs1.getX()[1] + (int)(((double)xlen/(double)ylen) * 10);	newY1[1] = vs1.getY()[1] + 10;
					
					
					int newX2[] = new int[vs2.getX().length];
					int newY2[] = new int[vs2.getY().length];
					
					if(vs2.getPentagon() == 1) {
						newX2[0] = vs2.getX()[0];
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1] + (int)(((double)xlen/(double)ylen) * 10);
						newY2[1] = vs2.getY()[1] + 10;
					}
					else if(vs2.getPentagon() == 2) {
						newX2[0] = vs2.getX()[0];
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1] + (int)(((double)xlen/(double)ylen) * 10);
						newY2[1] = vs2.getY()[1] + 10;
						newX2[2] = vs2.getX()[2] + (int)(((double)xlen/(double)ylen) * 10);
						newY2[2] = vs2.getY()[2] + 10;
					} 
					else if(vs2.getPentagon() == 3) {
						newX2[0] = vs2.getX()[0];
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1];
						newY2[1] = vs2.getY()[1] + 10;
						newX2[2] = vs2.getX()[2] + (int)(((double)xlen/(double)ylen) * 10);
						newY2[2] = vs2.getY()[2] + 10;
						newX2[3] = vs2.getX()[3] + (int)(((double)xlen/(double)ylen) * 10);
						newY2[3] = vs2.getY()[3];
					}
					else if(vs2.getPentagon() == 4) {
						newX2[0] = vs2.getX()[0];
						newY2[0] = vs2.getY()[0] + 10;
						newX2[1] = vs2.getX()[1] + ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[1] = vs2.getY()[1];
						newX2[2] = vs2.getX()[2] + (int)(((double)xlen/(double)ylen) * 10);
						newY2[2] = vs2.getY()[2] + 10;
					}
					else if(vs2.getPentagon() == 5) {
						newX2[0] = vs2.getX()[0] + ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1] + (int)((((double)xlen/(double)ylen) * 10) * 0.19);
						newY2[1] = vs2.getY()[1] + 10;
						newX2[2] = vs2.getX()[2] + (int)(((double)xlen/(double)ylen) * 10);
						newY2[2] = vs2.getY()[2] + (int)(10 * 0.38);
						newX2[3] = vs2.getX()[3];
						newY2[3] = vs2.getY()[3] + (int)(10 * 0.38);
						newX2[4] = vs2.getX()[4] + (int)((((double)xlen/(double)ylen) * 10) * 0.81);
						newY2[4] = vs2.getY()[4] + 10;
					}
					else if(vs2.getPentagon() == 6) {
						newX2[0] = vs2.getX()[0];
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1] + (int)((((double)xlen/(double)ylen) * 10) / 2);
						newY2[1] = vs2.getY()[1] + (int)(10 * 0.33 * 2) ;
						newX2[2] = vs2.getX()[2] + (int)((((double)xlen/(double)ylen) * 10) / 2);
						newY2[2] = vs2.getY()[2] - (int)(10 * 0.33);
						newX2[3] = vs2.getX()[3] + (int)(((double)xlen/(double)ylen) * 10);
						newY2[3] = vs2.getY()[3] + (int)(10 * 0.33 * 4);
					}
					else if(vs2.getPentagon() == 7) {
						newX2[0] = vs2.getX()[0] + ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1] + ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[1] = vs2.getY()[1] + (int)(10 * 0.25);
						newX2[2] = vs2.getX()[2] ;
						newY2[2] = vs2.getY()[2] + (int)(10 * 0.25);
						newX2[3] = vs2.getX()[3] ;
						newY2[3] = vs2.getY()[3] + (int)(10 * 0.75);
						newX2[4] = vs2.getX()[4] + ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[4] = vs2.getY()[4] + (int)(10 * 0.75);
						newX2[5] = vs2.getX()[5] + ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[5] = vs2.getY()[5] + 10;
						newX2[6] = vs2.getX()[6] + (int)(((double)xlen/(double)ylen) * 10);
						newY2[6] = vs2.getY()[6] + 5;
					}
					else if(vs2.getPentagon() == 8) {
						newX2[0] = vs2.getX()[0] + ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1];
						newY2[1] = vs2.getY()[1] + 5;
						newX2[2] = vs2.getX()[2] + (int)(((double)xlen/(double)ylen) * 10 * 0.25);
						newY2[2] = vs2.getY()[2] + 5;
						newX2[3] = vs2.getX()[3] + (int)(((double)xlen/(double)ylen) * 10 * 0.25);
						newY2[3] = vs2.getY()[3] + 10;
						newX2[4] = vs2.getX()[4] + (int)(((double)xlen/(double)ylen) * 10 * 0.75);
						newY2[4] = vs2.getY()[4] + 10;
						newX2[5] = vs2.getX()[5] + (int)(((double)xlen/(double)ylen) * 10 * 0.75);
						newY2[5] = vs2.getY()[5] + 5;
						newX2[6] = vs2.getX()[6] + (int)(((double)xlen/(double)ylen) * 10);
						newY2[6] = vs2.getY()[6] + 5;
					}
					
					
					Point newXP1 = new Point();
					Point newYP1 = new Point();
					
					newXP1.x = vs2.getStartP().x;
					newXP1.y = vs2.getStartP().y;
					newYP1.x = vs2.getEndP().x + (int)(((double)xlen/(double)ylen) * 10);
					newYP1.y = vs2.getEndP().y + 10;
					
					Point newXP2 = new Point();
					Point newYP2 = new Point();
					
					newXP2.x = vs2.getStartP().x;
					newXP2.y = vs2.getStartP().y;
					newYP2.x = vs2.getEndP().x + (int)(((double)xlen/(double)ylen) * 10);
					newYP2.y = vs2.getEndP().y + 10;

					control.drawShape(shapeList, g);
					shapeList.add(new VarietyShape(newX2, newY2, vs2.getPentagon(), vs2.isFill(), vs2.getEdgeSize(), vs2.getColor(), newXP1, newYP1));
					shapeList.add(new VarietyShape(newX1, newY1, 10, false, 3, new Color(153, 217, 234), newXP2, newYP2));
					control.drawShape(shapeList, g);	
					
					int lastValue = shapeList.size() - 1;
					VarietyShape vs = shapeList.get(lastValue);
					shapeList.get(lastValue).setStartP(vs.getStartP());
					shapeList.get(lastValue).setEndP(vs.getEndP());
				}
				
			}
		});
		add(upButton);
		
		downButton.setBounds(615, 45, 35, 35);
		downButton.setBorderPainted(false);
		downButton.setContentAreaFilled(false);
		downButton.setFocusPainted(false);
		downButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				downButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				downButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(control.getCurrentStatus() == 10) {
					Graphics g = getGraphics();
					rePaint(g);
					update(g);
					
					int choiceValue = shapeList.size() - 1;
					
					VarietyShape vs1 = shapeList.remove(choiceValue);			// 점선
					VarietyShape vs2 = shapeList.remove(choiceValue - 1);		// 도형
					
					int newX1[] = new int[vs1.getX().length];
					int newY1[] = new int[vs1.getY().length];
					
					int xlen = Math.abs(vs1.getEndP().x - vs1.getStartP().x);
					int ylen = Math.abs(vs1.getEndP().y - vs1.getStartP().y);
					
					
					newX1[0] = vs1.getX()[0];											newY1[0] = vs1.getY()[0];
					newX1[1] = vs1.getX()[1] - (int)(((double)xlen/(double)ylen) * 10);	newY1[1] = vs1.getY()[1] - 10;
					
					
					int newX2[] = new int[vs2.getX().length];
					int newY2[] = new int[vs2.getY().length];
					
					if(vs2.getPentagon() == 1) {
						newX2[0] = vs2.getX()[0];
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1] - (int)(((double)xlen/(double)ylen) * 10);
						newY2[1] = vs2.getY()[1] - 10;
					}
					else if(vs2.getPentagon() == 2) {
						newX2[0] = vs2.getX()[0];
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1] - (int)(((double)xlen/(double)ylen) * 10);
						newY2[1] = vs2.getY()[1] - 10;
						newX2[2] = vs2.getX()[2] - (int)(((double)xlen/(double)ylen) * 10);
						newY2[2] = vs2.getY()[2] - 10;
					} 
					else if(vs2.getPentagon() == 3) {
						newX2[0] = vs2.getX()[0];
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1];
						newY2[1] = vs2.getY()[1] - 10;
						newX2[2] = vs2.getX()[2] - (int)(((double)xlen/(double)ylen) * 10);
						newY2[2] = vs2.getY()[2] - 10;
						newX2[3] = vs2.getX()[3] - (int)(((double)xlen/(double)ylen) * 10);
						newY2[3] = vs2.getY()[3];
					}
					else if(vs2.getPentagon() == 4) {
						newX2[0] = vs2.getX()[0];
						newY2[0] = vs2.getY()[0] - 10;
						newX2[1] = vs2.getX()[1] - ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[1] = vs2.getY()[1];
						newX2[2] = vs2.getX()[2] - (int)(((double)xlen/(double)ylen) * 10);
						newY2[2] = vs2.getY()[2] - 10;
					}
					else if(vs2.getPentagon() == 5) {
						newX2[0] = vs2.getX()[0] - ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1] - (int)((((double)xlen/(double)ylen) * 10) * 0.19);
						newY2[1] = vs2.getY()[1] - 10;
						newX2[2] = vs2.getX()[2] - (int)(((double)xlen/(double)ylen) * 10);
						newY2[2] = vs2.getY()[2] - (int)(10 * 0.38);
						newX2[3] = vs2.getX()[3];
						newY2[3] = vs2.getY()[3] - (int)(10 * 0.38);
						newX2[4] = vs2.getX()[4] - (int)((((double)xlen/(double)ylen) * 10) * 0.81);
						newY2[4] = vs2.getY()[4] - 10;
					}
					else if(vs2.getPentagon() == 6) {
						newX2[0] = vs2.getX()[0];
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1] - (int)((((double)xlen/(double)ylen) * 10) / 2);
						newY2[1] = vs2.getY()[1] - (int)(10 * 0.33 * 2) ;
						newX2[2] = vs2.getX()[2] - (int)((((double)xlen/(double)ylen) * 10) / 2);
						newY2[2] = vs2.getY()[2] + (int)(10 * 0.33);
						newX2[3] = vs2.getX()[3] - (int)(((double)xlen/(double)ylen) * 10);
						newY2[3] = vs2.getY()[3] - (int)(10 * 0.33 * 4);
					}
					else if(vs2.getPentagon() == 7) {
						newX2[0] = vs2.getX()[0] - ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1] - ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[1] = vs2.getY()[1] - (int)(10 * 0.25);
						newX2[2] = vs2.getX()[2] ;
						newY2[2] = vs2.getY()[2] - (int)(10 * 0.25);
						newX2[3] = vs2.getX()[3] ;
						newY2[3] = vs2.getY()[3] - (int)(10 * 0.75);
						newX2[4] = vs2.getX()[4] - ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[4] = vs2.getY()[4] - (int)(10 * 0.75);
						newX2[5] = vs2.getX()[5] - ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[5] = vs2.getY()[5] - 10;
						newX2[6] = vs2.getX()[6] - (int)(((double)xlen/(double)ylen) * 10);
						newY2[6] = vs2.getY()[6] - 5;
					}
					else if(vs2.getPentagon() == 8) {
						newX2[0] = vs2.getX()[0] - ((int)(((double)xlen/(double)ylen) * 10) / 2);
						newY2[0] = vs2.getY()[0];
						newX2[1] = vs2.getX()[1];
						newY2[1] = vs2.getY()[1] - 5;
						newX2[2] = vs2.getX()[2] - (int)(((double)xlen/(double)ylen) * 10 * 0.25);
						newY2[2] = vs2.getY()[2] - 5;
						newX2[3] = vs2.getX()[3] - (int)(((double)xlen/(double)ylen) * 10 * 0.25);
						newY2[3] = vs2.getY()[3] - 10;
						newX2[4] = vs2.getX()[4] - (int)(((double)xlen/(double)ylen) * 10 * 0.75);
						newY2[4] = vs2.getY()[4] - 10;
						newX2[5] = vs2.getX()[5] - (int)(((double)xlen/(double)ylen) * 10 * 0.75);
						newY2[5] = vs2.getY()[5] - 5;
						newX2[6] = vs2.getX()[6] - (int)(((double)xlen/(double)ylen) * 10);
						newY2[6] = vs2.getY()[6] - 5;
					}
					
					
					Point newXP1 = new Point();
					Point newYP1 = new Point();
					
					newXP1.x = vs2.getStartP().x;
					newXP1.y = vs2.getStartP().y;
					newYP1.x = vs2.getEndP().x + (int)(((double)xlen/(double)ylen) * 10);
					newYP1.y = vs2.getEndP().y + 10;
					
					Point newXP2 = new Point();
					Point newYP2 = new Point();
					
					newXP2.x = vs2.getStartP().x;
					newXP2.y = vs2.getStartP().y;
					newYP2.x = vs2.getEndP().x + (int)(((double)xlen/(double)ylen) * 10);
					newYP2.y = vs2.getEndP().y + 10;

					control.drawShape(shapeList, g);
					shapeList.add(new VarietyShape(newX2, newY2, vs2.getPentagon(), vs2.isFill(), vs2.getEdgeSize(), vs2.getColor(), newXP1, newYP1));
					shapeList.add(new VarietyShape(newX1, newY1, 10, false, 3, new Color(153, 217, 234), newXP2, newYP2));
					control.drawShape(shapeList, g);	
					
					int lastValue = shapeList.size() - 1;
					VarietyShape vs = shapeList.get(lastValue);
					shapeList.get(lastValue).setStartP(vs.getStartP());
					shapeList.get(lastValue).setEndP(vs.getEndP());
				}
			}
		});
		add(downButton);
	}
	
	
	public void makeRangeSelect() {		
		
		rangeSelectButton.setBounds(550, 10, 60, 60);
		rangeSelectButton.setBorderPainted(false);
		rangeSelectButton.setContentAreaFilled(true);
		rangeSelectButton.setFocusPainted(false);
		rangeSelectButton.setBackground(Color.WHITE);
		rangeSelectButton.setFont(new Font("나눔바른고딕", Font.BOLD, 18));
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
				if(control.getCurrentStatus() == 10) {
					control.setCurrentStatus(11);
					rangeSelectButton.setText("Off");
				}
				else {
					control.setCurrentStatus(10);
					rangeSelectButton.setText("On");
				}
						
				if(control.getCurrentStatus() == 10){
					selectStatus = 0;
					int lastValue = shapeList.size() - 1;
					VarietyShape vs = shapeList.get(lastValue);
					startP = vs.getStartP();
					endP = vs.getEndP();
					
					Graphics g = getGraphics();
					rePaint(g);
					update(g);
					int[] x = new int[2];
					int[] y = new int[2];
					int boldSize = vs.getEdgeSize();
					
					x[0] = startP.x + 13 - boldSize;	y[0] = startP.y + 166 - boldSize;
					x[1] = endP.x + 13 + boldSize;		y[1] = endP.y + 166 + boldSize;

					shapeList.add(new VarietyShape(x, y, 10, false, 3, new Color(153, 217, 234), startP, endP));
					control.drawShape(shapeList, g);
					
					control.getP().addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							control.getP().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							Point moveP = e.getPoint();
							int  lastValue = shapeList.size() - 1;
							
							
							if(shapeList.get(lastValue).getStartP().x <= moveP.x && shapeList.get(lastValue).getEndP().x >= moveP.x && shapeList.get(lastValue).getStartP().y <= moveP.y && shapeList.get(lastValue).getEndP().y >= moveP.y) {
								selectStatus = 1;
							
								control.getP().setCursor(new Cursor(Cursor.MOVE_CURSOR));
							}
							else {
								selectStatus = 0;
								
								control.getP().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
							}
							
							lastValue = shapeList.size() - 1;
							
						}
						
						
						@Override
						public void mouseReleased(MouseEvent e) {
							
							if(selectStatus == 1) {
								selectStatus = 0;
								control.getP().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
								
								endP = e.getPoint();
								Graphics g = getGraphics();
								rePaint(g);
								update(g);
								
								int choiceValue = shapeList.size() - 1;
								
								VarietyShape vs1 = shapeList.remove(choiceValue);
								VarietyShape vs2 = shapeList.remove(lastValue);
								
								int newX1[] = new int[vs1.getX().length];
								int newY1[] = new int[vs1.getY().length];
								
								for(int i = 0; i < vs1.getX().length; i++) {
									newX1[i] = (vs1.getX()[i] + (endP.x - startP.x));
								}
								
								for(int i = 0; i < vs1.getY().length; i++) {
									newY1[i] = (vs1.getY()[i] + (endP.y - startP.y));
								}
								
								int newX2[] = new int[vs2.getX().length];
								int newY2[] = new int[vs2.getY().length];
								
								if(vs2.getPentagon() == 2) {
									newX2[0] = vs2.getX()[0] + (endP.x - startP.x);
									newY2[0] = vs2.getY()[0] + (endP.y - startP.y);
									newX2[1] = vs2.getX()[1] + (endP.x - startP.x);
									newY2[1] = vs2.getY()[1] + (endP.y - startP.y);
									newX2[2] = vs2.getX()[2] ;
									newY2[2] = vs2.getY()[2] ;
								}
								if(vs2.getPentagon() == 6) {
									newX2[0] = (vs2.getX()[0] + (endP.x - startP.x));
									newY2[0] = (vs2.getY()[0] + (endP.y - startP.y));
									newX2[1] = (vs2.getX()[1]);
									newY2[1] = (vs2.getY()[1]);
									newX2[2] = (vs2.getX()[2] + (endP.x - startP.x));
									newY2[2] = (vs2.getY()[2] + (endP.y - startP.y));
									newX2[3] = (vs2.getX()[3]);
									newY2[3] = (vs2.getY()[3]);
								}
								else {
									for(int i = 0; i < vs2.getX().length; i++) {
										newX2[i] = (vs2.getX()[i] + (endP.x - startP.x));
									}
									
									for(int i = 0; i < vs2.getY().length; i++) {
										newY2[i] = (vs2.getY()[i] + (endP.y - startP.y));
									}
								}
								
								Point newXP1 = new Point();
								Point newYP1 = new Point();
								
								newXP1.x = vs2.getStartP().x + (endP.x - startP.x);
								newXP1.y = vs2.getStartP().y + (endP.y - startP.y);
								newYP1.x = vs2.getEndP().x + (endP.x - startP.x);
								newYP1.y = vs2.getEndP().y + (endP.y - startP.y);
								
								Point newXP2 = new Point();
								Point newYP2 = new Point();
								
								newXP2.x = vs2.getStartP().x + (endP.x - startP.x);
								newXP2.y = vs2.getStartP().y + (endP.y - startP.y);
								newYP2.x = vs2.getEndP().x + (endP.x - startP.x);
								newYP2.y = vs2.getEndP().y + (endP.y - startP.y);

								control.drawShape(shapeList, g);
								shapeList.add(new VarietyShape(newX2, newY2, vs2.getPentagon(), vs2.isFill(), vs2.getEdgeSize(), vs2.getColor(), newXP1, newYP1));
								shapeList.add(new VarietyShape(newX1, newY1, 10, false, 3, new Color(153, 217, 234), newXP2, newYP2));
								control.drawShape(shapeList, g);	
								
								
								int lastValue = shapeList.size() - 1;
								VarietyShape vs = shapeList.get(lastValue);
								
								shapeList.get(lastValue).setStartP(vs.getStartP());
								shapeList.get(lastValue).setEndP(vs.getEndP());
							}
						}
						
						
					});

				}
				
				else if(control.getCurrentStatus() == 11){
					Graphics g = getGraphics();
					update(g);
					int lastValue = shapeList.size() - 1;
					if(lastValue >= 0) {
						shapeList.remove(lastValue);
						control.drawShape(shapeList, g);
					}
					
				}
				
				
			}
			
			});
		add(rangeSelectButton);
		
		choiceBox.setText("선택");
		choiceBox.setVerticalAlignment(SwingConstants.CENTER);
		choiceBox.setHorizontalAlignment(SwingConstants.RIGHT);
		choiceBox.setBounds(510, 85, 80, 15);
		choiceBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		choiceBox.setForeground(Color.BLACK);
		add(choiceBox);
	}
	
	
	public void setText() {		// 글자 정리
		colorButton.setVerticalTextPosition(JButton.CENTER);
		colorButton.setHorizontalTextPosition(JButton.CENTER);
		colorButton.setFont(new Font("Arial", Font.BOLD, 20));
	}
	
	
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
		
	}
	
	public void screenReDraw(Graphics g) {
		paintComponents(g);
		this.repaint();
	}
	
	

	
}
