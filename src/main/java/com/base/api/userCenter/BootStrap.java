package com.base.api.userCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by menzhongxin on 2017/6/12.
 */

@SpringBootApplication
@ConfigurationProperties(locations = "classpath:bootstrap.properties")
public class BootStrap {
    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class, args);
    }
}
