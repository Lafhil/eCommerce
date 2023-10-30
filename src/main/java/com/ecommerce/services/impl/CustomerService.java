package com.ecommerce.services.impl;

import com.ecommerce.entities.Customers;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService extends MannageServiceImpl<Customers,Integer, CustomerRepository> {
}
