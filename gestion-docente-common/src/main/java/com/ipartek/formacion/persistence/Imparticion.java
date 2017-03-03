package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="imparticion")
public class Imparticion  implements Serializable {
	



	/**
	 * 
	 */
	private static final long serialVersionUID = 6354577982488490172L;

	@Id
	@GeneratedValue
	private long codigo;
	
	/* Se une con el curso detalle.*/
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="curso_detalle_codigo")
	private CursoDetalle cursodetalle;
	
	/* Se une con el curso profesor.*/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="profesor_codigo")
	private Profesor profesor;

	
	/* Se declara un atributo para contener los modulos del alumno sin carga por defecto.
	 * @Fetch(FetchMode.JOIN) sirve para que no falle si se repeite una Imparticion.(Es un problema de JAVA). 
	 *   También se puede solucionar trabajando con SET en vez de LIST ya que SET no permite duplicados.*/
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="asistente",
		joinColumns= @JoinColumn(name="imparticion_codigo",referencedColumnName="codigo"), 
		inverseJoinColumns=@JoinColumn(name="alumno_codigo",
		referencedColumnName="codigo"))
	@Fetch(FetchMode.JOIN)
	private Set<Alumno> alumnos;
	
	
	
	
	
	public Imparticion() {
		super();
	}

	
	
	
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public CursoDetalle getCursodetalle() {
		return cursodetalle;
	}

	public void setCursodetalle(CursoDetalle cursodetalle) {
		this.cursodetalle = cursodetalle;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}





	public Set<Alumno> getAlumnos() {
		return alumnos;
	}





	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}





	@Override
	public String toString() {
		return "Imparticion [codigo=" + codigo + ", cursodetalle=" + cursodetalle + ", profesor=" + profesor
				+ ", alumnos=" + alumnos + "]";
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
		/* Se declara la variable que contendra la comparaci�n de objetos.*/
		boolean valido = false;
		/* Se compruebasi el objeto recibido es nulo.*/
		if (obj != null){
			/* Se comprueba si el objeto recogido es del tipo de la clase.*/
			if (obj instanceof Imparticion){
				/* Se comparan los codigos de la clase actual y el objeto recibido por parametro.*/
				if (this.getCodigo() == ((Imparticion) obj).getCodigo()){
					/* Se asigna verdadero a la comparai�n.*/
					valido = true;				
				}			
			}
		}	
		/* Se devuelve el resultado de la comparaci�n.*/
		return valido;
	}
	
	
	
	
	
}

