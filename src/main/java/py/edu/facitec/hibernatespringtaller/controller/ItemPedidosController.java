package py.edu.facitec.hibernatespringtaller.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.hibernatespringtaller.dao.DaoGenerico;
import py.edu.facitec.hibernatespringtaller.dao.ItemPedidosDao;

import py.edu.facitec.hibernatespringtaller.model.ItemPedido;





@RestController
@Transactional

@ RequestMapping("/usuario")

public class ItemPedidosController extends DaoGenerico<ItemPedido> {

	public ItemPedidosController(Class<ItemPedido> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private ItemPedidosDao itemPedidosDao;

	//Registrar un Pedidos
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

	//`permite asignar json a un objeto
	public ResponseEntity<ItemPedido> registrar(@RequestBody ItemPedido itemPedido, int ResponseEntity,ItemPedido iPedido ){

		//Usuario.guardar(usuario,usuario.);

		return new ResponseEntity<ItemPedido>(iPedido, HttpStatus.OK);


	}

	//se odtinen la lista 
	@RequestMapping(method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<ItemPedido>> obtenerTodos() {   

		List<ItemPedido> itemPedidos=itemPedidosDao.buscarTodos(); 

		return new ResponseEntity<List<ItemPedido>>(itemPedidos, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET,value="{id}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

	//Asigna el id de la url al parametro


	//Buscar Por id
	public  ResponseEntity<ItemPedido> buscarPorId(@PathVariable Integer id){


		ItemPedido itemPedido=itemPedidosDao.buscar(id);

		System.out.println(itemPedido);
		return new ResponseEntity<ItemPedido>( itemPedido,HttpStatus.OK);

	}
	///Eliminar 
	@RequestMapping(method=RequestMethod.GET,value="{id}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<ItemPedido> eliminar(@PathVariable Integer id){

		ItemPedido itemPedido=itemPedidosDao.buscar(id);
		if (buscarPorId(id)==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return eliminar(id);

	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}



}
