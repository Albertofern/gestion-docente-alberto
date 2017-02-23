package com.ipartek.formacion.dbms.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Curso implements Serializable, Comparable<Curso>{ 

	private static final long serialVersionUID = 1L;
	public static final int CODIGO_NULO = -1;
	private long codigo;
	private String nombre;
	private int duracion;
	private Date fechaInicio;
	private Date fechaFin;
	private int nhoras;
	private List<Alumno> alumnos;
	private Profesor profesor;
	
	

	public Curso() {
		super();
		this.nombre = "";
		this.duracion= 0;
		this.fechaInicio= new Date();
		this.fechaFin= new Date();
		this.nhoras = 0;
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = new Profesor();	
	}
	
	/**
	 * @return the codigo
	 */
	public long getCodigo() {
			return codigo;
	}
	
	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(long codigo) {
			this.codigo = codigo;
	}
	
	/**
	 * @return the nombreCurso
	 */
	public String getNombre() {
			return nombre;
	}
	
	/**
	 * @param nombre
	 *            the nombreCurso to set
	 */
	public void setNombre(String nombre) {
			this.nombre = nombre;
	}
	
	
	/**
	 * @return the duracion
	 */
	public int getDuracion() {
			return duracion;
	}
	
	/**
	 * @param nombre
	 *            the nombreCurso to set
	 */
	public void setDuracion(int duracion) {
			this.duracion = duracion;
	}
	
	
	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
			return fechaInicio;
	}
	
	/**
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */	
	public void setFechaInicio(Date fechaInicio) {
			this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechafin
	 */
	public Date getFechaFin() {
			return fechaFin;
	}
	
	/**
	 * @param fechafin
	 *            the fechafin to set
	 */	
	public void setFechaFin(Date fechaFin) {
			this.fechaFin = fechaFin;
	}

	/**
	 * @return the alumnos
	 */
	public List<Alumno> getAlumnos() {
			return alumnos;
	}
	
	/**
	 * @param alumnos
	 *            the alumnos to set
	 */
	public void setAlumnos(List<Alumno> alumnos) {
			this.alumnos = alumnos;
	}

	/**
	 * @return the profesor
	 */	
	public Profesor getProfesor() {
			return profesor;
	}

	/**
	 * @param profesor
	 *            the profesor to set
	 */
	public void setProfesor(Profesor profesor) {
			this.profesor = profesor;
	}
	
	@Override
	public int compareTo(Curso o) {
		return this.nombre.compareToIgnoreCase(o.nombre);
	}
	
	@Override
	public String toString() {
		return this.nombre+ ", " + this.duracion;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
  	public boolean equals(Object obj) {

  		boolean iguales = false;
		if (obj != null && obj instanceof Curso) {
  			Curso curso = (Curso) obj;
			if (this == curso || curso.getCodigo() == this.codigo) {
  				iguales = true;
  			}
  		}
 		return iguales;
	}

	public int getNhoras() {
		return nhoras;
	}

	public void setNhoras(int nhoras) {
		this.nhoras = nhoras;
	}
	
	/*
  	 * (non-Javadoc)
  	 * 
	 * @see java.lang.Object#hashCode()
	 */



	
}
