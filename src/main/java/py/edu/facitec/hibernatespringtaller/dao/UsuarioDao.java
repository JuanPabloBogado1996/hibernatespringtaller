package py.edu.facitec.hibernatespringtaller.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import py.edu.facitec.hibernatespringtaller.model.Usuario;




public class UsuarioDao extends DaoGenerico<Usuario>{
	
	private EntityManagerFactory factory;
	private EntityManager em;
	
	public UsuarioDao(){
	super(Usuario.class);
	factory=Persistence.createEntityManagerFactory("");
	em=factory.createEntityManager();
	}

	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

}
