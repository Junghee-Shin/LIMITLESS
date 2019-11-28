package com.limitless.recipedetailinfo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SearchRecipe2_1FXAppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("SearchRecipe2_2FX.fxml"));
		
		Scene scene = new Scene(root);
		//외부 css로딩
		scene.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
		primaryStage.setTitle("Event");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		

	}

	public static void main(String[] args) {
		launch(args);

	}

}
