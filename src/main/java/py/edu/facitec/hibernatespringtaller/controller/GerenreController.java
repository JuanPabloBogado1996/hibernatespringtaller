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
import py.edu.facitec.hibernatespringtaller.dao.GerenteDao;
import py.edu.facitec.hibernatespringtaller.model.Gerente;





@RestController
@Transactional

@ RequestMapping("/usuario")

public  class GerenreController extends DaoGenerico<Gerente> {

	public GerenreController(Class<Gerente> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private GerenteDao gerenteDao;

	//Registrar un Pedidos
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

	//`permite asignar json a un objeto
	public ResponseEntity<Gerente> registrar(@RequestBody Gerente gerente, int ResponseEntity, Gerente gerentes){

		//Usuario.guardar(usuario,usuario.);

		return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);


	}

	//se odtinen la lista 
	@RequestMapping(method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<Gerente>> obtenerTodos() {   

		List<Gerente> usuarios=gerenteDao.buscarTodos(); 

		return new ResponseEntity<List<Gerente>>(usuarios, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET,value="{id}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

	//Asigna el id de la url al parametro


	//Buscar Por id
	public  ResponseEntity<Gerente> buscarPorId(@PathVariable Integer id){


		Gerente gerente=gerenteDao.buscar(id);

		System.out.println(gerente);
		return new ResponseEntity<Gerente>( gerente,HttpStatus.OK);

	}
	///Eliminar 
	@RequestMapping(method=RequestMethod.GET,value="{id}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Gerente> eliminar(@PathVariable Integer id){

		Gerente gerente=gerenteDao.buscar(id);
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
