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
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long codigo;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="curso_detalle_codigo")
	private CursoDetalle cursodetalle;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="profesor_codigo")
	private Profesor profesor;
	
	
}

