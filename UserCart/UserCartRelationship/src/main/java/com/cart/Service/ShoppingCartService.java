package com.cart.Service;

import com.cart.Model.Product;
import com.cart.Model.Users;

public interface ShoppingCartService {
	
	public void addProductToCart(Users users,Product product,Integer quantity);

}
