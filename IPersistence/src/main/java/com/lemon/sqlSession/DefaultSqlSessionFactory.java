package com.lemon.sqlSession;

import com.lemon.pojo.Configuration;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 3:19 下午
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
