package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	// Curso donde se a generado
	// y el modulo que ....  AMBOS ManyToOne
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="curso_codigo")
	private Curso curso;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="modulo_codigo")
	private Modulo modulo;
	private Date fInicio;
	private Date fFin;
	
	
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
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}
	
	
	
}