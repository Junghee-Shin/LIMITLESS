 /**
 * @Class Name : RecipeSearchOkFXController.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019-05-28           최초생성
 *
 * @author 개발프레임웍크 실행환경 HR. 	LIMITLESS개발팀
 * @since 2019-05-28 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.limitless.recipedetailinfo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hr.eclass.cmn.HRConst;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * @author sist
 *
 */
public class RecipeSearchOkFXController implements Initializable {

	@FXML	Label	labelNick;
	
	@FXML	Button  firstRecipeBtn;
	@FXML	Button  secondRecipeBtn;
	@FXML	ImageView image01;
	@FXML	ImageView image02;
	@FXML	Button	homeBtn;
	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		homeBtn.setOnAction(homeEvent -> handlerHomeBtn(homeEvent));
		
		firstRecipeBtn.setOnAction(firstRecipeBtnEvent -> handlerFirstRecipeBtn(firstRecipeBtnEvent));
		secondRecipeBtn.setOnAction(secondRecipeBtnEvent -> handlerSecondRecipeBtn(secondRecipeBtnEvent));
		
		
		labelNick.setText(HRConst.session.getName());		
		
		RecipeDetailInfoVO re1;
		RecipeDetailInfoVO re2;
		RecipeDetailInfoDao recipeDetail;
		
		
		
		recipeDetail = new RecipeDetailInfoDao();
		re1 = new RecipeDetailInfoVO(HRConst.reRetmpVO01.getReNo(),"","","","","","","");
		
		
		re2 = new RecipeDetailInfoVO(HRConst.reRetmpVO02.getReNo(),"","","","","","","");
		
		RecipeDetailInfoVO outVO1 = (RecipeDetailInfoVO)	recipeDetail.do_selectOne(re1);
		RecipeDetailInfoVO outVO2 = (RecipeDetailInfoVO)	recipeDetail.do_selectOne(re2);
		
		if(outVO1.getReNo().equals(re1.getReNo())){
			firstRecipeBtn.setText(outVO1.getReName());
			
			image01.setImage
			(new Image(getClass().getResource("/com/limitless/recipedetailinfo/image/recipeimage/"+outVO1.getReImage()).toString()));
		}
		if(outVO2.getReNo().equals(re2.getReNo())){
			secondRecipeBtn.setText(outVO2.getReName());
			image02.setImage
			(new Image(getClass().getResource("/com/limitless/recipedetailinfo/image/recipeimage/"+outVO2.getReImage()).toString()));
		}
	}
	
	
	
	
	public void handlerHomeBtn(ActionEvent homeEvent) {
		
		try {
			Parent menuFx;
			menuFx = FXMLLoader.load(getClass().getResource("MenuFx.fxml"));
			//외부 css로딩
			menuFx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(menuFx);
			Stage primaryStage = (Stage)homeBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void handlerFirstRecipeBtn(ActionEvent firstRecipeBtnEvent) {
		try {
			
			HRConst.recipeDetailTmp.setReNo(HRConst.reRetmpVO01.getReNo()); 
			System.out.println("1번버튼 눌렀을 때 레시피넘버:"+HRConst.recipeDetailTmp.getReNo());
			Parent recipeDetailFx;
			recipeDetailFx = FXMLLoader.load(getClass().getResource("RecipeDetailFX.fxml"));
			//외부 css로딩
			recipeDetailFx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(recipeDetailFx);
			Stage primaryStage = (Stage)firstRecipeBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void handlerSecondRecipeBtn(ActionEvent secondRecipeBtnEvent) {
			try {
			
			HRConst.recipeDetailTmp.setReNo(HRConst.reRetmpVO02.getReNo());
			System.out.println("2번버튼 눌렀을 때 레시피넘버:"+HRConst.recipeDetailTmp.getReNo());
			Parent recipeDetailFx;
			recipeDetailFx = FXMLLoader.load(getClass().getResource("RecipeDetailFX.fxml"));
			//외부 css로딩
			recipeDetailFx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(recipeDetailFx);
			Stage primaryStage = (Stage)secondRecipeBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	

}
