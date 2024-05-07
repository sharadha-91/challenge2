package com.app.challenge_2.response;

import com.app.challenge_2.model.Product;

public class ProductResponse {
	
	private Product product;
	private ResponseStatus responseStatus;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	

}
