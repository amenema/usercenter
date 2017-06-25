package com.base.api.userCenter.model.manager;

import com.base.api.userCenter.model.Captcha;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by menzhongxin on 2017/6/25.
 */

@Component
@Scope(scopeName = "prototype")
public abstract class CaptchaManager {

   public Object process(){
       Captcha captcha = createManager();
       return captcha;
   }

   @Lookup
   protected abstract Captcha createManager();
}
