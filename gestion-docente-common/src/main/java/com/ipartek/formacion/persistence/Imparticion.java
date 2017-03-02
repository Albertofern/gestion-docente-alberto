package com.ipartek.formacion.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="curso_detalle_codigo")
	private CursoDetalle cursodetalle;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="profesor_codigo")
	private Profesor profesor;

	
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
	
	
	
	
	
}

