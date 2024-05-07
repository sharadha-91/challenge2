package com.app.challenge_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.challenge_2.exception.ProductNotFoundException;
import com.app.challenge_2.model.Category;
import com.app.challenge_2.model.Product;
import com.app.challenge_2.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	private CategoryService categoryService;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
		this.categoryService = categoryService;
		this.productRepository = productRepository;
	}
	
	@Override
	public Product createProduct(String title, String description, double price, String image, String categoryName) {
		Category category = categoryService.createCategory(categoryName);
		Product product = new Product();
		product.setTitle(title);
		product.setDescription(description);
		product.setPrice(price);
		product.setImage(image);
		product.setCategory(category);
		
		return productRepository.save(product);
		
	}

	@Override
	public Product getProductById(long id) {		
		return null;	
	}

	@Override
	public List<Product> getAllProducts() {
		return null;
	}

	@Override
	public Product updatePrice(long productId, float price) throws ProductNotFoundException {
	         Optional<Product> option = productRepository.findById(productId);
	        
				if(option.isEmpty()) {
					 throw new ProductNotFoundException("Product Id does not exits");
			    }else {
			    	Product pro =option.get();
			    	pro.setPrice(price);
			    	return productRepository.save(pro);
			    }
			
		
	}

	@Override
	public Product updateImage(long productId, String image) {
		return null;
	}

	@Override
	public boolean deleteProduct() {
		return false;
	}
	

}
