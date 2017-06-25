package com.base.api.userCenter.service;

import com.base.api.userCenter.component.captcha.CaptchaComponent;
import com.base.api.userCenter.model.Captcha;
import com.base.api.userCenter.model.CaptchaSceneEnum;
import com.base.api.userCenter.model.CaptchaTypeEnum;
import com.base.api.userCenter.model.manager.CaptchaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * Created by menzhongxin on 2017/6/12.
 */

@Service
public class CaptchaService {

    @Autowired
    private CaptchaComponent captchaComponent;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public Captcha generateCaptcha(String uuid, String type, String scene) {
        Captcha captcha = captchaManager();
        captcha.setScene(CaptchaSceneEnum.valueOf(scene.toUpperCase()));
        captcha.setType(CaptchaTypeEnum.valueOf(type.toUpperCase()));
        captcha.setCode(captchaComponent.getImgCaptchaText());
        captcha.setUuid(uuid);
        redisTemplate.opsForValue().set(captcha.getCacheKey(), captcha, 120, TimeUnit.SECONDS);
        return captcha;
    }

    public Captcha generateImgCaptcha(String uuid, String scene) {
        return generateCaptcha(uuid, CaptchaTypeEnum.IMG.toString(), scene);
    }

    public Captcha generateMsgCaptcha(String uuid, String scene) {
        return generateCaptcha(uuid, CaptchaTypeEnum.MSG.toString(), scene);
    }

    public boolean verify(Captcha captcha) {
       Captcha realCaptcha = (Captcha) redisTemplate.opsForValue().get(captcha.getCacheKey());
        return (realCaptcha != null) && (captcha.getCode().equals(realCaptcha.getCode()));
    }

    @Lookup
    public Captcha captchaManager(){
        return null;
    }
}
