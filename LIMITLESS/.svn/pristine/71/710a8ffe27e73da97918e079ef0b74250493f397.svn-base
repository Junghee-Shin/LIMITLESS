package com.limitless.reciperesearch;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.limitless.cmn.DTO;
import com.limitless.cmn.WorkDiv;
import com.limitless.reciperesearch.RecipeResearchDao;
import com.limitless.reciperesearch.RecipeResearchVO;

/**
 * @author 신정희
 *
 */
public class RecipeResearchDao implements WorkDiv{

	
	/** File을 읽어 to List <RecipeResearchVO> */
	private List<RecipeResearchVO> recipe = new ArrayList<RecipeResearchVO>();
	
	/** File 저장경로 */
	private final String FILE_PATH = "//211.238.142.124/hr_data/java03/RecipeResearch.csv";
	
	private Logger LOG = Logger.getLogger(RecipeResearchDao.class);
	
	
	
	public int saveFile(){
		int writeCnt = 0;//저장 Line Count
		FileWriter writer = null;
		
		
		try{			
			writer = new FileWriter(FILE_PATH);
						
			for(int i=0; i<recipe.size();i++){
				RecipeResearchVO outVO = recipe.get(i);
				//String email, String name, int birthday, String cellPhone
				String outStr =  outVO.getReNo()+","
								+outVO.getTool()+","
								+outVO.getDish()+","
								+outVO.getFood()+"\n";
				
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
	
	
	
	
	
	
	
	
	/** 초기화, 파일Read */
	public RecipeResearchDao(){
		List<RecipeResearchVO> content = new ArrayList<RecipeResearchVO>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
			String line = ""; //File 1개 라인 Data 저장
			
			while( (line = br.readLine()) != null){
				//vallidation ---> 공백 줄 있을 때 오류 없게 하려고
				if(null == line || line.equals("")){
					break;
				}
				
				String[] strArry = line.split(",");
				RecipeResearchVO inVO = new RecipeResearchVO(
								 strArry[0]
								,strArry[1]
								,strArry[2]
								,strArry[3]);
				
				recipe.add(inVO);
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
		
	}
	
	public List<RecipeResearchVO> readFile(String file){	
		List<RecipeResearchVO> recipe = new ArrayList<RecipeResearchVO>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
			String line = ""; //File 1개 라인 Data 저장
			
			while( (line = br.readLine()) != null){
				//vallidation ---> 공백 줄 있을 때 오류 없게 하려고
				if(null == line || line.equals("")){
					break;
				}
				
				String[] strArry = line.split(",");
				RecipeResearchVO inVO = new RecipeResearchVO(
										 strArry[0]
										,strArry[1]
										,strArry[2]
										,strArry[3]);
				
				recipe.add(inVO);
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
		return recipe;
		
	}
	
	
	
	@Override
	 public List<DTO> do_retrieve(DTO dto) {
		  List<DTO> list = new ArrayList<>();
		  RecipeResearchVO inVO= (RecipeResearchVO)dto;
		  RecipeResearchVO outVO = null;
			
		  for(int i=0; i<this.recipe.size();i++){
				RecipeResearchVO tmpVO =  recipe.get(i);
					if(tmpVO.getTool().equals(inVO.getTool())
							&& tmpVO.getDish().equals(inVO.getDish())
							&& tmpVO.getFood().equals(inVO.getFood())){		// 선택한 것 찾기
						
						outVO = tmpVO; //결과값 리스트에 저장
						
						outVO.getReNo();
						list.add(new RecipeResearchVO(outVO.getReNo(),"","",""));
					}
			}
			return list; //리스트 출력
			
	}
	
	



	/* (non-Javadoc)
	 * @see com.limitless.cmn.WorkDiv#do_save(com.limitless.cmn.DTO)
	 */
	@Override
	public int do_save(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}





	/* (non-Javadoc)
	 * @see com.limitless.cmn.WorkDiv#do_delete(com.limitless.cmn.DTO)
	 */
	@Override
	public int do_delete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}





	/* (non-Javadoc)
	 * @see com.limitless.cmn.WorkDiv#do_update(com.limitless.cmn.DTO)
	 */
	@Override
	public int do_update(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}





	/* (non-Javadoc)
	 * @see com.limitless.cmn.WorkDiv#do_selectOne(com.limitless.cmn.DTO)
	 */
	@Override
	public DTO do_selectOne(DTO dto) {
		RecipeResearchVO inVO= (RecipeResearchVO)dto;
		RecipeResearchVO outVO = null;
		
		for(int i=0; i<this.recipe.size();i++){
			RecipeResearchVO tmpVO =  recipe.get(i);
				if(tmpVO.getTool().equals(inVO.getTool())
						&& tmpVO.getDish().equals(inVO.getDish())
						&& tmpVO.getFood().equals(inVO.getFood())){		// 선택한 것 찾기
					
					outVO = tmpVO; //결과값 리스트에 저장
				}
		}
		return outVO; //리스트 출력
		
	}
	
	
	
}
