package com.my.score.utils;
import java.io.Serializable;
public class ResultRestModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status;

	private String code;
	private String msg;

	private Object data;

	public ResultRestModel() {
	}
      
	public ResultRestModel(String status, String msg) {
		//super();
		this.status = status;
		this.msg = msg;
	}
	  /**
	   * 
	   * Creates a new instance of ResultRestModel.
	   *
	   * @param status 状态
	   * @param code 状态码
	   * @param data 返回数据
	   * @param msg 描述信息
	   */
	public ResultRestModel(String status, String code, String msg, Object data) {
		//super();
		this.status = status;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	 /**
	   * 
	   * Creates a new instance of ResultRestModel.
	   *
	   * @param status 状态
	   * @param code 状态码
	   * @param data 返回数据
	   */
	public ResultRestModel(String status, String code, Object data) {
		//super();
		this.status = status;
		this.code = code;
		this.data = data;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
    
	
}
