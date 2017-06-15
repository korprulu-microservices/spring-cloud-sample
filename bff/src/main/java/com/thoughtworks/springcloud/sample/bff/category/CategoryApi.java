package com.thoughtworks.springcloud.sample.bff.category;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryApi {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path="categories")
    @HystrixCommand(fallbackMethod = "getCategoriesFallback")
    public List<String> getCategories() {
        return Arrays.stream(restTemplate.getForObject("http://service-product/categories", CategoryDto[].class))
            .map(CategoryDto::getName)
            .collect(Collectors.toList());
    }

    public List<String> getCategoriesFallback() {
        return Arrays.asList("fallback");
    }
}
