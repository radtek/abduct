package org.sky.app.utils;

public class MiniAppUtils {
	
	/**
	 * 生成校验码
	 * @return
	 */
	public static String getVerficationCode() {
		// TODO Auto-generated method stub
		int code = (int)((Math.random()*9+1)*100000);
		return code+"";
	}

	public static void main(String args[]) {
		System.out.println(getVerficationCode());
	}
}
