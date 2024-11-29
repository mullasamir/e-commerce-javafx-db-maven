package ecommerce;

import java.io.IOException;


import common.CommonStage;
import javafx.application.Application;
import javafx.stage.Stage;
import login.LoginScreen;

public class EcommerceMain extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	
	public void start(Stage stageCreatedByJavaFx) throws IOException {
		CommonStage.stage=stageCreatedByJavaFx;
		CommonStage.stage.setTitle("E-commerce Application");
		new LoginScreen().show();
	}

	
}
