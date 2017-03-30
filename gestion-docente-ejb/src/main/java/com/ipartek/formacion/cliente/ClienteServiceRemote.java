/**
 * 
 */
package com.ipartek.formacion.cliente;

import java.util.List;

import com.ipartek.formacion.persistence.Cliente;


/**
 * @author Alberto Fernandez
 *
 */
public interface ClienteServiceRemote {

	public List<Cliente> getAll();
	public Cliente getById(long codigo);
	// Cliente update(Cliente cliente);
	//public Cliente create(Cliente cliente);
	//public void delete(long codigo);
	
	
}
