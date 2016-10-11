package py.edu.facitec.hibernatespringtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.hibernatespringtaller.dao.DepartamentoDao;

import py.edu.facitec.hibernatespringtaller.model.Departamento;


@Transactional
@Controller
@RequestMapping("/departamento")
public class DepartamentoController {

	//injecta una dependencia
	@Autowired
	private DepartamentoDao departamentoDao;

	@RequestMapping (method=RequestMethod.POST)
	//save: vienen los datos del formulario y se pasan a objeto
	public String guardar(Departamento departamento){
		departamentoDao.guardar(departamento,departamento.getId());
		System.out.println("Registrando el Departamento"+departamento);

		//crea la pagina 
		return "/depatamento/ok";
	}
	//Este resspon de akclinte/formulario

	@RequestMapping(value="/formulario",method=RequestMethod.GET) 
	public String formulario(){
		return "/depatmento/formulario";
	}

	public ModelAndView getLista(){
		ModelAndView model =  new ModelAndView("/departamento/lista");
		return model.addObject("departamento", departamentoDao.buscarTodos());

	}

}
