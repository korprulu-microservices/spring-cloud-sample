package com.thoughtworks.springcloud.sample.bff.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryApi {
    @Autowired
    private CategoryClient categoryClient;

    @GetMapping(path="categories")
    public List<String> getCategories() {
        return categoryClient.getCategories()
            .stream()
            .map(CategoryDto::getName)
            .collect(Collectors.toList());
    }
}
