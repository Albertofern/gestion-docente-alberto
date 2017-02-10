package com.ipartek.formacion.dbms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dbms.dao.interfaces.ClienteDAO;
import com.ipartek.formacion.dbms.mappers.ClienteMapper;
import com.ipartek.formacion.dbms.persistence.Cliente;

@Repository("clienteDaoImp")
public class ClienteDAOImp  implements ClienteDAO{

	@Autowired 
	private DataSource dataSource;  // Todas las clases DAO implementaran este metodo
	private JdbcTemplate jdbctemplate;
	private Logger logger = LoggerFactory.getLogger(ClienteDAOImp.class);
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource); // para crear la QUERY en el getAll()
	}
		


	@Override
	public Cliente create(Cliente cliente) {
		// TODO Auto-generated method stub
				return null;
	}
	

	@Override
	public List<Cliente> getAll() {
		//final String SQL = "SELECT * FROM cliente";
		final String SQL = "CALL clientegetAll();";
		List<Cliente> clientes = null;
			try{
			clientes = jdbctemplate.query(SQL, new ClienteMapper());
			logger.info(String.valueOf(clientes.size()));
			}catch (EmptyResultDataAccessException e){
				logger.info("sin datos:" + e.getMessage() + " " + SQL);
				//clientes = new ArrayList<Cliente>();
			}
			return clientes;
	}

	@Override
	public Cliente getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente update(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		
	}

}
