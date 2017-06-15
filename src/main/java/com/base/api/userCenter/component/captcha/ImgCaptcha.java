package com.base.api.userCenter.component.captcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.stereotype.Component;

import java.util.Properties;


/**
 * Created by menzhongxin on 2017/6/12.
 */
@Component
public class ImgCaptcha extends DefaultKaptcha{

    private static CaptchaConfig captchaConfig = new CaptchaConfig();

    public ImgCaptcha() {
        super();
        Properties properties = captchaConfig.getConfig();
        Config config = new Config(properties);
        this.setConfig(config);
    }

}
