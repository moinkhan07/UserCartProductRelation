package com.cart.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long cartId;

	  @OneToOne
	  @JoinColumn(name = "user_id")
	  private Users user;

	  @OneToMany(mappedBy = "shoppingCart")
	  private List<CartItem> cartItems = new ArrayList<>();
}