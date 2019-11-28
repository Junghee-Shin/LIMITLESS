package com.hr.eclass.member.domain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UpdateMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("updateFX.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Event");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {

		launch(args);
		
	}

}
