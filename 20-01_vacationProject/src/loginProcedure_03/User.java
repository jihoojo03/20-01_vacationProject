package loginProcedure_03;

public class User {
	private String userID;
	private String userPassword;
	private String userName;
	private String userBirth;
	private String userPhone;
	
	UserDAO userDAO = new UserDAO();
	
	User(){
		userID = null;
		userPassword = null;
		userName = null;
		userBirth = null;
		userPhone = null;
	}
	
	User(String currentUser){
		String[] cUser = userDAO.find(currentUser);
		
		userID = cUser[0];
		userPassword = cUser[1];
		userName = cUser[2];
		userBirth = cUser[3];
		userPhone = cUser[4];
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getSplitYear() {
		String[] cBir = userBirth.split("/");
		String cYear = cBir[0];
		return cYear;
	}
	public String getSplitDay() {
		String[] cBir = userBirth.split("/");
		String cDay = cBir[2];
		return cDay;
	}
	public int getSplitMonth() {
		String[] cBir = userBirth.split("/");
		String cMonth = cBir[1];
		if(cMonth.equals("01")) return 1;
		else if(cMonth.equals("02")) return 2;
		else if(cMonth.equals("03")) return 3;
		else if(cMonth.equals("04")) return 4;
		else if(cMonth.equals("05")) return 5;
		else if(cMonth.equals("06")) return 6;
		else if(cMonth.equals("07")) return 7;
		else if(cMonth.equals("08")) return 8;
		else if(cMonth.equals("09")) return 9;
		else if(cMonth.equals("10")) return 10;
		else if(cMonth.equals("11")) return 11;
		else if(cMonth.equals("12")) return 12;
		else return 0;
	}
	
}
