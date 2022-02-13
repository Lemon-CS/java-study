package com.lemon.test;

import com.lemon.mapper.IOrderMapper;
import com.lemon.mapper.IUserMapper;
import com.lemon.pojo.Order;
import com.lemon.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月13日 2:44 下午
 */
public class MybatisTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IOrderMapper orderMapper = sqlSession.getMapper(IOrderMapper.class);
        List<Order> orderAndUser = orderMapper.findOrderAndUser();
        for (Order order : orderAndUser) {
            System.out.println(order.toString());
        }
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        List<User> allUserAndRole = mapper.findAllUserAndRole();
        for (User user : allUserAndRole) {
            System.out.println(user);
        }
    }

    private IUserMapper userMapper;
    private IOrderMapper orderMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(IUserMapper.class);
        orderMapper = sqlSession.getMapper(IOrderMapper.class);
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setId(3);
        user.setUsername("testName");
        user.setPassword("123");
        user.setBirthday(new Date());

        userMapper.addUser(user);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(3);
        user.setUsername("updateTestName");

        userMapper.updateUser(user);

    }

    @Test
    public void selectUser(){
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void deleteUser(){
        userMapper.deleteUser(3);
    }


    @Test
    public void oneToOne(){
        List<Order> orderAndUser = orderMapper.findOrderAndUser();
        for (Order order : orderAndUser) {
            System.out.println(order);
        }

    }

}
