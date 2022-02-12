package com.lemon.test;

import com.lemon.dao.IUserDao;
import com.lemon.io.Resources;
import com.lemon.pojo.User;
import com.lemon.sqlSession.SqlSession;
import com.lemon.sqlSession.SqlSessionFactory;
import com.lemon.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.*;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description: IPersistenceTest
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 2:20 下午
 */
public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 调用
        User user = new User();
        user.setId(2);
        user.setUsername("tom");
        /*User user2 = sqlSession.selectOne("user.selectOne", user);

        System.out.println(user2);

        List<User> users = sqlSession.selectList("user.selectList");
        for (User user1 : users) {
            System.out.println(user1);
        }*/
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user1 = userDao.findByCondition(user);
        System.out.println(user1);

        List<User> all = userDao.findAll();
        System.out.println(all);

    }

}


