package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoPaU4GcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4GcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		() -> {
//			System.out.println("Hola mundo");
//		}
		System.out.println("Hola");
	}
}
