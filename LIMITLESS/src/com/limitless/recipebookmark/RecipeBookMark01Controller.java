 /**
 * @Class Name : MenuFXController.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019-05-30           최초생성
 *
 * @author 개발프레임웍크 실행환경 HR. 	LIMITLESS개발팀
 * @since 2019-05-30 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.limitless.recipebookmark;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.hr.eclass.cmn.HRConst;
import com.limitless.recipedetailinfo.RecipeDetailInfoDao;
import com.limitless.recipedetailinfo.RecipeDetailInfoVO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class RecipeBookMark01Controller implements Initializable {
	
	public List<RecipeBookmarkVO> recipeBookmar=new ArrayList<>();
	public List<RecipeBookmarkVO> list1=new ArrayList<>();
	public List<RecipeBookmarkVO> rbp=new ArrayList<>();
	public ObservableList tableList=FXCollections.observableArrayList();
	private String id;
	private String recipe;
	@FXML private TableView<RecipeBookmarkPropertyVO> tableView;
	@FXML private TableColumn recipe_col;
	
	@FXML Button homeBtn;
	
	
	private RecipeBookmarkDao recipeBookmarkDao;
	
	 public void fileTable(List<RecipeBookmarkVO> list){
         for(int i=0; i<list.size(); i++){
            RecipeBookmarkVO tmpVO = rbp.get(i);
            tableList.add(new RecipeBookmarkPropertyVO(tmpVO.getId()
                        ,tmpVO.getRecipe()));
         }
           
      }
	
	


	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		homeBtn.setOnAction(homeEvent -> handlerHomeBtn(homeEvent));
		
		
	
//
//		id="";
//		
//		RecipeBookmarkDao recipeBookmarkDao=new RecipeBookmarkDao();
//		recipeBookmar=recipeBookmarkDao.getList();
//		
//		list1=recipeBookmarkDao.do_retrieve(id);
		
//		System.out.println(list1.toString());
//		List tmpList = new ArrayList<>(list1);
//		System.out.println(tmpList.get(0).toString());
		
		
		
		rbp = RecipeNmResearch();
		
		TableColumn recipe = tableView.getColumns().get(0);//1번째 컬럼
		recipe.setCellValueFactory(new PropertyValueFactory("recipe"));//모델에 속성 지정
		fileTable(rbp);
		tableView.setItems(tableList);
		tableView.setOnMouseClicked(event->handlerTableViewMouseClicked(event));
		
		
		
		
		
		
		//데이터를 담을 workStateDataList선언
		List<RecipeBookmarkVO> recipeDataList = new ArrayList<RecipeBookmarkVO>();
		//workStateDataList에 workState로 받아온 데이터들을 넣는다.

//		recipeDataList.add(rbp.get(1));
		
		//테이블뷰에 뿌려주기 위해 리스트로 만들음.
		//ObservableList<recipeDataList> workStateList = FXCollections.observableArrayList(recipeDataList);

//		System.out.println("========"+recipeDataList);
		
		
		
		//System.out.println(rbp.toString());
		
		
	}
	
	public void handlerTableViewMouseClicked(MouseEvent event){
		
		
		if(event.getClickCount() !=2)return;
			
			
			RecipeBookmarkPropertyVO reBPVO = this.tableView.getSelectionModel().getSelectedItem();
			HRConst.bookmarkReNm = reBPVO.getId();
			System.out.println(reBPVO.getId());
			
			try {
				Parent parent = FXMLLoader.load(getClass().getResource("/com/limitless/recipedetailinfo/RecipeDetailBookmarkFX.fxml"));
				//외부 css로딩
				parent.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
				Scene scene = new Scene(parent);
				Stage primaryStage =(Stage)homeBtn.getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
//		try{
//			
//			Stage dialog = new Stage(StageStyle.UTILITY);
//			dialog.initModality(Modality.WINDOW_MODAL);
//			dialog.initOwner(tableView.getScene().getWindow());
//			dialog.setTitle("즐겨찾기");
//			
//			
//			Parent parent = FXMLLoader.load(getClass().getResource("recipebookmark.fxml"));
//	
//			//닫기 버튼 처리
//			Button btnClose = (Button) parent.lookup("#btnClose");
//			btnClose.setOnAction(e->dialog.close());
//		
//			
//			//Parent와 Popup연결
//			Scene 	scene=new Scene(parent);
//			dialog.setScene(scene);
//			dialog.show();
//			
//			
//			
//			
//			
//		}catch(IOException io){}
	}
	
	
	
	public List<RecipeBookmarkVO> RecipeNmResearch(){
		List<RecipeBookmarkVO> recipeBookmarkPropertyVO = new  ArrayList<RecipeBookmarkVO>();
		
		id=HRConst.session.getUser_Id();
		
		RecipeBookmarkDao recipeBookmarkDao=new RecipeBookmarkDao();
		recipeBookmar=recipeBookmarkDao.getList();
		
		list1=recipeBookmarkDao.do_retrieve(id);
		System.out.println(list1.toString());
		
		List tmpList = new ArrayList<>();
		tmpList = list1;
		
//		RecipeBookmarkVO  tmpBookmark= new RecipeBookmarkVO();
//		tmpBookmark =  (RecipeBookmarkVO) tmpList.get(1);
//		tmpBookmark.getRecipe();
//		System.out.println(tmpBookmark.getRecipe());
		
		
		for(int i=0; i<tmpList.size();i++){
			RecipeBookmarkVO  tmpBookmark= new RecipeBookmarkVO();
			tmpBookmark =  (RecipeBookmarkVO) tmpList.get(i);
			tmpBookmark.getRecipe();
			System.out.println("tmpBookmark.getRecipe():"+tmpBookmark.getRecipe());
			
			
			
			RecipeDetailInfoVO re;
			RecipeDetailInfoDao recipeDetail = new RecipeDetailInfoDao();

			re = new RecipeDetailInfoVO(tmpBookmark.getRecipe(),"","","","","","","");
			String tmpReName;
			
			RecipeDetailInfoVO outVO = (RecipeDetailInfoVO)	recipeDetail.do_selectOne(re);
			
			if(outVO.getReNo().equals(re.getReNo())){
				tmpReName = outVO.getReName();	
				System.out.println("tmpReName:"+tmpReName);
				recipeBookmarkPropertyVO.add(new RecipeBookmarkVO(tmpBookmark.getRecipe(),tmpReName));
			}
			
		}
								
		return recipeBookmarkPropertyVO;
	}
	
	
	public void handlerHomeBtn(ActionEvent homeEvent) {
		
		try {
			Parent menuFx;
			menuFx = FXMLLoader.load(getClass().getResource("/com/limitless/recipedetailinfo/MenuFX.fxml"));
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
	
	

}



