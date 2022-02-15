package com.lemon.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter setter toString
@NoArgsConstructor //生成无参构造
@AllArgsConstructor // 生成全参构造
@TableName("user")
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;

}
