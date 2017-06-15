package com.thoughtworks.springcloud.sample.bff.category;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "service-product", fallback = CategoryFallback.class)
interface CategoryClient {
    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    List<CategoryDto> getCategories();
}
