package com.demo.HealthCare65plus.service;

import java.util.List;

import com.demo.HealthCare65plus.beans.ProfCategory;

public interface ProfCategoryService {

	ProfCategory getCategoryById(int categoryId);

	ProfCategory createCategory(ProfCategory category);

	List<ProfCategory> getAllCategories();

	boolean updateCategory(ProfCategory category);

	boolean deleteCategory(int categoryId);

}
