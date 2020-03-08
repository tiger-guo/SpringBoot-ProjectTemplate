package com.organization.projectName;

import com.organization.projectName.rabbitmq.Provider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: springboot-learn-shiyanlou
 * @description:
 * @author: liuguohu
 * @create: 2020-03-08 14:27
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class ApplicationTests {

    @Autowired
    private Provider provider;

    @Test
    public void providerTest() {
        provider.sendMessage("Hello Shiyanlou");
    }

}