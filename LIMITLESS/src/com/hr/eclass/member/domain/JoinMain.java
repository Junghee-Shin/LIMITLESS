package com.hr.eclass.member.domain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JoinMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		Parent root = FXMLLoader.load(getClass().getResource("joinFX.fxml"));
		//외부 css로딩
		root.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
		
		Scene scene = new Scene(root);
		
				
		primaryStage.setTitle("자취 세끼");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {

		launch(args);
		
	}

}
