package add_user;

import java.sql.SQLException;


import common.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddUserScreenController {
	
	@FXML
	TextField fname;
	@FXML
	TextField lname;
	@FXML
	TextField age;
	@FXML
	TextField gender;
	@FXML
	TextField email;
	@FXML
	TextField pass;
	
	
	
	
	public void addUserButton() throws SQLException {
		
		String fName = fname.getText();
		String lName = lname.getText();
		String ag = age.getText(); 
		String gen = gender.getText();
		String mail = email.getText();
		String password = pass.getText();
		
		String query = "insert into e_user(fname , lname, age, gender, email, pass)values('" + fName
				+ "', '" + lName + "', '" + ag + "', '" + gen + "', '" + mail + "', '"
				+ password + "')";
		
		DbUtils.executeQuery(query);
		
		System.out.println("inseted values in database");
		
	}
	
	

}
