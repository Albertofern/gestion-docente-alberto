package com.ipartek.formacion.dbms.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dbms.persistence.Cliente;

/**
 * Esta interfaz define los metodos de consulta a BBDD de la entidad Cliente
 * que tiene su correspondencia en la clase <code>Cliente</code> de la 
 * capa de persistencia
 * 
 * @author Alberto
 *
 */

public interface ClienteDAO extends DAOSetter{
	/**
	 * Método que cre un <code>Cliente<code> en la BBDD. El 
	 * <code>Cliente</code> tendra los datos necesarios excepto
	 *  el codigo que es generado por la BBDD
	 * 
	 * @param alumno
	 * @return <code>Cliente</code> se devuelve el objeto enviado con el código
	 * 			generado en la BBDD.
	 * 
	 */
	
	public Cliente create(Cliente cliente);
	
	public List<Cliente> getAll();
	
	public Cliente getById(int codigo);
	
	public Cliente update(Cliente cliente);
	
	public void delete(int codigo);
	
}
