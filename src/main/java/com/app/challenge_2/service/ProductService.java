package com.app.challenge_2.service;

import com.app.challenge_2.exception.ProductNotFoundException;
import com.app.challenge_2.model.Product;

import java.util.List;

public interface ProductService {

	public Product createProduct(String title, String description, double price,String image,String categoryName);
    public Product getProductById(long id) throws ProductNotFoundException;
    public List<Product> getAllProducts();
    public Product updatePrice(long productId, float price) throws ProductNotFoundException;
    public Product updateImage(long productId,String image);
    public boolean deleteProduct();
    
}
