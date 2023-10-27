package com.ecommerce.controlers;

import com.ecommerce.entities.ProductCategory;
import com.ecommerce.services.impl.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categoriProduct")
public class CategoriProductControler {
    @Autowired
    private ProductCategoryService productCategoryService;
    @GetMapping("/getAllCategories")
    public ResponseEntity<List<ProductCategory>> getAllCategories(){
        return ResponseEntity.ok(productCategoryService.getAll());
    }
}
