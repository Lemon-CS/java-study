package com.lagou.rpc.consumer;

import com.lagou.rpc.api.IUserService;
import com.lagou.rpc.consumer.proxy.RpcClientProxy;
import com.lagou.rpc.pojo.User;

/**
 * @Description: 测试类
 * @Author : Lemon-CS
 * @Date : 2022年03月08日 4:18 下午
 */
public class ClientBootStrap {

    public static void main(String[] args) {
        IUserService userService = (IUserService) RpcClientProxy.createProxy(IUserService.class);
        User user = userService.getById(2);
        System.out.println(user);
    }

}
