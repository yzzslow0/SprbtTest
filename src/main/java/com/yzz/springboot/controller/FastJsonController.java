package com.yzz.springboot.controller;

import com.yzz.springboot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * @author Yzz
 */
@Controller
@RequestMapping("fastjson")
public class FastJsonController {
    @RequestMapping("/test")
    @ResponseBody
    public User test() {
        User user = new User();
        user.setU_id(1);
        user.setEmail("123213");
        user.setMobile("123123123");
        user.setO_id(0);
        user.setGen_time(new Date());
        user.setLogin_time(new Date());



        return user;
    }
}