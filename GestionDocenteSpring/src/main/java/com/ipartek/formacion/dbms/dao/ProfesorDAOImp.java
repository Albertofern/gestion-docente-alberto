package com.ipartek.formacion.dbms.dao;

import java.util.ArrayList;
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

import com.ipartek.formacion.dbms.dao.interfaces.ProfesorDAO;
import com.ipartek.formacion.dbms.mappers.ProfesorMapper;
import com.ipartek.formacion.dbms.persistence.Profesor;

@Repository("profesorDaoImp")
public class ProfesorDAOImp implements ProfesorDAO{

	
	@Autowired 
	private DataSource dataSource;  // Todas las clases DAO implementaran este metodo
	private JdbcTemplate jdbctemplate;
	
	private SimpleJdbcCall jdbcCall;
	
	private Logger logger = LoggerFactory.getLogger(ProfesorDAOImp.class);
	
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource; //  esto es un setter!! Que se usara para la injección de dependencias.
									  //  (la conexion del OBJETO (Ben del root-contex: mysqlDataSource en el xml.))
		this.jdbctemplate = new JdbcTemplate(dataSource); // para crear la QUERY en el getAll()
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}

	@Override
	public Profesor create(Profesor profesor) {
		final String SQL = "profesorCreate";
		
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		
		jdbcCall.withProcedureName(SQL);
		
		//crear un mapa con los parametros de procedimientos almacenados
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pnombre", profesor.getNombre())
				.addValue("papellidos", profesor.getApellidos())
				.addValue("pdni", profesor.getDni())
				.addValue("pnss", profesor.getnSS())
				.addValue("pemail", profesor.getEmail())
				.addValue("pdireccion", profesor.getDireccion())
				.addValue("pcodigopostal", profesor.getCodigoPostal())
				.addValue("pfNacimiento", profesor.getfNacimiento())
				.addValue("ptelefono", profesor.getTelefono());
		logger.info(profesor.toString());
		
		//Como se recoge los datos?
		Map<String, Object> out = jdbcCall.execute(in);
		// En out se han recogido los parametros out de la consulta a BBDD.		
		
		profesor.setCodigo((Integer) out.get("pcodigo"));
		
		return profesor;
	}

	@Override
	public List<Profesor> getAll() {
		final String SQL = "CALL profesorgetAll();";
		List<Profesor> profesores = null;
		
		try { // Prueba si te devuelve registros (tuplas) del sql
			  // estructura de usar la conexión. Por cada registro un objeto de tipo alumno	
		profesores =  jdbctemplate.query(SQL, new ProfesorMapper());
		}catch (EmptyResultDataAccessException e){
			logger.trace(e.getMessage());
			//profesores = new ArrayList<Profesor>();
		}
		return profesores;
	}

	@Override
	public Profesor getById(int codigo) {
		Profesor profesor = null;
		final String SQL = "CALL profesorgetById(?)";
		
		try{
			profesor = jdbctemplate.queryForObject(SQL, new ProfesorMapper(),new Object[] { codigo });
			logger.info(profesor.toString());
		}catch (EmptyResultDataAccessException e){
			profesor = new Profesor();
			logger.info("No se ha encontrado Alumno para codigo: " + codigo + " " + e.getMessage());
		}
		
		return profesor;
	}

	@Override
	public Profesor update(Profesor profesor) {
		final String SQL = "profesorUpdate";
		
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pnombre", profesor.getNombre())
				.addValue("papellidos", profesor.getApellidos())
				.addValue("pdni", profesor.getDni())
				.addValue("pnss", profesor.getnSS())
				.addValue("pdireccion", profesor.getDireccion())
				.addValue("pcodigopostal", profesor.getCodigoPostal())
				.addValue("pemail", profesor.getEmail())
				.addValue("pfNacimiento", profesor.getfNacimiento())
				.addValue("ptelefono", profesor.getTelefono());
		
		logger.info(profesor.toString());
		
		jdbcCall.execute(in);
		return profesor;
	}

	@Override
	public void delete(int codigo) {
		final String SQL = "profesorDelete";
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource()
		.addValue("pcodigo", codigo);
		
		jdbcCall.execute(in);
		
	}

}
