package ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
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
	private TextField txtUserNameReg;

	@FXML
    private TextField txtPasswordReg;
	
	@FXML
    private ChoiceBox<String> prefB;
	
	@FXML
	private TextField urlPic;
	
	@FXML
    private Button btnFileC;
	
	@FXML
	private RadioButton rbMale;

	@FXML
	private RadioButton rbFemale;

	@FXML
	private RadioButton rbOther;
	
	@FXML
	private CheckBox cbSE;

	@FXML
	private CheckBox cbTE;

	@FXML
	private CheckBox cbIE;
	
	@FXML
    private DatePicker txtBDay;
	
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
		principalPane.getChildren().setAll(showAccountPane);
		
		validateLogin(txtUsernameLogin.getText(), txtPasswordLogin.getText());
	 }

	 @FXML
	 public void loadRegisterW(ActionEvent event) throws IOException {
		 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		fxmlLoader.setController(this); 	
			
		Parent showRegisterPane = fxmlLoader.load();
		principalPane.getChildren().clear();
		principalPane.getChildren().setAll(showRegisterPane);
		
		prefB.getItems().addAll("Chrome","FireFox","Explorer");
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
		 }else {		 
			 canCreateUser = checkUserIsNotRepeated(nameTxt);
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
	    		
	    	}
	 }
	 
	 @FXML
	 public void validateInfo(ActionEvent event) throws IOException {
		 
		 boolean validInformaion=true;
		 
		 String userName = txtUserNameReg.getText();
		 String password = txtPasswordReg.getText();
		 String url = urlPic.getText();	
		 String prefBrow = prefB.getValue();
		 String genreOption = "";
		 String dateBday= txtBDay.toString();
		 String[] careers = new String[3];
		 
		 if(rbMale.isSelected()) {
			 genreOption = "Male";
		 } else if(rbFemale.isSelected()) {
			 genreOption = "Female";
		 }else if(rbOther.isSelected()) {
			 genreOption = "Other";
		 }
		 		
		 //checkBox
		 if(cbIE.isSelected()) {
			 careers[0]="Industrial Engineering";
		 }
		 if(cbSE.isSelected()) {
			 careers[1]="Software Engineering";
		 }
		 if(cbTE.isSelected()) {
			 careers[2]="Telematic Engineering";
		 }
		 
		 //validation
		 if(userName.equals("") || password.equals("") || url.equals("") || prefBrow.equals("") || genreOption.equals("") 
				 || dateBday.equals("") || careers[0]==null && careers[1]==null && careers[2]==null) {
			 validInformaion=false;
			 
		 }
		 
		 if(validInformaion) {
			 boolean repeated = checkUserIsNotRepeated(userName);
			 if(!repeated) {
				 //user is created
				 classroom.createUser(userName, password, genreOption, url, prefBrow, dateBday, careers);
				 loadLoginW(null);
			 }else {
				 Alert alert = new Alert(AlertType.WARNING);
				 alert.setTitle("Register Error");
				 alert.setHeaderText("Register Error");
				 alert.setContentText("This username is taken");

				 alert.showAndWait();
			 }
		 }else {
			 Alert alert = new Alert(AlertType.WARNING);
			 alert.setTitle("Register Error");
			 alert.setHeaderText("Register Error");
			 alert.setContentText("There are empty fields. Please check them");

			 alert.showAndWait();
		 }
		 
	 }//end validateInfo
	 
	 public boolean checkUserIsNotRepeated(String nameTxt) {
		 boolean found=false;
		 if(!(classroom.getUserList().size()==0) && !found) {
				for (int i = 0; i < classroom.getUserList().size(); i++) {
					if(nameTxt.equals(classroom.getUserList().get(i).getUsername())) {
						found = true;
						System.out.println("ERROR LOGIN");
					}
				}
		}
		 return found;
	 }//end checkUserIsNotRepeated
}
