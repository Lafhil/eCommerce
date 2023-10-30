package com.ecommerce.services.impl;

import com.ecommerce.entities.Orders;
import com.ecommerce.repository.OrderRepo;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.stereotype.Service;

@Service("orderServive")
public class OrderService extends MannageServiceImpl<Orders,Integer,OrderRepo> {

}
