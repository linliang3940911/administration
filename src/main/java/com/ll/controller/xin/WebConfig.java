package com.ll.controller.xin;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: java类作用描述
 * @Author: 林亮
 * @CreateDate: 2018/8/21 0021$ 20:21$
 * @UpdateUser: 林亮
 * @UpdateDate: 2018/8/21 0021$ 20:21$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
    }
}
