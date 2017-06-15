package com.thoughtworks.springcloud.sample.bff.category;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryFallback implements CategoryClient {
    @Override
    public List<CategoryDto> getCategories() {
        return Arrays.asList(new CategoryDto("fake-id", "fallback"));
    }
}
