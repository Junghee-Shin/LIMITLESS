
package com.hr.test;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.limitless.recipebookmark.RecipeBookmarkVO;

//import com.hr.crud.Recipe;
//import com.hr.crud.RecipeBookmarkVO;
/**
 * @author sist
 *
 */
public class RecipeBookmarkMain {
	private List<RecipeBookmarkVO> recipeBookmark=new ArrayList<RecipeBookmarkVO>();
	//C:\\TEMP
	private String file = "//211.238.142.124/hr_data/java03/RecipeBookmark.csv";
	
	private RecipeBookmarkVO vo01;
	private RecipeBookmarkVO vo02;
	private RecipeBookmarkVO vo03;
	private static Logger LOG=Logger.getLogger(RecipeBookmarkMain.class);
	
	List<RecipeBookmarkVO> readFile(String file){
		List<RecipeBookmarkVO> content =new ArrayList<RecipeBookmarkVO>();
		
		try{
			BufferedReader br = new  BufferedReader(new FileReader(file));
			String line = "";
			while((line =br.readLine())!=null){
				if(null==line|| line.equals("")){
					break;
				}
				String[] strArry =line.split(",");
				RecipeBookmarkVO inVO=new RecipeBookmarkVO(strArry[0],strArry[1]);
				content.add(inVO);
			}
			
			
		}catch(FileNotFoundException fnfe){
			LOG.debug("===================");
			LOG.debug("FileNotFoundException="+fnfe.getMessage());
			LOG.debug("===================");
		}catch(IOException ioe){
			LOG.debug("===================");
			LOG.debug("IOException="+ioe.getMessage());
			LOG.debug("===================");			
		}
		return content;
	}
	
	public RecipeBookmarkMain(){
		vo01=new RecipeBookmarkVO("hr01@naver.com","�̻�01");
		vo02=new RecipeBookmarkVO("hr02@naver.com","�̻�02");
	}
	
