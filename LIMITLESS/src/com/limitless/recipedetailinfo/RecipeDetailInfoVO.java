package com.limitless.recipedetailinfo;

import com.limitless.cmn.DTO;

public class RecipeDetailInfoVO extends DTO{
	private String reNo;
	private String reName;
	private String reImage;
	private String reFood;
	private String reCook01;
	private String reCook02;
	private String reCook03;
	private String reCook04;
	
	
	public RecipeDetailInfoVO(){
		
	}
	
	/**
	 * @param reNo
	 * @param reName
	 * @param reImage
	 * @param reFood
	 * @param reCook01
	 * @param reCook02
	 * @param reCook03
	 * @param reCook04
	 */
	public RecipeDetailInfoVO(String reNo, String reName, String reImage, String reFood, String reCook01,
			String reCook02, String reCook03, String reCook04) {
		super();
		this.reNo = reNo;
		this.reName = reName;
		this.reImage = reImage;
		this.reFood = reFood;
		this.reCook01 = reCook01;
		this.reCook02 = reCook02;
		this.reCook03 = reCook03;
		this.reCook04 = reCook04;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RecipeDetailInfoVO [reNo=" + reNo + ", reName=" + reName + ", reImage=" + reImage + ", reFood=" + reFood
				+ ", reCook01=" + reCook01 + ", reCook02=" + reCook02 + ", reCook03=" + reCook03 + ", reCook04="
				+ reCook04 + "]";
	}

	/**
	 * @return the reNo
	 */
	public String getReNo() {
		return reNo;
	}
	/**
	 * @param reNo the reNo to set
	 */
	public void setReNo(String reNo) {
		this.reNo = reNo;
	}
	/**
	 * @return the reName
	 */
	public String getReName() {
		return reName;
	}
	/**
	 * @param reName the reName to set
	 */
	public void setReName(String reName) {
		this.reName = reName;
	}
	/**
	 * @return the reImage
	 */
	public String getReImage() {
		return reImage;
	}
	/**
	 * @param reImage the reImage to set
	 */
	public void setReImage(String reImage) {
		this.reImage = reImage;
	}
	/**
	 * @return the reFood
	 */
	public String getReFood() {
		return reFood;
	}
	/**
	 * @param reFood the reFood to set
	 */
	public void setReFood(String reFood) {
		this.reFood = reFood;
	}
	/**
	 * @return the reCook01
	 */
	public String getReCook01() {
		return reCook01;
	}
	/**
	 * @param reCook01 the reCook01 to set
	 */
	public void setReCook01(String reCook01) {
		this.reCook01 = reCook01;
	}
	/**
	 * @return the reCook02
	 */
	public String getReCook02() {
		return reCook02;
	}
	/**
	 * @param reCook02 the reCook02 to set
	 */
	public void setReCook02(String reCook02) {
		this.reCook02 = reCook02;
	}
	/**
	 * @return the reCook03
	 */
	public String getReCook03() {
		return reCook03;
	}
	/**
	 * @param reCook03 the reCook03 to set
	 */
	public void setReCook03(String reCook03) {
		this.reCook03 = reCook03;
	}
	/**
	 * @return the reCook04
	 */
	public String getReCook04() {
		return reCook04;
	}
	/**
	 * @param reCook04 the reCook04 to set
	 */
	public void setReCook04(String reCook04) {
		this.reCook04 = reCook04;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reCook01 == null) ? 0 : reCook01.hashCode());
		result = prime * result + ((reCook02 == null) ? 0 : reCook02.hashCode());
		result = prime * result + ((reCook03 == null) ? 0 : reCook03.hashCode());
		result = prime * result + ((reCook04 == null) ? 0 : reCook04.hashCode());
		result = prime * result + ((reFood == null) ? 0 : reFood.hashCode());
		result = prime * result + ((reImage == null) ? 0 : reImage.hashCode());
		result = prime * result + ((reName == null) ? 0 : reName.hashCode());
		result = prime * result + ((reNo == null) ? 0 : reNo.hashCode());
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
		RecipeDetailInfoVO other = (RecipeDetailInfoVO) obj;
		if (reCook01 == null) {
			if (other.reCook01 != null)
				return false;
		} else if (!reCook01.equals(other.reCook01))
			return false;
		if (reCook02 == null) {
			if (other.reCook02 != null)
				return false;
		} else if (!reCook02.equals(other.reCook02))
			return false;
		if (reCook03 == null) {
			if (other.reCook03 != null)
				return false;
		} else if (!reCook03.equals(other.reCook03))
			return false;
		if (reCook04 == null) {
			if (other.reCook04 != null)
				return false;
		} else if (!reCook04.equals(other.reCook04))
			return false;
		if (reFood == null) {
			if (other.reFood != null)
				return false;
		} else if (!reFood.equals(other.reFood))
			return false;
		if (reImage == null) {
			if (other.reImage != null)
				return false;
		} else if (!reImage.equals(other.reImage))
			return false;
		if (reName == null) {
			if (other.reName != null)
				return false;
		} else if (!reName.equals(other.reName))
			return false;
		if (reNo == null) {
			if (other.reNo != null)
				return false;
		} else if (!reNo.equals(other.reNo))
			return false;
		return true;
	}
	
	
	
	
}
