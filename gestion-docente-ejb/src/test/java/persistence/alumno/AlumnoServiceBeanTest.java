/**
 * 
 */
package persistence.alumno;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ipartek.formacion.alumno.AlumnoServiceBean;
import com.ipartek.formacion.alumno.AlumnoServiceRemote;
import com.ipartek.formacion.persistence.Alumno;
import com.ipartek.formacion.persistence.Cliente;
import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.persistence.Profesor;


/**
 * @author Alberto Fernandez
 *
 */
@RunWith(Arquillian.class)
public class AlumnoServiceBeanTest {
	
	@Deployment
	public static Archive<?> createDeployment() {
		File[] files = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve()
				.withTransitivity().asFile();
		WebArchive wa = ShrinkWrap.create(WebArchive.class, "test.war").addClass(Alumno.class).addClass(Curso.class)
				.addClass(AlumnoServiceBean.class).addClass(AlumnoServiceRemote.class).addClass(Profesor.class)
				.addClass(Cliente.class)/*.addAsResource("test-persistence.xml",
										 "META-INF/persistence.xml")*/
				.addAsLibraries(files).addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

		return wa;
	}

	@EJB
	AlumnoServiceRemote as;
	// @PersistenceContext(unitName = "gestiondocente")
	// private EntityManager em;

	@Test
	public void testIsDeployed() {
		assertNotNull(as);
	}

	@Test
	public void getByIdTest() {
		// assertNotNull("No deberia de ser nulo", em.find(Alumno.class, 1));
	}
	
	
	
}
