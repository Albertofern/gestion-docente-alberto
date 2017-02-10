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

import com.ipartek.formacion.dbms.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dbms.mappers.AlumnoMapper;
import com.ipartek.formacion.dbms.persistence.Alumno;


@Repository("alumnoDaoImp")
public class AlumnoDAOImp implements AlumnoDAO{

	@Autowired 
	private DataSource dataSource;  // Todas las clases DAO implementaran este metodo
	private JdbcTemplate template;
	private Logger logger = LoggerFactory.getLogger(AlumnoDAOImp.class);
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource; //  esto es un setter!! Que se usara para la injección de dependencias.
									  //  (la conexion del OBJETO (Ben del root-contex: mysqlDataSource en el xml.))
		this.template = new JdbcTemplate(dataSource); // para crear la QUERY en el getAll()
	}

	@Override
	public Alumno create(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> getAll() {
		//final String SQL = "SELECT * FROM alumno";
		final String SQL = "CALL alumnogetAll();";
		List<Alumno> alumnos = null;
		
		try{ // Prueba si te devuelve registros (tuplas) del sql
		// estructura de usar la conexión. Por cada registro un objeto de tipo alumno
		alumnos = (List<Alumno>) template.query(SQL, new AlumnoMapper()); // esto hace una query!!
		logger.info(String.valueOf(alumnos.size()));
		}catch (EmptyResultDataAccessException e){
			logger.info("sin datos:" + e.getMessage() + " " + SQL);
			//alumnos = new ArrayList<Alumno>();
		}
		
		return alumnos;
	}

	@Override
	public Alumno getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno update(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub
		
	}

}