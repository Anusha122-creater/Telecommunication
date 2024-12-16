package com.Telecommunication.service;

import com.Telecommunication.entity.Message;

import java.util.List;

public interface MessageService {

    // Method to get all messages
    List<Message> getAllMessages();
    
    // Method to get a message by its ID
    Message getMessageById(Integer messageId);
    
    // Method to create a new message
    void createMessage(Message message);
    
    // Method to update an existing message
    void updateMessage(Message message);
    
    // Method to delete a message by its ID
    void deleteMessage(Integer messageId);
}

