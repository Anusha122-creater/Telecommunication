package com.Telecommunication.service;

import com.Telecommunication.entity.Inventory;

import java.util.List;

public interface InventoryService {

    // Method to get all inventory
    List<Inventory> getAllInventory();
    
    // Method to get inventory by its ID
    Inventory getInventoryById(Integer inventoryId);
    
    // Method to create a new inventory
    void createInventory(Inventory inventory);
    
    // Method to update an existing inventory
    void updateInventory(Inventory inventory);
    
    // Method to delete inventory by its ID
    void deleteInventory(Integer inventoryId);
}
