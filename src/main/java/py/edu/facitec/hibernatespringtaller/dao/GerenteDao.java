package py.edu.facitec.hibernatespringtaller.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import py.edu.facitec.hibernatespringtaller.model.Gerente;




public class GerenteDao extends DaoGenerico<Gerente>{
	
	public GerenteDao(Class<Gerente> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	private EntityManagerFactory factory;
	private EntityManager em;
	
	public  GerenteDao() {
	super(Gerente.class);
	factory=Persistence.createEntityManagerFactory("entidadpu");
	em=factory.createEntityManager();
	}

	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

}



