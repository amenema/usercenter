package com.base.api.userCenter.component.response;

import com.base.api.userCenter.model.ResponseData;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * Created by menzhongxin on 2017/6/15.
 */
@Component
public class DealResponseComponent {

    public ResponseData success(Object data){
        ResponseData rd = new ResponseData();
        rd.setCode("0");
        rd.setBusinessCode("0");
        rd.setData(data);
        return rd;
    }

    public ResponseData error(String msg, String businessCode){
       ResponseData rd = new ResponseData();
       rd.setCode("-1");
       rd.setBusinessCode(businessCode);
       rd.setMessage(msg);
       return rd;
    }

    public ResponseData error(String msg){
        return error(msg, "-1");
    }
}
