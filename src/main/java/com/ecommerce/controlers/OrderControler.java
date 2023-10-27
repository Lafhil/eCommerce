package com.ecommerce.controlers;

import com.ecommerce.controlers.Interface.GenericController;
import com.ecommerce.entities.Order;
import com.ecommerce.services.impl.OrderService;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderControler extends GenericController<Order, Integer> {

/*
    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders(){
        return orderService.getAll();
    }*/
}
