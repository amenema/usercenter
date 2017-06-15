package com.base.api.userCenter.controller;

import com.base.api.userCenter.component.response.DealResponseComponent;
import com.base.api.userCenter.model.Captcha;
import com.base.api.userCenter.model.ResponseData;
import com.base.api.userCenter.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by menzhongxin on 2017/6/12.
 */
@RestController
@RequestMapping("/captcha/{scene}")
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private DealResponseComponent dealResponse;


    @GetMapping("/msg/{phone}")
    ResponseData msgCaptcha(@PathVariable String phone, @PathVariable String scene) {
        return dealResponse.success(captchaService.generateMsgCaptcha(phone, scene));
    }

    @GetMapping("/img/{phone}")
    ResponseData imgCaptcha(@PathVariable String phone, @PathVariable String scene) {
        return dealResponse.success(captchaService.generateImgCaptcha(phone, scene));
    }

    @PostMapping("/verify")
    ResponseData verifyCaptcha(@PathVariable String scene, @RequestBody Captcha captcha) {
        captcha.setScene(scene);
        return dealResponse.success(captchaService.verify(captcha));
    }

}
