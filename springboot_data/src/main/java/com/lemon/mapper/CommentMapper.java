package com.lemon.mapper;

import com.lemon.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper //标识该接口是mybatis的接口文件，并且让springboot能够扫描到该接口，生成该接口的代理对象，存到容器中
public interface CommentMapper {

    //根据id查询对应评论信息
    @Select("select * from t_comment where id = #{id}")
    public Comment findById(Integer id);

}
