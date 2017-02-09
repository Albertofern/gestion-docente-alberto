	package com.ipartek.formacion.dbms.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class Profesor implements Comparable<Profesor>,Serializable {

	private static final long serialVersionUID = -8239371384272787185L;
	public static final int CODIGO_NULO = -1;
	
	@NotNull(message="")
	@NotBlank(message="")
	private int codigo;
	private int nSS;
	@Pattern(regexp = "[0-9]{8}[a-z-A-Z]", message = "DNI introducido incorrecto")
	private String dni;
	@Size(min=3, max=50)
	private String nombre;
	@Size(min=7, max=150)
	private String apellidos;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past //Tiene que ser mas antigua que HOY
	private Date fNacimiento;
	@Email 
	private String email;
	private String direccion;
	//@Phone
	private String telefono;
	

	public Profesor() {
		super();
		this.codigo = Profesor.CODIGO_NULO;
		this.nSS = 0;
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return this.getCodigo() + " " + this.getNombre() + ", " + " " + this.getApellidos();
	}
	@Override
	public int compareTo(Profesor o) {
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
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public int getnSS() {
		return nSS;
	}

	public void setnSS(int nSS) {
		this.nSS = nSS;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Profesor profe = null;
		boolean iguales = false;
		if (obj != null && obj instanceof Profesor) {
			profe = (Profesor) obj;
			if (obj == this || (this.codigo == profe.getCodigo() && this.dni.equalsIgnoreCase(profe.getDni()))) {
				iguales = true;
			}
	 }
	return iguales;
	}
	
}
