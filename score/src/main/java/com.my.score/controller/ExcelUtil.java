/**
 * 
 */
package com.my.score.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
* 创建时间：2018年6月26日 上午10:36:27
* 项目名称：web-api
* @author 李少勇
* @since JDK 1.8.0_161
* 文件名称：ExcelUtil.java
* 类说明：
*/
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
@RequestMapping("excel")
@Controller
public class ExcelUtil {
	 
	/** 
	 * 简单的导入 
	 * @param file 
	 * @throws IOException  
	 * @throws InvalidFormatException  
	 */  
	@RequestMapping(value = "import")  
	public void importExcel(MultipartFile file) throws IOException, InvalidFormatException{ 
	    InputStream in = file.getInputStream(); //获取文件输入流  
	    Workbook wookbook;
		try {
			wookbook = WorkbookFactory.create(in);
			Sheet sheet = wookbook.getSheetAt(0);  //获取Excel的第一个子页  
		    Row row = null;     
		    for(int i=1;i<sheet.getLastRowNum();i++){    
		        int index = 0;  //列数  
		        row = sheet.getRow(i);  //第几个格子  
		        String id = row.getCell(index++).toString();   //获取第i行的第index列  
		        String name = row.getCell(index++).toString();  
		       System.out.println(id+","+name);
		    }  
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	    
	}  

}
