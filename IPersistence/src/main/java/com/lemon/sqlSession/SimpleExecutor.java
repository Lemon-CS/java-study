package com.lemon.sqlSession;

import com.lemon.config.BoundSql;
import com.lemon.pojo.Configuration;
import com.lemon.pojo.MappedStatement;
import com.lemon.utils.GenericTokenParser;
import com.lemon.utils.ParameterMapping;
import com.lemon.utils.ParameterMappingTokenHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @Description: SimpleExecutor
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 3:47 下午
 */
public class SimpleExecutor implements Executor {
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception {

        // 1. 注册驱动，获取连接
        Connection connection = configuration.getDataSource().getConnection();

        // 2. 获取sql语句 : select * from user where id = #{id} and username = #{username}
        // 转换sql语句： select * from user where id = ? and username = ? ，转换的过程中，还需要对#{}里面的值进行解析存储
        String sql = mappedStatement.getSql();
        BoundSql boundSql = getBoundSql(sql);

        // 3.获取预处理对象：preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());

        // 4. 设置参数
        // 获取到了参数的全路径

        // 5. 执行sql

        // 6. 封装返回结果集

        return null;

    }

    /**
     * 完成对#{}的解析工作：
     * 1.将 #{} 使用 ？进行代替
     * 2.解析出#{}里面的值进行存储
     * @param sql
     * @return BoundSql
     */
    private BoundSql getBoundSql(String sql) {
        //标记处理类：配置标记解析器来完成对占位符的解析处理工作
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        // 标记解析器
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);

        //解析出来的sql
        String parseSql = genericTokenParser.parse(sql);

        //#{}里面解析出来的参数名称
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();

        BoundSql boundSql = new BoundSql(parseSql, parameterMappings);
        return boundSql;
    }
}
