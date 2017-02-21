package com.ipartek.formacion.dbms.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dbms.persistence.Profesor;

/**
	 * Esta interfaz define los metodos de consulta a BBDD de la entidad Alumno
	 * que tiene su correspondencia en la clase <code>Alumno</code> de la 
	 * capa de persistencia
	 * 
	 * @author Alberto
	 *
	 */

//Heredan de DAOSetter el metodo setDataSource(DataSource dataSource)
public interface ProfesorDAO extends DAOSetter{

	/**
	 * Método que crea un <code>Alumno<code> en la BBDD. El 
	 * <code>Alumno</code> tendra los datos necesarios excepto
	 *  el codigo que es generado por la BBDD
	 * 
	 * @param alumno
	 * @return <code>Alumno</code> se devuelve el objeto enviado con el código
	 * 			generado en la BBDD.
	 * 
	 */
	
	public Profesor create(Profesor profesor);
	
	public List<Profesor> getAll();
	
	public Profesor getById(int codigo);
	
	public Profesor update(Profesor profesor);
	
	public void delete(int codigo);
	
	public Profesor getByDni(String dni);
	
	public Profesor getByNss(String nss);
	
	
	
}
