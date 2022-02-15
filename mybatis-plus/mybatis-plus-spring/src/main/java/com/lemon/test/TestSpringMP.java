package com.lemon.test;

import com.lemon.mapper.UserMapper;
import com.lemon.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Description: TestSpringMP
 * @Author : Lemon-CS
 * @Date : 2022年02月15日 9:52 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpringMP {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {

        List<User> userList = userMapper.selectList(null);

        for (User user : userList) {
            System.out.println(user);
        }
    }

}
