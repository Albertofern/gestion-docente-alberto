package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="evaluacion")
@NamedQueries({@NamedQuery(name="evaluacion.getAll",query="Select e From evaluacion as e")})
public class Evaluacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5404111911084872480L;
	@Id
	@GeneratedValue
	private long codigo;
	private Date fExamen;
	private int nota;
	
	/*
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="alumno_codigo")
	private Alumno alumno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="imparticion_codigo")
	private Imparticion imparticion;
	*/
	
	
	public Evaluacion() {
		super();
	}
	
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public Date getfExamen() {
		return fExamen;
	}
	public void setfExamen(Date fExamen) {
		this.fExamen = fExamen;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}


	@Override
	public String toString() {
		return "Evaluacion [codigo=" + codigo + ", fExamen=" + fExamen + ", nota=" + nota + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}


	/* Metodo que implementa la comparación. */
	@Override
	public boolean equals(Object obj) {
		/* Se declara la variable que contendra la comparaci�n de objetos.*/
		boolean valido = false;
		/* Se compruebasi el objeto recibido es nulo.*/
		if (obj != null){
			/* Se comprueba si el objeto recogido es del tipo de la clase.*/
			if (obj instanceof Evaluacion){
				/* Se comparan los codigos de la clase actual y el objeto recibido por parametro.*/
				if (this.getCodigo() == ((Evaluacion) obj).getCodigo()){
					/* Se asigna verdadero a la comparai�n.*/
					valido = true;				
				}			
			}
		}	
		/* Se devuelve el resultado de la comparaci�n.*/
		return valido;
	}

	/*
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Imparticion getImparticion() {
		return imparticion;
	}
	public void setImparticion(Imparticion imparticion) {
		this.imparticion = imparticion;
	}
	*/
	
	
	
}
