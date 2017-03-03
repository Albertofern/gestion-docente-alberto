package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/*
 * @NamedQueries({@NamedQuery(name="curso_detalle.getAll",query="Select c From curso_detalle as c")})
 */
@Entity
@Table(name= "curso_detalle")
public class CursoDetalle implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5340310142094950868L;
	@Id
	@GeneratedValue
	private long codigo;

	/* Se asocia con el curso. */
	// Curso donde se a generado
	// y el modulo que ....  AMBOS ManyToOne
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="curso_codigo")
	private Curso curso;
	
	/* Se asocia con el modulo. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="modulo_codigo")
	private Modulo modulo;
	
	/* Se une con el curso detalle.*/
	@OneToOne(fetch=FetchType.EAGER,mappedBy="cursodetalle")
	private Imparticion imparticion; 
	
	
	private Date finicio;
	private Date ffin;
	
	
	public CursoDetalle() {
		super();
	}
	
	
	

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Date getfInicio() {
		return finicio;
	}

	public Date getFinicio() {
		return finicio;
	}

	public void setFinicio(Date finicio) {
		this.finicio = finicio;
	}

	public Date getFfin() {
		return ffin;
	}

	public void setFfin(Date ffin) {
		this.ffin = ffin;
	}




	public Imparticion getImparticion() {
		return imparticion;
	}




	public void setImparticion(Imparticion imparticion) {
		this.imparticion = imparticion;
	}




	@Override
	public String toString() {
		return "CursoDetalle [codigo=" + codigo + ", curso=" + curso + ", modulo=" + modulo + ", imparticion="
				+ imparticion + ", finicio=" + finicio + ", ffin=" + ffin + "]";
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
			if (obj instanceof CursoDetalle){
				/* Se comparan los codigos de la clase actual y el objeto recibido por parametro.*/
				if (this.getCodigo() == ((CursoDetalle) obj).getCodigo()){
					/* Se asigna verdadero a la comparai�n.*/
					valido = true;				
				}			
			}
		}	
		/* Se devuelve el resultado de la comparaci�n.*/
		return valido;
	}

	
	
}
