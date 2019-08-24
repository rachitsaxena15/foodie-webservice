package com.adrak.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrak.foodie.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
