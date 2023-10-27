package com.ecommerce.services.impl;

import com.ecommerce.entities.Inventory;
import com.ecommerce.services.interfaces.MannageServiceImpl;
import org.springframework.stereotype.Service;

@Service("inventoryService")
public class InventoryService extends MannageServiceImpl<Inventory,Integer> {
}
