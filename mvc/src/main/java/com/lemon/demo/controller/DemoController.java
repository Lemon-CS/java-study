package com.lemon.demo.controller;



import com.lemon.demo.service.IDemoService;
import com.lemon.mvcframework.annotations.LagouAutowired;
import com.lemon.mvcframework.annotations.LagouController;
import com.lemon.mvcframework.annotations.LagouRequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@LagouController
@LagouRequestMapping("/demo")
public class DemoController {


    @LagouAutowired
    private IDemoService demoService;


    /**
     * URL: /demo/query?name=lisi
     * @param request
     * @param response
     * @param name
     * @return
     */
    @LagouRequestMapping("/query")
    public String query(HttpServletRequest request, HttpServletResponse response, String name) {
        return demoService.get(name);
    }
}
