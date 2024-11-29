package user_management;

import java.io.IOException;

import add_user.AddUserScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import update_user.UpdateUser;

public class UserScreenController {

	@FXML
	Button addUser;
	@FXML
	Button updateUser;
	@FXML
	Button searchUser;
	@FXML
	Button deleteUser;
	@FXML
	Button printUser;
	@FXML
	Button logOut;

	public void addUserButton() throws IOException {

		System.out.println("add user clicked");
		AddUserScreen adduser =	new AddUserScreen();
		adduser.show();

	}

	public void updateUserButton() throws IOException {
		System.out.println("update user clicked");
		UpdateUser updateuser = new UpdateUser();
		updateuser.show();
		

	}

}
