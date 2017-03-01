package com.ipartek.formacion.dbms.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;


import com.ipartek.formacion.dbms.dao.interfaces.AlumnoDAO;
import com.ipartek.formacion.dbms.mappers.AlumnoExtractor;
import com.ipartek.formacion.dbms.mappers.AlumnoMapper;
import com.ipartek.formacion.dbms.persistence.Alumno;



@Repository("alumnoDaoImp")
public class AlumnoDAOImp implements AlumnoDAO{

	@Autowired 
	@Qualifier("mysqlDataSource")
	private DataSource dataSource;  // Todas las clases DAO implementaran este metodo
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	private Logger logger = LoggerFactory.getLogger(AlumnoDAOImp.class);
	
	@Value("${alumno.crear}")
	private String sqlCreate;
	@Value("${alumno.borrar}")
	private String sqlDelete;
	@Value("${alumno.editar}")
	private String sqlUpdate;
	@Value("${alumno.obtener.todos}")
	private String sqlReadall;
	@Value("${alumno.obtener.id}")
	private String sqlReadbyid;
	@Value("${alumno.obtener.dni}")
	private String sqlReadbydni;
	
	@Autowired
	@Qualifier("mysqlDataSource")
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource; //  esto es un setter!! Que se usara para la injección de dependencias.
									  //  (la conexion del OBJETO (Ben del root-contex: mysqlDataSource en el xml.))
		this.jdbctemplate = new JdbcTemplate(dataSource); // para crear la QUERY en el getAll()
	
	}

	@Override
	public Alumno create(Alumno alumno) {
		final String SQL = "alumnoCreate";
		
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		
		jdbcCall.withProcedureName(SQL);
		
		
		//crear un mapa con los parametros de procedimientos almacenados
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pnombre", alumno.getNombre())
				.addValue("papellidos", alumno.getApellidos())
				.addValue("pdni", alumno.getDni())
				.addValue("pemail", alumno.getEmail())
				.addValue("ptelefono", alumno.getTelefono())
				.addValue("pfNacimiento", alumno.getfNacimiento())
				.addValue("pdireccion", alumno.getDireccion())
				.addValue("ppoblacion", alumno.getPoblacion())
				.addValue("pcodigopostal", alumno.getCodigoPostal())
				.addValue("pnHermanos", alumno.getnHermanos());
		// Como se ejecuta la consulta?
		//jdbcCall.execute(in);
		
		//logger
		logger.info(alumno.toString());
		
		//Como se recoge los datos?
		Map<String, Object> out = jdbcCall.execute(in);
		// En out se han recogido los parametros out de la consulta a BBDD.
		
		alumno.setCodigo((Integer) out.get("pcodigo"));		
		return alumno;
	}

	@Override
	public List<Alumno> getAll() {
		//final String SQL = "SELECT * FROM alumno";
		final String SQL = "CALL alumnogetAll();";
		List<Alumno> alumnos = null;
		
		try{ // Prueba si te devuelve registros (tuplas) del sql
		// estructura de usar la conexión. Por cada registro un objeto de tipo alumno
		alumnos = jdbctemplate.query(SQL, new AlumnoMapper()); // esto hace una query!!
		logger.info(String.valueOf(alumnos.size()));
		}catch (EmptyResultDataAccessException e){
			logger.info("sin datos:" + e.getMessage() + " " + SQL);
			//alumnos = new ArrayList<Alumno>();
		}
		return alumnos;
	}

	@Override
	public Alumno getById(int codigo) {
		Alumno alumno = null;
		final String SQL = "CALL alumnogetById(?)";
		try{
			alumno = jdbctemplate.queryForObject(SQL, new AlumnoMapper(),new Object[] { codigo });
			logger.info(alumno.toString());
		} catch (EmptyResultDataAccessException e){
			alumno = null;
			logger.info("No se ha encontrado Alumno para codigo: " + codigo + " " + e.getMessage());
		}
		
		return alumno;
	}

	@Override
	public Alumno update(Alumno alumno) {
		final String SQL = "alumnoUpdate";
		
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pcodigo", alumno.getCodigo())
				.addValue("pnombre", alumno.getNombre())
				.addValue("papellidos", alumno.getApellidos())
				.addValue("pdni", alumno.getDni())
				.addValue("pemail", alumno.getEmail())
				.addValue("ptelefono", alumno.getTelefono())
				.addValue("pfNacimiento", alumno.getfNacimiento())
				.addValue("pdireccion", alumno.getDireccion())
				.addValue("ppoblacion", alumno.getPoblacion())
				.addValue("pcodigopostal", alumno.getCodigoPostal())
				.addValue("pnHermanos", alumno.getnHermanos());
				
		
		logger.info(alumno.toString());
		
		// Se ejecuta, no tiene parametro out.
		jdbcCall.execute(in);
		return alumno;
	}

	@Override
	public void delete(int codigo) {
		String SQL = "alumnoDelete";
		this.jdbcCall = new SimpleJdbcCall(dataSource);
		jdbcCall.withProcedureName(SQL);
		logger.error(String.valueOf(codigo));
		SqlParameterSource in = new MapSqlParameterSource()
			.addValue("pcodigo", codigo);
		
		logger.info(String.valueOf(codigo));
		
		jdbcCall.execute(in);
		
	}
	@Override
	public Alumno getByDni(String dni) {
		Alumno alumno = null;
		sqlReadbydni = "call " + sqlReadbydni + "(?);";
		try {
			alumno = jdbctemplate.queryForObject(sqlReadbydni, new AlumnoMapper(), new Object[] { dni });
			logger.info(alumno.toString());
		} catch (EmptyResultDataAccessException e) {
			alumno = null;
			logger.info("No se ha encontrado Alumno para el dni: " + dni + " " + e.getMessage());
		}
		return alumno;
	}
	
	@Override
	public Alumno getInforme(int codigo) {
		Alumno alumno = null;
		final String SQL = "CALL alumnoInforme(?)"; //es la sentencia SQL se se ejecuta en la BBDD. (?) porque se pasa un parametro "el codigo"
	
		try{
			alumno = jdbctemplate.query(SQL, new AlumnoExtractor(), new Object[] { codigo }).get(codigo);
		}catch(EmptyResultDataAccessException e){
			logger.info("sin datos" + e.getMessage() + " " + SQL);
		}

		return alumno;
	}
	


}