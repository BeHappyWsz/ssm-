package common;

import java.io.Serializable;
/**
 * ��װ���ؽ��
 * @author wsz
 * @date 2018��1��29��
 */
public class Result implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Boolean success;
	
	private String returnMsg;
	
	private Object data;
	
	public Result() {}
	
	public Result(Boolean success) {
		this.success=success;
	}

	public Result(Boolean success,String returnMsg) {
		this(success);
		this.returnMsg=returnMsg;
	}
	
	public Result(Boolean success,String returnMsg,Object data) {
		this(success,returnMsg);
		this.data=data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
