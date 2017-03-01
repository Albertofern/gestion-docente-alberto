package com.ipartek.formacion.dbms.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dbms.persistence.Alumno;

/**
 * Esta interfaz define los metodos de consulta a BBDD de la entidad Alumno
 * que tiene su correspondencia en la clase <code>Alumno</code> de la 
 * capa de persistencia
 * 
 * @author Alberto
 *
 */


// Heredan de DAOSetter el metodo setDataSource(DataSource dataSource)
public interface AlumnoDAO extends DAOSetter{
	
	/**
	 * Método que cre un <code>Alumno<code> en la BBDD. El 
	 * <code>Alumno</code> tendra los datos necesarios excepto
	 *  el codigo que es generado por la BBDD
	 * 
	 * @param alumno
	 * @return <code>Alumno</code> se devuelve el objeto enviado con el código
	 * 			generado en la BBDD.
	 * 
	 */
	
	public Alumno create(Alumno alumno);
	
	public List<Alumno> getAll();
	
	public Alumno getById(int codigo);
	
	public Alumno update(Alumno alumno);
	
	public void delete(int codigo);
	
	public Alumno getByDni(String dni);
	
	public Alumno getInforme(int codigo);

}
