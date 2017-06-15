package com.thoughtworks.springcloud.sample.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@SpringBootApplication
public class SampleApplication {

	@GetMapping(path = "categories")
    public List<Category> getCategories() {
		return Arrays.asList(new Category("1", "A"), new Category("2", "B"),
			new Category("3", "C"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}
}
