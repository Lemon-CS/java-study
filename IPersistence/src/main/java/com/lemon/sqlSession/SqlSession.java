package com.lemon.sqlSession;

import java.util.List;

/**
 * @Description: SqlSession
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 3:21 下午
 */
public interface SqlSession {

    //查询所有
    public <E> List<E> selectList(String statementId, Object... params) throws Exception;

    //根据条件查询单个
    public <T> T selectOne(String statementId, Object... params) throws Exception;

    //根据条件进行修改
    public Integer update(String statementId, Object... params) throws Exception;

    //根据条件进行删除
    public Integer delete(String statementId, Object... params) throws Exception;

    //为Dao接口生成代理实现类
    public <T> T getMapper(Class<?> mapperClass);

}
