package com.limitless.recipedetailinfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.apache.log4j.Logger;

import com.limitless.cmn.DTO;
import com.limitless.cmn.WorkDiv;
import com.limitless.recipedetailinfo.RecipeDetailInfoDao;
import com.limitless.recipedetailinfo.RecipeDetailInfoVO;

public class RecipeDetailInfoDao  implements WorkDiv {

	/**
	 * 파일 읽어서 to List<RecipeDetailInfo>
	 * */
	
	private List<RecipeDetailInfoVO> recipeDetail = new ArrayList<RecipeDetailInfoVO>();
	
	
	/**
	 * File 저장 경로
	 * */
	
	private final String FILE_PATH = "//211.238.142.124/hr_data/java03/recipeDetailInfo.csv";
	
	private Logger LOG = Logger.getLogger(RecipeDetailInfoDao.class);
	
	/**
	 * 초기화, 파일Read
	 * */
	public RecipeDetailInfoDao(){
		List<RecipeDetailInfoDao> content = new ArrayList<RecipeDetailInfoDao>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
			String line = "";
			while(	(line = br.readLine()) !=null){
				if(null == line || line.equals("")){
					break;
				}
				String[] strArry = line.split(",");
//				System.out.println("strArry.length:" +strArry.length);
				RecipeDetailInfoVO inVO = new RecipeDetailInfoVO(
												 strArry[0]
												,strArry[1]
												,strArry[2]
												,strArry[3]
												,strArry[4]
												,strArry[5]
												,strArry[6]
												,strArry[7]);
				recipeDetail.add(inVO);
				
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
	
	}//-RecipeDetailInfoDao()

	@Override
	public DTO do_selectOne(DTO dto) {
		RecipeDetailInfoVO inVO= (RecipeDetailInfoVO)dto;
		RecipeDetailInfoVO outVO= null;
//		System.out.println("inVO:"+inVO);

		for(int i=0; i<this.recipeDetail.size();i++){
			RecipeDetailInfoVO tmpVO = recipeDetail.get(i);
//			System.out.println("tmpVO:"+tmpVO);
//			System.out.println("ttttttt:"+tmpVO.getReNo().equals(inVO.getReNo()));
			if(tmpVO.getReNo().equals(inVO.getReNo())){
				outVO=tmpVO;
				break;
			}
		}
		
//		System.out.println("outVO:"+outVO);
		return outVO;
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
	 * @see com.limitless.cmn.WorkDiv#do_retrieve(com.limitless.cmn.DTO)
	 */
	@Override
	public List<DTO> do_retrieve(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
