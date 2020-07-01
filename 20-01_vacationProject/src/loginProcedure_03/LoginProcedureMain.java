package loginProcedure_03;
 
public class LoginProcedureMain {

	public static final int SCREEN_WIDTH = 480;
	public static final int SCREEN_HEIGHT = 720;
	
    public static void main(String[] args){
    	System.out.println("luvya");
    	new GUITest();
    	
    	
//    	DBConnection connection = new DBConnection();
//    	System.out.println("관리자 여부  : " + connection.isAdmin("admin", "admin"));
    	UserDAO userDAO = new UserDAO();
    	System.out.println("로그인 여부 : " + userDAO.login("gildong", "123456"));
    	System.out.println("로그인 여부 : " + userDAO.login("luvwdv", "58515"));
    	System.out.println("로그인 여부 : " + userDAO.login("luvwdv", "88815"));
    }
}

