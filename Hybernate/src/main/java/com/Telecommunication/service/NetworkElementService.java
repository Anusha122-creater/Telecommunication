package com.Telecommunication.service;

import com.Telecommunication.entity.NetworkElement;

import java.util.List;

public interface NetworkElementService {

    // Method to get all network elements
    List<NetworkElement> getAllNetworkElements();
    
    // Method to get a network element by its ID
    NetworkElement getNetworkElementById(Integer networkElementId);
    
    // Method to create a new network element
    void createNetworkElement(NetworkElement networkElement);
    
    // Method to update an existing network element
    void updateNetworkElement(NetworkElement networkElement);
    
    // Method to delete a network element by its ID
    void deleteNetworkElement(Integer networkElementId);
}

