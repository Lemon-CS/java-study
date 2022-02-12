package com.lemon.config;

import com.lemon.utils.ParameterMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: BoundSql: 解析后的SQL语句和参数
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 3:56 下午
 */
public class BoundSql {

    private String sqlText; //解析过后的sql

    private List<ParameterMapping> parameterMappingList = new ArrayList<>();

    public BoundSql(String sqlText, List<ParameterMapping> parameterMappingList) {
        this.sqlText = sqlText;
        this.parameterMappingList = parameterMappingList;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public List<ParameterMapping> getParameterMappingList() {
        return parameterMappingList;
    }

    public void setParameterMappingList(List<ParameterMapping> parameterMappingList) {
        this.parameterMappingList = parameterMappingList;
    }

}
