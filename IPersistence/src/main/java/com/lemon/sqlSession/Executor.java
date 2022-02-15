package com.lemon.sqlSession;

import com.lemon.pojo.Configuration;
import com.lemon.pojo.MappedStatement;

import java.util.List;

/**
 * @Description: Executor
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 3:44 下午
 */
public interface Executor {

    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;

    public Integer update(Configuration configuration, MappedStatement mappedStatement, Object[] params) throws Exception;

    public Integer delete(Configuration configuration, MappedStatement mappedStatement, Object[] params) throws Exception;

}
