package com.ipartek.formacion.dbms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ipartek.formacion.dbms.persistence.Cliente;
import com.ipartek.formacion.persistence.Curso;

public class ClienteExtractor implements ResultSetExtractor<Map<Integer,Cliente>> {

	@Override
	public Map<Integer, Cliente> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
		
		
		while (rs.next()){
			//recogemos el codigo del cliente
			Long codigo = rs.getLong("codigo");
			//recogemos el cliente del mapa, que si no existe devolveremos null
			Cliente cliente = clientes.get(codigo);
			
			if (cliente == null){
				cliente = new Cliente();
				cliente.setNombre(rs.getString("nombre"));
				cliente.setIdentificador(rs.getString("identificador"));
				cliente.setCodigoPostal(rs.getInt("codigopostal"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setEmail(rs.getString("email"));
				cliente.setPoblacion(rs.getString("poblacion"));
				cliente.setTelefono(String.valueOf(rs.getInt("telefono")));	
				cliente.setActivo(rs.getBoolean("activo"));
				cliente.setCodigo(rs.getInt("codigo"));
				
				cliente.setCursos(new HashMap<Long, Curso>());
			}	
			// Aqui es donde cargamos el mapa/coleccion de cursos
			Map<Long,Curso> cursos = cliente.getCursos();
		
			Curso curso = new Curso(); //coge los datos de la consulta de BBDD
			curso.setCodigo(rs.getLong("codigocurso"));
			curso.setNombre(rs.getString("nombrecurso"));
			curso.setFinicio(rs.getDate("finicio"));
			curso.setFfin(rs.getDate("ffin"));
			curso.setNhoras(rs.getInt("nhoras"));
			//guardas el curso en el map	
			cursos.put(curso.getCodigo(), curso);
			//guardas el mapa en el cliente
			cliente.setCursos(cursos);
			//guarda el cliente en su mapa
			clientes.put(cliente.getCodigo(),cliente);
		}
		
		return clientes;
	}

}
