package com.organization.projectName.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;

/**
 * @program: springboot-learn-shiyanlou
 * @description: 配置类
 * @author: liuguohu
 * @create: 2020-03-07 15:36
 **/
//@Configuration
public class ServletConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(8080);
    }
}
