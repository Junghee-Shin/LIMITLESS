
package com.hr.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hr.address.dao.AddressBookDao;
import com.hr.address.domain.MemberVO;
import com.hr.eclass.member.dao.MemberEClassDao;
import com.limitless.cmn.DTO;
import com.limitless.reciperesearch.RecipeResearchDao;
import com.limitless.reciperesearch.RecipeResearchVO;


public class RecipeResearchMain {
	private RecipeResearchVO vo01;
	private RecipeResearchDao recipeResearchDao;
	
	
	public RecipeResearchMain(){
		recipeResearchDao = new RecipeResearchDao();
		vo01 = new RecipeResearchVO("","가스레인지","한그릇 음식","닭");
	}
	

	
	public static void main(String[] args) {
		RecipeResearchMain recipeResearchMain =new RecipeResearchMain();
		recipeResearchMain.check();
		System.out.println("=====");
	}
	
	
	
	public void check(){
		
		// check() 안에 do_retrieve()를 실행 시키고 싶음!!
		
		recipeResearchDao.do_retrieve(vo01);
		
		List list = new ArrayList<>(recipeResearchDao.do_retrieve(vo01));
		RecipeResearchVO tmpVO01 = new RecipeResearchVO();
		RecipeResearchVO tmpVO02 = new RecipeResearchVO();
		tmpVO01=(RecipeResearchVO) list.get(0);
		System.out.println("list:"+tmpVO01);
		tmpVO01.getReNo();
		System.out.println("reNo:"+tmpVO01.getReNo());
		
		tmpVO02=(RecipeResearchVO) list.get(1);
		System.out.println("list:"+tmpVO02);
		tmpVO02.getReNo();
		System.out.println("reNo:"+tmpVO02.getReNo());
		
		
	}
	


	
	
}
