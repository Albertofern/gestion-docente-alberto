/**
 * 
 */
package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.cliente.ClienteServiceRemote;
import com.ipartek.formacion.persistence.Cliente;

/**
 * @author Alberto Fernandez
 *
 */
public interface ClienteServiceEJB {

	public void setClienteServiceRemote(ClienteServiceRemote clienteService);

	public List<Cliente> getAll();

	public Cliente getById(long codigo);
}
