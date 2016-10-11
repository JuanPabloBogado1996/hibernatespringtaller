package py.edu.facitec.hibernatespringtaller.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.hibernatespringtaller.dao.PedidoDAO;
import py.edu.facitec.hibernatespringtaller.model.Pedido;

// clase Encargada de manipular peticiones de test 
@RestController
@Transactional

@ RequestMapping("/pedido")

public class PedidoController {

	@Autowired
	private PedidoDAO PedidoDAO;

	//Registrar un Pedidos
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

	//`permite asignar json a un objeto
	public ResponseEntity<Pedido> registrar(@RequestBody Pedido pedido, int ResponseEntity, int Pedido){

		PedidoDAO.guardar(pedido, pedido.getId());

		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);


	}

	//recupera la lista de pedidos
	@RequestMapping(method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<List<Pedido>> obtenerTodos() {   
		
		List<Pedido> pedidos=PedidoDAO.buscarTodos(); 
		
		return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
	}

 @RequestMapping(method=RequestMethod.GET,value="{id}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
 
 //Asigna el id de la url al parametro
 
 
 //Buscar Por id
	public  ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id){

	
	 Pedido pedido= PedidoDAO.buscar(id);

	 System.out.println(pedido);
	 return new ResponseEntity<Pedido>( pedido,HttpStatus.OK);
	
	}
 ///Eliminar 
 @RequestMapping(method=RequestMethod.GET,value="{id}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

 public ResponseEntity<Pedido> eliminar(@PathVariable Integer id){
	 
	 Pedido pedido=PedidoDAO.buscar(id);
	 if (buscarPorId(id)==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	 
	 PedidoDAO.eliminar(pedido);
	 return new ResponseEntity<>(HttpStatus.OK);
	 
 }
   
}
