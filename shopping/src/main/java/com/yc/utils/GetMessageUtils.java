package com.yc.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONObject;

/**
 * 获取短信验证码类
 * @author LB_lfx
 *
 *
 */
public class GetMessageUtils {


	/**
	 * 用户ID
	 */
	public static final String ACCOUNT_SID = "dd7453df053b4797beeec95bc01d43c5";//这里填写你在平台里的ACOUNT_SID

	/**
	 * 密钥
	 */
	public static final String AUTH_TOKEN = "ba562cf0905246d684bb79e61dc4cfae";

	/**
	 * 请求地址前半部分
	 */
	public static final String BASE_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";//请求地址是固定的不用改

	//public static  String randNum = RandomMessageUtils.getRandNum();

	//public  static String smsContent = "【源辰信息】尊敬的用户,您的验证码为{"+randNum+"}";
	/**
	 * (获取短信验证码)
	 * @param to
	 * @return String
	 */
	public static String getResult(String to) {
		String randNum = RandomMessageUtils.getRandNum();
		String smsContent = "【源辰信息】尊敬的用户,您的验证码为{"+randNum+"}";            //这里的randNum 和 smsContent和上面的静态变量是一样的，可删除可保留
		String args = QueryMessageUtils.queryArguments(ACCOUNT_SID, AUTH_TOKEN, smsContent, to);
		OutputStreamWriter out = null;
		InputStream in = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();


		try {
			URL url = new URL(BASE_URL);
			URLConnection connection = url.openConnection(); //打开链接
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setConnectTimeout(5000);  //设置链接超时
			connection.setReadTimeout(10000);    //设置读取超时

			//提交数据
			out = new OutputStreamWriter(connection.getOutputStream(),"utf-8");
			out.write(args);
			out.flush();

			//读取返回数据
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			while((line = br.readLine())!=null){
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (br!=null) {
					br.close();
				}
				if (out!=null) {
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		JSONObject jsonObject = JSONObject.fromObject(sb.toString());
		System.out.println(jsonObject);
		Object object = jsonObject.get("respCode");
		System.out.println("状态码："+object+"验证码："+randNum);
		System.out.println(!object.equals("00000"));
		if (!object.equals("00000")) {
			return object.toString();
		}else{

			return randNum;
		}


	}
  //测试功能
//  public static void main(String[] args) {
//      String result = getResult("18508486691");
//      System.out.println("验证码："+getResult("18508486691")+"\t"+result);
//      //System.out.println(smsContent);
//  }
}
