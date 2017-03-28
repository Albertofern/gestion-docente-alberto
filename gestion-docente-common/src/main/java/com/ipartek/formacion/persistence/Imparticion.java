package com.ipartek.formacion.persistence;

import java.io.Serializable;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "imparticion")
@Table(name="imparticion")
public class Imparticion  implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6354577982488490172L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	

	
	/* Se une con el curso profesor.
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="profesor_codigo")
	private Profesor profesor;*/

	
	/* Se declara un atributo para contener los modulos del alumno sin carga por defecto.
	 * @Fetch(FetchMode.JOIN) sirve para que no falle si se repeite una Imparticion.(Es un problema de JAVA). 
	 *   También se puede solucionar trabajando con SET en vez de LIST ya que SET no permite duplicados.
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="asistente",
		joinColumns= @JoinColumn(name="imparticion_codigo",referencedColumnName="codigo"), 
		inverseJoinColumns=@JoinColumn(name="alumno_codigo",
		referencedColumnName="codigo"))
	@Fetch(FetchMode.JOIN)
	private Set<Alumno> alumnos;*/
	

	public Imparticion() {
		super();
	}

	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
}