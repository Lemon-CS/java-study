package com.lemon.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter setter toString
@NoArgsConstructor //生成无参构造
@AllArgsConstructor // 生成全参构造
@TableName("user")
public class User extends Model<User> {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(select = true) //查询的时候，不返回该字段的值
    private String name;
    private Integer age;

    @TableField(value = "email") // 解决字段名不一致问题
    private String mail;

    @TableField(exist = false)  // 该字段在数据库表中不存在
    private String address;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic
    private Integer deleted;

}
