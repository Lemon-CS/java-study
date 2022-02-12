package com.lemon.dao;

import com.lemon.io.Resources;
import com.lemon.pojo.User;
import com.lemon.sqlSession.SqlSession;
import com.lemon.sqlSession.SqlSessionFactory;
import com.lemon.sqlSession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 5:25 下午
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public List<User> findAll() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users = sqlSession.selectList("user.selectList");
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    @Override
    public User findByCondition(User user) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 调用
        User result = sqlSession.selectOne("user.selectOne", user);

        System.out.println(result);

        return result;

    }
}
