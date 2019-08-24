package com.adrak.foodie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrak.foodie.entity.UserExtension;

@Repository
public interface UserExtensionRepository extends CrudRepository<UserExtension, Long>{

}
