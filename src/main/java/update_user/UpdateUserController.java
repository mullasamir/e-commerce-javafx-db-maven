package update_user;

import java.sql.SQLException;

import common.DbUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class UpdateUserController {

	@FXML
	TextField mailIdToUpdate;

	@FXML
	TextField new_email;

	@FXML
	TextField new_fname;

	@FXML
	TextField new_lname;

	@FXML
	TextField new_pass;

	@FXML
	TextField new_gender;

	@FXML
	TextField new_age;

	@FXML
	Label updateMsg;

	@FXML
	Button updateUser;

	public void updateUserButton() {

		String usermailField = mailIdToUpdate.getText();
		String updatedUserMailField = new_email.getText();
		String updatedUserFNameField = new_fname.getText();
		String updatedLnameField = new_lname.getText();
//        String updatedAddressField = new_address.getText();
		String updatedPasswordField = new_pass.getText();
		String updatedGenderField = new_gender.getText();
		String updatedAgeField = new_age.getText();

		if (usermailField.isEmpty() || updatedUserMailField.isEmpty() || updatedUserFNameField.isEmpty()
				|| updatedLnameField.isEmpty() || updatedPasswordField.isEmpty() || updatedGenderField.isEmpty()
				|| updatedAgeField.isEmpty()) {
			updateMsg.setText("Please fill in all fields.");
			updateMsg.setTextFill(Color.RED);
			return;
		}

		try {

			int newAge = Integer.parseInt(updatedAgeField);

			if (updateUserInDb(usermailField, updatedUserMailField, updatedUserFNameField, updatedLnameField,
					updatedGenderField, newAge, updatedPasswordField)) {
				updateMsg.setText("User updated successfully!!");
				updateMsg.setTextFill(Color.GREEN);
				clearFields();
			} else {
				updateMsg.setText("Failed to update user!!");
				updateMsg.setTextFill(Color.RED);
			}
		} catch (NumberFormatException e) {

			updateMsg.setText("Invalid age format. Please enter a number.");
			updateMsg.setTextFill(Color.RED);
		}
	}

	private void clearFields() {

		mailIdToUpdate.clear();
		new_email.clear();
		new_fname.clear();
		new_lname.clear();

		new_pass.clear();
		new_gender.clear();
		new_age.clear();
	}

	public boolean updateUserInDb(String mailIdToUpdate, String new_email, String new_fname, String new_lname,
			String new_gender, int new_age, String new_pass) {

		String query = "UPDATE e_user SET email = '" + new_email + "', fname = '" + new_fname + "', lname = '"
				+ new_lname + "', pass = '" + new_pass + "', age = " + new_age + ", gender = '" + new_gender
				+ "' WHERE email = '" + mailIdToUpdate + "'";

		boolean isUpdated = false;
		try {
			isUpdated = DbUtils.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isUpdated;
	}
}
