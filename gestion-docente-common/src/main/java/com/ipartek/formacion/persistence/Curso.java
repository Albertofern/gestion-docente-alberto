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





@Table(name="curso")
@Entity(name="curso")
@NamedQueries({@NamedQuery(name= "curso.getAll", query = "SELECT c FROM curso as c") })
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name="curso.getAlumnos",
				procedureName="alumnogetByCurso", resultClasses= Alumno.class, 
				parameters={@StoredProcedureParameter(mode= ParameterMode.IN,
				type=Long.class)})})
public class Curso implements Serializable{

	public static final int CODIGO_NULO = -1;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // strategy = Como se genera el valor. 
	private long codigo;
	@Column(name = "nombre")
	private String nombre;
	private String identificador;
	private Date finicio;
	private Date ffin;
	private int nhoras;
	private String temario;
	private double precio;

	//------------------------------- RELACIONES ENTRE CLASES ----------------------------------------

	//@OneToMany(fetch = FetchType.LAZY,mappedBy="curso")
	//@Fetch(FetchMode.JOIN)
	
	
	/* Se enlaza la clase curso detalle usando como join la el atributo curso de la clase curso detalle. */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cliente_codigo")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="profesor_codigo")
	private Profesor profesor;

	@Transient
	private List<Alumno> alumnos;
	

	public Curso() {
		super();
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
		return identificador;
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
 			if (obj instanceof Curso){
  				/* Se comparan los codigos de la clase actual y el objeto recibido por parametro.*/
				if (this.getCodigo() == ((Curso) obj).getCodigo()){
  					/* Se asigna verdadero a la comparai�n.*/
  					valido = true;				
				}			
 			}
 		}	
 		/* Se devuelve el resultado de la comparaci�n.*/
 		return valido;
 	}
 	
 	/* Metodo que castea el objeto a String. */
 	@Override
 	public String toString() {
 		return "Curso [codigo=" + this.codigo + ", nombre=" + this.nombre + ", " +
 	                  "identificador=" + this.identificador + ", "+
 	                  "finicio=" + this.finicio + ", ffin=" + this.ffin + ", " +
 	                  "nhoras=" + this.nhoras + ", temario=" + this.temario + ",profesor=" + profesor.toString() + "]";
 	}


	





	public Cliente getCliente() {
		return cliente;
	}






	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}






	public List<Alumno> getAlumnos() {
		return alumnos;
	}






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
	 * @param profesor the profesor to set
	 */
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	
	
	
}
