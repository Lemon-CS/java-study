package com.lagou.edu.service;

/**
 * @author Lemon-CS
 */
public interface TransferService {

    void transfer(String fromCardNo,String toCardNo,int money) throws Exception;
}
