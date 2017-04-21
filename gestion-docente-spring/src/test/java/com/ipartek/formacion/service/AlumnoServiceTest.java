package com.ipartek.formacion.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.DuplicateFormatFlagsException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.ipartek.formacion.dbms.persistence.Alumno;
import com.ipartek.formacion.service.interfaces.AlumnoService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class AlumnoServiceTest {

		@Autowired
		AlumnoService aS;
		
		int[] codigos;
		
		Alumno alumno;
		List<Alumno> alumnos;
		
		
		
		@Before
		public void setUp() throws Exception {
			alumno = new Alumno();
			alumno.setNombre("Jon Koldobika");
			alumno.setApellidos("ajuriagogeaskoa Belaustegigoitia");
			alumno.setDni("12345678d");
			alumno.setCodigoPostal(45005);
			codigos= new int[4];
			codigos[0]= 0;
			codigos[1]= 1;
			codigos[2]= 2;
			codigos[3]= 3;
		}
		
		@After
		public void tearDown() throws Exception {
			alumno = null;
		}
		
		
		@Test //test unitario 
		public void testclase(){	
			assertEquals("class com.ipartek.formacion.service.AlumnoServiceImp", this.aS.getClass().toString());
		}
		
		//@Ignore
		@Test(expected= DuplicateFormatFlagsException.class)
		public void create(){
			Alumno alum = aS.create(alumno);
			
			assertNotNull("El alumno es nulo", alum); // Cuando "alum" sea NULO //Espero que NO sea NULO
			//todos los atributos
			assertTrue("El codigo debe ser mayor que 0", alum.getCodigo()>0); // cuando esto "alum.getCodigo()>0" sea FALSO 
			assertFalse("El codigo debe se menor que 0", alum.getCodigo()<0);
			assertEquals("El nombre no es identico", alum.getNombre(), alumno.getNombre());
			// apellidos, dni, fecha....
			
			assertEquals("Los datos no son identicos", alum,aS.getById(alum.getCodigo()));
			
			//alum= aS.create(alumno);
			aS.delete(alum.getCodigo());
			
			//fail("no implementado");
		}
		
		@Test
		public void deleteTest(){
			Alumno alum = aS.create(alumno);
			aS.delete(alum.getCodigo());
			assertNull("El alumno no se ha borrado correctamente", aS.getById(alum.getCodigo()));
			
			aS.delete(-1);	
		}
		
		
		@Test(timeout = 500)
		public void getAllTest(){
			List<Alumno> alumnos = aS.getAll();
			int size = 4;
			assertEquals("numero de alumnos incorrecto",size , alumnos.size());		
		}
		
		@Test
		public void getByIdTest(){
			for(int i=0; i<codigos.length; i++){
				Alumno alum = aS.getById(codigos[i]);
				assertNotNull("El alumno tiene que existir. El alumno con codigo " 
							+ codigos[i] + " esta en BBDDs",	
							alum);
				assertEquals("El codigo del alumno no coincide. El codigo enviado es:" + codigos[i] 
							+ " y el recibido es:" + alum.getCodigo(),
							codigos[i], alum.getCodigo());
			}
		}
	
	
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
		}
	
		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		}
	

}
