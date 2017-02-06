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

import com.ipartek.formacion.dbms.dao.interfaces.ProfesorDAO;
import com.ipartek.formacion.dbms.mappers.ProfesorMapper;
import com.ipartek.formacion.dbms.persistence.Profesor;

@Repository("profesorDaoImp")
public class ProfesorDAOImp implements ProfesorDAO{

	
	@Autowired 
	private DataSource dataSource;  // Todas las clases DAO implementaran este metodo
	private JdbcTemplate template;
	private Logger logger = LoggerFactory.getLogger(ProfesorDAOImp.class);
	
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource; //  esto es un setter!! Que se usara para la injección de dependencias.
									  //  (la conexion del OBJETO (Ben del root-contex: mysqlDataSource en el xml.))
		this.template = new JdbcTemplate(dataSource); // para crear la QUERY en el getAll()
	}

	@Override
	public Profesor create(Profesor profesor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profesor> getAll() {
		final String SQL = "SELECT * FROM profesor";
		List<Profesor> profesores = null;
		
		try { // Prueba si te devuelve registros (tuplas) del sql
			  // estructura de usar la conexión. Por cada registro un objeto de tipo alumno	
		profesores =  template.query(SQL, new ProfesorMapper());
		}catch (EmptyResultDataAccessException e){
			logger.trace(e.getMessage());
			profesores = new ArrayList<Profesor>();
		}
		return profesores;
	}

	@Override
	public Profesor getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profesor update(Profesor profesor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		
	}

}
