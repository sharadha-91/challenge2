package com.app.challenge_2.service;

import com.app.challenge_2.dto.FakeStoreProductDto;
import com.app.challenge_2.exception.ProductNotFoundException;
import com.app.challenge_2.model.Category;
import com.app.challenge_2.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
//Actual Fakestore needs DB, here Fakestore needs 2 implementations 1.Fakestore 2.connect to db

@Service("fakestore")
public class FakeStoreProductServiceImpl implements ProductService {
	
	private RestTemplate restTemplate;
	
	@Autowired
    public FakeStoreProductServiceImpl(RestTemplate restTemplate) {
    	this.restTemplate = restTemplate;
    }
	
	private Product convertFakeStoreObjectToProduct(FakeStoreProductDto fakeProduct) {
		Product prod = new Product();
		prod.setId(fakeProduct.getId());
		prod.setTitle(fakeProduct.getTitle());
		prod.setPrice(fakeProduct.getPrice());
		prod.setDescription(fakeProduct.getDescription());
		prod.setImage(fakeProduct.getImage());
		
		Category category = new Category();
		prod.setCategory(category);
		return prod;
	}
	
	@Override
	public Product createProduct(String title, String description, double price, String image, String categoryName) {		
		return null;
	}

	@Override
	public Product getProductById(long id) {
		FakeStoreProductDto fakeproduct =	restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
	      return convertFakeStoreObjectToProduct(fakeproduct);
	}

	@Override
	public List<Product> getAllProducts() {
		return null;
	}

	@Override
	public Product updatePrice(long productId, float price) throws ProductNotFoundException {
		return null;
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
