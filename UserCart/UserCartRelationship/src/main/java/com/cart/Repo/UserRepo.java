package com.cart.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.Model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long>{

}