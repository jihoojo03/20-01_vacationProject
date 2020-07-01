package loginProcedure_03;

import java.sql.*;

public class DBConnection {
    String driver = "org.mariadb.jdbc.Driver";
    Connection con;
    PreparedStatement pstmt;
    Statement st;
    ResultSet rs;
 
    
    public DBConnection() {
         try {
            Class.forName(driver);
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/db",
                    "jihoon",
                    "00000008");
            st = con.createStatement();
            
            if( con != null ) {
                System.out.println("DB 접속 성공");
            }
            
        } catch (ClassNotFoundException e) { 
            System.out.println("드라이버 로드 실패");
        } catch (SQLException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();
        }
    }
    
    public boolean isAdmin(String adminID, String adminPassword) {
    	try {
    		String SQL = "SELECT * FROM admin WHERE adminID = '" + adminID + "' and adminPassword = '" + adminPassword + "'";
    		rs = st.executeQuery(SQL);
    		if(rs.next()) return true;
    	
    	}
    	catch(Exception e) {
    		System.out.println("데이터베이스 검색 오류 : " + e.getMessage());
    		
    	}
    	return false;
    }
    
}
