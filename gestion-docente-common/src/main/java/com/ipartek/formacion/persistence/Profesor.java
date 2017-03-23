package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "profesor")
@Table(name = "profesor")
public class Profesor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 865873567733136148L;
	@Id
	@GeneratedValue
	private long codigo;
	private String nombre;
	private String apellidos;
	private String nss;
	private String dni;
	private String email;
	private String direccion;
	private Integer codigopostal;
	private String telefono;
	private String poblacion;
	private boolean activo;
	private Date fNacimiento;
	
	
	// esta clase es la que tiene varias. onetomany  one (la primera) hace la referencia a la otra tabla
	// En un Set no puede haber dos datos iguales.
	
	
	@OneToMany(fetch = FetchType.EAGER , mappedBy="profesor")
	private Set<Imparticion> imparticiones;
	
	public Profesor() {
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
	public String getNss() {
		return nss;
	}
	public void setNss(String nss) {
		this.nss = nss;
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
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public Date getfNacimiento() {
		return fNacimiento;
	}
	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public Set<Imparticion> getImparticiones() {
		return imparticiones;
	}


	public void setImparticiones(Set<Imparticion> imparticiones) {
		this.imparticiones = imparticiones;
	}


	public void setCodigopostal(Integer codigopostal) {
		this.codigopostal = codigopostal;
	}
	
	
	
	
	
}
