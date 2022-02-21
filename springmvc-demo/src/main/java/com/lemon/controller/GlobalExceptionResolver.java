package com.lemon.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 全局异常处理
 * 可以让我们优雅的捕获所有Controller对象handler方法抛出的异常
 * @Author : Lemon-CS
 * @Date : 2022年02月21日 11:31 下午
 */
@ControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView handleException(ArithmeticException exception, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",exception.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
