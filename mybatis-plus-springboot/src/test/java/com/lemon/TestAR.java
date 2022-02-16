package com.lemon;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAR {

    /*
        在AR模式下，完成根据主键查询
     */
    @Test
    public void testARSelectById(){

        User user = new User();
        user.setId(1L);

        User user1 = user.selectById();
        System.out.println(user1);

    }


    /*
        在AR模式下，完成添加操作
    */
    @Test
    public void testARInsert(){

        User user = new User();
        user.setName("墨竹");
        user.setAge(18);
        user.setMail("mozhu@lemon.com");

        boolean insert = user.insert();
        System.out.println(insert);

    }


    /*
        在AR模式下，完成更新操作
    */
    @Test
    public void testARUpate(){


        User user = new User();
        User user1 = user.selectById(1L);

        user.setId(6L);
        user.setName("青梅");
        user.setVersion(user1.getVersion());

        boolean insert = user.updateById();
        System.out.println(insert);

    }

    /*
        在AR模式下，完成删除操作
    */
    @Test
    public void testARDelete(){

        User user = new User();
        //user.setId(6L);

        boolean b = user.deleteById(6L);
        System.out.println(b);
    }


    /*
        在AR模式下，根据条件进行查询
    */
    @Test
    public void testARFindByWrapper(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age","20");

        User user = new User();
        List<User> users = user.selectList(queryWrapper);
        for (User user1 : users) {
            System.out.println(user1);
        }

    }



}
