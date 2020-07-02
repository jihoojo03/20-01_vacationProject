package loginProcedure_03;

import java.util.ArrayList;

public class UserList {
	ArrayList<String[]> userList;
	private String[][] userArray;
	private int size;
	
	UserDAO userDAO = new UserDAO();
	
	UserList(){
		userList = userDAO.showAdmin();
		userArray = new String[userList.size()][5];
		for(int i = 0; i < userList.size(); i++) {
			String[] row = {userList.get(i)[0], userList.get(i)[1], userList.get(i)[2], userList.get(i)[3], userList.get(i)[4]};
			userArray[i] = row;
		}
		size = userList.size();
	}

	public ArrayList<String[]> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<String[]> userList) {
		this.userList = userList;
	}

	public String[][] getUserArray() {
		return userArray;
	}

	public void setUserArray(String[][] userArray) {
		this.userArray = userArray;
	}
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
	
	public void sortUserArray(String sortValue) {
		userList = userDAO.showSortAdmin(sortValue);
		userArray = new String[userList.size()][5];
		for(int i = 0; i < userList.size(); i++) {
			String[] row = {userList.get(i)[0], userList.get(i)[1], userList.get(i)[2], userList.get(i)[3], userList.get(i)[4]};
			userArray[i] = row;
		}
		size = userList.size();
	}
	
	public void updateUserArray(User user) {
		userDAO.update(user);
		userList = userDAO.showAdmin();
		userArray = new String[userList.size()][5];
		for(int i = 0; i < userList.size(); i++) {
			String[] row = {userList.get(i)[0], userList.get(i)[1], userList.get(i)[2], userList.get(i)[3], userList.get(i)[4]};
			userArray[i] = row;
		}
		size = userList.size();
	}
	
	public void deleteUserArray(String userID) {
		userDAO.delete(userID);
		userList = userDAO.showAdmin();
		userArray = new String[userList.size()][5];
		for(int i = 0; i < userList.size(); i++) {
			String[] row = {userList.get(i)[0], userList.get(i)[1], userList.get(i)[2], userList.get(i)[3], userList.get(i)[4]};
			userArray[i] = row;
		}
		size = userList.size();
	}
	
	public int joinUserArray(User user) {
		int result = userDAO.join(user);
		
		if(result == -1) {
			return -1;	// 해당 아이디가 이미 존재한다
		}
		else {
			userList = userDAO.showAdmin();
			userArray = new String[userList.size()][5];
			for(int i = 0; i < userList.size(); i++) {
				String[] row = {userList.get(i)[0], userList.get(i)[1], userList.get(i)[2], userList.get(i)[3], userList.get(i)[4]};
				userArray[i] = row;
			}
			size = userList.size();
			return 0;
		}
		

	}
}
