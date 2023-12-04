package com.cart.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.Model.CartItem;
import com.cart.Model.Product;
import com.cart.Model.ShoppingCart;
import com.cart.Model.Users;
import com.cart.Repo.CartItemRepo;
import com.cart.Repo.ShoppingCartRepo;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	 @Autowired
	 private CartItemRepo cartItemRepo;
	 
	 @Autowired
	 private ShoppingCartRepo shoppingCartRepo;

	@Override
    public void addProductToCart(Users user, Product product, Integer quantity) {
		        // Assume user has a cart (one-to-one relationship)
		        ShoppingCart cart = user.getShoppingCart();

		        // Check if the cart exists, create one if not
		        if (cart == null) {
		            cart = new ShoppingCart();
		            cart.setUser(user);
		            shoppingCartRepo.save(cart);
		            user.setShoppingCart(cart);
		        }

		        // Check if the product is already in the cart, update quantity if it is
		        Optional<CartItem> existingCartItem = cartItemRepo.findByShoppingCartAndProduct(cart, product);
		        if (existingCartItem.isPresent()) {
		            CartItem cartItem = existingCartItem.get();
		            cartItem.setQuantity(cartItem.getQuantity() + quantity);
		            cartItemRepo.save(cartItem);
		        } else {
		            // Create a new cart item and add it to the cart
		            CartItem cartItem = new CartItem();
		            cartItem.setShoppingCart(cart);
		            cartItem.setProduct(product);
		            cartItem.setQuantity(quantity);
		            cartItemRepo.save(cartItem);
		        }
		    }
	}