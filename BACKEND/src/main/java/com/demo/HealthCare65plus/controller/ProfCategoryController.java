package com.demo.HealthCare65plus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.HealthCare65plus.beans.ProfCategory;
import com.demo.HealthCare65plus.service.ProfCategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categories")
public class ProfCategoryController {

	@Autowired
	ProfCategoryService categoryService;


    @PostMapping("/addCat")
    public ResponseEntity<ProfCategory> createCategory(@RequestBody ProfCategory category)
    {
        ProfCategory createdCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ProfCategory> getCategoryById(@PathVariable int categoryId) {
        ProfCategory category = categoryService.getCategoryById(categoryId);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getallCat")
    public ResponseEntity<List<ProfCategory>> getAllCategories() {
        List<ProfCategory> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable int categoryId, @RequestBody ProfCategory category) {
        category.setCatId(categoryId);
        boolean updated = categoryService.updateCategory(category);
        if (updated) {
            return ResponseEntity.ok("Category updated successfully: " + category);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable int categoryId) {
        boolean deleted = categoryService.deleteCategory(categoryId);
        if (deleted) {
            return ResponseEntity.ok("Category deleted successfully: " + categoryId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
