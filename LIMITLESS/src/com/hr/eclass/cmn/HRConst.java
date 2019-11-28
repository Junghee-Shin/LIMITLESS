package com.hr.eclass.cmn;

import java.util.ArrayList;
import java.util.List;

import com.hr.eclass.member.domain.MemberEClassVO;
import com.limitless.recipedetailinfo.RecipeDetailInfoVO;
import com.limitless.reciperesearch.RecipeResearchVO;

public class HRConst {

	public final static String VERSION ="2018-05-28 1.0";
	public final static String path ="";
	
	//DB연결
	public final static String DB_URL = "jdbc:oracle:thin:@211.238.142.124:1521:orcl";
	public final static String DB_USER = "SIST_DH";
	public final static String DB_PASSWORD = "DH1024";
	
	public static MemberEClassVO session =null;
	
	public static RecipeDetailInfoVO recipeDetailTmp = new RecipeDetailInfoVO();
	
	public static RecipeResearchVO recipeResearchVOTmp = new RecipeResearchVO();
	
	public static RecipeResearchVO reRetmpVO01 = new RecipeResearchVO();
	public static RecipeResearchVO reRetmpVO02 = new RecipeResearchVO();
	
	public static RecipeResearchVO reBookmarktmpVO = new RecipeResearchVO();
	public static String bookmarkReNm;
	
	public HRConst() {
		// TODO Auto-generated constructor stub
	}

}
