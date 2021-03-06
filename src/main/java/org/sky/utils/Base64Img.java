/**   
 * @Title: Base64Img.java 
 * @Package org.sky.utils 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author weifengxiang911@163.com
 * @date 2017-5-14 下午1:26:39 
 * @version V1.0   
 */

package org.sky.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @ClassName: Base64Img
 * @Description: TODO(base64与图片相互转化)
 * @author weifengxiang911@163.com
 * @date 2017-5-14 下午1:26:39
 * @version V1.0
 */
public class Base64Img {

	public static String GetImageStr(File imgFile) throws Exception {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		//String imgFile = "d://test.jpg";// 待处理的图片
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		in = new FileInputStream(imgFile);
		data = new byte[in.available()];
		in.read(data);
		in.close();
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}
	// 图片转化成base64字符串
	public static String GetImageStr(String imgFile) throws Exception {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		//String imgFile = "d://test.jpg";// 待处理的图片
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		in = new FileInputStream(imgFile);
		data = new byte[in.available()];
		in.read(data);
		in.close();
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * base64字符串转化成图片
	 * @param imgStr
	 * @param filepath
	 * @return
	 */
	public static boolean GenerateImage(String imgStr,String filepath) throws Exception { // 对字节数组字符串进行Base64解码并生成图片
		imgStr=imgStr.replace("data:image/jpeg;base64,", "");
		if (imgStr == null) { // 图像数据为空
			return false;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		// Base64解码
		byte[] b = decoder.decodeBuffer(imgStr);
		for (int i = 0; i < b.length; ++i) {
			if (b[i] < 0) {// 调整异常数据
				b[i] += 256;
			}
		}
		// 生成jpeg图片
		OutputStream out = new FileOutputStream(filepath);
		out.write(b);
		out.flush();
		out.close();
		return true;
	}
}
