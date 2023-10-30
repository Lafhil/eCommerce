package com.ecommerce.services.impl;

import com.ecommerce.entities.Administrators;
import com.ecommerce.repository.AdministratorRepository;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.stereotype.Service;

@Service("dministratorServive")
public class AdministratorService extends MannageServiceImpl<Administrators,Integer, AdministratorRepository> {
}
