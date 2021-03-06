package com.yzz.springboot.system;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;



/**
 * @author Yzz
 */
@Configuration
public class WebConfig {

//    @Bean
//    public HandlerInterceptor getLoginInterceptor(){
//        return new LoginInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(getLoginInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/error")
//                .excludePathPatterns("/static/*");
//    }


        @Bean
        public HttpMessageConverters fastJsonHttpMessageConverters () {
            FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
            FastJsonConfig fastJsonConfig = new FastJsonConfig();
            fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
            fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
            return new HttpMessageConverters((HttpMessageConverter<?>) fastJsonHttpMessageConverter);

    }
}