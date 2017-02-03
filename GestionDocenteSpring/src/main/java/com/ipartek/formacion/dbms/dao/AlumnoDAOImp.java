package com.ipartek.formacion.dbms.dao;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
		final String SQL = "SELECT * FROM alumno";
		List<Alumno> alumnos = null;
		// estructura de usar la conexión. Por cada registro un objeto de tipo alumno
		alumnos = (List<Alumno>) template.queryForObject(SQL, new AlumnoMapper()); // esto hace una query!!
		
		
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