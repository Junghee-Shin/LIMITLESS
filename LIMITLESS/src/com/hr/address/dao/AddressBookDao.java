/**
 * 
 */
package com.hr.address.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hr.address.domain.MemberVO;
import com.limitless.cmn.DTO;
import com.limitless.cmn.WorkDiv;


/**
 * @author sist
 *
 */
public class AddressBookDao implements WorkDiv {
	/**
	 * File 읽어 to List <MemberVO>
	 * */	
	private List<MemberVO> addressBook = new ArrayList<MemberVO>();
	
	/**
	 * File 저장경로
	 * */
	private final String FILE_PATH = "C:/TEMP/addressBook.csv"; //파일 읽기
	//private final String FILE_PATH = "//211.238.142.124/hr_data/javahr/addRessBook.csv";
	
	private Logger LOG = Logger.getLogger(AddressBookDao.class);
	
	
	///수정
		public boolean isMemberExist(MemberVO vo){
			boolean flag = false;
			
			for(MemberVO orgVO:this.addressBook){
				if(orgVO.getEmail().equals(vo.getEmail())){
					flag = true;
					break;
				}
			}
			
			return flag;
		}
	
	
	
	
	
	
	/**
	 * 초기화, 파일Read
	 * */
	public AddressBookDao(){
		List<MemberVO> content = new ArrayList<MemberVO>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
			String line="";//File 1개 라인 Data 저장
			while(	(line = br.readLine()) !=null){
				//validation
				if(null == line || line.equals("")){
					break;
				}
				
				
				String[] strArry = line.split(",");
				MemberVO inVO = new MemberVO(
								 strArry[0]
								,strArry[1]
								,Integer.parseInt(strArry[2])//String값을 int로 변형해야 함.(생일)
								,strArry[3]
								);
				addressBook.add(inVO);
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
		MemberVO vo= (MemberVO)dto;
		int saveCnt = 0;
		//data 존재 여부 확인
		for(int i=0; i<addressBook.size();i++){
			MemberVO checkVO = addressBook.get(0);
			if(checkVO.getEmail().equals(vo.getEmail())){//기존에 있는 Email과 같은지 체크하는 과정임
				saveCnt = -1; //같은 값이 있으면 -1을 입력
				return saveCnt;
			}
		}
		boolean flag = addressBook.add(vo);
		if(flag == true){//중복되는 값이 없으면 입력하고 1을 출력
			saveCnt =1;
		}
		
		return saveCnt;
	}

	/* (non-Javadoc)
	 * @see com.hr.cmn.WorkDiv#do_delete(com.hr.cmn.DTO)
	 */
	@Override
	public int do_delete(DTO dto) {
		MemberVO inVO= (MemberVO)dto;
		int flag=0;
		//뒤에서부터 찾아 삭제할 것.
		for(int i = this.addressBook.size()-1;i>=0;i--){
			MemberVO orgVO = addressBook.get(i);
			if(orgVO.getEmail().equals(inVO.getEmail())){
				addressBook.remove(i);
				flag ++;
				break;
			}
		}
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.hr.cmn.WorkDiv#do_update(com.hr.cmn.DTO)
	 */
	@Override
	public int do_update(DTO dto) {
		
		MemberVO inVO = (MemberVO) dto;
		int flag=0;//Data 존재 여부(email)
	
		if(isMemberExist(inVO)){
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
		MemberVO inVO= (MemberVO)dto;
		MemberVO outVO = null;
		for(int i=0; i<this.addressBook.size();i++){
			MemberVO tmpVO =  addressBook.get(i);
			if(tmpVO.getEmail().equals(inVO.getEmail())){
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
	public List<DTO> do_retrieve(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	public int saveFile(){
		int writeCnt = 0;//저장 Line Count
		FileWriter writer = null;
		
		
		
		try{			
			writer = new FileWriter(FILE_PATH);
						
			for(int i=0; i<addressBook.size();i++){
				MemberVO outVO = addressBook.get(i);
				//String email, String name, int birthday, String cellPhone
				String outStr =  outVO.getEmail()+","
								+outVO.getName()+","
								+outVO.getBirthday()+","
								+outVO.getCellPhone()+"\n";
				
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
	
	

}
