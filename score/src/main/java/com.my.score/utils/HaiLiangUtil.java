/**   
 * <p>Title: HaiLiangUtil.java</p>   
 * <p>Description: </p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: www.baidudu.com</p>   
 * @author 凌静  
 * @date 2018年6月12日   
 * @version 1.0   
*/  
package com.my.score.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**   
 * <p>Title: HaiLiangUtil</p>   
 * <p>Description: </p>   
 * @author 凌静  
 * @date 2018年6月12日   
*/
public class HaiLiangUtil {
	
	public static JSONObject HairuiConnection(String url,Map<String, Object> map) {
		URL realUrl = null;
		HttpURLConnection con = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		// 发送请求
		try {
			realUrl = new URL(url);
			// 打开和URL之间的连接
			con = (HttpURLConnection) realUrl.openConnection();
			// 发送POST请求必须设置如下两行
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Cache-Control", "no-cache");
			con.setRequestProperty("Postman-Token", "176c8f5b-0af4-47af-b649-6bc9ab50367d");

			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);

			// 获取URLConnection对象对应的输出流（设置请求编码为UTF-8）
			out = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
			// 发送请求参数
			out.print(JSON.toJSONString(map));
			// flush输出流的缓冲
			out.flush();

			// 获取请求返回数据（设置返回数据编码为UTF-8）
			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return JSONObject.parseObject(result);
	}


}
