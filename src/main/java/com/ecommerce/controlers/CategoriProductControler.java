package com.ecommerce.controlers;

import com.ecommerce.controlers.Interface.GenericController;
import com.ecommerce.entities.ProductCategories;
import com.ecommerce.services.impl.ProductCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categoriProduct")
public class CategoriProductControler extends GenericController<ProductCategories,Integer,ProductCategoryService> {

}
