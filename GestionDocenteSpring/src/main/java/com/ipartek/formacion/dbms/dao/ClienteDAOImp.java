package com.ipartek.formacion.dbms.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dbms.dao.interfaces.ClienteDAO;
import com.ipartek.formacion.dbms.mappers.ClienteMapper;
import com.ipartek.formacion.dbms.persistence.Cliente;

@Repository("clienteDaoImp")
public class ClienteDAOImp  implements ClienteDAO{

	@Autowired 
	private DataSource dataSource;  // Todas las clases DAO implementaran este metodo
	private JdbcTemplate jdbctemplate;
	
	private SimpleJdbcCall jdbcCall;
	
	private Logger logger = LoggerFactory.getLogger(ClienteDAOImp.class);
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource); // para crear la QUERY en el getAll()
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}
		


	@Override
	public Cliente create(Cliente cliente) {
		final String SQL = "clienteCreate";
		
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		
		jdbcCall.withProcedureName(SQL);
		
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pnombre", cliente.getNombre())
				.addValue("pidentificador", cliente.getIdentificador())
				.addValue("ptelefono", cliente.getTelefono())
				.addValue("pemail", cliente.getEmail())
				.addValue("pdireccion", cliente.getDireccion())
				.addValue("pcodigopostal", cliente.getCodigoPostal())
				.addValue("ppoblacion", cliente.getPoblacion());
		
		logger.info(cliente.toString());
		
		Map<String, Object> out = jdbcCall.execute(in);
		
		cliente.setCodigo((Integer) out.get("pcodigo"));
		return cliente;
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
		Cliente cliente = null;
		final String SQL = "CALL clientegetById(?)";
		try{
			cliente = jdbctemplate.queryForObject(SQL, new ClienteMapper(), new Object[] { codigo });
			logger.info(cliente.toString());
		}catch (EmptyResultDataAccessException e) {
			cliente = new Cliente();
			logger.info("No se ha encontrado Curso para codigo: " + codigo + " " + e.getMessage());
		}

		
		return cliente;
	}

	@Override
	public Cliente update(Cliente cliente) {
		final String SQL = "clienteUpdate";
		
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pnombre", cliente.getNombre())
				.addValue("pidentificador", cliente.getIdentificador())
				.addValue("ptelefono", cliente.getTelefono())
				.addValue("pemail", cliente.getEmail())
				.addValue("pdireccion", cliente.getDireccion())
				.addValue("pcodigopostal", cliente.getCodigoPostal())
				.addValue("ppoblacion", cliente.getPoblacion())
				.addValue("pcodigo", cliente.getCodigo());
		
		logger.info(cliente.toString());
		
		jdbcCall.execute(in);
		return cliente;
	}

	@Override
	public void delete(int codigo) {
		final String SQL = "clienteDelete";
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pcodigo", codigo);
		
		logger.info(String.valueOf(codigo));
		
		jdbcCall.execute(in);
		
	}
	
	@Override
	public Cliente getByIdentificador(String identificador) {
		// TODO Auto-generated method stub
		return null;
	}

}
