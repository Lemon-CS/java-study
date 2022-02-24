package com.lemon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月24日 12:46 下午
 */
@RestController //相当于配置 @Responsebody+@Controller
public class HelloController {


    @RequestMapping("/demo")
    public String demo() {

        return "你好，springboot";
    }


}
