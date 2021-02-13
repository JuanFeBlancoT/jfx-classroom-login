package model;

public class UserAccount {
	
	private String username;
	private String passwrod;
	private String genre;
	private String urlPhoto;
	private String favBrowser;
	private String birthday;
	private String[] career;
	
	public UserAccount(String username, String password, String ganere, String urlPhoto, String favBrowser, String brithday, String[] career) {
		this.username = username;
		this.passwrod = password;
		this.genre = genre;
		this.urlPhoto = urlPhoto;
		this.favBrowser = favBrowser;
		this.birthday = birthday;
		this.career = career;
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

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
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

	public String[] getCareer() {
		return career;
	}

	public void setCareer(String[] career) {
		this.career = career;
	}
	
}
