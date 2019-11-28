/**
 * 
 */
package com.limitless.userboard1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.hr.eclass.cmn.HRConst;
import com.hr.eclass.member.domain.MemberEClassVO;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * @author sist
 *
 */
public class UserBoardFXcontroller implements Initializable {
	
	@FXML Button writeBtn;
	@FXML TableView <UserBoardTableVO> tableView;	
	@FXML TextField txtcontent;
	@FXML Button homeBtn;
	@FXML Button chartBtn;
	
	private UserBoardDao userBoardDao;
	
	
	private ObservableList<UserBoardTableVO> commentlist;
	public void handleWriteBtnAddAction(ActionEvent e){
		
		//member
		MemberEClassVO sessoionVO = new MemberEClassVO();
		
			String content = txtcontent.getText();
			System.out.println("content:"+content);	
		
		
		//date	
		Date today = new Date();
		SimpleDateFormat sdf01;
		sdf01 = new SimpleDateFormat("yyyy-MM-dd");
			
//			commentlist.add(new UserBoardTableVO(content
//							,num
//							,HRConst.session.getUser_Id()
//							,""							
//							,sdf01.format(today)
//							));
		Integer number = UserboardConst.userTableViewList.size()+1;
		UserBoardTableVO tableVO = 	new UserBoardTableVO(
									txtcontent.getText()
									,number.toString()
									,HRConst.session.getUser_Id()
									,HRConst.session.getName()
									,sdf01.format(today)
									);
		System.out.println(tableVO);			
	
		UserboardConst.userTableViewList.add (tableVO); 
		
		UserBoardVO tmpBoard = new UserBoardVO(
			
									tableVO.getContent(),
									tableVO.getId(),
									tableVO.getNickname(),
									tableVO.getDate()
									);
		tmpBoard.setNo(number.toString());
		int flag = this.userBoardDao.do_save(tmpBoard);
		System.out.println("=========");
		System.out.println("=flag="+flag);
		System.out.println("=========");
					    			
		//file에 저장
		userBoardDao.do_saveFile();
		
		//텍스트 필드 초기화
		
		txtcontent.setText("");						
	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//Dao객체 생성 
		userBoardDao = new UserBoardDao();
		System.out.println("===========================");
		System.out.println("==UserboardConst.userBoard="+UserboardConst.userBoard);
		System.out.println("===========================");
		
		//List->TableView list 변환
		//UserBoardVO - >userboard
		//list->observablelist
		
		for(UserBoardVO uVO : UserboardConst.userBoard){
			UserBoardTableVO tVO = new UserBoardTableVO(
					uVO.getContent(),
					uVO.getNo(),
					uVO.getId(),
					uVO.getNickname(),
					uVO.getDate()
					);
			
			
			UserboardConst.userTableViewList.add(tVO);
		}
		
		writeBtn.setOnAction(event->handleWriteBtnAddAction(event) );
		userBoardDao = new UserBoardDao();
		
	
		TableColumn tcNo = tableView.getColumns().get(0);
		tcNo.setCellValueFactory(new PropertyValueFactory<>("no"));
		
		TableColumn tcContent = tableView.getColumns().get(1);
		tcContent.setCellValueFactory(new PropertyValueFactory<>("content"));
		
		TableColumn tcId = tableView.getColumns().get(2);
		tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn tcNickname = tableView.getColumns().get(3);
		tcNickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));
		
		TableColumn tcDate = tableView.getColumns().get(4);
		tcDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		
	
		//table에 data set
	
		tableView.setItems(UserboardConst.userTableViewList);
		
		
		//홈버튼
		homeBtn.setOnAction(homeEvent -> handlerHomeBtn(homeEvent));
		
		
		//tableview RowEvent감지 
		tableView.setOnMouseClicked(event->handlerTableViewMouseClicked(event));
		
		//차트버튼
		chartBtn.setOnAction(chartEvent -> handlerBtnBarchartAction(chartEvent)); 
		
		
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
			UserboardConst.userTableViewList.clear();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//tableview RowEvent감지 :PieChart Event
	public void handlerTableViewMouseClicked(MouseEvent event){
		if(event.getClickCount() !=2)return; //더블클릭해야 이벤트 발생 
		System.out.println(event);
		
		try{ 
			//Parent
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(homeBtn.getScene().getWindow());
			dialog.setTitle("파이그래프");
			
			//popup화면
			Parent parent = FXMLLoader.load(getClass().getResource("UserBoardPiechart.fxml"));
			PieChart piechart = (PieChart)parent.lookup("#piechart");
		
			
			piechart.setData(FXCollections.observableArrayList(
					new PieChart.Data("한그릇음식",70 ),
					new PieChart.Data("밥반찬",30 ),
					new PieChart.Data("국물요리",10)
					));
			
			//닫기 버튼 처리 
			Button btnClose = (Button) parent.lookup("#btnClose");
			btnClose.setOnAction(e->dialog.close());
			
			//Parent과Popup 연결
			Scene scene = new Scene(parent);
			//scene.getStylesheets().add(getClass().getResource("app.css")); //스타일 입히기  왜오류가 뜨는지 확인해볼것. 
			dialog.setScene(scene);
			dialog.show();
			
			
			
		}catch(IOException io){}
	}
	
	public void handlerBtnBarchartAction(ActionEvent e){
		Parent parent = null;
		try {
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(homeBtn.getScene().getWindow());
			dialog.setTitle("막대 그래프");
				
			parent = FXMLLoader.load(getClass().getResource("chart.fxml"));
			AreaChart barChart = (AreaChart) parent.lookup("#Chart");
			
			
			XYChart.Series	user01 = new XYChart.Series<>();
			
			user01.setName(HRConst.session.getUser_Id());
			UserBoardDao userBoardDao = new UserBoardDao();
			UserBoardVO chartVO = new UserBoardVO("","",HRConst.session.getUser_Id(),"");
			System.out.println("id:"+HRConst.session.getUser_Id());
			userBoardDao.do_retrieve(chartVO);
			System.out.println("userBoardDao.do_retrieve(chartVO)="+userBoardDao.do_retrieve(chartVO));
			List idList = new ArrayList<>(userBoardDao.do_retrieve(chartVO));
			System.out.println("idList="+idList);
			List dateList = new ArrayList<>();
			List user01List = new ArrayList<>();
			
			//date	
			Date today01 = new Date();
			SimpleDateFormat sdf0101;
			sdf0101 = new SimpleDateFormat("yyyy-MM-dd");
			
			for(int i=0; i<idList.size();i++){
				UserBoardVO tmpVO = (UserBoardVO) idList.get(i);
				if(tmpVO.getDate().equals(sdf0101.format(today01))){
					dateList.add(tmpVO);
				}
				
			}
			user01List.add(new XYChart.Data<>("2019-06-03",3));
			user01List.add(new XYChart.Data<>("2019-06-04",3));
			user01List.add(new XYChart.Data<>("2019-06-05",5));
			
			
			
			ObservableList 	observableList	=FXCollections.observableArrayList(user01List);
			user01.setData(observableList);
			
			barChart.getData().add(user01);
			
			
			Button btnClose = (Button) parent.lookup("#btnClose");
			btnClose.setOnAction(event->dialog.close());
			
			
			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
			
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}


	
	
