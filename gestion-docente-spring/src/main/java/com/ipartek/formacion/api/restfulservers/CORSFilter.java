package com.ipartek.formacion.api.restfulservers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
										
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		//tenemos que parsear el ServletRequest y el ServletResponse				
		HttpServletResponse response = (HttpServletResponse) res;
		// cambiar los encabezados
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		//--------------- COSAS que podriamos capar -------------------------
		// "POST,GET,PUT" no nos dejaria hacer el DELETE
		response.setHeader("Access-Control-Allow-Method", "POST,GET,DELETE,PUT");
		// Para que una peticion tenga un tiempo maximo. por si se queda pillado.
		response.setHeader("Access-Control-Max-Age", "3600");
		// capar las peticiones por tipo 
		response.setHeader("Access-Control-Allow-Headers", "x-request-with");
		
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
