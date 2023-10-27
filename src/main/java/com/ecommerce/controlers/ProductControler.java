package com.ecommerce.controlers;

import com.ecommerce.controlers.Interface.GenericController;
import com.ecommerce.entities.Order;
import com.ecommerce.entities.Product;
import com.ecommerce.services.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductControler extends GenericController<Order,Integer> {

}
