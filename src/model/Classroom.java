package model;

import java.util.ArrayList;

public class Classroom {

	private ArrayList<UserAccount> userList;

	public Classroom() {
		userList = new ArrayList<>();
	}
	
	public void createUser() {
		
	}

	public ArrayList<UserAccount> getUserList() {
		return userList;
	}
	
}
