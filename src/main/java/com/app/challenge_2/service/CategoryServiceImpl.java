package com.app.challenge_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.challenge_2.model.Category;
import com.app.challenge_2.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository =categoryRepository;
	}
	
	@Override
	public Category createCategory(String categoryName) {
		Category category = new Category();
		category.setCategoryName(categoryName);
		return categoryRepository.save(category);
		
	}
	

}
