package com.cart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.Model.Product;
import com.cart.Repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product getProductById(Long productId) {
		return productRepo.findById(productId).orElse(null);
	}

}