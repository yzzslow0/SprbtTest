package com.yzz.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author Yzz
 */
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @RequestMapping("homepage")
    public String homePage(Map<String,Object> map){
        map.put("msg","Hello Thymeleaf");
        map.put("img","../imgs/1.png");
        return "homePage";
    }
}
