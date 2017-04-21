/**
 * 
 */
package com.ipartek.formacion.controller.pojo;

import java.io.Serializable;

/**
 * @author Alberto Fernandez
 *
 */
public class Mensaje implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6451560427458411917L;
	String msg;
	MensajeType type;
	int code;
	
	
	/**
	 * 
	 */
	/**
	 * @param txt
	 */
	public Mensaje(final String txt) {
		super();
		this.msg = txt;
		this.type = MensajeType.MSG_TYPE_SUCCESS;
	}
	/**
	 * @param msg
	 * 
	 */
	public Mensaje(final MensajeType type) {
		super();
		this.msg = "";
		this.type = type;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the type
	 */
	public MensajeType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(MensajeType type) {
		this.type = type;
	}
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mensaje [msg=" + msg + ", type=" + type + ", code=" + code + "]";
	}
	
	
	
	
	
	
	
	
	
}
