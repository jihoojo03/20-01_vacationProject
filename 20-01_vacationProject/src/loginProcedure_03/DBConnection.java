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
                System.out.println("DB ���� ����");
            }
            
        } catch (ClassNotFoundException e) { 
            System.out.println("����̹� �ε� ����");
        } catch (SQLException e) {
            System.out.println("DB ���� ����");
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
    		System.out.println("�����ͺ��̽� �˻� ���� : " + e.getMessage());
    		
    	}
    	return false;
    }
    
}
