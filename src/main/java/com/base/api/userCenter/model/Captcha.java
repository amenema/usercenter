package com.base.api.userCenter.model;


import java.io.Serializable;

/**
 * Created by menzhongxin on 2017/6/12.
 */

public class Captcha implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String img;
    private CaptchaTypeEnum type;
    private CaptchaSceneEnum scene;
    private String uuid;

    public Captcha() {

    }

    public Captcha(CaptchaSceneEnum scene, CaptchaTypeEnum type) {
        this.scene = scene;
        this.type = type;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public CaptchaTypeEnum getType() {
        return type;
    }

    public void setType(CaptchaTypeEnum type) {
        this.type = type;
    }


    public CaptchaSceneEnum getScene() {
        return scene;
    }

    public void setScene(CaptchaSceneEnum scene) {
        this.scene = scene;
    }

    public void setScene(String scene) {
        this.setScene(CaptchaSceneEnum.valueOf(scene.toUpperCase()));
    }

    /**
     * @param uuid
     * @return "captcha:scene:type:uuid"
     */
    public String getCacheKey() {
        StringBuilder sb = new StringBuilder();
        sb.append("captcha:");
        sb.append(this.scene.toString().toUpperCase());
        sb.append(":");
        sb.append(this.type.toString().toUpperCase());
        sb.append(":");
        sb.append(this.uuid);
        return sb.toString();
    }
}
