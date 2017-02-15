package com.ipartek.formacion.dbms.persistence;

import java.io.Serializable;

public class Cliente implements Comparable<Cliente>, Serializable {





	/**
	 * 
	 */
	private static final long serialVersionUID = -7688754835135725879L;
	public static final int CODIGO_NULO = -1;
	private int codigo;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private String poblacion;
 	private int codigoPostal;
	private String identificador;
	private boolean activo;
	
	public Cliente () {
		super();
		this.codigo = CODIGO_NULO;
		this.nombre = "";
		this.direccion = "";
		this.telefono = "";
		this.poblacion = "";
 		this.codigoPostal = 48;
		this.email = "";
		this.identificador = "";
		this.activo = true;
		
	}
	
	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * @param activo
	 *            the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
			int result = 1;
			result = prime * result + codigo;
			return result;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj != null && obj instanceof Cliente) {
			Cliente clien = (Cliente) obj;
			if (this == clien || (clien.getCodigo() == this.codigo && this.identificador.equalsIgnoreCase(clien.getIdentificador()))) {
				iguales = true;
			}
		}
		return iguales;
	}

	
	@Override
	public int compareTo(Cliente o) {
		return this.nombre.compareToIgnoreCase(o.getNombre());
	}



	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", email=" + email + ", identificador=" + identificador + "]";
	}



	public String getPoblacion() {
		return poblacion;
	}



	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}



	public int getCodigoPostal() {
		return codigoPostal;
	}



	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


}
