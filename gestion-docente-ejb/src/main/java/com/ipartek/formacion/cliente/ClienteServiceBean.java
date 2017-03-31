/**
 * 
 */
package com.ipartek.formacion.cliente;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistence.Cliente;

/**
 * @author Alberto Fernandez
 *
 */
@Stateless(name="clienteServiceBean")
public class ClienteServiceBean implements ClienteServiceRemote{

	@PersistenceContext(unitName = "gestiondocente")
	private EntityManager entityManager;

	
	@Override
	public List<Cliente> getAll() {
		TypedQuery<Cliente> clientes = entityManager.createNamedQuery("cliente.getAll",  Cliente.class);
		return clientes.getResultList();
	}

	@Override
	public Cliente getById(long codigo) {
		Cliente cliente = entityManager.find(Cliente.class, codigo);
		return cliente;
	}

	/*@Override
	public Cliente update(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente create(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long codigo) {
		// TODO Auto-generated method stub
	}*/

}
