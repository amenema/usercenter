package com.base.api.userCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by menzhongxin on 2017/6/12.
 */

@SpringBootApplication
@ConfigurationProperties(locations = "classpath:bootstrap.properties")
public class BootStrap extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

    }

    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class, args);
    }
}
