package com.Telecommunication.service;

import java.util.List;

import com.Telecommunication.entity.Call;

public interface CallService {

    List<Call> getAllCalls();
    
    Call getCallById(Integer callId);
    
    void createCall(Call call);
    
    void updateCall(Call call);
    
    void deleteCall(Integer callId);
}
