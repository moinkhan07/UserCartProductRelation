package com.cart.Service;

import com.cart.Model.Product;

public interface ProductService {
	
	public Product addProduct(Product product);

	public Product getProductById(Long productId);

}
