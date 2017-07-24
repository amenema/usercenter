package com.base.api.userCenter.controller;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by menzhongxin on 2017/6/18.
 */

@RestController
public class BaseController {


    @RequestMapping(name = "/error")
    Object noFound() throws ChangeSetPersister.NotFoundException{
        throw new ChangeSetPersister.NotFoundException();
    }
}
