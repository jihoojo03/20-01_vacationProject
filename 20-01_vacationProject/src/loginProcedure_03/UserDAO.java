package loginProcedure_03;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String dbURL = "jdbc:mariadb://localhost:3306/db";
			String dbID = "jihoon";
			String dbPassword = "00000008";
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					if(userID.equals("admin")) return 2;	// 관리자 로그인 성공
					return 1; // 로그인 성공
				}
				else
					return 0; // 비밀번호 불일치
			}
			return -1;	// ID 없음
		}catch(Exception e){
			e.printStackTrace();
		}
		return -2; // DB 오류
	}
	
	public int join(User user) {
		String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserBirth());
			pstmt.setString(5, user.getUserPhone());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;		// DB 오류
	}
	
	public ArrayList<String[]> showAdmin() {
		ArrayList<String[]> userList = new ArrayList<String[]>();
		String SQL = "SELECT * FROM USER";
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(SQL);
			
			while(rs.next()) {
				String user[] = new String[5];
				user[0] = rs.getString("userID");
				user[1] = rs.getString("userPassword");
				user[2] = rs.getString("userName");
				user[3] = rs.getString("userBirth");
				user[4] = rs.getString("userPhone");
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public ArrayList<String[]> showSortAdmin(String sortValue) {
		ArrayList<String[]> userList = new ArrayList<String[]>();
		String SQL = "SELECT * FROM USER ORDER BY " + sortValue;
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(SQL);
			
			while(rs.next()) {
				String user[] = new String[5];
				user[0] = rs.getString("userID");
				user[1] = rs.getString("userPassword");
				user[2] = rs.getString("userName");
				user[3] = rs.getString("userBirth");
				user[4] = rs.getString("userPhone");
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public int update(User user) {
		String SQL = "UPDATE USER SET userPassword = ?, userName = ?, userBirth = ?, userPhone = ? WHERE userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserPassword());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserBirth());
			pstmt.setString(4, user.getUserPhone());
			pstmt.setString(5, user.getUserID());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;		// DB 오류
	}
	
	public int delete(String userID) {
		String SQL = "DELETE FROM USER WHERE userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;		// DB 오류
	}
	
}
