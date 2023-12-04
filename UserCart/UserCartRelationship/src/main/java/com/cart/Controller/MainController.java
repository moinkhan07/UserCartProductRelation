package com.cart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cart.Model.Product;
import com.cart.Model.Users;
import com.cart.Service.ProductService;
import com.cart.Service.ShoppingCartService;
import com.cart.Service.UsersService;

@RestController
public class MainController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	 @PostMapping("/users")
	 public ResponseEntity<Users> registerUser(@RequestBody Users user) {
	      Users registeredUser = usersService.registerUser(user);
	      return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
	 }
	 
	 @PostMapping("/products")
	 public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	     Product addedProduct = productService.addProduct(product);
	     return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
	 }
	 
	 @PostMapping("/addtocart")
	 public ResponseEntity<String> addProductToCart(
	 @RequestParam Long userId,
     @RequestParam Long productId,
	 @RequestParam int quantity) {

	 Users user = usersService.getUserById(userId);
	 Product product = productService.getProductById(productId);

	 if (user == null || product == null) {
	     return new ResponseEntity<>("Invalid user or product", HttpStatus.BAD_REQUEST);
	 }

	 shoppingCartService.addProductToCart(user, product, quantity);
	      return new ResponseEntity<>("Product added to cart successfully", HttpStatus.OK);
	 }

}
