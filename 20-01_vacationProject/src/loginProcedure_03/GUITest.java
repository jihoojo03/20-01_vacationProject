package loginProcedure_03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class GUITest extends JFrame {
	
	UserDAO userDAO = new UserDAO();
	User user = new User();
	UserList userList = new UserList();
	
	private JPanel loginPanel = new JPanel();
	private JPanel signUpPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JPanel mainUnlogPanel = new JPanel();
	private JPanel adminPanel = new JPanel();
	private JPanel modificationPanel = new JPanel();
	private JPanel findIDPWPanel = new JPanel();
	
	private ImageIcon mainBasicImage = new ImageIcon(LoginProcedureMain.class.getResource("../images/naver.png"));
	private ImageIcon mainSmallBasicImage = new ImageIcon(LoginProcedureMain.class.getResource("../images/naver_small.png"));
	private ImageIcon jihoonBasicImage = new ImageIcon(LoginProcedureMain.class.getResource("../images/jihoon.png"));
	private ImageIcon userBasicImage = new ImageIcon(LoginProcedureMain.class.getResource("../images/user.png"));
	private ImageIcon newsBasicImage = new ImageIcon(LoginProcedureMain.class.getResource("../images/news.png"));
	
	
	private JButton mainButton = new JButton(mainBasicImage);
	private JButton mainSmallButton = new JButton(mainSmallBasicImage);
	private JButton mainSmallButton02 = new JButton(mainSmallBasicImage);
	private JButton mainSmallButton03 = new JButton(mainSmallBasicImage);
	private JButton mainSmallButton04 = new JButton(mainSmallBasicImage);
	private JButton mainSmallButton05 = new JButton(mainSmallBasicImage);
	private JButton mainSmallButton06 = new JButton(mainSmallBasicImage);
	private JButton loginButton = new JButton("로그인");
	private JButton signUpButton = new JButton("회원가입");
	private JButton joinUsButton = new JButton("가입하기");
	private JButton fixButton = new JButton("수정하기");
	private JButton pictureButton = new JButton(userBasicImage);
	private JButton userPictureButton = new JButton(userBasicImage);
	private JButton logoutButton = new JButton("LogOut");
	private JButton editButton = new JButton("Edit");
	private JButton deleteButton = new JButton("탈퇴");
	private JButton deleteButton02 = new JButton();
	private JButton userIDTableButton = new JButton("ID");
	private JButton userPWTableButton = new JButton("PW");
	private JButton userNameTableButton = new JButton("Name");
	private JButton userBirthTableButton = new JButton("Birth");
	private JButton userPhoneTableButton = new JButton("Phone");
	private JButton deleteTableButton = new JButton("삭제하기");
	private JButton fixTableButton = new JButton("수정하기");
	private JButton mainLoginButton = new JButton("NAVER Login");
	private JButton mainJoinButton = new JButton("회원가입");
	private JButton mainFindButton = new JButton("아이디 비번 찾기");
	private JButton findPWButton = new JButton("비밀번호 찾기");
	private JButton findIDButton = new JButton("아이디 찾기");
	private JButton newsButton = new JButton(newsBasicImage);
	private JButton newsButton02 = new JButton(newsBasicImage);
	
	private JCheckBox chckbxNewCheckBox = new JCheckBox(" 아이디 저장");
	
	private JTextField idField = new JTextField("   아이디");
	private JTextField passwordField = new JTextField("    비밀번호");
	private JTextField idTextField;
	private JTextField pwTextField;
	private JTextField pwConfirmTextField;
	private JTextField nameTextField;
	private JTextField yearTextField;
	private JTextField dayTextField;
	private JTextField phoneTextField;
	
	private JTextField idTextField02;
	private JTextField pwTextField02;
	private JTextField pwConfirmTextField02;
	private JTextField nameTextField02;
	private JTextField yearTextField02;
	private JTextField dayTextField02;
	private JTextField phoneTextField02;
	
	private JLabel idBox = new JLabel("아이디");
	private JLabel pwBox = new JLabel("비밀번호");
	private JLabel pwConfirmBox = new JLabel("비밀번호 확인");
	private JLabel nameBox = new JLabel("이름");
	private JLabel birthBox = new JLabel("생년월일");
	private JLabel phoneBox = new JLabel("전화번호");
	private JLabel loginNameBox = new JLabel("User Name");
	private JLabel loginEmailBox = new JLabel("email@naver.com");
	
	private JLabel idBox02 = new JLabel("아이디");
	private JLabel pwBox02 = new JLabel("비밀번호");
	private JLabel pwConfirmBox02 = new JLabel("비밀번호 확인");
	private JLabel nameBox02 = new JLabel("이름");
	private JLabel birthBox02 = new JLabel("생년월일");
	private JLabel phoneBox02 = new JLabel("전화번호");
	private JLabel findPWLabel = new JLabel("비밀번호 찾기");
	private JLabel findIDLabel = new JLabel("아이디 찾기");
	private JLabel rejectIDLabel = new JLabel("입력 값이 올바르지 않습니다");
	private JLabel rejectPWLabel = new JLabel("영문과 숫자를 혼용하십시오");
	private JLabel rejectPWOkLabel = new JLabel("비밀번호가 일치하지 않습니다");
	private JLabel rejectBirthLabel = new JLabel("형식이 올바르지 않습니다");
	private JLabel rejectPhoneLabel = new JLabel("형식이 올바르지 않습니다");
	private JLabel rejectNameLabel = new JLabel("입력값이 존재하지 않습니다");
	
	JSeparator separator = new JSeparator();
	JSeparator separator_1 = new JSeparator();
	JSeparator separator_2 = new JSeparator();
	JSeparator separator_3 = new JSeparator();
	
	private String month[] = {"선택", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	private JComboBox<String> monthBox = new JComboBox<String>(month);
	private JComboBox<String> monthBox02 = new JComboBox<String>(month);

	DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
	
	private String header[] = {"userID", "userPW", "userName", "userBirth", "userPhone"};
	
	private String currentUser = "ssu";
	private boolean isIDStore = false;
	private boolean isAdmin = false;
	
	JTable userTable = new JTable(userList.getUserArray(), header);
	private JTextField findIDNameField;
	private JTextField findIDPhoneField;
	private JSeparator separator_4 = new JSeparator();
	
	private JTextField findPWIDField = new JTextField();

	
	GUITest() {

		getContentPane().setBackground(new Color(245, 245, 245));
		setTitle("Login Procedure Program");
		setSize(LoginProcedureMain.SCREEN_WIDTH, LoginProcedureMain.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		makeLoginMain();
		makeMain();
		makeAdmin();		
		makeModification();
		makeFindIDPW();
		makeSignUp();
		makeUnLoginMain();
	}
	
	public void makeMain(){
		mainButton.setBounds(80, 80, 320, 160);
		mainButton.setBorderPainted(false);
		mainButton.setContentAreaFilled(false);
		mainButton.setFocusPainted(false);
		mainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mainButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mainButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				loginPanel.setVisible(false);
				mainUnlogPanel.setVisible(true);
				getContentPane().add(mainUnlogPanel);
			}
		});
		loginPanel.setLayout(null);
		loginPanel.add(mainButton);
		
		idField.setForeground(new Color(192, 192, 192));
		idField.setBounds(80, 260, 320, 60);
		idField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		idField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				idField.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				idField.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				idField.setText("");
				idField.setForeground(Color.BLACK);
				idField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
			}
		});
		loginPanel.add(idField);
		
		passwordField.setForeground(new Color(192, 192, 192));
		passwordField.setBounds(80, 340, 320, 60);
		passwordField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				passwordField.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				passwordField.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				passwordField.setText("");
				passwordField.setForeground(Color.BLACK);
				passwordField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
			}
		});
		loginPanel.add(passwordField);
		
		signUpButton.setBounds(250, 465, 150, 50);
		signUpButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		signUpButton.setForeground(Color.BLACK);
		signUpButton.setFocusPainted(false);
		signUpButton.setBackground(Color.WHITE);
		signUpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				signUpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				loginPanel.setVisible(false);
				signUpPanel.setVisible(true);
				getContentPane().add(signUpPanel);
			}
		});
		loginPanel.add(signUpButton);
		
		loginButton.setBounds(80, 465, 150, 50);
		loginButton.setFocusPainted(false);
		loginButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		loginButton.setBackground(new Color(51, 255, 153));
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(userDAO.login(idField.getText(), passwordField.getText()) == 1) {
					System.out.println("로그인 성공입니다.");
					currentUser = idField.getText();
					System.out.println(currentUser);
					loginPanel.setVisible(false);
					mainPanel.setVisible(true);
					getContentPane().add(mainPanel);
					
					User cUser = new User(currentUser);
					loginNameBox.setText(cUser.getUserName() + "님");
					loginEmailBox.setText(currentUser + "@naver.com");
					idTextField02.setText(cUser.getUserID());
					pwTextField02.setText(cUser.getUserPassword());
					pwConfirmTextField02.setText(cUser.getUserPassword());
					nameTextField02.setText(cUser.getUserName());
					yearTextField02.setText(cUser.getSplitYear());
					monthBox02.setSelectedIndex(cUser.getSplitMonth());
					dayTextField02.setText(cUser.getSplitDay());
					phoneTextField02.setText(cUser.getUserPhone());
					pictureButton.setIcon(userBasicImage);
					userPictureButton.setIcon(userBasicImage);
				}
				else if(userDAO.login(idField.getText(), passwordField.getText()) == 0) {
					System.out.println("비밀번호가 틀렸습니다.");
					JFrame jf = new JFrame();
					JLabel jl = new JLabel("비번이 틀렸어요");
					jf.setSize(320,160);
					jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
					jl.setHorizontalAlignment(JLabel.CENTER);
					jl.setVerticalAlignment(JLabel.CENTER);
					jf.getContentPane().add(jl);
					jl.setVisible(true);
					jf.setVisible(true);
					jf.setLocationRelativeTo(null);
				}
				else if(userDAO.login(idField.getText(), passwordField.getText()) == -1) {
					System.out.println("아이디가 없습니다.");
					JFrame jf = new JFrame();
					JLabel jl = new JLabel("아이디가 없어요");
					jf.setSize(320,160);
					jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
					jl.setHorizontalAlignment(JLabel.CENTER);
					jl.setVerticalAlignment(JLabel.CENTER);
					jf.getContentPane().add(jl);
					jl.setVisible(true);
					jf.setVisible(true);
					jf.setLocationRelativeTo(null);
				}
				else if(userDAO.login(idField.getText(), passwordField.getText()) == 2) {
					System.out.println("관리자 로그인 성공");
					isAdmin = true;
					currentUser = "admin";
					userList.getUserList();
					loginPanel.setVisible(false);
					adminPanel.setVisible(true);
					getContentPane().add(adminPanel);
					
					User cUser = new User(currentUser);
					loginNameBox.setText(cUser.getUserName() + "님");
					loginEmailBox.setText(currentUser + "@naver.com");
					idTextField02.setText(cUser.getUserID());
					pwTextField02.setText(cUser.getUserPassword());
					pwConfirmTextField02.setText(cUser.getUserPassword());
					nameTextField02.setText(cUser.getUserName());
					yearTextField02.setText(cUser.getSplitYear());
					monthBox02.setSelectedIndex(cUser.getSplitMonth());
					dayTextField02.setText(cUser.getSplitDay());
					phoneTextField02.setText(cUser.getUserPhone());
					pictureButton.setIcon(jihoonBasicImage);
					userPictureButton.setIcon(jihoonBasicImage);
				}
				
			}
		});
		loginPanel.add(loginButton);
		
		chckbxNewCheckBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		chckbxNewCheckBox.setBackground(new Color(245, 245, 245));
		chckbxNewCheckBox.setBounds(80, 406, 157, 47);
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				chckbxNewCheckBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				chckbxNewCheckBox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				isIDStore = (!isIDStore);
				System.out.println(isIDStore);
			}
		});
		loginPanel.add(chckbxNewCheckBox);

		getContentPane().setVisible(false);
		loginPanel.setVisible(false);
		getContentPane().add(loginPanel);

	}
	
	public void makeSignUp() {
		rejectIDLabel.setVisible(false);
		rejectPWLabel.setVisible(false);
		rejectPWOkLabel.setVisible(false); 
		rejectBirthLabel.setVisible(false);
		rejectPhoneLabel.setVisible(false);
		rejectNameLabel.setVisible(false);
		
		mainSmallButton.setBounds(80, 20, 320, 80);
		mainSmallButton.setBorderPainted(false);
		mainSmallButton.setContentAreaFilled(false);
		mainSmallButton.setFocusPainted(false);
		mainSmallButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mainSmallButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mainSmallButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				mainUnlogPanel.setVisible(true);
				signUpPanel.setVisible(false);
				getContentPane().add(mainUnlogPanel);
			}
		});
		signUpPanel.setLayout(null);
		signUpPanel.add(mainSmallButton);
		
		
		idBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		idBox.setBounds(80, 120, 47, 15);
		signUpPanel.add(idBox);
		
		idTextField = new JTextField();
		idTextField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		idTextField.setBounds(80, 140, 320, 40);
		idTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				idTextField.setBackground(new Color(245, 245, 245));
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(idTextField.getText().equals("")) {
					idTextField.setBackground(new Color(242, 121, 121));
					rejectIDLabel.setText("입력값이 아무것도 없습니다");
					rejectIDLabel.setVisible(true);
				}
				else if(userDAO.haveID(idTextField.getText()) == 1) {
					idTextField.setBackground(new Color(242, 121, 121));
					rejectIDLabel.setText("이미 등록된 아이디입니다");
					rejectIDLabel.setVisible(true);
				}
				else if (userDAO.haveID(idTextField.getText()) == 0) {
					idTextField.setBackground(new Color(192, 255, 192));
					rejectIDLabel.setVisible(false);
				}
			}
		});
		signUpPanel.add(idTextField);
		idTextField.setColumns(10);
		
		pwTextField = new JTextField();
		pwTextField.setForeground(Color.LIGHT_GRAY);
		pwTextField.setBackground(Color.WHITE);
		pwTextField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		pwTextField.setText("  영문 / 숫자 혼합");
		pwTextField.setBounds(80, 215, 320, 40);
		pwTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				pwTextField.setBackground(new Color(245, 245, 245));
				pwTextField.setForeground(Color.BLACK);
				pwTextField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(pwTextField.getText().equals("")) {
					pwTextField.setBackground(new Color(242, 121, 121));
					rejectPWLabel.setText("입력값이 아무것도 없습니다");
					rejectPWLabel.setVisible(true);
				}
				else {
					String pw = pwTextField.getText();
					int numCount = 0, charCount = 0;
					for(int i = 0 ; i < pw.length(); i++) {
						if(Character.isDigit(pw.charAt(i))) numCount++;
						else if(Character.isLetter(pw.charAt(i))) charCount++;
					}
					if(numCount != 0 && charCount != 0) {
						pwTextField.setBackground(new Color(192, 255, 192));
						rejectPWLabel.setVisible(false);
					}
					else {
						pwTextField.setBackground(new Color(242, 121, 121));
						rejectPWLabel.setText("영문과 숫자를 혼용하십시오");
						rejectPWLabel.setVisible(true);
					}
				}
			}
		});
		signUpPanel.add(pwTextField);
		pwTextField.setColumns(10);
		
		
		pwBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		pwBox.setBounds(80, 195, 75, 15);
		signUpPanel.add(pwBox);
		
		
		pwConfirmBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		pwConfirmBox.setBounds(80, 270, 115, 15);
		signUpPanel.add(pwConfirmBox);
		
		pwConfirmTextField = new JTextField();
		pwConfirmTextField.setBounds(80, 290, 320, 40);
		pwConfirmTextField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		pwConfirmTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				pwConfirmTextField.setBackground(new Color(245, 245, 245));
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(pwConfirmTextField.getText().equals("")) {
					pwConfirmTextField.setBackground(new Color(242, 121, 121));
					rejectPWOkLabel.setText("입력값이 아무것도 없습니다");
					rejectPWOkLabel.setVisible(true);
				}
				else if(pwConfirmTextField.getText().equals(pwTextField.getText())) {
					pwConfirmTextField.setBackground(new Color(192, 255, 192));
					rejectPWOkLabel.setVisible(false);
				}
				else {
					pwConfirmTextField.setBackground(new Color(242, 121, 121));
					rejectPWOkLabel.setText("비밀번호가 일치하지 않습니다");
					rejectPWOkLabel.setVisible(true);
				}
			}
		});
		signUpPanel.add(pwConfirmTextField);
		pwConfirmTextField.setColumns(10);
		
		
		nameBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		nameBox.setBounds(80, 360, 57, 15);
		signUpPanel.add(nameBox);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(80, 380, 320, 40);
		nameTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				nameTextField.setBackground(new Color(245, 245, 245));
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(nameTextField.getText().equals("")) {
					nameTextField.setBackground(new Color(242, 121, 121));
					rejectNameLabel.setText("입력값이 아무것도 없습니다");
					rejectNameLabel.setVisible(true);
				}
				else {
					nameTextField.setBackground(new Color(192, 255, 192));
					rejectNameLabel.setVisible(false);
				}
			}
		});
		signUpPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		
		birthBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		birthBox.setBounds(80, 435, 75, 15);
		signUpPanel.add(birthBox);
		
		yearTextField = new JTextField();
		yearTextField.setForeground(Color.LIGHT_GRAY);
		yearTextField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		yearTextField.setText("  XXXX");
		yearTextField.setBounds(80, 455, 100, 40);
		yearTextField.setColumns(10);
		yearTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				yearTextField.setBackground(new Color(245, 245, 245));
				yearTextField.setForeground(Color.BLACK);
				yearTextField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(yearTextField.getText().equals("")) {
					yearTextField.setBackground(new Color(242, 121, 121));
					rejectBirthLabel.setText("입력값이 아무것도 없습니다");
					rejectBirthLabel.setVisible(true);
				}
				else {
					if(Integer.parseInt(yearTextField.getText()) <= 1900 || Integer.parseInt(yearTextField.getText()) > 2020) {
						rejectBirthLabel.setText("형식이 올바르지 않습니다");
						rejectBirthLabel.setVisible(true);
						yearTextField.setBackground(new Color(242, 121, 121));
					}
					else {
						yearTextField.setBackground(new Color(192, 255, 192));
					}
				}
			}
		});
		signUpPanel.add(yearTextField);
		
		monthBox.setBounds(190, 455, 100, 40);
		signUpPanel.add(monthBox);
		
		dayTextField = new JTextField();
		dayTextField.setForeground(Color.LIGHT_GRAY);
		dayTextField.setText("  XX");
		dayTextField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		dayTextField.setBounds(300, 455, 100, 40);
		dayTextField.setColumns(10);
		dayTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				dayTextField.setBackground(new Color(245, 245, 245));
				dayTextField.setForeground(Color.BLACK);
				dayTextField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(dayTextField.getText().equals("")) {
					dayTextField.setBackground(new Color(242, 121, 121));
					rejectBirthLabel.setText("입력값이 아무것도 없습니다");
					rejectBirthLabel.setVisible(true);
				}
				else {
					if(Integer.parseInt(dayTextField.getText()) < 0 || Integer.parseInt(dayTextField.getText()) > 31) {
						rejectBirthLabel.setText("형식이 올바르지 않습니다");
						dayTextField.setBackground(new Color(242, 121, 121));
						rejectBirthLabel.setVisible(true);
					}
					else {
						dayTextField.setBackground(new Color(192, 255, 192));
						if((Integer.parseInt(yearTextField.getText()) > 1900 || Integer.parseInt(yearTextField.getText()) < 2020) && !(monthBox.getSelectedItem().toString().equals("선택")) && (Integer.parseInt(dayTextField.getText()) >= 0 || Integer.parseInt(dayTextField.getText()) <= 31)) {
							rejectBirthLabel.setVisible(false);
							dayTextField.setBackground(new Color(192, 255, 192));
						}
							
					}
				}
			}
		});
		signUpPanel.add(dayTextField);
		
		
		
		phoneBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		phoneBox.setBounds(80, 510, 57, 15);
		signUpPanel.add(phoneBox);
		
		phoneTextField = new JTextField();
		phoneTextField.setForeground(Color.LIGHT_GRAY);
		phoneTextField.setText("  010-XXXX-XXXX");
		phoneTextField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		phoneTextField.setBounds(80, 530, 320, 40);
		phoneTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				phoneTextField.setBackground(new Color(245, 245, 245));
				phoneTextField.setForeground(Color.BLACK);
				phoneTextField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(phoneTextField.getText().equals("")) {
					phoneTextField.setBackground(new Color(242, 121, 121));
					rejectPhoneLabel.setText("입력값이 아무것도 없습니다");
					rejectPhoneLabel.setVisible(true);
				}
				else {
					if(phoneTextField.getText().length() == 13) {
						String[] cPhone = phoneTextField.getText().split("-");
						String cFront = cPhone[0];
						String cMid = cPhone[1];
						String cBack = cPhone[2];
						if(cFront.equals("010") && cMid.length() == 4 && cBack.length() == 4) {
							phoneTextField.setBackground(new Color(192, 255, 192));
							rejectPhoneLabel.setVisible(false);
						}
						else {
							rejectBirthLabel.setText("형식이 올바르지 않습니다");
							phoneTextField.setBackground(new Color(242, 121, 121));
							rejectPhoneLabel.setVisible(true);
						}
					}
					else {
						rejectPhoneLabel.setText("형식이 올바르지 않습니다");
						phoneTextField.setBackground(new Color(242, 121, 121));
						rejectPhoneLabel.setVisible(true);
					}
					
				}
			}
		});
		signUpPanel.add(phoneTextField);
		phoneTextField.setColumns(10);
		
		joinUsButton.setBackground(new Color(102, 255, 102));
		joinUsButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		joinUsButton.setBounds(80, 600, 320, 50);
		joinUsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				joinUsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				joinUsButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(idTextField.getText().equals("") || pwTextField.getText().equals("") || pwConfirmTextField.getText().equals("") || nameTextField.getText().equals("") || yearTextField.getText().equals("") || dayTextField.getText().equals("") || monthBox.getSelectedItem().toString().equals("선택") || phoneTextField.getText().equals("")) {
					JFrame jf = new JFrame();
					JLabel jl = new JLabel("정보가 미흡합니다");
					jf.setSize(320,160);
					jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
					jl.setHorizontalAlignment(JLabel.CENTER);
					jl.setVerticalAlignment(JLabel.CENTER);
					jf.getContentPane().add(jl);
					jl.setVisible(true);
					jf.setVisible(true);
					jf.setLocationRelativeTo(null);
				}
				else if((!rejectIDLabel.isVisible()) && (!rejectPWLabel.isVisible()) && (!rejectPWOkLabel.isVisible()) && (!rejectBirthLabel.isVisible()) && (!rejectPhoneLabel.isVisible()) && (!rejectNameLabel.isVisible())){
					user.setUserID(idTextField.getText());
					user.setUserPassword(pwTextField.getText());
					user.setUserName(nameTextField.getText());
					String birth = yearTextField.getText() + "/" + monthBox.getSelectedItem().toString() + "/" + dayTextField.getText();
					user.setUserBirth(birth);
					System.out.println(birth);
					user.setUserPhone(phoneTextField.getText());
					
					int result = userList.joinUserArray(user);
					if(result == -1) {
						System.out.println("해당 아이디가 존재합니다!");
					}
					else if(result == 0){
						currentUser = user.getUserID();
						JFrame jf = new JFrame();
						JLabel jl = new JLabel("회원가입을 축하합니다!");
						jf.setSize(320,160);
						jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
						jl.setHorizontalAlignment(JLabel.CENTER);
						jl.setVerticalAlignment(JLabel.CENTER);
						jf.getContentPane().add(jl);
						jl.setVisible(true);
						jf.setVisible(true);
						jf.setLocationRelativeTo(null);
						
						mainPanel.setVisible(true);
						signUpPanel.setVisible(false);
						getContentPane().add(mainPanel);
						
						User cUser = new User(currentUser);
						loginNameBox.setText(cUser.getUserName() + "님");
						loginEmailBox.setText(currentUser + "@naver.com");
						idTextField02.setText(cUser.getUserID());
						pwTextField02.setText(cUser.getUserPassword());
						pwConfirmTextField02.setText(cUser.getUserPassword());
						nameTextField02.setText(cUser.getUserName());
						yearTextField02.setText(cUser.getSplitYear());
						monthBox02.setSelectedIndex(cUser.getSplitMonth());
						dayTextField02.setText(cUser.getSplitDay());
						phoneTextField02.setText(cUser.getUserPhone());
						pictureButton.setIcon(userBasicImage);
						userPictureButton.setIcon(userBasicImage);
						
					}
				}
				else {
					JFrame jf = new JFrame();
					JLabel jl = new JLabel("올바르지 못한 정보가 있습니다");
					jf.setSize(320,160);
					jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
					jl.setHorizontalAlignment(JLabel.CENTER);
					jl.setVerticalAlignment(JLabel.CENTER);
					jf.getContentPane().add(jl);
					jl.setVisible(true);
					jf.setVisible(true);
					jf.setLocationRelativeTo(null);
				}
				System.out.println(idTextField.getText());
				System.out.println("회원가입 완료");
			}
		});
		signUpPanel.add(joinUsButton);
		
		
		
		
		rejectIDLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		rejectIDLabel.setForeground(new Color(250, 128, 114));
		rejectIDLabel.setBounds(244, 119, 156, 15);
		signUpPanel.add(rejectIDLabel);
		
		
		rejectPWLabel.setForeground(new Color(250, 128, 114));
		rejectPWLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		rejectPWLabel.setBounds(244, 194, 156, 15);
		signUpPanel.add(rejectPWLabel);
		
		
		rejectPWOkLabel.setForeground(new Color(250, 128, 114));
		rejectPWOkLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		rejectPWOkLabel.setBackground(new Color(250, 128, 114));
		rejectPWOkLabel.setBounds(232, 269, 168, 15);
		signUpPanel.add(rejectPWOkLabel);
		
		
		rejectBirthLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		rejectBirthLabel.setForeground(new Color(250, 128, 114));
		rejectBirthLabel.setBounds(244, 435, 156, 15);
		signUpPanel.add(rejectBirthLabel);
		
		
		rejectPhoneLabel.setForeground(new Color(250, 128, 114));
		rejectPhoneLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		rejectPhoneLabel.setBackground(new Color(250, 128, 114));
		rejectPhoneLabel.setBounds(244, 509, 156, 15);
		signUpPanel.add(rejectPhoneLabel);
		rejectNameLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		rejectNameLabel.setForeground(new Color(250, 128, 114));
		rejectNameLabel.setBounds(244, 359, 156, 15);
		
		signUpPanel.setVisible(false);
		getContentPane().add(signUpPanel);
		signUpPanel.add(rejectNameLabel);
		getContentPane().setVisible(false);

	}
	
	public void makeLoginMain() {
		mainSmallButton02.setBounds(80, 20, 320, 80);
		mainSmallButton02.setBorderPainted(false);
		mainSmallButton02.setContentAreaFilled(false);
		mainSmallButton02.setFocusPainted(false);
		mainSmallButton02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mainSmallButton02.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mainSmallButton02.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		mainPanel.setLayout(null);
		mainPanel.add(mainSmallButton02);
		
		mainPanel.setVisible(true);
		getContentPane().add(mainPanel);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		pictureButton.setBounds(60, 140, 90, 90);
		mainPanel.add(pictureButton);
		
		User cUser = new User(currentUser);
		loginNameBox.setText(cUser.getUserName() + "님");
		loginNameBox.setFont(new Font("나눔바른고딕", Font.BOLD, 18));
		loginNameBox.setBounds(170, 150, 100, 35);
		mainPanel.add(loginNameBox);
		
		loginEmailBox.setText(currentUser + "@naver.com");
		loginEmailBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		loginEmailBox.setBounds(170, 195, 150, 22);
		mainPanel.add(loginEmailBox);
		
		logoutButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		logoutButton.setBounds(330, 194, 90, 25);
		logoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				logoutButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				mainPanel.setVisible(false);
				mainUnlogPanel.setVisible(true);
				if(isIDStore) idField.setText(currentUser);
				else {
					idField.setText("  아이디");
					idField.setForeground(new Color(192, 192, 192));
				}
				passwordField.setText("  비밀번호");
				passwordField.setForeground(new Color(192, 192, 192));
				currentUser = null;
				isAdmin = false;
				getContentPane().add(mainUnlogPanel);
			}
		});
		mainPanel.add(logoutButton);
		
		separator.setBounds(50, 240, 382, 2);
		mainPanel.add(separator);
		
		editButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		editButton.setBounds(330, 156, 90, 25);
		editButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				editButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(isAdmin) {
					mainPanel.setVisible(false);
					adminPanel.setVisible(true);
					getContentPane().add(adminPanel);
				}
				else {
					mainPanel.setVisible(false);
					modificationPanel.setVisible(true);
					getContentPane().add(modificationPanel);
				}
			}
		});
		mainPanel.add(editButton);
		
		separator_1.setBounds(50, 128, 382, 2);
		mainPanel.add(separator_1);
		
		newsButton02.setBounds(50, 254, 380, 410);
		newsButton02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newsButton02.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				newsButton02.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		
		mainUnlogPanel.add(newsButton02);
		
		getContentPane().setVisible(false);
		mainPanel.setVisible(false);
		getContentPane().add(mainPanel);
	}
	
	public void makeUnLoginMain() {
		mainSmallButton03.setBounds(80, 20, 320, 80);
		mainSmallButton03.setBorderPainted(false);
		mainSmallButton03.setContentAreaFilled(false);
		mainSmallButton03.setFocusPainted(false);
		mainSmallButton03.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mainSmallButton03.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mainSmallButton03.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				idField.setText("  아이디");
				passwordField.setText("  비밀번호");
			}
		});
		mainUnlogPanel.setLayout(null);
		mainUnlogPanel.add(mainSmallButton03);
		
		separator_2.setBounds(50, 240, 380, 2);
		mainUnlogPanel.add(separator_2);
		
		separator_3.setBounds(50, 128, 380, 2);
		mainUnlogPanel.add(separator_3);
		
		mainLoginButton.setBackground(new Color(102, 255, 102));
		mainLoginButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		mainLoginButton.setBounds(60, 140, 360, 50);
		mainLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mainLoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mainLoginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				mainUnlogPanel.setVisible(false);
				loginPanel.setVisible(true);
				getContentPane().add(loginPanel);
			}
		});
		mainUnlogPanel.add(mainLoginButton);
		
		mainJoinButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		mainJoinButton.setBounds(330, 200, 90, 30);
		mainJoinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mainJoinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mainJoinButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				signUpPanel.setVisible(true);
				mainUnlogPanel.setVisible(false);
				getContentPane().add(signUpPanel);
			}
		});
		mainUnlogPanel.add(mainJoinButton);
		
		mainFindButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		mainFindButton.setBounds(60, 200, 150, 30);
		mainFindButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mainFindButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mainFindButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				findIDPWPanel.setVisible(true);
				mainUnlogPanel.setVisible(false);
				getContentPane().add(findIDPWPanel);
			}
		});
		
		mainUnlogPanel.add(mainFindButton);
		
		
		newsButton.setBounds(50, 254, 380, 410);
		newsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				newsButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		
		mainUnlogPanel.add(newsButton);
		
		getContentPane().setVisible(true);
		mainUnlogPanel.setVisible(true);
		getContentPane().add(mainUnlogPanel);
	}
	
	public void makeAdmin() {
		
		mainSmallButton04.setBounds(80, 20, 320, 80);
		mainSmallButton04.setBorderPainted(false);
		mainSmallButton04.setContentAreaFilled(false);
		mainSmallButton04.setFocusPainted(false);
		mainSmallButton04.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mainSmallButton04.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mainSmallButton04.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				adminPanel.setVisible(false);
				mainPanel.setVisible(true);
				
				getContentPane().add(mainPanel);
			}
		});
		adminPanel.setLayout(null);
		adminPanel.add(mainSmallButton04);

		userTable.setRowHeight(30);
		userTable.setBounds(30, 150, 420, 400);
		adminPanel.setLayout(null);
		adminPanel.add(userTable);
		
		
		userIDTableButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		userIDTableButton.setBounds(30, 110, 75, 40);
		userIDTableButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				userIDTableButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				userIDTableButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				userList.sortUserArray("userID");
				adminPanel.remove(userTable);
				userTable = new JTable(userList.getUserArray(), header);
				
				userTable.setRowHeight(30);
				userTable.setBounds(30, 150, 420, 400);
				userTable.setVisible(true);
				adminPanel.setLayout(null);
				adminPanel.add(userTable);
				adminPanel.setVisible(true);
				
				userTable.getColumn("userID").setCellRenderer(celAlignCenter);
				userTable.getColumn("userID").setPreferredWidth(50);
				userTable.getColumn("userPW").setCellRenderer(celAlignCenter);
				userTable.getColumn("userPW").setPreferredWidth(60);
				userTable.getColumn("userName").setCellRenderer(celAlignCenter);
				userTable.getColumn("userName").setPreferredWidth(50);
				userTable.getColumn("userBirth").setCellRenderer(celAlignCenter);
				userTable.getColumn("userBirth").setPreferredWidth(60);
				userTable.getColumn("userPhone").setCellRenderer(celAlignCenter);
			}
		});
		
		userPWTableButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		userPWTableButton.setBounds(105, 110, 85, 40);
		userPWTableButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				userPWTableButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				userPWTableButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				userList.sortUserArray("userPassword");
				adminPanel.remove(userTable);
				userTable = new JTable(userList.getUserArray(), header);
				
				userTable.setRowHeight(30);
				userTable.setBounds(30, 150, 420, 400);
				userTable.setVisible(true);
				adminPanel.setLayout(null);
				adminPanel.add(userTable);
				adminPanel.setVisible(true);
				
				userTable.getColumn("userID").setCellRenderer(celAlignCenter);
				userTable.getColumn("userID").setPreferredWidth(50);
				userTable.getColumn("userPW").setCellRenderer(celAlignCenter);
				userTable.getColumn("userPW").setPreferredWidth(60);
				userTable.getColumn("userName").setCellRenderer(celAlignCenter);
				userTable.getColumn("userName").setPreferredWidth(50);
				userTable.getColumn("userBirth").setCellRenderer(celAlignCenter);
				userTable.getColumn("userBirth").setPreferredWidth(60);
				userTable.getColumn("userPhone").setCellRenderer(celAlignCenter);
			}
		});
		
		userNameTableButton.setFont(new Font("나눔바른고딕", Font.BOLD, 14));
		userNameTableButton.setBounds(190, 110, 75, 40);
		userNameTableButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				userNameTableButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				userNameTableButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				userList.sortUserArray("userName");
				adminPanel.remove(userTable);
				userTable = new JTable(userList.getUserArray(), header);
				
				userTable.setRowHeight(30);
				userTable.setBounds(30, 150, 420, 400);
				userTable.setVisible(true);
				adminPanel.setLayout(null);
				adminPanel.add(userTable);
				adminPanel.setVisible(true);
				
				userTable.getColumn("userID").setCellRenderer(celAlignCenter);
				userTable.getColumn("userID").setPreferredWidth(50);
				userTable.getColumn("userPW").setCellRenderer(celAlignCenter);
				userTable.getColumn("userPW").setPreferredWidth(60);
				userTable.getColumn("userName").setCellRenderer(celAlignCenter);
				userTable.getColumn("userName").setPreferredWidth(50);
				userTable.getColumn("userBirth").setCellRenderer(celAlignCenter);
				userTable.getColumn("userBirth").setPreferredWidth(60);
				userTable.getColumn("userPhone").setCellRenderer(celAlignCenter);
			}
		});
		
		
		userBirthTableButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		userBirthTableButton.setBounds(265, 110, 85, 40);
		userBirthTableButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				userBirthTableButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				userBirthTableButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				userList.sortUserArray("userBirth");
				adminPanel.remove(userTable);
				userTable = new JTable(userList.getUserArray(), header);
				
				userTable.setRowHeight(30);
				userTable.setBounds(30, 150, 420, 400);
				userTable.setVisible(true);
				adminPanel.setLayout(null);
				adminPanel.add(userTable);
				adminPanel.setVisible(true);
				
				userTable.getColumn("userID").setCellRenderer(celAlignCenter);
				userTable.getColumn("userID").setPreferredWidth(50);
				userTable.getColumn("userPW").setCellRenderer(celAlignCenter);
				userTable.getColumn("userPW").setPreferredWidth(60);
				userTable.getColumn("userName").setCellRenderer(celAlignCenter);
				userTable.getColumn("userName").setPreferredWidth(50);
				userTable.getColumn("userBirth").setCellRenderer(celAlignCenter);
				userTable.getColumn("userBirth").setPreferredWidth(60);
				userTable.getColumn("userPhone").setCellRenderer(celAlignCenter);
			}
		});
		
		userPhoneTableButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		userPhoneTableButton.setBounds(350, 110, 100, 40);
		userPhoneTableButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				userPhoneTableButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				userPhoneTableButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				userList.sortUserArray("userPhone");
				adminPanel.remove(userTable);
				userTable = new JTable(userList.getUserArray(), header);
				
				userTable.setRowHeight(30);
				userTable.setBounds(30, 150, 420, 400);
				userTable.setVisible(true);
				adminPanel.setLayout(null);
				adminPanel.add(userTable);
				adminPanel.setVisible(true);
				
				userTable.getColumn("userID").setCellRenderer(celAlignCenter);
				userTable.getColumn("userID").setPreferredWidth(50);
				userTable.getColumn("userPW").setCellRenderer(celAlignCenter);
				userTable.getColumn("userPW").setPreferredWidth(60);
				userTable.getColumn("userName").setCellRenderer(celAlignCenter);
				userTable.getColumn("userName").setPreferredWidth(50);
				userTable.getColumn("userBirth").setCellRenderer(celAlignCenter);
				userTable.getColumn("userBirth").setPreferredWidth(60);
				userTable.getColumn("userPhone").setCellRenderer(celAlignCenter);
			}
		});

		
		adminPanel.add(userNameTableButton);
		adminPanel.add(userIDTableButton);
		adminPanel.add(userPWTableButton);
		adminPanel.add(userBirthTableButton);
		adminPanel.add(userPhoneTableButton);
		
		fixTableButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		fixTableButton.setBounds(30, 591, 195, 53);
		fixTableButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				fixTableButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				fixTableButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				User fixUser = new User();
				for(int i = 0; i < userList.getUserList().size(); i++) {
					fixUser.setUserID((String)userTable.getModel().getValueAt(i, 0));
					fixUser.setUserPassword((String)userTable.getModel().getValueAt(i, 1));
					fixUser.setUserName((String)userTable.getModel().getValueAt(i, 2));
					fixUser.setUserBirth((String)userTable.getModel().getValueAt(i, 3));
					fixUser.setUserPhone((String)userTable.getModel().getValueAt(i, 4));
					userList.updateUserArray(fixUser);
				}
				adminPanel.remove(userTable);
				JTable userTable = new JTable(userList.getUserArray(), header);
				
				userTable.setRowHeight(30);
				userTable.setBounds(30, 150, 420, 400);
				userTable.setVisible(true);
				adminPanel.setLayout(null);
				adminPanel.add(userTable);
				adminPanel.setVisible(true);
				
				userTable.getColumn("userID").setCellRenderer(celAlignCenter);
				userTable.getColumn("userID").setPreferredWidth(50);
				userTable.getColumn("userPW").setCellRenderer(celAlignCenter);
				userTable.getColumn("userPW").setPreferredWidth(60);
				userTable.getColumn("userName").setCellRenderer(celAlignCenter);
				userTable.getColumn("userName").setPreferredWidth(50);
				userTable.getColumn("userBirth").setCellRenderer(celAlignCenter);
				userTable.getColumn("userBirth").setPreferredWidth(60);
				userTable.getColumn("userPhone").setCellRenderer(celAlignCenter);

			}
		});
		adminPanel.add(fixTableButton);
		

		deleteTableButton.setBackground(new Color(255, 99, 71));
		deleteTableButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		deleteTableButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				deleteTableButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				deleteTableButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				userList.deleteUserArray((String)userTable.getModel().getValueAt(userTable.getSelectedRow(), 0));
				adminPanel.remove(userTable);
				userTable = new JTable(userList.getUserArray(), header);
				
				userTable.setRowHeight(30);
				userTable.setBounds(30, 150, 420, 400);
				userTable.setVisible(true);
				adminPanel.setLayout(null);
				adminPanel.add(userTable);
				adminPanel.setVisible(true);
				
				userTable.getColumn("userID").setCellRenderer(celAlignCenter);
				userTable.getColumn("userID").setPreferredWidth(50);
				userTable.getColumn("userPW").setCellRenderer(celAlignCenter);
				userTable.getColumn("userPW").setPreferredWidth(60);
				userTable.getColumn("userName").setCellRenderer(celAlignCenter);
				userTable.getColumn("userName").setPreferredWidth(50);
				userTable.getColumn("userBirth").setCellRenderer(celAlignCenter);
				userTable.getColumn("userBirth").setPreferredWidth(60);
				userTable.getColumn("userPhone").setCellRenderer(celAlignCenter);
				
			}
		});
		deleteTableButton.setBounds(255, 591, 195, 53);
		adminPanel.add(deleteTableButton);
		
		
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		userTable.getColumn("userID").setCellRenderer(celAlignCenter);
		userTable.getColumn("userID").setPreferredWidth(50);
		userTable.getColumn("userPW").setCellRenderer(celAlignCenter);
		userTable.getColumn("userPW").setPreferredWidth(60);
		userTable.getColumn("userName").setCellRenderer(celAlignCenter);
		userTable.getColumn("userName").setPreferredWidth(50);
		userTable.getColumn("userBirth").setCellRenderer(celAlignCenter);
		userTable.getColumn("userBirth").setPreferredWidth(60);
		userTable.getColumn("userPhone").setCellRenderer(celAlignCenter);

		userTable.setBounds(30, 150, 420, 400);
		userTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				userTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				userTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		adminPanel.setLayout(null);
		adminPanel.add(userTable);
		

		adminPanel.setVisible(false);
		getContentPane().add(adminPanel);
		getContentPane().setVisible(false);
	}
	
	public void makeModification() {

		mainSmallButton05.setBounds(80, 20, 320, 80);
		mainSmallButton05.setBorderPainted(false);
		mainSmallButton05.setContentAreaFilled(false);
		mainSmallButton05.setFocusPainted(false);
		mainSmallButton05.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mainSmallButton05.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mainSmallButton05.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				modificationPanel.setVisible(false);
				mainPanel.setVisible(true);
				getContentPane().add(mainPanel);

			}
		});
		modificationPanel.setLayout(null);
		modificationPanel.add(mainSmallButton05);

		
		idBox02.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		idBox02.setBounds(80, 120, 47, 15);
		modificationPanel.add(idBox02);
		
		idTextField02 = new JTextField();
		idTextField02.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		idTextField02.setBounds(80, 140, 215, 40);
		modificationPanel.add(idTextField02);
		idTextField02.setColumns(10);
		
		pwTextField02 = new JTextField();
		pwTextField02.setBounds(80, 215, 320, 40);
		modificationPanel.add(pwTextField02);
		pwTextField02.setColumns(10);
		
		pwBox02.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		pwBox02.setBounds(80, 195, 75, 15);
		modificationPanel.add(pwBox02);
		
		pwConfirmBox02.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		pwConfirmBox02.setBounds(80, 270, 115, 15);
		modificationPanel.add(pwConfirmBox02);
		
		pwConfirmTextField02 = new JTextField();
		pwConfirmTextField02.setBounds(80, 290, 320, 40);
		modificationPanel.add(pwConfirmTextField02);
		pwConfirmTextField02.setColumns(10);
		
		
		nameBox02.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		nameBox02.setBounds(80, 360, 57, 15);
		modificationPanel.add(nameBox02);
		
		nameTextField02 = new JTextField();
		nameTextField02.setBounds(80, 380, 320, 40);
		modificationPanel.add(nameTextField02);
		nameTextField02.setColumns(10);
		
		
		birthBox02.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		birthBox02.setBounds(80, 435, 75, 15);
		modificationPanel.add(birthBox02);
		
		yearTextField02 = new JTextField();
		yearTextField02.setBounds(80, 455, 100, 40);
		yearTextField02.setColumns(10);
		modificationPanel.add(yearTextField02);
		
		monthBox02.setBounds(190, 455, 100, 40);
		modificationPanel.add(monthBox02);
		
		dayTextField02 = new JTextField();
		dayTextField02.setBounds(300, 455, 100, 40);
		dayTextField02.setColumns(10);
		modificationPanel.add(dayTextField02);
		
		
		phoneBox02.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		phoneBox02.setBounds(80, 510, 57, 15);
		modificationPanel.add(phoneBox02);
		
		phoneTextField02 = new JTextField();
		phoneTextField02.setBounds(80, 530, 320, 40);
		modificationPanel.add(phoneTextField02);
		phoneTextField02.setColumns(10);
		
		deleteButton.setBackground(Color.RED);
		deleteButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		deleteButton.setBounds(330, 600, 70, 50);
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				deleteButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				deleteButton.setVisible(false);
				deleteButton02.setVisible(true);
			}
		});
		modificationPanel.add(deleteButton);
		
		deleteButton02.setBackground(Color.RED);
		deleteButton02.setBounds(0, 0, 10, 10);
		deleteButton02.setVisible(false);
		deleteButton02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				deleteButton02.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				deleteButton02.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				userList.deleteUserArray(currentUser);
				userList = new UserList();
				currentUser = null;
				
				adminPanel.remove(userTable);
				userTable = new JTable(userList.getUserArray(), header);
				
				userTable.setRowHeight(30);
				userTable.setBounds(30, 150, 420, 400);
				adminPanel.setLayout(null);
				adminPanel.add(userTable);
				
				userTable.getColumn("userID").setCellRenderer(celAlignCenter);
				userTable.getColumn("userID").setPreferredWidth(50);
				userTable.getColumn("userPW").setCellRenderer(celAlignCenter);
				userTable.getColumn("userPW").setPreferredWidth(60);
				userTable.getColumn("userName").setCellRenderer(celAlignCenter);
				userTable.getColumn("userName").setPreferredWidth(50);
				userTable.getColumn("userBirth").setCellRenderer(celAlignCenter);
				userTable.getColumn("userBirth").setPreferredWidth(60);
				userTable.getColumn("userPhone").setCellRenderer(celAlignCenter);
				
				JFrame jf = new JFrame();
				JLabel jl = new JLabel("계정 삭제 완료");
				jf.setSize(320,160);
				jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
				jl.setHorizontalAlignment(JLabel.CENTER);
				jl.setVerticalAlignment(JLabel.CENTER);
				jf.getContentPane().add(jl);
				jl.setVisible(true);
				jf.setVisible(true);
				jf.setLocationRelativeTo(null);
				
				idField.setText("  아이디");
				idField.setForeground(new Color(192, 192, 192));
				passwordField.setText("  비밀번호");
				passwordField.setForeground(new Color(192, 192, 192));
				
				modificationPanel.setVisible(false);
				mainUnlogPanel.setVisible(true);
				getContentPane().add(mainUnlogPanel);
			}
		});
		modificationPanel.add(deleteButton02);
		
		fixButton.setBackground(new Color(102, 255, 102));
		fixButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		fixButton.setBounds(80, 600, 240, 50);
		fixButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				fixButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				fixButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(idTextField02.getText().equals("") || pwTextField02.getText().equals("") || pwConfirmTextField02.getText().equals("") || nameTextField02.getText().equals("") || yearTextField02.getText().equals("") || dayTextField02.getText().equals("") || monthBox02.getSelectedItem().toString().equals("선택") || phoneTextField02.getText().equals("")) {
					System.out.println("잘못됐어용");
				}
				else {
					user.setUserID(idTextField02.getText());
					user.setUserPassword(pwTextField02.getText());
					user.setUserName(nameTextField02.getText());
					String birth = yearTextField02.getText() + "/" + monthBox02.getSelectedItem().toString() + "/" + dayTextField02.getText();
					user.setUserBirth(birth);
					user.setUserPhone(phoneTextField02.getText());
					
					userList.updateUserArray(user);
					adminPanel.remove(userTable);
					userTable = new JTable(userList.getUserArray(), header);
					
					userTable.setRowHeight(30);
					userTable.setBounds(30, 150, 420, 400);
					adminPanel.setLayout(null);
					adminPanel.add(userTable);
					
					userTable.getColumn("userID").setCellRenderer(celAlignCenter);
					userTable.getColumn("userID").setPreferredWidth(50);
					userTable.getColumn("userPW").setCellRenderer(celAlignCenter);
					userTable.getColumn("userPW").setPreferredWidth(60);
					userTable.getColumn("userName").setCellRenderer(celAlignCenter);
					userTable.getColumn("userName").setPreferredWidth(50);
					userTable.getColumn("userBirth").setCellRenderer(celAlignCenter);
					userTable.getColumn("userBirth").setPreferredWidth(60);
					userTable.getColumn("userPhone").setCellRenderer(celAlignCenter);
					
					JFrame jf = new JFrame();
					JLabel jl = new JLabel("수정이 완료되었습니다");
					jf.setSize(320,160);
					jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
					jl.setHorizontalAlignment(JLabel.CENTER);
					jl.setVerticalAlignment(JLabel.CENTER);
					jf.getContentPane().add(jl);
					jl.setVisible(true);
					jf.setVisible(true);
					jf.setLocationRelativeTo(null);
					
				}
				System.out.println(idTextField02.getText());
				System.out.println("수정 완료");
			}
		});
		modificationPanel.add(fixButton);

		User cUser = new User(currentUser);
		
		idTextField02.setText(cUser.getUserID());
		pwTextField02.setText(cUser.getUserPassword());
		pwConfirmTextField02.setText(cUser.getUserPassword());
		nameTextField02.setText(cUser.getUserName());
		yearTextField02.setText(cUser.getSplitYear());
		monthBox02.setSelectedIndex(cUser.getSplitMonth());
		dayTextField02.setText(cUser.getSplitDay());
		phoneTextField02.setText(cUser.getUserPhone());
		
		userPictureButton.setBounds(310, 110, 90, 90);
		modificationPanel.add(userPictureButton);
		
		modificationPanel.setVisible(false);
		getContentPane().add(modificationPanel);
		getContentPane().setVisible(false);

	}

	public void makeFindIDPW() {
		mainSmallButton06.setBounds(80, 20, 320, 80);
		mainSmallButton06.setBorderPainted(false);
		mainSmallButton06.setContentAreaFilled(false);
		mainSmallButton06.setFocusPainted(false);
		mainSmallButton06.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mainSmallButton06.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mainSmallButton06.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				findIDPWPanel.setVisible(false);
				mainUnlogPanel.setVisible(true);
				getContentPane().add(mainUnlogPanel);
			}
		});
		findIDPWPanel.setLayout(null);
		findIDPWPanel.add(mainSmallButton06);
		findIDPWPanel.setLayout(null);
		
		
		findIDLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		findIDLabel.setBounds(80, 170, 80, 15);
		findIDPWPanel.add(findIDLabel);
		
		findIDNameField = new JTextField();
		findIDNameField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		findIDNameField.setText("  \uC774\uB984");
		findIDNameField.setBounds(80, 195, 320, 50);
		findIDNameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				findIDNameField.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				findIDNameField.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				findIDNameField.setText("");
			}
		});
		findIDPWPanel.add(findIDNameField);
		findIDNameField.setColumns(10);
		
		findIDPhoneField = new JTextField();
		findIDPhoneField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		findIDPhoneField.setText("  \uD734\uB300\uC804\uD654");
		findIDPhoneField.setBounds(80, 255, 320, 50);
		findIDPhoneField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				findIDPhoneField.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				findIDPhoneField.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				findIDPhoneField.setText("");
			}
		});
		findIDPWPanel.add(findIDPhoneField);
		findIDPhoneField.setColumns(10);
		
		findIDButton.setBackground(new Color(102, 255, 102));
		findIDButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		findIDButton.setBounds(280, 315, 120, 50);
		findIDButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				findIDButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				findIDButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(findIDPhoneField.getText().equals("") || findIDNameField.getText().equals("")) {
					JFrame jf = new JFrame();
					JLabel jl = new JLabel("정보가 미흡합니다");
					jf.setSize(320,160);
					jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
					jl.setHorizontalAlignment(JLabel.CENTER);
					jl.setVerticalAlignment(JLabel.CENTER);
					jf.getContentPane().add(jl);
					jl.setVisible(true);
					jf.setVisible(true);
					jf.setLocationRelativeTo(null);
				}
				else if(userDAO.findID(findIDNameField.getText(), findIDPhoneField.getText()).equals("NoID")) {
					JFrame jf = new JFrame();
					JLabel jl = new JLabel("일치하는 정보가 없습니다");
					jf.setSize(320,160);
					jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
					jl.setHorizontalAlignment(JLabel.CENTER);
					jl.setVerticalAlignment(JLabel.CENTER);
					jf.getContentPane().add(jl);
					jl.setVisible(true);
					jf.setVisible(true);
					jf.setLocationRelativeTo(null);
				}
				else {
					String inform = "당신의 아이디는 " + userDAO.findID(findIDNameField.getText(), findIDPhoneField.getText()) + "입니다";
					JFrame jf = new JFrame();
					JLabel jl = new JLabel(inform);
					jf.setSize(320,160);
					jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
					jl.setHorizontalAlignment(JLabel.CENTER);
					jl.setVerticalAlignment(JLabel.CENTER);
					jf.getContentPane().add(jl);
					jl.setVisible(true);
					jf.setVisible(true);
					jf.setLocationRelativeTo(null);
				}
			}
		});
		findIDButton.setLayout(null);
		findIDPWPanel.add(findIDButton);
		separator_4.setBounds(80, 390, 320, 2);
		
		findIDPWPanel.add(separator_4);
		findPWLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		findPWLabel.setBounds(80, 415, 80, 15);
		
		findPWIDField.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		findPWIDField.setText("  \uC544\uC774\uB514");
		findPWIDField.setBounds(80, 440, 320, 50);
		findPWIDField.setColumns(10);
		findPWIDField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				findPWIDField.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				findPWIDField.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				findPWIDField.setText("");
				
			}
		});
		
		findIDPWPanel.add(findPWLabel);
		
		findIDPWPanel.add(findPWIDField);
		findPWButton.setBackground(new Color(102, 255, 102));
		findPWButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		findPWButton.setBounds(280, 500, 120, 50);
		findPWButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				findPWButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				findPWButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(findPWIDField.getText().equals("")) {
					JFrame jf = new JFrame();
					JLabel jl = new JLabel("정보가 미흡합니다");
					jf.setSize(320,160);
					jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
					jl.setHorizontalAlignment(JLabel.CENTER);
					jl.setVerticalAlignment(JLabel.CENTER);
					jf.getContentPane().add(jl);
					jl.setVisible(true);
					jf.setVisible(true);
					jf.setLocationRelativeTo(null);
				}
				else if(userDAO.findPassword(findPWIDField.getText()).equals("NoPW")) {
					JFrame jf = new JFrame();
					JLabel jl = new JLabel("일치하는 정보가 없습니다");
					jf.setSize(320,160);
					jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
					jl.setHorizontalAlignment(JLabel.CENTER);
					jl.setVerticalAlignment(JLabel.CENTER);
					jf.getContentPane().add(jl);
					jl.setVisible(true);
					jf.setVisible(true);
					jf.setLocationRelativeTo(null);
				}
				else {
					String inform = "당신의 비밀번호는 " + userDAO.findPassword(findPWIDField.getText()) + "입니다";
					JFrame jf = new JFrame();
					JLabel jl = new JLabel(inform);
					jf.setSize(320,160);
					jl.setFont(new Font("나눔바른고딕", Font.PLAIN, 16));
					jl.setHorizontalAlignment(JLabel.CENTER);
					jl.setVerticalAlignment(JLabel.CENTER);
					jf.getContentPane().add(jl);
					jl.setVisible(true);
					jf.setVisible(true);
					jf.setLocationRelativeTo(null);
				}
			}
		});
		
		findIDPWPanel.add(findPWButton);
		
		findIDPWPanel.setVisible(false);
		getContentPane().add(findIDPWPanel);
		getContentPane().setVisible(false);
	}
}
