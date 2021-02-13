package model;

import javafx.scene.image.Image;

public class UserAccount {
	
	private String username;
	private String passwrod;
	private String genre;
	private String favBrowser;
	private String birthday;
	private String[] career;
	public Image picture;

	public UserAccount(String username, String password, String genre, Image picture, String favBrowser, String birthday, String[] career) {
		this.username = username;
		this.passwrod = password;
		this.genre = genre;
		this.favBrowser = favBrowser;
		this.birthday = birthday;
		this.career = career;
		this.picture = picture;
	}

	public Image getPicture() {
		return picture;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getFavBrowser() {
		return favBrowser;
	}

	public void setFavBrowser(String favBrowser) {
		this.favBrowser = favBrowser;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCareer() {
		String careerString = "";
		careerString = getBDToString();
		return careerString;
	}

	private String getBDToString() {
		String CL = "";
		if(career[0]!=null) {
			CL+=career[0];
		}
		if(career[1]!=null) {
			CL+=", " + career[1];
		}
		if(career[2]!=null) {
			CL+=", " + career[2];
		}
		return CL;
		
	}

	public void setCareer(String[] career) {
		this.career = career;
	}
	
}
