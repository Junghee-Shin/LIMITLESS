 /**
 * @Class Name : RecipeBookmarkDao.java
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
package com.limitless.recipebookmark;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.limitless.recipebookmark.RecipeBookmarkVO;
import com.hr.address.domain.MemberVO;
import com.limitless.cmn.DTO;
import com.limitless.cmn.WorkDiv;


/**
 * @author sist
 *
 */
public class RecipeBookmarkDao implements WorkDiv {
	/**
	 * File 읽어 to List <MemberVO>
	 * */	
	private  List<RecipeBookmarkVO> recipeBookmar = new ArrayList<RecipeBookmarkVO>();
	
	/**
	 * File 저장경로
	 * */
	private final String FILE_PATH = "//211.238.142.124/hr_data/java03/RecipeBookmark.csv";
	
	
	private Logger LOG = Logger.getLogger(RecipeBookmarkDao.class);
	
	
	///수정
		public boolean isRecipeBookmarExist(RecipeBookmarkVO vo){
			boolean flag = false;
			
			for(RecipeBookmarkVO orgVO:this.recipeBookmar){
				if(orgVO.getRecipe().equals(vo.getRecipe())){
					flag = true;
					break;
				}
			}
			
			return flag;
		}
	
	
	
	
	
	
	/**
	 * 초기화, 파일Read
	 * */
	public RecipeBookmarkDao(){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
			String line="";//File 1개 라인 Data 저장
			while(	(line = br.readLine()) !=null){
				//validation
				if(null == line || line.equals("")){
					break;
				}
				
				
				String[] strArry = line.split(",");
				RecipeBookmarkVO inVO = new RecipeBookmarkVO(
								 strArry[0]
								,strArry[1]
								);
				recipeBookmar.add(inVO);
			}
			
		}catch(FileNotFoundException fnfe){
			LOG.debug("==================");
			LOG.debug("FileNotFoundException="+fnfe.getMessage());
			LOG.debug("==================");
		}catch(IOException ioe){
			LOG.debug("==================");
			LOG.debug("IOException="+ioe.getMessage());
			LOG.debug("==================");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see com.hr.cmn.WorkDiv#do_save(com.hr.cmn.DTO)
	 */
	@Override
	public int do_save(DTO dto) {
		RecipeBookmarkVO vo= (RecipeBookmarkVO)dto;
		int saveCnt = 0;
		//data 존재 여부 확인
		for(int i=0; i<recipeBookmar.size();i++){
			RecipeBookmarkVO checkVO = recipeBookmar.get(0);
			if(checkVO.getRecipe().equals(vo.getRecipe())){//기존에 있는 Recipe과 같은지 체크하는 과정임
				saveCnt = -1; //같은 값이 있으면 -1을 입력
				return saveCnt;
			}
		}
		boolean flag = recipeBookmar.add(vo);
		if(flag == true){//중복되는 값이 없으면 입력하고 1을 출력
			saveCnt =1;
		}
		
		return saveCnt;
	}
	
	public  List<RecipeBookmarkVO> do_sa(DTO dto) {
		RecipeBookmarkVO vo= (RecipeBookmarkVO)dto;
		int saveCnt = 0;
		//data 존재 여부 확인
		for(int i=0; i<recipeBookmar.size();i++){
			RecipeBookmarkVO checkVO = recipeBookmar.get(i);
			if(checkVO.getRecipe().equals(vo.getRecipe()) &&
					checkVO.getId().equals(vo.getId())){//기존에 있는 Recipe과 같은지 체크하는 과정임
				saveCnt = -1; //같은 값이 있으면 -1을 입력
				
			}
		}
		if(saveCnt==-1){
			
		}else{
		recipeBookmar.add(vo);
		}
		
		
		return recipeBookmar;
		
	}
	/* (non-Javadoc)
	 * @see com.hr.cmn.WorkDiv#do_delete(com.hr.cmn.DTO)
	 */
	@Override
	public int do_delete(DTO dto) {
		RecipeBookmarkVO inVO= (RecipeBookmarkVO)dto;
		int flag=0;
		//뒤에서부터 찾아 삭제할 것.
		
		for(int i = this.recipeBookmar.size()-1;i>=0;i--){
			RecipeBookmarkVO orgVO = recipeBookmar.get(i);
			if(orgVO.getRecipe().equals(inVO.getRecipe())){
				recipeBookmar.remove(i);
				flag ++;
				break;
			}
		}
		
		return flag;
	}
	public List<RecipeBookmarkVO> do_del(DTO dto) {
		RecipeBookmarkVO inVO= (RecipeBookmarkVO)dto;
		
		//뒤에서부터 찾아 삭제할 것.
		
		for(int i = this.recipeBookmar.size()-1;i>=0;i--){
			RecipeBookmarkVO orgVO = recipeBookmar.get(i);
			if(orgVO.getRecipe().equals(inVO.getRecipe()) 
					&& orgVO.getId().equals(inVO.getId())){
				recipeBookmar.remove(i);
				
				break;
			}
		}
		
		return recipeBookmar;
	}

	/* (non-Javadoc)
	 * @see com.hr.cmn.WorkDiv#do_update(com.hr.cmn.DTO)
	 */
	@Override
	public int do_update(DTO dto) {
		
		RecipeBookmarkVO inVO = (RecipeBookmarkVO) dto;
		int flag=0;//Data 존재 여부(email)
	
		if(isRecipeBookmarExist(inVO)){
			do_delete(inVO);
			flag = do_save(inVO);
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.hr.cmn.WorkDiv#do_selectOne(com.hr.cmn.DTO)
	 */
	@Override
	public DTO do_selectOne(DTO dto) {
		RecipeBookmarkVO inVO= (RecipeBookmarkVO)dto;
		RecipeBookmarkVO outVO = null;
		for(int i=0; i<this.recipeBookmar.size();i++){
			RecipeBookmarkVO tmpVO = recipeBookmar.get(i);
			if(tmpVO.getRecipe().equals(inVO.getRecipe())){
				outVO = tmpVO;
				break;
			}
		}
		return outVO;
	}

	/* (non-Javadoc)
	 * @see com.hr.cmn.WorkDiv#do_retrieve(com.hr.cmn.DTO)
	 */
	@Override
	public List<RecipeBookmarkVO> do_retrieve(DTO dto) {
			return null;
			  
			
			 }

	public List<RecipeBookmarkVO> do_retrieve(String searchKeyword ){
		  List<RecipeBookmarkVO> list=new ArrayList<>();
		

		  Pattern p = Pattern.compile(".*"+searchKeyword+".*");

		  for(int i=0;i<recipeBookmar.size();i++){
		   RecipeBookmarkVO outVO = recipeBookmar.get(i);
		   Matcher m = null;
		   
		    m = p.matcher(outVO.getId());
		  
		   
		   
		   if (m.matches()) {
		    list.add(outVO);
		   }
		  }
		  
		  return list;
	}
	public boolean do_sdf(String searchKeyword ,List<RecipeBookmarkVO> list1 ){
		  boolean check=false;
		

		  Pattern p = Pattern.compile(".*"+searchKeyword+".*");

		  for(int i=0;i<list1.size();i++){
		   RecipeBookmarkVO outVO = list1.get(i);
		   Matcher m = null;
		   
		    m = p.matcher(outVO.getRecipe());
		  
		   
		   
		   if (m.matches()) {
		   check= true;
		   }
		  }
		  
		  return check;
	}
	
	
	
	
	
	public int saveFile(){
		int writeCnt = 0;//저장 Line Count
		FileWriter writer = null;
		
		
		
		try{			
			writer = new FileWriter(FILE_PATH);
						
			for(int i=0; i<recipeBookmar.size();i++){
				RecipeBookmarkVO outVO = recipeBookmar.get(i);
				//String email, String name, int birthday, String cellPhone
				String outStr =  outVO.getId()+","
								+outVO.getRecipe()+"\n";

				writer.write(outStr);
				writeCnt++;
			}
		}catch(IOException e){
			LOG.debug("==================");
			LOG.debug("IOException="+e.getMessage());
			LOG.debug("==================");
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				LOG.debug("---------------------");
				LOG.debug("IOException:"+e.getMessage());
				LOG.debug("---------------------");
			}
		}
		return writeCnt;
	}
	public List<RecipeBookmarkVO> getList(){
		return recipeBookmar;
	}
	
	

}
