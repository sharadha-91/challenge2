package com.app.challenge_2.webclient;

import com.app.challenge_2.dto.FakeStoreProductDto;
import com.app.challenge_2.exception.ProductNotFoundException;
import com.app.challenge_2.model.Category;
import com.app.challenge_2.model.Product;
import com.app.challenge_2.service.ProductService;

import reactor.core.publisher.Flux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
//Actual Fakestore needs DB, here Fakestore needs 2 implementations 1.Fakestore 2.connect to db

@Service("webfakestore")
public class FakeStoreProductServiceWebClient implements ProductService {
	
	private WebClient webclient;
	
	@Autowired
    public FakeStoreProductServiceWebClient(WebClient webclient) {
    	this.webclient = webclient;
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
	public Product getProductById(long id) throws ProductNotFoundException {
		//getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class)
		FakeStoreProductDto fakeproduct =	this.webclient
				               						   .get()
				                                       .uri("https://fakestoreapi.com/products/"+id)
				                                       .retrieve()
				                                       .bodyToMono(FakeStoreProductDto.class)
				                                       .block() ;
		if(fakeproduct== null) {
			throw new ProductNotFoundException("Id does not exist");
		}
	      return convertFakeStoreObjectToProduct(fakeproduct);
	}

	@Override
	public List<Product> getAllProducts() {
//		WebClient client = WebClient.create("https://fakestoreapi.com/products/");
//		Flux<FakeStoreProductDto> flux= client
//				.get()
//				.uri("/allproducts")
//				.retrieve()
//				.bodyToFlux(FakeStoreProductDto.class);
//		flux.doOnNext(System.out::println).blockLast();
//		return flux;
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
