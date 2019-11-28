package com.limitless.recipebookmark;

import com.limitless.cmn.DTO;

public class RecipeBookmarkVO extends DTO {

	private String id;
	private String recipe;
	/**
	 * @param id
	 * @param recipe
	 */
	public RecipeBookmarkVO(){}
	
	public RecipeBookmarkVO(String id, String recipe) {
		super();
		this.id = id;
		this.recipe = recipe;
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
	 * @return the recipe
	 */
	public String getRecipe() {
		return recipe;
	}
	/**
	 * @param recipe the recipe to set
	 */
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
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
		RecipeBookmarkVO other = (RecipeBookmarkVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RecipeBookmarkVO [id=" + id + ", recipe=" + recipe + "]";
	}
	
}
