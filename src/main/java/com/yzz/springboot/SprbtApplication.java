package com.yzz.springboot;

import com.yzz.springboot.util.JpaConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 该注解指定项目为springboot，由此类当作程序入口
 自动装配 web 依赖的环境
 *
 * @author Yzz
 * */
@Slf4j
@SpringBootApplication
@ImportAutoConfiguration(value= JpaConfiguration.class)
public class SprbtApplication {


    public static void main(String[] args) {
        SpringApplication.run(SprbtApplication.class, args);
        log.info("SpringBoot 加载结束");

    }


}
