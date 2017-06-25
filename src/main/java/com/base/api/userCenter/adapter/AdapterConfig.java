package com.base.api.userCenter.adapter;

import com.base.api.userCenter.config.ApplicationConfigure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


/**
 * Created by menzhongxin on 2017/6/16.
 */

@Component
public final class AdapterConfig extends ApplicationConfigure {

    @Autowired
    DealResponseDataAdapter dealResponseDataAdapter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(dealResponseDataAdapter);
    }




}
