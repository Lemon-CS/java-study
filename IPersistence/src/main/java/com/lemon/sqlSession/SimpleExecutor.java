package com.lemon.sqlSession;

import com.lemon.pojo.Configuration;
import com.lemon.pojo.MappedStatement;

import java.util.List;

/**
 * @Description: SimpleExecutor
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 3:47 下午
 */
public class SimpleExecutor implements Executor {
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception {
        return null;
    }
}
