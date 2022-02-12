package com.lemon.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 数据库配置信息
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 2:26 下午
 */
public class Configuration {

    private DataSource dataSource;

    /*
     *   key: statementid  value:封装好的mappedStatement对象
     */
    Map<String, MappedStatement> mappedStatementMap = new HashMap<>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }

}
