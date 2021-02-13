package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.Classroom;

public class ClassroomGUI{

	private Classroom classroom;
	
	//login atributes
	@FXML
	private TextField txtUsernameLogin;

	@FXML
	private TextField txtPasswordLogin;
	
	//others
	@FXML
	private Pane principalPane;
	 
	
	public ClassroomGUI(Classroom classroom) {
		this.classroom = classroom;
		
	}
	
	 @FXML
	 public void loadAccountW(ActionEvent event) throws IOException {
		 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
		fxmlLoader.setController(this); 	
			
		Parent showAccountPane = fxmlLoader.load();
		principalPane.getChildren().clear();
		principalPane.getChildren().setAll(showAccountPane);
	 }

	 @FXML
	 public void loadRegisterW(ActionEvent event) throws IOException {
		 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		fxmlLoader.setController(this); 	
			
		Parent showRegisterPane = fxmlLoader.load();
		principalPane.getChildren().clear();
		principalPane.getChildren().setAll(showRegisterPane);
	 }
	 
	 @FXML
	 public void loadLoginW(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		fxmlLoader.setController(this); 	
				
		Parent showLoginPane = fxmlLoader.load();
		principalPane.getChildren().clear();
		principalPane.getChildren().setAll(showLoginPane);
		
	 }
	 
	 
	 public boolean checkLogin(String nameTxt, String passwrodTxt) {
		 
		 boolean canCreateUser=true;
		 
		 if(nameTxt.equals("") || passwrodTxt.equals("")){
			 canCreateUser = false;
		 }		 
		 
		 if(!(classroom.getUserList().size()==0) && canCreateUser) {
			for (int i = 0; i < classroom.getUserList().size(); i++) {
				if(nameTxt.equals(classroom.getUserList().get(i).getUsername())) {
					canCreateUser = false;
				}
			}
		 }
		return canCreateUser;
	 }
	 
}
