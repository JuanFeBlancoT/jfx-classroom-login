package model;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Classroom {

	private ArrayList<UserAccount> userList;

	public Classroom() {
		userList = new ArrayList<>();
	}
	
	public void createUser(String username, String password, String genre, Image Photo, String favBrowser, String birthday, String[] career) {
		userList.add(new UserAccount(username, password, genre, Photo, favBrowser, birthday, career));
	}

	public ArrayList<UserAccount> getUserList() {
		return userList;
	}
	
	
	
}
