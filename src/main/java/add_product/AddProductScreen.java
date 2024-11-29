package add_product;

import java.sql.SQLException;

import common.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddProductScreen {
	
	
	@FXML
	TextField pname;
	@FXML
	TextField pqty;
	@FXML
	TextField pprc;
	@FXML
	TextField prod_id;
	
	
	
	public void addProductButton() throws SQLException {
		String pid = prod_id.getText();
		String prod_name = pname.getText();
		String prod_qty = pqty.getText();
		String prod_prc = pprc.getText(); 
		
		
		String query = "insert into product(product_Id,product_name , product_qty, product_prc)values('"+pid+"','" + prod_name
				+ "', '" + prod_qty + "', '" + prod_prc + "')";
	
		
		DbUtils.executeQuery(query);
		
		System.out.println("inseted values in database");
		
	}

}
