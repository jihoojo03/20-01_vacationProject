package loginProcedure_03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	
	private ImageIcon mainBasicImage = new ImageIcon(LoginProcedureMain.class.getResource("../images/naver.png"));
	private ImageIcon mainSmallBasicImage = new ImageIcon(LoginProcedureMain.class.getResource("../images/naver_small.png"));
	private ImageIcon jihoonBasicImage = new ImageIcon(LoginProcedureMain.class.getResource("../images/jihoon.png"));
	private ImageIcon userBasicImage = new ImageIcon(LoginProcedureMain.class.getResource("../images/user.png"));
	
	private JButton mainButton = new JButton(mainBasicImage);
	private JButton mainSmallButton = new JButton(mainSmallBasicImage);
	private JButton mainSmallButton02 = new JButton(mainSmallBasicImage);
	private JButton mainSmallButton03 = new JButton(mainSmallBasicImage);
	private JButton mainSmallButton04 = new JButton(mainSmallBasicImage);
	private JButton mainSmallButton05 = new JButton(mainSmallBasicImage);
	private JButton loginButton = new JButton("로그인");
	private JButton signUpButton = new JButton("회원가입");
	private JButton joinUsButton = new JButton("가입하기");
	private JButton fixButton = new JButton("수정하기");
	private JButton pictureButton = new JButton(userBasicImage);
	private JButton userPictureButton = new JButton(userBasicImage);
	private JButton logoutButton = new JButton("LogOut");
	private JButton editButton = new JButton("Edit");
	private JButton userIDTableButton = new JButton("ID");
	private JButton userPWTableButton = new JButton("PW");
	private JButton userNameTableButton = new JButton("Name");
	private JButton userBirthTableButton = new JButton("Birth");
	private JButton userPhoneTableButton = new JButton("Phone");
	private JButton deleteTableButton = new JButton("삭제하기");
	private JButton fixTableButton = new JButton("수정하기");
	
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
	
	JSeparator separator = new JSeparator();
	JSeparator separator_1 = new JSeparator();
	JSeparator separator_2 = new JSeparator();
	JSeparator separator_3 = new JSeparator();
	
	private String month[] = {"선택", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	private JComboBox<String> monthBox = new JComboBox<String>(month);
	private JComboBox<String> monthBox02 = new JComboBox<String>(month);

	private String currentUser = null;
	private final JButton mainLoginButton = new JButton("NAVER Login");
	private final JButton mainJoinButton = new JButton("회원가입");
	private final JButton mainFindButton = new JButton("아이디 비번 찾기");
	private JTextField textField;

	DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
	
	private String header[] = {"userID", "userPW", "userName", "userBirth", "userPhone"};
	
	
	GUITest() {
		getContentPane().setBackground(new Color(245, 245, 245));
		setTitle("Login Procedure Program");
		setSize(LoginProcedureMain.SCREEN_WIDTH, LoginProcedureMain.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		makeUnLoginMain();
		makeSignUp();
		makeLoginMain();
		makeAdmin();
		makeModification();
		makeMain();
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
				idField.setText("  아이디");
				passwordField.setText("  비밀번호");
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
				}
				else if(userDAO.login(idField.getText(), passwordField.getText()) == 0) {
					System.out.println("비밀번호가 틀렸습니다.");
				}
				else if(userDAO.login(idField.getText(), passwordField.getText()) == -1) {
					System.out.println("아이디가 없습니다.");
				}
				else if(userDAO.login(idField.getText(), passwordField.getText()) == 2) {
					
					System.out.println("관리자 로그인 성공");
				}
				
			}
		});
		loginPanel.add(loginButton);
		
		chckbxNewCheckBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 12));
		chckbxNewCheckBox.setBackground(new Color(245, 245, 245));
		chckbxNewCheckBox.setBounds(80, 406, 157, 47);
		loginPanel.add(chckbxNewCheckBox);

		getContentPane().setVisible(true);
		loginPanel.setVisible(true);
		getContentPane().add(loginPanel);

	}
	
	public void makeSignUp() {
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
				loginPanel.setVisible(true);
				signUpPanel.setVisible(false);
				getContentPane().add(loginPanel);
			}
		});
		signUpPanel.setLayout(null);
		signUpPanel.add(mainSmallButton);
		
		
		idBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		idBox.setBounds(80, 120, 47, 15);
		signUpPanel.add(idBox);
		
		idTextField = new JTextField();
		idTextField.setBounds(80, 140, 320, 40);
		signUpPanel.add(idTextField);
		idTextField.setColumns(10);
		
		pwTextField = new JTextField();
		pwTextField.setBounds(80, 215, 320, 40);
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
		signUpPanel.add(pwConfirmTextField);
		pwConfirmTextField.setColumns(10);
		
		
		nameBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		nameBox.setBounds(80, 360, 57, 15);
		signUpPanel.add(nameBox);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(80, 380, 320, 40);
		signUpPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		
		birthBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		birthBox.setBounds(80, 435, 75, 15);
		signUpPanel.add(birthBox);
		
		yearTextField = new JTextField();
		yearTextField.setBounds(80, 455, 100, 40);
		yearTextField.setColumns(10);
		signUpPanel.add(yearTextField);
		
		monthBox.setBounds(190, 455, 100, 40);
		signUpPanel.add(monthBox);
		
		dayTextField = new JTextField();
		dayTextField.setBounds(300, 455, 100, 40);
		dayTextField.setColumns(10);
		signUpPanel.add(dayTextField);
		
		
		phoneBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		phoneBox.setBounds(80, 510, 57, 15);
		signUpPanel.add(phoneBox);
		
		phoneTextField = new JTextField();
		phoneTextField.setBounds(80, 530, 320, 40);
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
				if(idTextField.getText() == null || pwTextField.getText() == null || pwConfirmTextField.getText() == null || nameTextField.getText() == null || yearTextField.getText() == null || dayTextField.getText() == null || monthBox.getSelectedItem().toString().equals("선택") || phoneTextField.getText() == null) {
					System.out.println("잘못됐어용");
				}
				else {
					user.setUserID(idTextField.getText());
					user.setUserPassword(pwTextField.getText());
					user.setUserName(nameTextField.getText());
					String birth = yearTextField.getText() + "/" + monthBox.getSelectedItem().toString() + "/" + dayTextField.getText();
					user.setUserBirth(birth);
					System.out.println(birth);
					user.setUserPhone(phoneTextField.getText());
					
					int result = userDAO.join(user);
					if(result == 1) {
						System.out.println("해당 아이디가 존재합니다!");
					}
					else {
						currentUser = user.getUserID();
						System.out.println("회원가입을 축하합니다!");
					}
					
				}
				System.out.println(idTextField.getText());
				System.out.println("회원가입 완료");
			}
		});
		signUpPanel.add(joinUsButton);
		
		signUpPanel.setVisible(false);
		getContentPane().add(signUpPanel);
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
		
		loginNameBox.setFont(new Font("나눔바른고딕", Font.BOLD, 18));
		loginNameBox.setBounds(170, 150, 100, 35);
		mainPanel.add(loginNameBox);
		
		
		loginEmailBox.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		loginEmailBox.setBounds(170, 195, 150, 22);
		mainPanel.add(loginEmailBox);
		
		logoutButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		logoutButton.setBounds(330, 194, 90, 25);
		mainPanel.add(logoutButton);
		
		separator.setBounds(50, 240, 382, 2);
		mainPanel.add(separator);
		
		editButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		editButton.setBounds(330, 156, 90, 25);
		mainPanel.add(editButton);
		
		separator_1.setBounds(50, 128, 382, 2);
		mainPanel.add(separator_1);
		
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
				loginPanel.setVisible(true);
				mainUnlogPanel.setVisible(false);
				getContentPane().add(loginPanel);
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
		
		mainUnlogPanel.add(mainLoginButton);
		mainJoinButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		mainJoinButton.setBounds(330, 200, 90, 30);
		
		mainUnlogPanel.add(mainJoinButton);
		mainFindButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		mainFindButton.setBounds(60, 200, 150, 30);
		mainUnlogPanel.add(mainFindButton);
		
		getContentPane().setVisible(false);
		mainUnlogPanel.setVisible(false);
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
					
			}
		});
		adminPanel.setLayout(null);
		adminPanel.add(mainSmallButton04);

		JTable userTable = new JTable(userList.getUserArray(), header);
		
		userTable.setRowHeight(30);
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
		
		
		userIDTableButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		userIDTableButton.setBounds(30, 110, 75, 40);
		
		userPWTableButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		userPWTableButton.setBounds(105, 110, 85, 40);
		
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
				
			}
		});
		adminPanel.add(userNameTableButton);
		
		userBirthTableButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		userBirthTableButton.setBounds(265, 110, 85, 40);
		
		userPhoneTableButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		userPhoneTableButton.setBounds(350, 110, 100, 40);


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
				System.out.println(userTable.getSelectedRow());
				System.out.println(userTable.getModel().getValueAt(0, 3));
				User fixUser = new User();
				for(int i = 0; i < userList.getUserList().size(); i++) {
					fixUser.setUserID((String)userTable.getModel().getValueAt(i, 0));
					fixUser.setUserPassword((String)userTable.getModel().getValueAt(i, 1));
					fixUser.setUserName((String)userTable.getModel().getValueAt(i, 2));
					fixUser.setUserBirth((String)userTable.getModel().getValueAt(i, 3));
					fixUser.setUserPhone((String)userTable.getModel().getValueAt(i, 4));
					userList.updateUserArray(fixUser);
				}
				
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
//				userTable.dispose();
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

			}
		});
		modificationPanel.setLayout(null);
		modificationPanel.add(mainSmallButton05);
		
		
		idBox02.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
		idBox02.setBounds(80, 120, 47, 15);
		modificationPanel.add(idBox02);
		
		idTextField02 = new JTextField();
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
		
		fixButton.setBackground(new Color(102, 255, 102));
		fixButton.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
		fixButton.setBounds(80, 600, 320, 50);
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
				if(idTextField.getText() == null || pwTextField.getText() == null || pwConfirmTextField.getText() == null || nameTextField.getText() == null || yearTextField.getText() == null || dayTextField.getText() == null || monthBox.getSelectedItem().toString().equals("선택") || phoneTextField.getText() == null) {
					System.out.println("잘못됐어용");
				}
				else {
					user.setUserID(idTextField02.getText());
					user.setUserPassword(pwTextField02.getText());
					user.setUserName(nameTextField02.getText());
					String birth = yearTextField02.getText() + "/" + monthBox02.getSelectedItem().toString() + "/" + dayTextField02.getText();
					user.setUserBirth(birth);
					System.out.println(birth);
					user.setUserPhone(phoneTextField02.getText());
					
					int result = userDAO.join(user);
					if(result == 1) {
						System.out.println("해당 아이디가 존재합니다!");
					}
					else {
						currentUser = user.getUserID();
						System.out.println("회원가입을 축하합니다!");
					}
					
				}
				System.out.println(idTextField02.getText());
				System.out.println("회원가입 완료");
			}
		});
		modificationPanel.add(fixButton);

		
		
		
		userPictureButton.setBounds(310, 110, 90, 90);
		modificationPanel.add(userPictureButton);
		
		modificationPanel.setVisible(false);
		getContentPane().add(modificationPanel);
		getContentPane().setVisible(false);
		
	
			
		
	}
}
