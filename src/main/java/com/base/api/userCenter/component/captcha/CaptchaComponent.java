package com.base.api.userCenter.component.captcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Base64;

/**
 * Created by menzhongxin on 2017/6/12.
 */

@Component
public class CaptchaComponent {

    @Autowired
    private ImgCaptcha imgCaptcha;

    public String getImgCaptchaText(){
        return imgCaptcha.createText();
    }


    public String getImgCaptcha(String text){
        ByteArrayOutputStream out = null;
        String result = null;
        try {
            BufferedImage bi = imgCaptcha.createImage(text);
            out = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", out);
            result = Base64.getEncoder().encodeToString(out.toByteArray());
            out.flush();
        }catch (MalformedURLException e1){
            e1.printStackTrace();

        } catch (IOException e2){
            e2.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
