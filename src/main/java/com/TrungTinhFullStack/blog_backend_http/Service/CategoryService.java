package com.TrungTinhFullStack.blog_backend_http.Service;

import com.TrungTinhFullStack.blog_backend_http.Entity.Category;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public interface CategoryService {

    List<Category> getAllCategory();
    Category createCategory(Category category);
    Category getCategoryById(Long id);
    Category updateCategory(Long id,Category category);
    Category deleteCategory(Long id);
}
