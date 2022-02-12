package com.lemon.test;

import com.lemon.io.Resources;
import com.lemon.pojo.User;
import com.lemon.sqlSession.SqlSession;
import com.lemon.sqlSession.SqlSessionFactory;
import com.lemon.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description: IPersistenceTest
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 2:20 下午
 */
public class IPersistenceTest {

    public void test() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 调用
        //调用
        User user = new User();
        user.setId(1);
        user.setUsername("tom");
        User user2 = sqlSession.selectOne("user.selectOne", user);

        System.out.println(user2);

        List<User> users = sqlSession.selectList("user.selectList");
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

}
