package com.base.api.userCenter.model;

/**
 * Created by menzhongxin on 2017/6/12.
 */
public enum CaptchaSceneEnum {
    REGISTER(1),LOGIN(2);

    private int index;

    CaptchaSceneEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
