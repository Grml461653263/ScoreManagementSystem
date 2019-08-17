package com.my.score.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpRequestUtils {
	
	public static Map<String,Object> PostRequest(String Url,Map<String,Object> map,String PostType){
		Map<String,Object> remap=new HashMap<String,Object>();
			URL realUrl=null;
			HttpURLConnection con = null;
			PrintWriter out = null;
			BufferedReader in = null;
			String result = "";
		try {
			//创建请求地址
			realUrl = new URL(Url);
			 // 打开和URL之间的连接
			con = (HttpURLConnection) realUrl.openConnection();
			con.setRequestMethod("POST");
		    con.setRequestProperty("Content-Type", PostType);//application/json
		    con.setRequestProperty("Cache-Control", "no-cache");
		    
		    con.setDoOutput(true);
	        con.setDoInput(true);
	        con.setUseCaches(false);
	        // 获取URLConnection对象对应的输出流（设置请求编码为UTF-8）
	        out = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
	        // 发送请求参数
	        if(null != map && map.size()>0) {
	        	out.print(JSONObject.toJSONString(map));
	        }
	        // flush输出流的缓冲
	        out.flush();
	        
	        // 获取请求返回数据（设置返回数据编码为UTF-8）
	        in = new BufferedReader(
	                new InputStreamReader(con.getInputStream(), "UTF-8"));
	        String line;
	        while ((line = in.readLine()) != null) {
	            result += line;
	        }
	        remap = JSON.parseObject(result);
		} catch (Exception e) {
			remap.put("message", e.getMessage());
		}finally {
			try{
	             if(out!=null){
	                 out.close();
	             }
	             if(in!=null){
	                 in.close();
	             }
	         }
	         catch(IOException ex){
	             ex.printStackTrace();
	         } 
		}
		return remap;
	}
}
