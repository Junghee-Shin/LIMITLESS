 /**
 * @Class Name : RecipeDetailFXController.java
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.hr.eclass.cmn.HRConst;
import com.limitless.recipebookmark.RecipeBookmarkDao;
import com.limitless.recipebookmark.RecipeBookmarkVO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
	

/**
 * @author sist
 *
 */
public class RecipeDetailBookmarkFXController implements Initializable {
	@FXML	Button 	homeBtn;
	@FXML	Button  backBtn;
	@FXML 	Label	reName;
	@FXML 	Label	reFood;
	@FXML 	Label	reCook01;
	@FXML 	Label	reCook02;
	@FXML 	Label	reCook03;
	@FXML 	Label	reCook04;
	@FXML	ImageView reImage;
	//즐겨찾기 관련
	@FXML	Button Buttonrecipebookmark;
	@FXML 	ImageView starImageView;
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
	public void initialize(URL arg0, ResourceBundle arg1) {
		homeBtn.setOnAction(homeEvent -> handlerHomeBtn(homeEvent));
		backBtn.setOnAction(backEvent -> handlerBackBtn(backEvent));
		
		
		RecipeDetailInfoVO re = new RecipeDetailInfoVO(HRConst.bookmarkReNm,"","","","","","","");
		RecipeDetailInfoDao recipeDetail= new RecipeDetailInfoDao();
				
		
		
		
		RecipeDetailInfoVO outVO = (RecipeDetailInfoVO)	recipeDetail.do_selectOne(re);
		
		
		if(outVO.getReNo().equals(re.getReNo())){
			System.out.println(outVO.getReName());
			reName.setText(outVO.getReName());
			System.out.println(outVO.getReImage());
			reImage.setImage
			(new Image(getClass().getResource("/com/limitless/recipedetailinfo/image/recipeimage/"+outVO.getReImage()).toString()));
			System.out.println(outVO.getReFood());
			reFood.setText(outVO.getReFood());
			System.out.println(outVO.getReCook01());
			reCook01.setText(outVO.getReCook01());
			System.out.println(outVO.getReCook02());
			reCook02.setText(outVO.getReCook02());
			System.out.println(outVO.getReCook03());
			reCook03.setText(outVO.getReCook03());
			System.out.println(outVO.getReCook04());
			reCook04.setText(outVO.getReCook04());
		
		
		}
		
		
		
		//즐겨찾기 구역
		alert =new Alert(AlertType.INFORMATION);
		alert.setTitle("INFORMATION");
		alert.setHeaderText("즐겨찾기를 성공하셧습니다");
		

		id=HRConst.session.getUser_Id();
		recipe= HRConst.bookmarkReNm;
		RecipeBookmarkDao recipeBookmarkDao=new RecipeBookmarkDao();
		recipeBookmar=recipeBookmarkDao.getList();
		
		list1=recipeBookmarkDao.do_retrieve(id);
	
		Starchange= recipeBookmarkDao.do_sdf(recipe, list1);
		
		
		


		if(Starchange==true){
			starImageView.setImage(new Image(getClass().getResource("/com/limitless/recipedetailinfo/image/star.png").toString()));

		}
		else{
			starImageView.setImage(new Image(getClass().getResource("/com/limitless/recipedetailinfo/image/star_no.png").toString()));
		
		}
		Starchange=!Starchange;		
		Buttonrecipebookmark.setOnAction(event->handlerBookMarkBtnAction(event));
		
		//즐겨찾기 구역 끝
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
			
			System.out.println("선택값:"+HRConst.reRetmpVO01.getReNo()+","+ HRConst.reRetmpVO02.getReNo());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void handlerBackBtn(ActionEvent backEvent) {
		
		try {
			Parent recipeSearchOkFx;
			recipeSearchOkFx = FXMLLoader.load(getClass().getResource("/com/limitless/recipebookmark/RecipeBookMarkFX.fxml"));
			//외부 css로딩
			recipeSearchOkFx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(recipeSearchOkFx);
			Stage primaryStage = (Stage)backBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void handlerBookMarkBtnAction(ActionEvent event){

		RecipeBookmarkDao recipeBookmarkDao=new RecipeBookmarkDao();
		RecipeBookmarkVO inVO = new RecipeBookmarkVO(id,recipe);
	

		
		if(Starchange==true){
			starImageView.setImage(new Image(getClass().getResource("/com/limitless/recipedetailinfo/image/star.png").toString()));
			recipeBookmar=recipeBookmarkDao.do_sa(inVO);
			recipeBookmarkDao.saveFile();
			
			
		}
		
		else{
			
			starImageView.setImage(new Image(getClass().getResource("/com/limitless/recipedetailinfo/image/star_no.png").toString()));
			recipeBookmar=recipeBookmarkDao.do_del(inVO);
			recipeBookmarkDao.saveFile();
			
			
			
			
		}
		Starchange=!Starchange;
		
			
		
	}
	


}
