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
	
	public String[] find(String userID) {
		String user[] = new String[5];
		String SQL = "SELECT * FROM USER WHERE userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user[0] = rs.getString("userID");
				user[1] = rs.getString("userPassword");
				user[2] = rs.getString("userName");
				user[3] = rs.getString("userBirth");
				user[4] = rs.getString("userPhone");
				return user; // 정보 확인
			}
			user[0] = "NoId";
			return user;	// ID 없음
		}catch(Exception e){
			e.printStackTrace();
		}
		user[0] = "NoDB";
		return user; // DB 오류
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
	
	public String findID(String userName, String userPhone) {
		String SQL = "SELECT userID FROM USER WHERE userName = ? AND userPhone = ?";
			try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPhone);
			rs = pstmt.executeQuery();
			String userID = new String();
			if(rs.next()) {
				userID = rs.getString("userID");
				return userID; // 정보 확인
			}
			else{
				userID = "NoID";
				return userID;	// ID 없음
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		String userID = "DBError";
		return userID;
	}
	
	public String findPassword(String userID) {
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
			try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			String userPW = new String();
			if(rs.next()) {
				userPW = rs.getString("userPassword");
				return userPW; // 정보 확인
			}
			else{
				userPW = "NoPW";
				return userPW;	// PW 없음
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		String userPW = "DBError";
		return userPW;
	}
	
	public int haveID(String userID) {
		String SQL = "SELECT EXISTS (SELECT * FROM USER WHERE userID = ?) AS SUCCESS";
			try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("success");	// ID 있음
			}
			else{
				return 0;	// ID 없음
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1; // DB 오류
	}
	
}
