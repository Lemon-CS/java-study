package com.lemon.sqlSession;

/**
 * @Description: SqlSessionFactory
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 2:40 下午
 */
public interface SqlSessionFactory {

    public SqlSession openSession();

}