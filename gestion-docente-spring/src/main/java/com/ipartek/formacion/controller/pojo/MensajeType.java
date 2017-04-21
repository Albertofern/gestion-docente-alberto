/**
 * 
 */
package com.ipartek.formacion.controller.pojo;

/**
 * @author Alberto Fernandez
 *
 */
public enum MensajeType {
		
	MSG_TYPE_SUCCESS("alert alert-success alert-dismissible"), 
	MSG_TYPE_INFO("alert alert-info alert-dismissible"), 
	MSG_TYPE_WARNING("alert alert-warning alert-dismissible"), 
	MSG_TYPE_DANGER("alert alert-danger alert-dismissible");  
	
	private String styles;
	
	
	private MensajeType(String s){
		this.styles = s;
	}


	/**
	 * @return the styles
	 */
	public String getStyles() {
		return styles;
	}


	/**
	 * @param styles the styles to set
	 */
	public void setStyles(String styles) {
		this.styles = styles;
	}

}
