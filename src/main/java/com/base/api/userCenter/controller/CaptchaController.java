package com.base.api.userCenter.controller;

import com.base.api.userCenter.model.Captcha;
import com.base.api.userCenter.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by menzhongxin on 2017/6/12.
 */
@RestController
@RequestMapping("/captcha/{scene}")
public class CaptchaController{

    @Autowired
    private CaptchaService captchaService;


    @GetMapping("/msg/{phone}")
    Captcha msgCaptcha(@PathVariable String phone, @PathVariable String scene) {
//        throw new RuntimeException("test");
        return captchaService.generateMsgCaptcha(phone, scene);
    }

    @GetMapping("/img/{phone}")
    Captcha imgCaptcha(@PathVariable String phone, @PathVariable String scene) {
        return captchaService.generateImgCaptcha(phone, scene);
    }

    @PostMapping("/verify")
    boolean verifyCaptcha(@PathVariable String scene, @RequestBody Captcha captcha) {
        captcha.setScene(scene);
        return captchaService.verify(captcha);
    }

}
