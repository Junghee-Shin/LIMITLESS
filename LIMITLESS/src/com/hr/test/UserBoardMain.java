 /**
 * @Class Name : UserBoardMain.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019-05-23           최초생성
 *
 * @author 개발프레임웍크 실행환경 HR. 	LIMITLESS개발팀
 * @since 2019-05-23 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.hr.test;
import java.util.*;


import org.apache.log4j.Logger;

import com.limitless.userboard1.UserBoardDao;
import com.limitless.userboard1.UserBoardVO;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserBoardMain extends Application {
	private UserBoardVO vo01;		
	private UserBoardVO vo02;		
	private UserBoardVO vo03;
	private UserBoardDao userboarddao;
	
	private static final Logger LOG=Logger.getLogger(UserBoardMain.class);
	
	public UserBoardMain(){
		userboarddao = new UserBoardDao();
		vo01=new UserBoardVO("맛있어요","memkek","뫄뫄","2010523");
		vo02=new UserBoardVO("괜찮은자취요리","memkekd","와와","2010523");
		vo03=new UserBoardVO("가성비맛","memkek03","사사","20150524");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("UserBoardFX.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("이용자게시판");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	
	}
	


	
	
}
