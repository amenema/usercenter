package com.base.api.userCenter.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by menzhongxin on 2017/7/2.
 */

@RestController
@RequestMapping(name = "/login")
public class AuthController extends BaseController {

    void registerOrLogin (@RequestParam String phone, @RequestParam String code){

    }
}
