package com.fangpeng.globalid;

import redis.clients.jedis.Jedis;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年03月03日 10:45 下午
 */
public class RedisGenerator {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        for (int i = 0; i < 100; i++) {
            Long id = jedis.incr("id");//<id,0>
            System.out.println(id);
        }
    }

}
