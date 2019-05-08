package com.gangbin.store.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * é€šç”¨çš„è¿”å›žçš„ç±?
 * 
 * @author lfy
 * 
 */
public class Message {
	//×´Ì¬Âë£¬ 100 ³É¹¦       200 Ê§°Ü
	private int code;

	private String msg;
	

	private Map<String, Object> extend = new HashMap<String, Object>();

	public static Message success(){
		Message result = new Message();
		result.setCode(100);
		result.setMsg("³É¹¦");
		return result;
	}
	
	public static Message fail(){
		Message result = new Message();
		result.setCode(200);
		result.setMsg("Ê§°Ü");
		return result;
	}
	
	public Message add(String key,Object value){
		this.getExtend().put(key, value);
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	
}
