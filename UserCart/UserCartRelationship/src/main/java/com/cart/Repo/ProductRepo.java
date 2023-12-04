package com.cart.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
