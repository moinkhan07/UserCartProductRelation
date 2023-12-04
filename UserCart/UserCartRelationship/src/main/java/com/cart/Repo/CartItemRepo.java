package com.cart.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.Model.CartItem;
import com.cart.Model.Product;
import com.cart.Model.ShoppingCart;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long>{
	
	Optional<CartItem> findByShoppingCartAndProduct(ShoppingCart shoppingCart, Product product);

}