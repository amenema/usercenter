package com.base.api.userCenter.model;

/**
 * Created by menzhongxin on 2017/6/12.
 */
public enum CaptchaTypeEnum {
    MSG(1), IMG(2);

    private int index;

    CaptchaTypeEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
