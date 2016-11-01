package com.hsl.ecargo.common.vo;

/**
 * Ajax post delete put request response json obj.
 * @author hushenglang
 * @date 2015年9月8日 上午9:07:04 
 *
 */
public class AjaxResult {
	public final static String SUCCESS = "success";
	public final static String FAIL = "fail";
	
	/** ajax result code [success|fail] */
	private String code;
	
	/** if code==fail, errorMsg is the message showing the fail reason */
	private String errorMsg;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
