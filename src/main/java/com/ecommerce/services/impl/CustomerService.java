package com.ecommerce.services.impl;

import com.ecommerce.entities.Customer;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService extends MannageServiceImpl<Customer,Integer> {
}
