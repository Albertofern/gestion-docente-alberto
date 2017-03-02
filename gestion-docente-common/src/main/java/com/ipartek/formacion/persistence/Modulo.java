package com.ipartek.formacion.persistence;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="modulo")  // si no se llama modulo, esta anotacion no la añadiriamos (ejemplo)
public class Modulo implements Serializable {
	
	/**
	 * Obligados a serializar la clase. los objetos tienen que ser serializables (el EntityManager)
	 * que los objetos puedan ser pasados a "chorro" de bits.
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // strategy = Como se genera el valor. 
	@Column(name="codigo") // si no se llama codigo, esta anotacion no la añadiriamos (ejemplo)
	private long codigo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="nhoras")
	private int nhoras;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="precio")
	private double precio;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modulo") 
	private Set<CursoDetalle> detalle;
	
	
	
	public Modulo() {
		super();
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
		boolean iguales = false;
		if (obj != null && obj instanceof Curso) {
  			Modulo modulo = (Modulo) obj;
			if (this == modulo || modulo.getCodigo() == this.codigo) {
  				iguales = true;
  			}
  		}
 		return iguales;
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
	public int getNhoras() {
		return nhoras;
	}
	public void setNhoras(int nhoras) {
		this.nhoras = nhoras;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Set<CursoDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(Set<CursoDetalle> detalle) {
		this.detalle = detalle;
	}
	
	
	
		
}
