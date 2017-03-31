package com.ipartek.formacion.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dbms.persistence.Cliente;
import com.ipartek.formacion.service.interfaces.ClienteService;

@Controller
@RequestMapping(value="/clientes")
public class ClienteController {
	
	
	@Inject
	private ClienteService cS =null;
	private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	ModelAndView mav = null;
	
	// --------------------  Para el validador de SPRING  --------------------------
	
	
	@Resource(name="clienteValidator")
	private Validator validator = null;
	
	@InitBinder // Esta anotacion alimenta el metodo init de ese Servlet
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 		sdf.setLenient(true);
 		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
 		binder.setValidator(validator);
	}
	
	// --------------------------- METODOS CRUD ------------------------------------
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll(){
		mav = new ModelAndView("clientes/clientes");
		List<Cliente> clientes = cS.getAll();
		mav.addObject("listadoClientes", clientes);
		return mav;
	}
	
	@RequestMapping(value = "/addCliente")
	public String addCliente(Model model){
		model.addAttribute("cliente", new Cliente());
		return "clientes/cliente";
	}
	
	@RequestMapping(value= "/{id}") // PARA estructurar la URL
	public ModelAndView getById(@PathVariable("id") int id) { // me parsea el id
		mav = new ModelAndView("clientes/cliente");
		mav.addObject("cliente", cS.getById(id)); 
		return mav;
	}
	
	@RequestMapping(value="/deleteCliente/{id}") 
	public String delete(@PathVariable("id") int id){ 
		cS.delete(id);								 
		return"redirect:/clientes";// Que hace esto? Hace una redireccion a "public ModelAndView getAll()"
								   // LO RECICLA, el codigo de getAll()
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCliente(Model model, @ModelAttribute("cliente") @Validated Cliente cliente,
						BindingResult bindingResult) { 
		String destino = ""; // tiene que ir algun if. Aqui va la inset o la update
		
		if (bindingResult.hasErrors()){
			logger.info("cliente tiene errores");
			destino = "/clientes/cliente";
		} else {
			destino = "redirect:/alumnos"; 
			if(cliente.getCodigo() > Cliente.CODIGO_NULO){
				logger.info(cliente.toString());
				cS.update(cliente);
			} else {
				logger.info(cliente.toString());
				cS.create(cliente);
				
			}
		}
		return destino;
	}
	
	// ----------------- METODOS PARA LA QUERY ------------------------
	
	@RequestMapping(value = "/getInforme/{codigo}")
	public String getInforme(Model model, @PathVariable("codigo") int codigo) {
		logger.info("codigo: " + codigo);
		Cliente cliente = cS.getInforme(codigo);
		logger.info(cliente.toString());
		model.addAttribute("cliente", cliente);
		return "/clientes/informe";

	}
	
	
	
}
