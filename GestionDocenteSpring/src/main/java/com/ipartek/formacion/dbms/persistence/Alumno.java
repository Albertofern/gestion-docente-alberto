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

	public Alumno() {
		super();// constructor de la clase padre
		this.codigo = CODIGO_NULO;
		this.activo = true;
		this.nHermanos = 0;

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return this.getCodigo() + " " + this.getApellidos() + ", " + this.getNombre() + " " + this.getDni();
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getnHermanos() {
		return nHermanos;
	}

	public void setnHermanos(int nHermanos) {
		this.nHermanos = nHermanos;
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

	/**
	 * Para evaluar si los objetos son iguales
	 */

	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj instanceof Alumno) {
			Alumno alum = (Alumno) obj;
			if (this.codigo == alum.getCodigo()) {
				iguales = true;
			}
		}
		return iguales;
	}

}
