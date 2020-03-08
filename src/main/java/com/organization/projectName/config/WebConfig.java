package com.organization.projectName.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: springboot-learn-shiyanlou
 * @description:
 * @author: liuguohu
 * @create: 2020-03-07 18:25
 **/

//设置配置类
//@Configuration
class WebConfig implements WebMvcConfigurer {

    //重写addResourceHandlers方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //设置静态资源映射路径为/**，资源位置为类路径下的upload
        registry.addResourceHandler("/**").addResourceLocations("classpath:/upload/");

    }
}