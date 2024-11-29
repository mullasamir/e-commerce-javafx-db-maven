package home;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import product_management.ProductScreen;
import user_management.UserScreen;

public class HomeScreenController {

	@FXML
	Button productManagementButton;
	@FXML
	Button userManagementButton;
	@FXML
	Button logOut;

	public void userManagementButton() throws IOException {

		System.out.println("userManagementButton clicked");
		UserScreen user = new UserScreen();
		user.show();
		

	}

	public void productManagementButton() throws IOException {
		System.out.println("productManagementButton clicked");
		ProductScreen product = new ProductScreen();
		product.show();

	}

	public void logoutButton() {

	}

}
