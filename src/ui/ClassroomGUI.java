package ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.Classroom;

public class ClassroomGUI{

	private Classroom classroom;
	
	//login attributes
	@FXML
	private TextField txtUsernameLogin;

	@FXML
	private TextField txtPasswordLogin;
	
	//register attributes
	@FXML
    private ChoiceBox<String> careers;
	
	@FXML
	private TextField urlPic;
	
	@FXML
    private Button btnFileC;
	
	private ListView listView;
	
	//others
	@FXML
	private Pane principalPane;
	 
	
	public ClassroomGUI(Classroom classroom) {
		this.classroom = classroom;
		System.out.println(classroom.getUserList().size());
	}
	
	 @FXML
	 public void loadAccountW(ActionEvent event) throws IOException {
		 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
		fxmlLoader.setController(this); 	
			
		Parent showAccountPane = fxmlLoader.load();
		principalPane.getChildren().clear();
		//principalPane.getChildren().setAll(showAccountPane);
		principalPane.setClip(showAccountPane);
		
		validateLogin(txtUsernameLogin.getText(), txtPasswordLogin.getText());
	 }

	 @FXML
	 public void loadRegisterW(ActionEvent event) throws IOException {
		 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		fxmlLoader.setController(this); 	
			
		Parent showRegisterPane = fxmlLoader.load();
		principalPane.getChildren().clear();
		principalPane.getChildren().setAll(showRegisterPane);
		
		careers.getItems().addAll("Chrome","FireFox","Explorer");
	 }
	 
	 @FXML
	 public void loadLoginW(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		fxmlLoader.setController(this); 	
				
		Parent showLoginPane = fxmlLoader.load();
		principalPane.getChildren().clear();
		principalPane.getChildren().setAll(showLoginPane);
		
	 }
	 
	 
	 public boolean validateLogin(String nameTxt, String passwrodTxt) {
		 
		 boolean canCreateUser=true;
		 
		 if(nameTxt.equals("") || passwrodTxt.equals("")){
			 canCreateUser = false;
		 }		 
		 
		 if(!(classroom.getUserList().size()==0) && canCreateUser) {
			for (int i = 0; i < classroom.getUserList().size(); i++) {
				if(nameTxt.equals(classroom.getUserList().get(i).getUsername())) {
					canCreateUser = false;
					System.out.println("ERROR LOGIN");
				}
			}
		 }
		return canCreateUser;
	 }
	 
	 public void showAlerts() {
		 Alert alert = new Alert(AlertType.ERROR);
		 alert.setTitle("Login Error");
		 alert.setHeaderText("Login Error");
		 alert.setContentText("User not found! please try again");

		 alert.showAndWait();
	 }
	 

	 @FXML
	 public void selectPhoto(ActionEvent event) {
	    	FileChooser photoC = new FileChooser();
	    	File selectedFile = photoC.showOpenDialog(null);
	    	
	    	if(selectedFile != null) {
	    		urlPic.setText(selectedFile.getAbsolutePath());
	    	} else {
	    		System.out.println("WATAFAK?!");
	    	}
	    }
}
