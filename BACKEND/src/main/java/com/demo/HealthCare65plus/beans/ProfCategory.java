package com.demo.HealthCare65plus.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProfCategory {
	@Id
	private int catId;
	private String category;
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	
	private List<HealthProfessional> professions;
	
	public ProfCategory(int catId, String category) {
		super();
		this.catId = catId;
		this.category = category;
	}
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
