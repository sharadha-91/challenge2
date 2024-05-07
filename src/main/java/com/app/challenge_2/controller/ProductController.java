package com.app.challenge_2.controller;

import com.app.challenge_2.dto.ProductRequestDTO;
import com.app.challenge_2.exception.ProductNotFoundException;
import com.app.challenge_2.model.Product;
import com.app.challenge_2.response.ProductResponse;
import com.app.challenge_2.response.ResponseStatus;
import com.app.challenge_2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired  
    public ProductController(@Qualifier("webfakestore")ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable("id") long id)throws ProductNotFoundException{
    	ProductResponse response = new ProductResponse();
    	try {
    		Product pro =this.productService.getProductById(id);
    		response.setProduct(pro);
    		response.setResponseStatus(ResponseStatus.SUCCESS);
    	}catch(Exception e) {
    		e.getStackTrace();
    		response.setResponseStatus(ResponseStatus.FAILURE);
    	}
      return response ;
    }

    @GetMapping("/allproducts")
    public List<Product> getAllProducts(){    	   	
    		return this.productService.getAllProducts();    	 
    }
    
    @PostMapping("/save")
    public Product createProduct(@RequestBody ProductRequestDTO requestDto){
        // validate the data
       String title =requestDto.getTitle();
       String desc = requestDto.getDescription();
       double price = requestDto.getPrice();
       String image = requestDto.getImage();
       String categoryname = requestDto.getCategoryName();

        return productService.createProduct(title, desc,price,image,categoryname);
    }

}
