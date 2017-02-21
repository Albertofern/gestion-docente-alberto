package com.ipartek.formacion.dbms.persistence;

import java.io.Serializable;
import java.util.Date;


public class Alumno implements Comparable<Alumno>, Serializable {




	private static final long serialVersionUID = -6698866485450376235L;
	public static final int CODIGO_NULO = -1;
	
	
		private int codigo;
		private boolean activo;
		private int nHermanos;
		private String dni;
		private String nombre;
		private String apellidos;
		private Date fNacimiento;
		private String email;
		private String direccion;
		private String telefono;
		private String poblacion;
		private int codigoPostal;
		

	public Alumno() {
		super();// constructor de la clase padre
		this.codigo = CODIGO_NULO;
		this.nombre = "";
		this.apellidos = "";
		this.dni = "";
		this.fNacimiento = new Date();
		this.email = "";
		this.direccion = "";
		this.poblacion = "";
		this.telefono = "";
		this.codigoPostal = 48;
		this.activo = true;
		this.nHermanos = 0;

	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return this.getCodigo() + " " + this.getApellidos() + ", " + this.getNombre() + " " + this.getDni();
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

	/**
	 * @return the nHermanos
	 */
	public int getnHermanos() {
		return nHermanos;
	}

	/**
	 * @param nHermanos
	 *            the nHermanos to set
	 */
	public void setnHermanos(int nHermanos) {
		this.nHermanos = nHermanos;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * @param poblacion
	 *            the poblacion to set
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	
	}
	/**
	 * @return the codigopostal
	 */
	public int getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigopostal
	 *            the codigopostal to set
	 */
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	/**
	 * Se usa en el caso de ordenamiento de List o Array
	 * 
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Alumno o) {
		return this.apellidos.compareToIgnoreCase(o.getApellidos());
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * @param dni
	 *            the dni to set
	 */
	public void setDni(String dni) {
			this.dni = dni;
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the fNacimiento
	 */
	public Date getfNacimiento() {
		return fNacimiento;
	}
	
	/**
	 * @param fNacimiento
	 *            the fNacimiento to set
	 */
	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj != null && obj instanceof Alumno) {
			Alumno alum = (Alumno) obj;
			if (this == alum || (alum.getCodigo() == this.codigo && this.dni.equalsIgnoreCase(alum.getDni()))) {
				iguales = true;
			}
		}
		return iguales;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
			int result = 1;
			result = prime * result + codigo;
			return result;
	}
}
