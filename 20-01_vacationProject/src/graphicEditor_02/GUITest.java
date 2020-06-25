package graphicEditor_02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import calculator_01.CalculatorMain;


public class GUITest extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon lineButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/line.png"));
	private ImageIcon circleButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/circle.png"));
	private ImageIcon squareButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/square.png"));
	private ImageIcon triangleButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/triangle.png"));
	private ImageIcon starButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/star.png"));
	private ImageIcon heartButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/heart.png"));
	
	private JButton numButton01 = new JButton(lineButtonBasicImage);
	private JButton numButton02 = new JButton(circleButtonBasicImage);
	private JButton numButton03 = new JButton(squareButtonBasicImage);
	private JButton numButton04 = new JButton(triangleButtonBasicImage);
	private JButton numButton05 = new JButton(starButtonBasicImage);
	private JButton numButton06 = new JButton(heartButtonBasicImage);
	private JButton colorButton = new JButton();
	private JButton boldButton = new JButton("10");
	private JButton fillButton = new JButton();
	
	private JPanel buttonPanel = new JPanel();
	
	private JLabel shapeBox = new JLabel();
	private JLabel colorBox = new JLabel();
	private JLabel boldBox = new JLabel();
	private JLabel fillBox = new JLabel();
	
	private int mouseX, mouseY;
	
	EdgeColor edgeColor = new EdgeColor();
	FillColor fillColor = new FillColor();
	Bold bold = new Bold();
	Control control = new Control();

	
	GUITest() {
		setTitle("Graphic Editor");
		setSize(GraphicEditorMain.SCREEN_WIDTH, GraphicEditorMain.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		
		createMenuBar();
		makeShapeBox();
		makeProperty();
		makePanel();
		setText();

	}
	
	
	public void createMenuBar() {
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
				control.changeCurrentStatus(GraphicEditorMain.LINE);
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
		
			}
		});
		add(numButton06);
		
		shapeBox.setText("도형");
		shapeBox.setVerticalAlignment(SwingConstants.CENTER);
		shapeBox.setHorizontalAlignment(SwingConstants.RIGHT);
		shapeBox.setBounds(0, 85, 80, 15);
		shapeBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		shapeBox.setForeground(Color.BLACK);
		add(shapeBox);
		
	}
	
	public void makeProperty() {
		colorButton.setBounds(150, 10, 60, 60);
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
			}
		});
		add(colorButton);
		
		colorBox.setText("색상");
		colorBox.setVerticalAlignment(SwingConstants.CENTER);
		colorBox.setHorizontalAlignment(SwingConstants.RIGHT);
		colorBox.setBounds(111, 85, 80, 15);
		colorBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		colorBox.setForeground(Color.BLACK);
		add(colorBox);
		
		boldButton.setBounds(220, 10, 60, 60);
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
			}
		});
		add(boldButton);
		
		boldBox.setText("굵기");
		boldBox.setVerticalAlignment(SwingConstants.CENTER);
		boldBox.setHorizontalAlignment(SwingConstants.RIGHT);
		boldBox.setBounds(181, 85, 80, 15);
		boldBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		boldBox.setForeground(Color.BLACK);
		add(boldBox);
		
		fillButton.setBounds(290, 10, 60, 60);
		fillButton.setBorderPainted(false);
		fillButton.setContentAreaFilled(true);
		fillButton.setFocusPainted(false);
		fillButton.setBackground(fillColor.getFillColor());
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
				fillColor.changeFillColor();
				fillButton.setBackground(fillColor.getFillColor());
			}
		});
		add(fillButton);
		
		fillBox.setText("채우기");
		fillBox.setVerticalAlignment(SwingConstants.CENTER);
		fillBox.setHorizontalAlignment(SwingConstants.RIGHT);
		fillBox.setBounds(257, 85, 80, 15);
		fillBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		fillBox.setForeground(Color.BLACK);
		add(fillBox);
	}
	
	public void setText() {		// 글자 정리
		colorButton.setVerticalTextPosition(JButton.CENTER);
		colorButton.setHorizontalTextPosition(JButton.CENTER);
		colorButton.setFont(new Font("Arial", Font.BOLD, 20));
	}
	

	
	public void paint(Graphics g) {
		try {
			Thread.sleep(100);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		screenImage = createImage(GraphicEditorMain.SCREEN_WIDTH, GraphicEditorMain.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		paintComponents(g);
		this.repaint();
	}
	
}
