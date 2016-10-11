package py.edu.facitec.hibernatespringtaller.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.hibernatespringtaller.model.Departamento;



@Repository
public class DepartamentoDao extends DaoGenerico<Departamento>{
	@PersistenceContext
	private EntityManagerFactory factory;
	private EntityManager em;

	
	public DepartamentoDao(){
		super(Departamento.class);
		
		factory=Persistence.createEntityManagerFactory("entidadpu");
		em=factory.createEntityManager();
	}

	@Override
	protected EntityManager getEntityManager() {

		return em;
	}

}


