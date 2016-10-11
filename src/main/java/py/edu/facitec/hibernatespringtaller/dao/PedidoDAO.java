package py.edu.facitec.hibernatespringtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.hibernatespringtaller.model.Pedido;

@Repository
public class PedidoDAO extends DaoGenerico<Pedido> {

	@PersistenceContext
	private EntityManager manager;
	
	
	public PedidoDAO() {
		super(Pedido.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}
	
	
	

}
