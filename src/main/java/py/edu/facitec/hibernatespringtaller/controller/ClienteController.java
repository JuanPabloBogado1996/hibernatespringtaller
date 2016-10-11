package py.edu.facitec.hibernatespringtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import py.edu.facitec.hibernatespringtaller.dao.ClienteDAO;
import py.edu.facitec.hibernatespringtaller.model.Cliente;

//gestiona transasiones
@Transactional
@Controller
@RequestMapping("/cliente")
public class ClienteController {

	//injecta una dependencia
	@Autowired
	private ClienteDAO clienteDao;

	@RequestMapping (method=RequestMethod.POST)
	//save: vienen los datos del formulario y se pasan a objeto
	public String  guardar(Cliente cliente){
		clienteDao.guardar(cliente,cliente.getId());
		System.out.println("Registrando el cliente"+cliente);

		//crea la pagina ok.jsp
		return "/clientes/ok";
	}
//Este resspon de akclinte/formulario
	
	@RequestMapping(value="/formulario",method=RequestMethod.GET) 
	public String formulario(){
		return "/clientes/formulario";
	}

	public ModelAndView getLista(){
		ModelAndView model =  new ModelAndView("/clientes/lista");
		return model.addObject("cliente", clienteDao.buscarTodos());
				
	}
}
