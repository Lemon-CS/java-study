package com.lemon.springboot_demo1;

import com.lemon.controller.HelloController;
import com.lemon.pojo.MyProperties;
import com.lemon.pojo.Person;
import com.lemon.pojo.SimpleBean;
import com.lemon.pojo.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //测试启动器，并加载spring boot测试注解
@SpringBootTest //标记该类为spring boot单元测试类，并加载项目的applicationContext上下文环境
class SpringbootDemo1ApplicationTests {

    @Autowired
    private HelloController helloController;

    @Test
    void contextLoad1() {
        String demo = helloController.demo();
        System.out.println(demo);
    }

     /*
      配置文件properties配置测试
     */

    @Autowired
    private Person person;

    @Test
    void configurationTest() {
        System.out.println(person);
        System.out.println("你好");
    }

    /*
      @Value进行测试
     */

    @Autowired
    private Student student;

    @Test
    void studentTest() {
        System.out.println(student);
    }

     /*
      @propertySource进行测试
     */

    @Autowired
    private MyProperties myProperties;

    @Test
    void myPropertiesTest() {
        System.out.println(myProperties);
    }


     /*
      @Configuration进行测试
     */

    @Autowired
    private ApplicationContext context;

    @Test
    void iocTest() {
        System.out.println(context.containsBean("iservice"));
    }

    /*
      测试随机数及参数间引用
     */
    @Value("${tom.description}")
    private String description;


    @Test
    void placeholderTest() {
        System.out.println(description);
    }

    /*
     测试自定义starter
    */
   @Autowired
    private SimpleBean simpleBean;


    @Test
    void starterTest() {
        System.out.println(simpleBean.toString());
    }

}
