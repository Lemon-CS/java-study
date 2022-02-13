package com.lemon.mapper;

import com.lemon.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月13日 5:44 下午
 */
public interface IRoleMapper {

    @Select("select * from sys_role r,sys_user_role ur where r.id = ur.roleid and ur.userid = #{uid}")
    public List<Role> findRoleByUid(Integer uid);

}
