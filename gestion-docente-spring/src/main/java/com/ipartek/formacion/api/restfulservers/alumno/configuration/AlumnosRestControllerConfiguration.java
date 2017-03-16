package com.ipartek.formacion.api.restfulservers.alumno.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration // especifica que configura lo de la ruta com.ipartek..
@EnableWebMvc // me trate la clase como un archivo de configuracion web
@ComponentScan(basePackages= "com.ipartek.formacion.api.restfulservers.alumno.configuration") // escanea el rest
public class AlumnosRestControllerConfiguration {

	
	
	
	
}
