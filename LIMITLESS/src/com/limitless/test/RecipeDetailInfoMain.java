package com.limitless.test;

import java.util.List;

import com.limitless.recipedetailinfo.RecipeDetailInfoDao;
import com.limitless.recipedetailinfo.RecipeDetailInfoVO;





public class RecipeDetailInfoMain {
	private RecipeDetailInfoVO re;
	
	private RecipeDetailInfoDao recipeDetail;
	
	public RecipeDetailInfoMain(){
		recipeDetail = new RecipeDetailInfoDao();
		re = new RecipeDetailInfoVO("recipe01","","","","","","","");

		
	}
	
	
	public static void main(String[] args) {
		
		RecipeDetailInfoMain test =new RecipeDetailInfoMain();
		test.search();
		
		
		
	}
	public void search(){
		RecipeDetailInfoVO outVO = (RecipeDetailInfoVO)	recipeDetail.do_selectOne(re);
		System.out.println(outVO);
		if(outVO.getReNo().equals(re.getReNo())){
			System.out.println(outVO.getReName());
			System.out.println(outVO.getReImage());
			System.out.println(outVO.getReFood());
			System.out.println(outVO.getReCook01());
			System.out.println(outVO.getReCook02());
			System.out.println(outVO.getReCook03());
			System.out.println(outVO.getReCook04());
			
		
	

			
			
			}
	}
	
	
}


