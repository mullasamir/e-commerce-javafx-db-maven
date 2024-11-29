package update_product;

import java.sql.SQLException;


import common.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class ProductUpdateController {

	
	@FXML
	TextField ProductIdToUpdate;
	
	@FXML
	TextField new_prod_id;
	
	@FXML
	TextField new_pname;
	
	@FXML
	TextField new_pqty;
	
	@FXML
	TextField new_pprc;
	
	@FXML
	Button UpdateProduct;
	
//	@FXML
//	Button CancleProduct;
	
	@FXML
	Label updateMsg;

	
	public void updateProductButton() {
		String ProductIdField=ProductIdToUpdate.getText();
		String UpdatedProductIdField=new_prod_id.getText();
		String UpdatedProductNameField=new_pname.getText();
		String UpdatedProductQuantityField=new_pqty.getText();
		String UpdatedProductPriceField=new_pprc.getText();
		
		if (ProductIdField.isEmpty() || UpdatedProductIdField.isEmpty() || UpdatedProductNameField.isEmpty() || UpdatedProductQuantityField.isEmpty() || UpdatedProductPriceField.isEmpty()) {
            updateMsg.setText("Please fill in all fields.");
            updateMsg.setTextFill(Color.RED);
            return;
        }
		
		if (updateProductInDb(Integer.parseInt(ProductIdField), Integer.parseInt(UpdatedProductIdField), UpdatedProductNameField, Integer.parseInt(UpdatedProductQuantityField), Integer.parseInt(UpdatedProductPriceField))) {

			updateMsg.setText("Failed to update product!!");
			updateMsg.setTextFill(Color.RED);
            clearFields();
        } else {

        	updateMsg.setText("Product updated successfully!!");
            updateMsg.setTextFill(Color.GREEN);
            clearFields();
        }
	}
	
	private void clearFields() {
        ProductIdToUpdate.clear();
        new_prod_id.clear();
        new_pname.clear();
        new_pqty.clear();
        new_pprc.clear();
    }
	
//	public void cancelButtonClick() throws IOException {
//		new UserManagement().show();
//     }

	
	public boolean updateProductInDb(int productId, int updatedProductId, String updatedProductName, int updatedProductQuantity, int updatedProductPrice) {
        String query = "UPDATE product SET product_id = '" + updatedProductId + "', product_name = '" + updatedProductName + "', product_qty = '" + updatedProductQuantity + "', product_prc = '" + updatedProductPrice + "' WHERE product_id = '" + productId + "'";

        boolean isUpdated = false;
        try {
            isUpdated = DbUtils.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }
}
