package zzd.action;

import java.awt.image.BufferedImage;

import com.opensymphony.xwork2.ActionSupport;

import zzd.vcode.utils.VerifyCode;

public class VerifyCodeAction extends ActionSupport{
	public void getVerifyCode(){
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();
//		VerifyCode.output(image, response.getOutputStream());
	}
}
