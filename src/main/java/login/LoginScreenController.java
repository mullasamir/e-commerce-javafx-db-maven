package login;

import java.io.IOException;



import java.sql.ResultSet;
import java.sql.SQLException;

import common.*;
import home.HomeScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginScreenController{
	@FXML
	TextField uname;
	@FXML
	TextField upass;
	@FXML
	Label msg;

	public void loginButtonMsg() throws SQLException, IOException {

		String usernm = uname.getText();
		String userpass = upass.getText();

		if (loginValidate(usernm, userpass)) {

//			HomeScreen.show();
			msg.setText("Login Successfulllyyy..");
			msg.setTextFill(Color.GREEN);
			new HomeScreen().show();

		} else {
			msg.setText("Login Failed..");
			msg.setTextFill(Color.RED);
		}
		

	}

	public boolean loginValidate(String username, String userpass) throws SQLException {

		String query = "select fname , pass from e_user where fname = '" + username + "' and pass = '" + userpass + "'";
		ResultSet resultSet = DbUtils.selectQuery(query);
		return resultSet.next();
	}

}