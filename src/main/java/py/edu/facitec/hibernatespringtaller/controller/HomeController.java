package py.edu.facitec.hibernatespringtaller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Indicamos que se encargara de las peticiones del usuario
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(){
		
			//Pagina a ser visualizada   
		
		return "hello-world";//en appweb se completa el .jsp
	}
	

}
