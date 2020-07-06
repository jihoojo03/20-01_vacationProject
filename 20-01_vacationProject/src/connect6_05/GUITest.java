package connect6_05;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;

public class GUITest extends JFrame {
	
	private JPanel gamePanel = new JPanel();
	private JPanel settingPanel = new JPanel();
	private JPanel startPanel = new JPanel();
	
	private ImageIcon boardImage01 = new ImageIcon(Connect6Main.class.getResource("../images/board.png"));
	private ImageIcon boardImage02 = new ImageIcon(Connect6Main.class.getResource("../images/board02.png"));
	private ImageIcon boardImage03 = new ImageIcon(Connect6Main.class.getResource("../images/jihoonBoard.png"));
	private ImageIcon blackStone = new ImageIcon(Connect6Main.class.getResource("../images/blackStone.png"));
	private ImageIcon whiteStone = new ImageIcon(Connect6Main.class.getResource("../images/whiteStone.png"));
	private ImageIcon blueStone = new ImageIcon(Connect6Main.class.getResource("../images/blueStone.png"));
	private ImageIcon yellowStone = new ImageIcon(Connect6Main.class.getResource("../images/yellowStone.png"));
	private ImageIcon xMark = new ImageIcon(Connect6Main.class.getResource("../images/newXMark.png"));
	private ImageIcon buttonImage = new ImageIcon(Connect6Main.class.getResource("../images/containButtonEntered.png"));
	private ImageIcon blackStoneTitle = new ImageIcon(Connect6Main.class.getResource("../images/blackStoneTitle.png"));
	private ImageIcon player = new ImageIcon(Connect6Main.class.getResource("../images/player.png"));
	private ImageIcon whiteFlag = new ImageIcon(Connect6Main.class.getResource("../images/whiteFlag.png"));
	private ImageIcon reset = new ImageIcon(Connect6Main.class.getResource("../images/reset.png"));
	private ImageIcon back = new ImageIcon(Connect6Main.class.getResource("../images/back.png"));
	private ImageIcon exit = new ImageIcon(Connect6Main.class.getResource("../images/exit.png"));
	
	private JLabel connect6Main = new JLabel("Connect6");
	private JLabel blackStoneMain = new JLabel(blackStoneTitle);
	private JLabel connect6Title = new JLabel("Connect6");
	private JLabel boardLabel = new JLabel(boardImage02);
	private JLabel connect6Title02 = new JLabel("Connect6");
	private JLabel boardLabel02 = new JLabel(boardImage02);
	private JLabel shapeLabel = new JLabel("¹ÙµÏÆÇ ¸ð¾ç");
	private JLabel colorLabel = new JLabel("¹ÙµÏµ¹ »ö±ò");
	private JLabel player1Image = new JLabel(player);
	private JLabel player2Image = new JLabel(player);
	private JLabel timerLabel = new JLabel("Example");
	private JLabel player1Label = new JLabel("Player 1");
	private JLabel player2Label = new JLabel("Player 2");
	private JLabel timeLimitLabel = new JLabel("Á¦ÇÑ½Ã°£ ¼³Á¤");
	private JLabel timeShowLabel = new JLabel("15s");
	private JLabel optionP1Label = new JLabel(blackStone);
	private JLabel optionP2Label = new JLabel(whiteStone);

	private JLabel stoneLabel[][] = new JLabel[19][19];
	private JLabel stoneLabel02[][] = new JLabel[19][19];
	
	private JCheckBox defaultShapeCheckBox = new JCheckBox("±âº»");
	private JCheckBox whiteShapeCheckBox = new JCheckBox("È­ÀÌÆ®");
	private JCheckBox jihoonShapeCheckBox = new JCheckBox("ÁöÈÆ");
	private JCheckBox player1BlackCheckBox = new JCheckBox("Èæ");
	private JCheckBox player1WhiteCheckBox = new JCheckBox("¹é");
	private JCheckBox player1BlueCheckBox = new JCheckBox("Ã»");
	private JCheckBox player1YellowCheckBox = new JCheckBox("³ë");
	private JCheckBox player2BlackCheckBox = new JCheckBox("Èæ");
	private JCheckBox player2WhiteCheckBox = new JCheckBox("¹é");
	private JCheckBox player2BlueCheckBox = new JCheckBox("Ã»");
	private JCheckBox player2YellowCheckBox = new JCheckBox("³ë");
	
