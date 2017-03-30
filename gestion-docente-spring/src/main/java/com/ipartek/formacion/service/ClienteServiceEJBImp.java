/**
 * 
 */
package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.cliente.ClienteServiceRemote;
import com.ipartek.formacion.persistence.Cliente;
import com.ipartek.formacion.service.interfaces.ClienteServiceEJB;

/**
 * @author Alberto Fernandez
 *
 */

@Service("clienteServiceEJB")
public class ClienteServiceEJBImp implements ClienteServiceEJB{

	@Resource(name = "clienteServiceRemote")
	private ClienteServiceRemote clienteServiceRemote;

	@Override
	public void setClienteServiceRemote(ClienteServiceRemote clienteService) {
		this.clienteServiceRemote = clienteService;
		
	}

	@Override
	public List<Cliente> getAll() {
		
		return clienteServiceRemote.getAll();
	}

	@Override
	public Cliente getById(long codigo) {
		
		return clienteServiceRemote.getById(codigo);
	}
	
	
	

}
