package calculator_01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUITest extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon numButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/numButton.png"));
	private ImageIcon symbolButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/symbolButton.png"));
	private ImageIcon numButtonEnteredImage = new ImageIcon(CalculatorMain.class.getResource("../images/numButtonEntered.png"));
	private ImageIcon equalButtonBasicImage = new ImageIcon(CalculatorMain.class.getResource("../images/equalButton.png"));
	private ImageIcon equalButtonEnteredImage = new ImageIcon(CalculatorMain.class.getResource("../images/equalButtonEntered.png"));

	private String numText01 = "1";
	private String numText02 = "2";
	private String numText03 = "3";
	private String numText04 = "4";
	private String numText05 = "5";
	private String numText06 = "6";
	private String numText07 = "7";
	private String numText08 = "8";
	private String numText09 = "9";
	private String numText00 = "0";
	private String numTextPlusMinus = "¡¾";
	private String numTextDot = ".";
	
	private String symbolTextCE = "CE";
	private String symbolTextC = "C";
	private String symbolTextBack = "¡ç";
	private String symbolTextDivide = "¡À";
	private String symbolTextMultiple = "¡¿";
	private String symbolTextMinus = "¡ª";
	private String symbolTextPlus = "+";
	
	private String equalText = "=";
	
	private JButton numButton01 = new JButton(numText01, numButtonBasicImage);
	private JButton numButton02 = new JButton(numText02, numButtonBasicImage);
	private JButton numButton03 = new JButton(numText03, numButtonBasicImage);
	private JButton numButton04 = new JButton(numText04, numButtonBasicImage);
	private JButton numButton05 = new JButton(numText05, numButtonBasicImage);
	private JButton numButton06 = new JButton(numText06, numButtonBasicImage);
	private JButton numButton07 = new JButton(numText07, numButtonBasicImage);
	private JButton numButton08 = new JButton(numText08, numButtonBasicImage);
	private JButton numButton09 = new JButton(numText09, numButtonBasicImage);
	private JButton numButton00 = new JButton(numText00, numButtonBasicImage);
	private JButton numButtonPlusMinus = new JButton(numTextPlusMinus, numButtonBasicImage);
	private JButton numButtonDot = new JButton(numTextDot, numButtonBasicImage);
	
	private JButton symbolButtonCE = new JButton(symbolTextCE, symbolButtonBasicImage);
	private JButton symbolButtonC = new JButton(symbolTextC, symbolButtonBasicImage);
	private JButton symbolButtonBack = new JButton(symbolTextBack, symbolButtonBasicImage);
	private JButton symbolButtonDivide = new JButton(symbolTextDivide, symbolButtonBasicImage);
	private JButton symbolButtonMultiple = new JButton(symbolTextMultiple, symbolButtonBasicImage);
	private JButton symbolButtonMinus = new JButton(symbolTextMinus, symbolButtonBasicImage);
	private JButton symbolButtonPlus = new JButton(symbolTextPlus, symbolButtonBasicImage);
	
	private JButton equalButton = new JButton(equalText, equalButtonBasicImage);
	
	private JLabel calculateBox = new JLabel();
	
	
	Calculate calculate = new Calculate();

	
	GUITest() {
		setTitle("Calculator");
		setSize(CalculatorMain.SCREEN_WIDTH, CalculatorMain.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		
		makeNum();
		makeSymbol();
		makeEqual();
		setText();
		setValueText();
	}
	
	
	
	public void makeNum() {
		numButtonPlusMinus.setBounds(5, 385, 80, 70);
		numButtonPlusMinus.setBorderPainted(false);
		numButtonPlusMinus.setContentAreaFilled(false);
		numButtonPlusMinus.setFocusPainted(false);
		numButtonPlusMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButtonPlusMinus.setIcon(numButtonEnteredImage);
				numButtonPlusMinus.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButtonPlusMinus.setIcon(numButtonBasicImage);
				numButtonPlusMinus.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.setCurrentValue(calculate.changePlusMinus());
				setValueText();
			}
		});
		add(numButtonPlusMinus);
		
		numButton00.setBounds(90, 385, 80, 70);
		numButton00.setBorderPainted(false);
		numButton00.setContentAreaFilled(false);
		numButton00.setFocusPainted(false);
		numButton00.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton00.setIcon(numButtonEnteredImage);
				numButton00.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton00.setIcon(numButtonBasicImage);
				numButton00.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.plusCurrentValue("0");
				setValueText();
			}
		});
		add(numButton00);
		
		numButtonDot.setBounds(175, 385, 80, 70);
		numButtonDot.setBorderPainted(false);
		numButtonDot.setContentAreaFilled(false);
		numButtonDot.setFocusPainted(false);
		numButtonDot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButtonDot.setIcon(numButtonEnteredImage);
				numButtonDot.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButtonDot.setIcon(numButtonBasicImage);
				numButtonDot.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.plusCurrentValue(".");
				setValueText();
				calculate.setDotClicked(true);
			}
		});
		add(numButtonDot);
		
		numButton01.setBounds(5, 310, 80, 70);
		numButton01.setBorderPainted(false);
		numButton01.setContentAreaFilled(false);
		numButton01.setFocusPainted(false);
		numButton01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton01.setIcon(numButtonEnteredImage);
				numButton01.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton01.setIcon(numButtonBasicImage);
				numButton01.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.plusCurrentValue("1");
				setValueText();
			}
		});
		add(numButton01);
		
		numButton02.setBounds(90, 310, 80, 70);
		numButton02.setBorderPainted(false);
		numButton02.setContentAreaFilled(false);
		numButton02.setFocusPainted(false);
		numButton02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton02.setIcon(numButtonEnteredImage);
				numButton02.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton02.setIcon(numButtonBasicImage);
				numButton02.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.plusCurrentValue("2");
				setValueText();
				
			}
		});
		add(numButton02);
		
		numButton03.setBounds(175, 310, 80, 70);
		numButton03.setBorderPainted(false);
		numButton03.setContentAreaFilled(false);
		numButton03.setFocusPainted(false);
		numButton03.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton03.setIcon(numButtonEnteredImage);
				numButton03.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton03.setIcon(numButtonBasicImage);
				numButton03.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.plusCurrentValue("3");
				setValueText();
				
			}
		});
		add(numButton03);
		
		numButton04.setBounds(5, 235, 80, 70);
		numButton04.setBorderPainted(false);
		numButton04.setContentAreaFilled(false);
		numButton04.setFocusPainted(false);
		numButton04.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton04.setIcon(numButtonEnteredImage);
				numButton04.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton04.setIcon(numButtonBasicImage);
				numButton04.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.plusCurrentValue("4");
				setValueText();
			}

		});
		add(numButton04);
		
		numButton05.setBounds(90, 235, 80, 70);
		numButton05.setBorderPainted(false);
		numButton05.setContentAreaFilled(false);
		numButton05.setFocusPainted(false);
		numButton05.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton05.setIcon(numButtonEnteredImage);
				numButton05.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton05.setIcon(numButtonBasicImage);
				numButton05.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.plusCurrentValue("5");
				setValueText();
			}

		});
		add(numButton05);
		
		numButton06.setBounds(175, 235, 80, 70);
		numButton06.setBorderPainted(false);
		numButton06.setContentAreaFilled(false);
		numButton06.setFocusPainted(false);
		numButton06.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton06.setIcon(numButtonEnteredImage);
				numButton06.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton06.setIcon(numButtonBasicImage);
				numButton06.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.plusCurrentValue("6");
				setValueText();
			}

		});
		add(numButton06);
		
		numButton07.setBounds(5, 160, 80, 70);
		numButton07.setBorderPainted(false);
		numButton07.setContentAreaFilled(false);
		numButton07.setFocusPainted(false);
		numButton07.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton07.setIcon(numButtonEnteredImage);
				numButton07.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton07.setIcon(numButtonBasicImage);
				numButton07.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.plusCurrentValue("7");
				setValueText();
			}

		});
		add(numButton07);
		
		numButton08.setBounds(90, 160, 80, 70);
		numButton08.setBorderPainted(false);
		numButton08.setContentAreaFilled(false);
		numButton08.setFocusPainted(false);
		numButton08.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton08.setIcon(numButtonEnteredImage);
				numButton08.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton08.setIcon(numButtonBasicImage);
				numButton08.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.plusCurrentValue("8");
				setValueText();
			}

		});
		add(numButton08);
		
		numButton09.setBounds(175, 160, 80, 70);
		numButton09.setBorderPainted(false);
		numButton09.setContentAreaFilled(false);
		numButton09.setFocusPainted(false);
		numButton09.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				numButton09.setIcon(numButtonEnteredImage);
				numButton09.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				numButton09.setIcon(numButtonBasicImage);
				numButton09.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.plusCurrentValue("9");
				setValueText();
			}

		});
		add(numButton09);
		
	}
	
	public void makeSymbol() {
		symbolButtonCE.setBounds(5, 85, 80, 70);
		symbolButtonCE.setBorderPainted(false);
		symbolButtonCE.setContentAreaFilled(false);
		symbolButtonCE.setFocusPainted(false);
		symbolButtonCE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				symbolButtonCE.setIcon(numButtonEnteredImage);
				symbolButtonCE.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				symbolButtonCE.setIcon(symbolButtonBasicImage);
				symbolButtonCE.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.setCurrentValue("");
				calculate.setSymbolClicked(false);
				calculate.setDotClicked(false);
				calculate.setIntermediateStored(false);
				setValueText();
			}
		});
		add(symbolButtonCE);
		
		symbolButtonC.setBounds(90, 85, 80, 70);
		symbolButtonC.setBorderPainted(false);
		symbolButtonC.setContentAreaFilled(false);
		symbolButtonC.setFocusPainted(false);
		symbolButtonC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				symbolButtonC.setIcon(numButtonEnteredImage);
				symbolButtonC.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				symbolButtonC.setIcon(symbolButtonBasicImage);
				symbolButtonC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.setCurrentValue("");
				calculate.setSymbolClicked(false);
				calculate.setDotClicked(false);
				calculate.setIntermediateStored(false);
				setValueText();
			}
		});
		add(symbolButtonC);
		
		symbolButtonBack.setBounds(175, 85, 80, 70);
		symbolButtonBack.setBorderPainted(false);
		symbolButtonBack.setContentAreaFilled(false);
		symbolButtonBack.setFocusPainted(false);
		symbolButtonBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				symbolButtonBack.setIcon(numButtonEnteredImage);
				symbolButtonBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				symbolButtonBack.setIcon(symbolButtonBasicImage);
				symbolButtonBack.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.setCurrentValue(calculate.deleteValue());
				setValueText();
			}
		});
		add(symbolButtonBack);
		
		symbolButtonDivide.setBounds(260, 85, 80, 70);
		symbolButtonDivide.setBorderPainted(false);
		symbolButtonDivide.setContentAreaFilled(false);
		symbolButtonDivide.setFocusPainted(false);
		symbolButtonDivide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				symbolButtonDivide.setIcon(numButtonEnteredImage);
				symbolButtonDivide.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				symbolButtonDivide.setIcon(symbolButtonBasicImage);
				symbolButtonDivide.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(calculate.isIntermediateStored()) {
					calculate.setCurrentValue(calculate.calculateAnswer());
					calculate.setIntermediateResult(Float.parseFloat(calculate.getCurrentValue()));
					setValueText();
				}
				else {
					calculate.setIntermediateResult(Float.parseFloat(calculate.getCurrentValue()));
				}
				calculate.setSymbolClicked(true);
				calculate.setPlusClicked(false);
				calculate.setMinusClicked(false);
				calculate.setMultipleClicked(false);
				calculate.setDivideClicked(true);
				calculate.setIntermediateStored(true);
				
			}
		});
		add(symbolButtonDivide);
		
		symbolButtonMultiple.setBounds(260, 160, 80, 70);
		symbolButtonMultiple.setBorderPainted(false);
		symbolButtonMultiple.setContentAreaFilled(false);
		symbolButtonMultiple.setFocusPainted(false);
		symbolButtonMultiple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				symbolButtonMultiple.setIcon(numButtonEnteredImage);
				symbolButtonMultiple.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				symbolButtonMultiple.setIcon(symbolButtonBasicImage);
				symbolButtonMultiple.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(calculate.isIntermediateStored()) {
					calculate.setCurrentValue(calculate.calculateAnswer());
					calculate.setIntermediateResult(Float.parseFloat(calculate.getCurrentValue()));
					setValueText();
				}
				else {
					calculate.setIntermediateResult(Float.parseFloat(calculate.getCurrentValue()));
				}
				calculate.setSymbolClicked(true);
				calculate.setPlusClicked(false);
				calculate.setMinusClicked(false);
				calculate.setMultipleClicked(true);
				calculate.setDivideClicked(false);
				calculate.setIntermediateStored(true);
			}
		});
		add(symbolButtonMultiple);
		
		symbolButtonMinus.setBounds(260, 235, 80, 70);
		symbolButtonMinus.setBorderPainted(false);
		symbolButtonMinus.setContentAreaFilled(false);
		symbolButtonMinus.setFocusPainted(false);
		symbolButtonMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				symbolButtonMinus.setIcon(numButtonEnteredImage);
				symbolButtonMinus.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				symbolButtonMinus.setIcon(symbolButtonBasicImage);
				symbolButtonMinus.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(calculate.isIntermediateStored()) {
					calculate.setCurrentValue(calculate.calculateAnswer());
					calculate.setIntermediateResult(Float.parseFloat(calculate.getCurrentValue()));
					setValueText();
				}
				else {
					calculate.setIntermediateResult(Float.parseFloat(calculate.getCurrentValue()));
				}
				calculate.setSymbolClicked(true);
				calculate.setPlusClicked(false);
				calculate.setMinusClicked(true);
				calculate.setMultipleClicked(false);
				calculate.setDivideClicked(false);
				calculate.setIntermediateStored(true);
			}
		});
		add(symbolButtonMinus);
		
		symbolButtonPlus.setBounds(260, 310, 80, 70);
		symbolButtonPlus.setBorderPainted(false);
		symbolButtonPlus.setContentAreaFilled(false);
		symbolButtonPlus.setFocusPainted(false);
		symbolButtonPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				symbolButtonPlus.setIcon(numButtonEnteredImage);
				symbolButtonPlus.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				symbolButtonPlus.setIcon(symbolButtonBasicImage);
				symbolButtonPlus.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(calculate.isIntermediateStored()) {
					calculate.setCurrentValue(calculate.calculateAnswer());
					calculate.setIntermediateResult(Float.parseFloat(calculate.getCurrentValue()));
					setValueText();
				}
				else {
					calculate.setIntermediateResult(Float.parseFloat(calculate.getCurrentValue()));
				}
				calculate.setSymbolClicked(true);
				calculate.setPlusClicked(true);
				calculate.setMinusClicked(false);
				calculate.setMultipleClicked(false);
				calculate.setDivideClicked(false);
				calculate.setIntermediateStored(true);
			}
		});
		add(symbolButtonPlus);
		
	}
	
	
	public void makeEqual() {
		equalButton.setBounds(260, 385, 80, 70);
		equalButton.setBorderPainted(false);
		equalButton.setContentAreaFilled(false);
		equalButton.setFocusPainted(false);
		equalButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				equalButton.setIcon(equalButtonEnteredImage);
				equalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				equalButton.setIcon(equalButtonBasicImage);
				equalButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				calculate.setCurrentValue(calculate.calculateAnswer());
				setValueText();
			}
		});
		add(equalButton);
	}
	
	public void setText() {		
		numButton01.setVerticalTextPosition(JButton.CENTER);
		numButton01.setHorizontalTextPosition(JButton.CENTER);	
		numButton01.setFont(new Font("Arial", Font.BOLD, 20));
		
		numButton02.setVerticalTextPosition(JButton.CENTER);
		numButton02.setHorizontalTextPosition(JButton.CENTER);
		numButton02.setFont(new Font("Arial", Font.BOLD, 20));
		
		numButton03.setVerticalTextPosition(JButton.CENTER);
		numButton03.setHorizontalTextPosition(JButton.CENTER);
		numButton03.setFont(new Font("Arial", Font.BOLD, 20));
		
		numButton04.setVerticalTextPosition(JButton.CENTER);
		numButton04.setHorizontalTextPosition(JButton.CENTER);
		numButton04.setFont(new Font("Arial", Font.BOLD, 20));
		
		numButton05.setVerticalTextPosition(JButton.CENTER);
		numButton05.setHorizontalTextPosition(JButton.CENTER);
		numButton05.setFont(new Font("Arial", Font.BOLD, 20));
		
		numButton06.setVerticalTextPosition(JButton.CENTER);
		numButton06.setHorizontalTextPosition(JButton.CENTER);
		numButton06.setFont(new Font("Arial", Font.BOLD, 20));
		
		numButton07.setVerticalTextPosition(JButton.CENTER);
		numButton07.setHorizontalTextPosition(JButton.CENTER);
		numButton07.setFont(new Font("Arial", Font.BOLD, 20));
		
		numButton08.setVerticalTextPosition(JButton.CENTER);
		numButton08.setHorizontalTextPosition(JButton.CENTER);
		numButton08.setFont(new Font("Arial", Font.BOLD, 20));
		
		numButton09.setVerticalTextPosition(JButton.CENTER);
		numButton09.setHorizontalTextPosition(JButton.CENTER);
		numButton09.setFont(new Font("Arial", Font.BOLD, 20));
		
		numButton00.setVerticalTextPosition(JButton.CENTER);
		numButton00.setHorizontalTextPosition(JButton.CENTER);
		numButton00.setFont(new Font("Arial", Font.BOLD, 20));
		
		numButtonPlusMinus.setVerticalTextPosition(JButton.CENTER);
		numButtonPlusMinus.setHorizontalTextPosition(JButton.CENTER);
		numButtonPlusMinus.setFont(new Font("Arial", Font.BOLD, 20));
		
		numButtonDot.setVerticalTextPosition(JButton.CENTER);
		numButtonDot.setHorizontalTextPosition(JButton.CENTER);
		numButtonDot.setFont(new Font("Arial", Font.BOLD, 20));
		
		symbolButtonCE.setVerticalTextPosition(JButton.CENTER);
		symbolButtonCE.setHorizontalTextPosition(JButton.CENTER);
		symbolButtonCE.setFont(new Font("Arial", Font.PLAIN, 20));
		
		symbolButtonC.setVerticalTextPosition(JButton.CENTER);
		symbolButtonC.setHorizontalTextPosition(JButton.CENTER);
		symbolButtonC.setFont(new Font("Arial", Font.PLAIN, 20));

		symbolButtonBack.setVerticalTextPosition(JButton.CENTER);
		symbolButtonBack.setHorizontalTextPosition(JButton.CENTER);
		symbolButtonBack.setFont(new Font("Arial", Font.PLAIN, 20));
		
		symbolButtonDivide.setVerticalTextPosition(JButton.CENTER);
		symbolButtonDivide.setHorizontalTextPosition(JButton.CENTER);
		symbolButtonDivide.setFont(new Font("Arial", Font.PLAIN, 30));
		
		symbolButtonMultiple.setVerticalTextPosition(JButton.CENTER);
		symbolButtonMultiple.setHorizontalTextPosition(JButton.CENTER);
		symbolButtonMultiple.setFont(new Font("Arial", Font.PLAIN, 30));
		
		symbolButtonMinus.setVerticalTextPosition(JButton.CENTER);
		symbolButtonMinus.setHorizontalTextPosition(JButton.CENTER);
		symbolButtonMinus.setFont(new Font("Arial", Font.PLAIN, 18));
		
		symbolButtonPlus.setVerticalTextPosition(JButton.CENTER);
		symbolButtonPlus.setHorizontalTextPosition(JButton.CENTER);
		symbolButtonPlus.setFont(new Font("Arial", Font.PLAIN, 30));
		
		equalButton.setVerticalTextPosition(JButton.CENTER);
		equalButton.setHorizontalTextPosition(JButton.CENTER);
		equalButton.setFont(new Font("Arial", Font.PLAIN, 30));
		
	}

	public void setValueText() {
		calculateBox.setText(calculate.getCurrentValue());
		calculateBox.setVerticalAlignment(SwingConstants.CENTER);
		calculateBox.setHorizontalAlignment(SwingConstants.RIGHT);
		calculateBox.setBounds(0, 5, 320, 80);
		calculateBox.setFont(new Font("Serif", Font.BOLD, 30));
		calculateBox.setForeground(Color.BLACK);
		add(calculateBox);
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(CalculatorMain.SCREEN_WIDTH, CalculatorMain.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		paintComponents(g);
		this.repaint();
	}
	
}
