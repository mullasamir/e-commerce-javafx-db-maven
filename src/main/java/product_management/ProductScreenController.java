package product_management;

import java.io.IOException;

import add_product.AddProduct;
import home.HomeScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import update_product.UpdateProduct;

public class ProductScreenController {

	@FXML
	Button addProduct;
	@FXML
	Button updateProduct;
	@FXML
	Button searchProduct;
	@FXML
	Button deleteProduct;
	@FXML
	Button printProduct;
	@FXML
	Button logOut;

	public void addProductButton() throws IOException {

		System.out.println("add user clicked");
		AddProduct addproduct = new AddProduct();
		addproduct.show();
	}

	public void updateProductButton() throws IOException {
		System.out.println("update user clicked");
		UpdateProduct updateproduct = new UpdateProduct();
		updateproduct.show();

	}

	public void logoutButton() throws IOException {
		System.out.println("logoutButton clicked");
		new HomeScreen().show();

	}

}
