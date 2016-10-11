package py.edu.facitec.hibernatespringtaller.controller;

import java.util.List;

import javax.persistence.EntityManager;
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

import py.edu.facitec.hibernatespringtaller.dao.DaoGenerico;
import py.edu.facitec.hibernatespringtaller.dao.UsuarioDao;
import py.edu.facitec.hibernatespringtaller.model.Usuario;




@RestController
@Transactional

@ RequestMapping("/usuario")

public  class UsuarioController extends DaoGenerico<Usuario> {

	public UsuarioController(Class<Usuario> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private UsuarioDao usuarioDao;

	//Registrar un Pedidos
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

	//`permite asignar json a un objeto
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario, int ResponseEntity, Usuario usuarios){

		//Usuario.guardar(usuario,usuario.);

		return new ResponseEntity<Usuario>(usuarios, HttpStatus.OK);


	}

	//se odtinen la lista 
	@RequestMapping(method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<Usuario>> obtenerTodos() {   

		List<Usuario> usuarios=usuarioDao.buscarTodos(); 

		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET,value="{id}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

	//Asigna el id de la url al parametro


	//Buscar Por id
	public  ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id){


		Usuario usuario = usuarioDao.buscar(id);

		System.out.println(usuario);
		return new ResponseEntity<Usuario>( usuario,HttpStatus.OK);

	}
	///Eliminar 
	@RequestMapping(method=RequestMethod.GET,value="{id}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Usuario> eliminar(@PathVariable Integer id){

		Usuario usuario =usuarioDao.buscar(id);
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
