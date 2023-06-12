package com.demo.HealthCare65plus.service;

import java.util.List;
import com.demo.HealthCare65plus.beans.ProfCategory;
import com.demo.HealthCare65plus.dao.ProfCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfCategoryServiceImpl implements ProfCategoryService {

    private final ProfCategoryDao categoryDao;

    @Autowired
    public ProfCategoryServiceImpl(ProfCategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public ProfCategory getCategoryById(int categoryId) {
        return categoryDao.findById(categoryId).orElse(null);
    }

    @Override
    public ProfCategory createCategory(ProfCategory category) {
        return categoryDao.save(category);
    }

    @Override
    public List<ProfCategory> getAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public boolean updateCategory(ProfCategory category) {
        if (categoryDao.existsById(category.getCatId())) {
            categoryDao.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCategory(int categoryId) {
        if (categoryDao.existsById(categoryId)) {
            categoryDao.deleteById(categoryId);
            return true;
        }
        return false;
    }
}