	private JButton settingConfirmButton = new JButton("¼³Á¤ ¿Ï·á");
	private JButton startMainButton = new JButton("°ÔÀÓ ½ÃÀÛ");
	private JButton settingMainButton = new JButton("¼³Á¤");
	private JButton player1Button = new JButton("Player1");
	private JButton player2Button = new JButton("Player2");
	private JButton whiteFlagButton = new JButton(whiteFlag);
	private JButton resetButton = new JButton(reset);
	private JButton backButton = new JButton(back);
	private JButton exitButton = new JButton(exit);
	
	private JSlider timeLimitSlider = new JSlider(15, 60);
	
	private Timer timer = new Timer();
	
	private int countX;
	private int countY;
	
	GameAlgorithm gameAl = new GameAlgorithm();
	
	GUITest() {
		getContentPane().setBackground(new Color(245, 245, 245));
		setTitle("Connect6");
		setSize(Connect6Main.SCREEN_WIDTH, Connect6Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		makeSetting();
		makeStart();
		makeGame();
	}
	
	public void makeGame() {	
		for(countX = 0; countX < 19; countX++) {
			for(countY = 0; countY < 19; countY++) {
				stoneLabel[countX][countY] = new JLabel();
				stoneLabel[countX][countY].setBounds(24 + 28 * countX, 24 + 28 * countY, 27, 27);
				stoneLabel[countX][countY].setVisible(true);
				gamePanel.add(stoneLabel[countX][countY]);
			}
		}
		
		boardLabel.setBackground(new Color(0, 0, 0));
		boardLabel.setBounds(20, 20, 540, 540);
		boardLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boardLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boardLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Point point = e.getPoint();
				System.out.println(point);
				int adjX = (point.x - 3) / 28 + 1;
				int adjY = (point.y - 3) / 28 + 1;
				
				if(gameAl.isStone(adjX, adjY)) {
					System.out.println("StoneÀÌ ÀÖ½À´Ï´Ù");
				}
				else {
					gameAl.launch();
					System.out.println(adjX + "/" + adjY);
					gameAl.setStone(adjX, adjY, gameAl.getCurrentTurn());
					System.out.println("Win : "+ gameAl.win(adjX, adjY));
					if(gameAl.getCurrentTurn() == 0) stoneLabel[adjX - 1][adjY - 1].setIcon(blackStone);
					else if(gameAl.getCurrentTurn() == 1) stoneLabel[adjX - 1][adjY - 1].setIcon(whiteStone);
				}
			}
		});	
		gamePanel.add(boardLabel);
		
		
		connect6Title.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		connect6Title.setBounds(228, 570, 108, 31);
		gamePanel.add(connect6Title);
		
		player1Image.setBounds(590, 120, 160, 160);
		player1Image.setVisible(true);
		gamePanel.add(player1Image);
		
		player2Image.setBounds(765, 120, 160, 160);
		player2Image.setVisible(true);
		gamePanel.add(player2Image);
		
		timerLabel.setBackground(Color.BLACK);
		timerLabel.setBounds(590, 20, 335, 90);
		timerLabel.setVisible(true);
		gamePanel.add(timerLabel);
		
		player1Button.setBounds(590, 290, 160, 40);
		player1Button.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 16));
		player1Button.setVisible(true);
		player1Button.setBorderPainted(false);
		player1Button.setContentAreaFilled(true);
		player1Button.setBackground(Color.BLACK);
		player1Button.setFocusPainted(false);
		gamePanel.add(player1Button);
		
		player2Button.setBounds(765, 290, 160, 40);
		player2Button.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 16));
		player2Button.setVisible(true);
		player2Button.setBorderPainted(false);
		player2Button.setContentAreaFilled(false);
		player2Button.setFocusPainted(false);
		gamePanel.add(player2Button);
		
		whiteFlagButton.setBounds(590, 480, 80, 80);
		whiteFlagButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 16));
		whiteFlagButton.setVisible(true);
		whiteFlagButton.setBorderPainted(false);
		whiteFlagButton.setContentAreaFilled(false);
		whiteFlagButton.setFocusPainted(false);
		gamePanel.add(whiteFlagButton);
		
		backButton.setBounds(675, 480, 80, 80);
		backButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 16));
		backButton.setVisible(true);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		gamePanel.add(backButton);
		
		resetButton.setBounds(760, 480, 80, 80);
		resetButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 16));
		resetButton.setVisible(true);
		resetButton.setBorderPainted(false);
		resetButton.setContentAreaFilled(false);
		resetButton.setFocusPainted(false);
		gamePanel.add(resetButton);
		
		exitButton.setBounds(845, 480, 80, 80);
		exitButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 16));
		exitButton.setVisible(true);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				gamePanel.setVisible(false);
				startPanel.setVisible(true);
				getContentPane().add(startPanel);
			}
		});	
		gamePanel.add(exitButton);
		
		gamePanel.setLayout(null);
		gamePanel.setVisible(true);
		getContentPane().setVisible(true);
		getContentPane().add(gamePanel);
		
	}
	
	public void makeSetting() {
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				stoneLabel02[i][j] = new JLabel();
				stoneLabel02[i][j].setBounds(24 + 28 * i, 24 + 28 * j, 27, 27);
				stoneLabel02[i][j].setVisible(true);
				settingPanel.add(stoneLabel02[i][j]);
			}
		}
		
		boardLabel02.setBackground(new Color(0, 0, 0));
		boardLabel02.setBounds(20, 20, 540, 540);
		boardLabel02.setVisible(true);
		boardLabel02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boardLabel02.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boardLabel02.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Point point = e.getPoint();
				System.out.println(point);
				int adjX = (point.x - 3) / 28 + 1;
				int adjY = (point.y - 3) / 28 + 1;
				
				if(gameAl.isStone(adjX, adjY)) {
					System.out.println("StoneÀÌ ÀÖ½À´Ï´Ù");
				}
				else {
					gameAl.setStone(adjX, adjY, 2);
					stoneLabel02[adjX - 1][adjY - 1].setIcon(xMark);
				}
			}
		});	
		settingPanel.add(boardLabel02);

		connect6Title02.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		connect6Title02.setBounds(228, 570, 108, 31);
		settingPanel.add(connect6Title02);
		
		shapeLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16));
		shapeLabel.setBounds(600, 30, 75, 15);
		settingPanel.add(shapeLabel);
		
		defaultShapeCheckBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		defaultShapeCheckBox.setBounds(632, 60, 52, 23);
		defaultShapeCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				whiteShapeCheckBox.setSelected(false);
				jihoonShapeCheckBox.setSelected(false);
				boardLabel02.setIcon(boardImage01);
			}
		});
		settingPanel.add(defaultShapeCheckBox);
		
		whiteShapeCheckBox.setSelected(true);
		whiteShapeCheckBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		whiteShapeCheckBox.setBounds(726, 60, 67, 23);
		whiteShapeCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				defaultShapeCheckBox.setSelected(false);
				jihoonShapeCheckBox.setSelected(false);
				boardLabel02.setIcon(boardImage02);
			}
		});
		settingPanel.add(whiteShapeCheckBox);
		
		jihoonShapeCheckBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		jihoonShapeCheckBox.setBounds(828, 60, 67, 23);
		jihoonShapeCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				whiteShapeCheckBox.setSelected(false);
				defaultShapeCheckBox.setSelected(false);
				boardLabel02.setIcon(boardImage03);
			}
		});
		settingPanel.add(jihoonShapeCheckBox);
		
		colorLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16));
		colorLabel.setBounds(600, 120, 75, 15);
		settingPanel.add(colorLabel);
		
		player1Label.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		player1Label.setBounds(610, 145, 75, 15);
		settingPanel.add(player1Label);
		
		player1BlackCheckBox.setSelected(true);
		player1BlackCheckBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		player1BlackCheckBox.setBounds(632, 170, 42, 23);
		player1BlackCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				optionP1Label.setIcon(blackStone);
				player1WhiteCheckBox.setSelected(false);
				player1BlueCheckBox.setSelected(false);
				player1YellowCheckBox.setSelected(false);
			}
		});
		settingPanel.add(player1BlackCheckBox);
		
		player1WhiteCheckBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		player1WhiteCheckBox.setBounds(700, 170, 42, 23);
		player1WhiteCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				optionP1Label.setIcon(whiteStone);
				player1BlackCheckBox.setSelected(false);
				player1BlueCheckBox.setSelected(false);
				player1YellowCheckBox.setSelected(false);
			}
		});
		settingPanel.add(player1WhiteCheckBox);
		
		player1BlueCheckBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		player1BlueCheckBox.setBounds(769, 170, 42, 23);
		player1BlueCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				optionP1Label.setIcon(blueStone);
				player1WhiteCheckBox.setSelected(false);
				player1BlackCheckBox.setSelected(false);
				player1YellowCheckBox.setSelected(false);
			}
		});
		settingPanel.add(player1BlueCheckBox);
		
		player1YellowCheckBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		player1YellowCheckBox.setBounds(838, 170, 42, 23);
		player1YellowCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				optionP1Label.setIcon(yellowStone);
				player1WhiteCheckBox.setSelected(false);
				player1BlueCheckBox.setSelected(false);
				player1BlackCheckBox.setSelected(false);
			}
		});
		settingPanel.add(player1YellowCheckBox);
	
		player2Label.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		player2Label.setBounds(610, 210, 75, 15);
		settingPanel.add(player2Label);
		
		player2BlackCheckBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		player2BlackCheckBox.setBounds(632, 235, 42, 23);
		player2BlackCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				optionP2Label.setIcon(blackStone);
				player2WhiteCheckBox.setSelected(false);
				player2BlueCheckBox.setSelected(false);
				player2YellowCheckBox.setSelected(false);
			}
		});
		settingPanel.add(player2BlackCheckBox);
		
		player2WhiteCheckBox.setSelected(true);
		player2WhiteCheckBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		player2WhiteCheckBox.setBounds(700, 235, 42, 23);
		player2WhiteCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				optionP2Label.setIcon(whiteStone);
				player2BlackCheckBox.setSelected(false);
				player2BlueCheckBox.setSelected(false);
				player2YellowCheckBox.setSelected(false);
			}
		});
		settingPanel.add(player2WhiteCheckBox);
		
		player2BlueCheckBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		player2BlueCheckBox.setBounds(769, 235, 42, 23);
		player2BlueCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				optionP2Label.setIcon(blueStone);
				player2WhiteCheckBox.setSelected(false);
				player2BlackCheckBox.setSelected(false);
				player2YellowCheckBox.setSelected(false);
			}
		});
		settingPanel.add(player2BlueCheckBox);
		
		player2YellowCheckBox.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		player2YellowCheckBox.setBounds(838, 235, 42, 23);
		player2YellowCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				optionP2Label.setIcon(yellowStone);
				player2WhiteCheckBox.setSelected(false);
				player2BlueCheckBox.setSelected(false);
				player2BlackCheckBox.setSelected(false);
			}
		});
		settingPanel.add(player2YellowCheckBox);
		
		timeLimitLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16));
		timeLimitLabel.setBounds(600, 290, 95, 15);
		settingPanel.add(timeLimitLabel);
		
		timeShowLabel.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 14));
		timeShowLabel.setBounds(740, 290, 70, 15);
		settingPanel.add(timeShowLabel);
		
		timeLimitSlider.setBounds(650, 320, 200, 50);
		timeLimitSlider.setMajorTickSpacing(15);
		timeLimitSlider.setPaintTicks(true);
		timeLimitSlider.setPaintLabels(true);
		timeLimitSlider.setValue(15);
		timeLimitSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				String time = Integer.toString(timeLimitSlider.getValue()) + "s";
				timeShowLabel.setText(time);
			}
    	});
		settingPanel.add(timeLimitSlider);
		
    	
    	optionP1Label.setBounds(20, 570, 27, 27);
    	optionP1Label.setVisible(true);
    	settingPanel.add(optionP1Label);
    	
    	optionP2Label.setBounds(533, 570, 27, 27);
    	optionP2Label.setVisible(true);
    	settingPanel.add(optionP2Label);
    	
		settingConfirmButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 16));
		settingConfirmButton.setBackground(Color.PINK);
		settingConfirmButton.setBounds(700, 520, 120, 40);
		settingConfirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				settingConfirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				settingConfirmButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				settingPanel.setVisible(false);
				startPanel.setVisible(true);
				getContentPane().add(startPanel);
			}
		});	
		settingPanel.add(settingConfirmButton);
		
		settingPanel.setLayout(null);
		settingPanel.setVisible(false);
		getContentPane().setVisible(false);
		getContentPane().add(settingPanel);
	}

	public void makeStart() {
		connect6Main.setBackground(new Color(0, 0, 0));
		connect6Main.setBounds(385, 100, 190, 40);
		connect6Main.setVisible(true);
		connect6Main.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 40));
		connect6Main.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				connect6Main.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				connect6Main.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});	
		startPanel.add(connect6Main);
		
		startMainButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 25));
		startMainButton.setBackground(Color.WHITE);
		startMainButton.setBorderPainted(false);
		startMainButton.setContentAreaFilled(false);
		startMainButton.setFocusPainted(false);
		startMainButton.setForeground(Color.WHITE);
		startMainButton.setBounds(395, 270, 160, 40);
		startMainButton.setVisible(true);
		startMainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startMainButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				startMainButton.setContentAreaFilled(true);
				startMainButton.setForeground(Color.BLACK);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startMainButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				startMainButton.setContentAreaFilled(false);
				startMainButton.setForeground(Color.WHITE);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				startPanel.setVisible(false);
				gamePanel.setVisible(true);
				getContentPane().add(gamePanel);
			}
		});	
		startPanel.add(startMainButton);
		
		settingMainButton.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 25));
		settingMainButton.setBackground(Color.WHITE);
		settingMainButton.setBorderPainted(false);
		settingMainButton.setContentAreaFilled(false);
		settingMainButton.setFocusPainted(false);
		settingMainButton.setForeground(Color.WHITE);
		settingMainButton.setBounds(395, 370, 160, 40);
		settingMainButton.setVisible(true);
		settingMainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				settingMainButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				settingMainButton.setContentAreaFilled(true);
				settingMainButton.setForeground(Color.BLACK);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				settingMainButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				settingMainButton.setContentAreaFilled(false);
				settingMainButton.setForeground(Color.WHITE);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				startPanel.setVisible(false);
				settingPanel.setVisible(true);
				getContentPane().add(settingPanel);
			}
		});	
		startPanel.add(settingMainButton);
		
		blackStoneMain.setBackground(new Color(0, 0, 0));
		blackStoneMain.setBounds(295, 160, 360, 360);
		blackStoneMain.setVisible(true);
		blackStoneMain.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 40));
		startPanel.add(blackStoneMain);
		
		startPanel.setBackground(Color.WHITE);
		startPanel.setLayout(null);
		startPanel.setVisible(false);
		getContentPane().setVisible(false);
		getContentPane().add(startPanel);
	}
}
