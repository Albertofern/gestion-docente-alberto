package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="alumno")
public class Alumno implements Serializable{

	private static final long serialVersionUID = -468805280262731464L;
	@Id
	@GeneratedValue
	@Column(name = "codigo")// si el campo de la bbdd no se llama igual
	private long codigo;
	private String nombre;
	private String apellidos;
	private Date fNacimiento;
	private String dni;
	private String email;
	private String poblacion;
	private String direccion;
	private Integer codigopostal;
	private String telefono;
	private int nHermanos;
	private boolean activo;
	//@Fetch(FetchMode.JOIN) // porque son datos subceptibles a repeticion. Si fuese imprescindible una List se tendria
	// que incluir esta anotacion  con JOIN o SUBSELECT
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "asistente", 
		joinColumns= @JoinColumn(name="alumno_codigo", referencedColumnName  = "codigo"),
		inverseJoinColumns = @JoinColumn(name="imparticion_codigo", referencedColumnName="codigo"))
	private Set<Imparticion> imparticiones;
	
	
	
	public Alumno() {
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getfNacimiento() {
		return fNacimiento;
	}
	public void setfNacimienteo(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCodigopostal() {
		return codigopostal;
	}
	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getnHermanos() {
		return nHermanos;
	}
	public void setnHermanos(int nHermanos) {
		this.nHermanos = nHermanos;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	/* Metodo que asigna un codigo unitario al objeto. */
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
			if (obj instanceof Alumno){
				/* Se comparan los codigos de la clase actual y el objeto recibido por parametro.*/
				if (this.getCodigo() == ((Alumno) obj).getCodigo()){
					/* Se asigna verdadero a la comparai�n.*/
					valido = true;				
				}			
			}
		}	
		/* Se devuelve el resultado de la comparacion.*/
		return valido;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Alumno [codigo=" + this.codigo + ", dni=" + this.dni + ", nombre=" + this.nombre + ", "+
					   "apellidos=" + this.apellidos + ", fNacimiento=" + this.fNacimiento + ", " +
				       "email=" + this.email + ", direccion=" + this.direccion + ", " +
					   "codigopostal=" + this.codigopostal + ", poblacion=" + this.poblacion + ", " +
					   "telefono=" + this.telefono + "]";
	}
	
}
