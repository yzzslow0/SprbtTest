package com.yzz.springboot.controller;

import com.yzz.springboot.bean.Tuser;
import com.yzz.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * @Author:Yangzhengzheng
 * @Date: Created in 15:33 2018/7/20
 * @Description:
 * @Modified By:
 */
@Controller
@RequestMapping("jpa")
public class JpaTestController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/add")
	@ResponseBody
	public Tuser add(){
		Tuser user = new Tuser();
		user.setVsername("setVsername");
		user.setEmail("setEmail");
		user.setGenTime(new Date());
		user.setLoginName("setLoginName");
		user.setPassword("setPassword");
//		Tuser result =
//		System.out.println(result);
		user.setUId(-1);
		int i = 1/0;
		return this.userRepository.save(user);
	}
}
