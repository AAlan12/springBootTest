package com.example.springboottutorial;

import com.example.springboottutorial.entities.Category;
import com.example.springboottutorial.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootTutorialApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World")String name){
		return String.format("Hello %s!",name);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(1L,"Electronics");
		Category cat2 = new Category(2L,"Books");
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
	}
}
