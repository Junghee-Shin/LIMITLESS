package com.limitless.userboard1;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author SIST
 *
 */
public class UserBoardTableVO {
	
	private SimpleStringProperty content;
	
	/**번호*/
	private SimpleStringProperty no;
	
	/**이메일*/
	private SimpleStringProperty id;
	
	/**닉네임*/
	private SimpleStringProperty nickname;
	
	/**게시일자*/
	private SimpleStringProperty date;

	/**
	 * @return the content
	 */
	public String getContent() {
		return content.get();
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content.set(content);
	}

	/**
	 * @return the no
	 */
	public String getNo() {
		
		return no.get();
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no.set(no);;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id.get();
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id.set(id);;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname.get();
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname.set(nickname);
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date.get();
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date.set(date);;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserBoardTableVO [content=" + content.get() + ", no=" + no.get()  + ", id=" + id.get()  + ", nickname=" + nickname.get() 
				+ ", date=" + date.get()  + "]";
	}

	public UserBoardTableVO(){
		
	}
	/**
	 * @param content
	 * @param no
	 * @param id
	 * @param nickname
	 * @param date
	 */
	public UserBoardTableVO(String content, String no, String id,
			String nickname, String date) {
		super();
		this.content = new SimpleStringProperty (content);
		this.no = new SimpleStringProperty (no);
		this.id = new SimpleStringProperty (id);
		this.nickname = new SimpleStringProperty (nickname);
		this.date = new SimpleStringProperty (date);
	}

	
}

