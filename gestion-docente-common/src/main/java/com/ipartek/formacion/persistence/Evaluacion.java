package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="evaluacion")
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
	
	
	
	
}
