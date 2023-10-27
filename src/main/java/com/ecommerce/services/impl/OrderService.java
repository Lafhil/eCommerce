package com.ecommerce.services.impl;

import com.ecommerce.entities.Order;
import com.ecommerce.repository.OrderRepo;
import com.ecommerce.services.interfaces.ManageServices;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Primary
@Service("orderServive")
public class OrderService extends MannageServiceImpl<Order,Integer> {

}
