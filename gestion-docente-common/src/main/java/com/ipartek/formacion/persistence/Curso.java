package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Transient;


@Table(name= "curso")
@Entity(name= "curso")
@NamedQueries({ @NamedQuery(name = "curso.getAll", query = "SELECT c FROM curso as c") })
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "curso.getAlumnos", procedureName = "alumnogetByCurso", resultClasses = Alumno.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class) }) })
public class Curso implements Serializable {

	public static final int CODIGO_NULO = -1;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // strategy = Como se genera
													// el valor.
	@Column
	private long codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column
	private String identificador;
	@Column
	private Date finicio;
	@Column
	private Date ffin;
	@Column
	private int nhoras;
	@Column
	private String temario;
	@Column
	private double precio;

	// ------------------------------- RELACIONES ENTRE CLASES
	// ----------------------------------------

	// @OneToMany(fetch = FetchType.LAZY,mappedBy="curso")
	// @Fetch(FetchMode.JOIN)

	/*
	 * Se enlaza la clase curso detalle usando como join la el atributo curso de
	 * la clase curso detalle.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_codigo")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profesor_codigo")
	private Profesor profesor;

	@Transient
	private List<Alumno> alumnos;
	
	private boolean activo;

	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Curso() {
		super();
		this.codigo = CODIGO_NULO;
		this.identificador="";
		this.nombre = "";
		
		
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
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

	public int getNhoras() {
		return nhoras;
	}

	public void setNhoras(int nhoras) {
		this.nhoras = nhoras;
	}

	public String getTemario() {
		return temario;
	}

	public void setTemario(String temario) {
		this.temario = temario;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Curso)) {
			return false;
		}
		Curso other = (Curso) obj;
		if (codigo != other.codigo) {
			return false;
		}
		return true;
	}

	/* Metodo que castea el objeto a String. */
	@Override
	public String toString() {
		return "Curso [codigo=" + this.codigo + ", nombre=" + this.nombre + ", " + "identificador=" + this.identificador
				+ ", " + "finicio=" + this.finicio + ", ffin=" + this.ffin + ", " + "nhoras=" + this.nhoras
				+ ", temario=" + this.temario + ",profesor=" + profesor.toString() + "]";
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

}
