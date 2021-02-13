package model;

import java.util.ArrayList;

public class Classroom {

	private ArrayList<UserAccount> userList;

	public Classroom() {
		userList = new ArrayList<>();
	}
	
	public void createUser(String username, String password, String genre, String urlPhoto, String favBrowser, String brithday, String[] career) {
		userList.add(new UserAccount(username, password, genre, urlPhoto, favBrowser, brithday, career));
	}

	public ArrayList<UserAccount> getUserList() {
		return userList;
	}
	
}
