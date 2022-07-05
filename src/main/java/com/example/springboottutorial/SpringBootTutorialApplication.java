package com.example.springboottutorial;

import com.example.springboottutorial.entities.Category;
import com.example.springboottutorial.entities.Product;
import com.example.springboottutorial.repositories.CategoryRepository;
import com.example.springboottutorial.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class SpringBootTutorialApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World")String name){
		return String.format("Hello %s!",name);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null,"Electronics");
		Category cat2 = new Category(null,"Books");

		Product p1 = new Product(null,"TV",2200.00,cat1);
		Product p2 = new Product(null,"Driven Design",120.00,cat2);
		Product p3 = new Product(null,"PS5",2800.00,cat1);
		Product p4 = new Product(null,"Docker",100.00,cat2);

		cat1.getProducts().addAll(Arrays.asList(p1,p3));
		cat2.getProducts().addAll(Arrays.asList(p2,p4));

		categoryRepository.save(cat1);
		categoryRepository.save(cat2);

		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
	}
}
