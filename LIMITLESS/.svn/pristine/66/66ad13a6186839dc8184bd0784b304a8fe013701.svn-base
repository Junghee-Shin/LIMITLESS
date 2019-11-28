package com.limitless.recipebookmark;

import com.limitless.cmn.DTO;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RecipeBookmarkPropertyVO extends DTO {

	private SimpleStringProperty id;
	private SimpleStringProperty  recipe;
	/**
	 * @param id
	 * @param recipe
	 */
	public RecipeBookmarkPropertyVO(){
		id=new SimpleStringProperty();
		recipe =new SimpleStringProperty();		
		
		
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
	 * @return the recipe
	 */
	public String getRecipe() {
		return recipe.get();
	}
	/**
	 * @param recipe the recipe to set
	 */
	public void setRecipe(String recipe) {
		this.recipe.set(recipe);
	}
	/**
	 * @param id
	 * @param recipe
	 */
	public RecipeBookmarkPropertyVO(String id, String recipe) {
		super();
		this.id=new SimpleStringProperty(id);
		this.recipe = new SimpleStringProperty(recipe);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RecipeBookmarkPropertyVO [id=" + id + ", recipe=" + recipe + "]";
	}
	
	
	
}
