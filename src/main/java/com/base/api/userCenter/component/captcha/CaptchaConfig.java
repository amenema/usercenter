package com.base.api.userCenter.component.captcha;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * Created by menzhongxin on 2017/6/13.
 */

public class CaptchaConfig{

    public Properties getConfig(){
        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream(new File(CaptchaConfig.class.getClassLoader().getResource("bootstrap.properties").getPath())));
        }catch (IOException e){
            e.printStackTrace();
        }
        Set<String> names = properties.stringPropertyNames();
        for (String name : names){
            if(!name.contains("kaptcha")){
                properties.remove(name);
            }
        }
        return properties;
    }
}
