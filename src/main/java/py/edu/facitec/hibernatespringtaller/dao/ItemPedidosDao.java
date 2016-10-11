package py.edu.facitec.hibernatespringtaller.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import py.edu.facitec.hibernatespringtaller.model.ItemPedido;




public class ItemPedidosDao extends DaoGenerico<ItemPedido>{

	private EntityManagerFactory factory;
	private EntityManager em;

	public ItemPedidosDao(){
		super(ItemPedido.class);
		factory=Persistence.createEntityManagerFactory("entidadpu");
		em=factory.createEntityManager();
	}

	@Override
	protected EntityManager getEntityManager() {

		return em;
	}

}