	int saveFile(FileWriter writer){
		int writeCnt =0;
		
		try{
			for(int i=0; i<recipeBookmark.size();i++){
				RecipeBookmarkVO outVO = recipeBookmark.get(i);
			
					
				String outStr=  outVO.getId()+","
								+outVO.getRecipe()+"\n";
		
				writer.write(outStr);
				writeCnt++;
			}
		}catch(IOException e){
			LOG.debug("---------------------");
			LOG.debug("IOException:"+e.getMessage());
			LOG.debug("---------------------");
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
	RecipeBookmarkVO getInputDate(Scanner scanner){
		RecipeBookmarkVO outVO =null;
		scanner=new Scanner(System.in);
		String readDate = scanner.nextLine().trim();
		String[] readArray = readDate.split(",");
		
		outVO =new RecipeBookmarkVO(readArray[0],readArray[1]);
		
		return outVO;
	}
	int do_save(RecipeBookmarkVO vo){
		int saveCnt = 0;

		for(int i=0; i<recipeBookmark.size();i++){
			RecipeBookmarkVO checkVO = recipeBookmark.get(i);
			if(checkVO.getRecipe().equals(vo.getRecipe())){
				saveCnt =-1;
				return saveCnt;
			}
		}
		boolean flag = recipeBookmark.add(vo);
		if(flag==true){
			saveCnt=1;
		}
		return saveCnt;
	}

	public int do_delete(RecipeBookmarkVO inVO){
		int flag =0;
	
		for(int i=this.recipeBookmark.size()-1;i>=0;i--){
			RecipeBookmarkVO orgVO =recipeBookmark.get(i);
			if(orgVO.getId().equals(inVO.getId())){
				recipeBookmark.remove(i);
				flag++;
				break;
			}
		
		}
		return flag;

	}
	public boolean isMemberExist(RecipeBookmarkVO vo){
		boolean flag = false;
		for(RecipeBookmarkVO orgVO:this.recipeBookmark){
			if(orgVO.getId().equals(vo.getId())){
				flag = true;
				break;
			}
		}
		return flag;
		
	}
	RecipeBookmarkVO do_selectOne(RecipeBookmarkVO inVO){
		RecipeBookmarkVO outVO= null;
		for(int i=0; i<recipeBookmark.size();i++){
			RecipeBookmarkVO tmpVO =recipeBookmark.get(i);
			if(tmpVO.getId().equals(inVO.getId())){
				outVO =tmpVO;
				break;
			}
		}
		
		return outVO;
	}
	
	public List <RecipeBookmarkVO> do_retrieve(){
		List<RecipeBookmarkVO> list =new ArrayList<RecipeBookmarkVO>();
		LOG.debug("Id            레서피 ");
		LOG.debug("====================");
		for(int i=0; i<recipeBookmark.size();i++){
			RecipeBookmarkVO tmpVO = recipeBookmark.get(i);
			String outMsg =tmpVO.getId()+"             "+tmpVO.getRecipe();
					
			LOG.debug(outMsg);
			list.add(tmpVO);
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		RecipeBookmarkMain recipe=new RecipeBookmarkMain();

		File checkFile=new File(recipe.file);
		LOG.debug("checkFile.exists():"+checkFile.exists());
		if(checkFile.exists()==true){
			recipe.recipeBookmark=recipe.readFile(recipe.file);
			LOG.debug("-recipe.recipeBookmark===============");
			LOG.debug(recipe.recipeBookmark);
			LOG.debug("===============");
		}		

		Scanner scanner =new Scanner(System.in);
		String input01="";
		Scanner sMember =null;
		do{
			System.out.print("C:등록,D:삭제,RE:목록 조회,Q:종료>>");
			input01 =scanner.nextLine().trim();
			
			String memberDate =""; 
			RecipeBookmarkVO inVO =null;
			String[] inArrat = null;
			int flag =0;
			switch(input01.toUpperCase()){
			/*
				case "R" :
					System.out.println("");
					inVO=recipe.getInputDate(sMember);
					
					//RecipeBookmarkVO do_selectOne(RecipeBookmarkVO inVO)
					RecipeBookmarkVO outVO =recipe.do_selectOne(inVO);
					if(outVO==null){
						LOG.debug("R:"+inVO);
					}else{
						LOG.debug("R:"+outVO);
					}
					break;
					*/
					
				case "RE" :
						//List <RecipeBookmarkVO> do_retrieve()
					List<RecipeBookmarkVO> outList =recipe.do_retrieve();

					break;
					
				case "D" :
					System.out.println("이름 레시피");
					//Scanner ->RecipeBookmarkVO
					
					inVO=recipe.getInputDate(sMember);
					
		
					//boolean isMemberExist(RecipeBookmarkVO vo)
					
					
					flag=recipe.do_delete(inVO);
					if(flag==1){
						LOG.debug("D:삭제 성공");
					}else{	
						LOG.debug("D:삭제 실패"+flag);
					}					
					
					break;
					/*
				case "U" :
					System.out.println("");
					//Scanner ->RecipeBookmarkVO
					
					inVO=recipe.getInputDate(sMember);
					//boolean isMemberExist(RecipeBookmarkVO vo)
					
				
					
					
					if(recipe.isMemberExist(inVO)){
						recipe.do_delete(inVO);
						flag =recipe.do_save(inVO);
						if(flag==1){
							LOG.debug("U:��������:"+flag);
						}else{
							LOG.debug("U:��������:"+flag);
						}
					}					
					
					break;
					*/
				case "C" :
					System.out.println("이름 레시피");
					inVO=recipe.getInputDate(sMember);
					flag =recipe.do_save(inVO);
					if(flag==1){
						LOG.debug("C:등록 성공");
					}else{	
						LOG.debug("C:등록 실패"+flag);
					}
					break;
										
				case "Q" :
					
					try{
						FileWriter writer = new FileWriter(recipe.file);
						int writeCnt = recipe.saveFile(writer);
						LOG.debug("writeCnt"+writeCnt);
					}catch(IOException e){
						e.printStackTrace();
					}
					break;
							
			}//--switch
			
		}while(!input01.equalsIgnoreCase("q"));
		
		System.out.println("프로그램이 종료되었습니다");
		System.exit(0);
		}
}

