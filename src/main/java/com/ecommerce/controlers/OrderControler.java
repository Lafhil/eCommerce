package com.ecommerce.controlers;

import com.ecommerce.controlers.Interface.GenericController;
import com.ecommerce.entities.Orders;
import com.ecommerce.services.impl.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderControler extends GenericController<Orders, Integer,OrderService> {

/*
    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders(){
        return orderService.getAll();
    }*/
}
