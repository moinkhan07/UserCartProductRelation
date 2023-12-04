package com.cart.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem { // DELETE FROM cart_item WHERE cart_id = 1 AND product_id = 1;
	    
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long cartItemId;

	 @ManyToOne
	 @JoinColumn(name = "cart_id")
     private ShoppingCart shoppingCart;

     @ManyToOne
     @JoinColumn(name = "product_id")
	 private Product product;

	 private int quantity;
}
