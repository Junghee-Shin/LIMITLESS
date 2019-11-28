 /**
 * @Class Name : RecipebookmarkController.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019-05-24           최초생성
 *
 * @author 개발프레임웍크 실행환경 HR. 	LIMITLESS개발팀
 * @since 2019-05-24 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.limitless.recipebookmark;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.limitless.cmn.DTO;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;

/**
 * @author sist
 *
 */

public class RecipebookmarkController implements Initializable {
	@FXML Button Buttonrecipebookmark;
	@FXML ImageView starImageView;
	private Alert alert;
	private boolean Starchange=false;
	private String id;
	private String recipe;
	public List<RecipeBookmarkVO> recipeBookmar=new ArrayList<>();
	public List<RecipeBookmarkVO> list1=new ArrayList<>();
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		alert =new Alert(AlertType.INFORMATION);
		alert.setTitle("INFORMATION");
		alert.setHeaderText("즐겨찾기를 성공하셧습니다");
		

		id="윤준";
		recipe="닭볶음탕짱";
		RecipeBookmarkDao recipeBookmarkDao=new RecipeBookmarkDao();
		recipeBookmar=recipeBookmarkDao.getList();
		
		list1=recipeBookmarkDao.do_retrieve(id);
	
		Starchange= recipeBookmarkDao.do_sdf(recipe, list1);
		
		
		


		if(Starchange==true){
			starImageView.setImage(new Image(getClass().getResource("/com/limitless/recipebookmark/image/star.jpg").toString()));

		}
		else{
			starImageView.setImage(new Image(getClass().getResource("/com/limitless/recipebookmark/image/star1.png").toString()));
		
		}
		Starchange=!Starchange;		
		Buttonrecipebookmark.setOnAction(event->handlerBookMarkBtnAction(event));
	}


	public void handlerBookMarkBtnAction(ActionEvent event){

		RecipeBookmarkDao recipeBookmarkDao=new RecipeBookmarkDao();
		RecipeBookmarkVO inVO = new RecipeBookmarkVO(id,recipe);
	

		
		if(Starchange==true){
			starImageView.setImage(new Image(getClass().getResource("/com/limitless/recipebookmark/image/star.jpg").toString()));
			recipeBookmar=recipeBookmarkDao.do_sa(inVO);
			recipeBookmarkDao.saveFile();
			
			
		}
		
		else{
			
			starImageView.setImage(new Image(getClass().getResource("/com/limitless/recipebookmark/image/star1.png").toString()));
			recipeBookmar=recipeBookmarkDao.do_del(inVO);
			recipeBookmarkDao.saveFile();
			
			
			
			
		}
		Starchange=!Starchange;
		
		
		
		
		
		
	}


}
