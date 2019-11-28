 /**
 * @Class Name : UserBoardDomain.java
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
package com.limitless.userboard1;

import com.limitless.cmn.DTO;

/**
 * @author 박지윤
 *
 */
public class UserBoardVO extends DTO {

		
		/**게시글내용*/
		private String content;
		
		/**이메일*/
		private String id;
		
		/**닉네임*/
		private String nickname;
		
		/**게시일자*/
		private String date;
		
		
		public UserBoardVO(){
			
		}

		
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((content == null) ? 0 : content.hashCode());
			result = prime * result + ((date == null) ? 0 : date.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
			return result;
		}


		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			UserBoardVO other = (UserBoardVO) obj;
			if (content == null) {
				if (other.content != null)
					return false;
			} else if (!content.equals(other.content))
				return false;
			if (date == null) {
				if (other.date != null)
					return false;
			} else if (!date.equals(other.date))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (nickname == null) {
				if (other.nickname != null)
					return false;
			} else if (!nickname.equals(other.nickname))
				return false;
			return true;
		}


		/**
		 * @param content
		 * @param id
		 * @param nickname
		 * @param date
		 */
		public UserBoardVO(String content, String id, String nickname, String date) {
			super();
			this.content = content;
			this.id = id;
			this.nickname = nickname;
			this.date = date;
		}


		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "UserBoardVO [content=" + content + ", id=" + id + ", nickname=" + nickname + ", date=" + date + "]";
		}


		/**
		 * @return the content
		 */
		public String getContent() {
			return content;
		}


		/**
		 * @param content the content to set
		 */
		public void setContent(String content) {
			this.content = content;
		}


		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}


		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}


		/**
		 * @return the nickname
		 */
		public String getNickname() {
			return nickname;
		}


		/**
		 * @param nickname the nickname to set
		 */
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}


		/**
		 * @return the date
		 */
		public String getDate() {
			return date;
		}


		/**
		 * @param date the date to set
		 */
		public void setDate(String date) {
			this.date = date;
		}


		public static UserBoardVO get(int i) {
			// TODO Auto-generated method stub
			return null;
		}

}