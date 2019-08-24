package com.adrak.foodie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
//@Controller("com.adrak.foodie.controllers")
public class FoodieApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodieApisApplication.class, args);
	}

}
