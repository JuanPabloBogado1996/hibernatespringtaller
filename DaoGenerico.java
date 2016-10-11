package src.py.edu.facitec.hibernate.dao;

import java.util.List;
import javax.persistence.EntityManager;

import com.sun.xml.internal.stream.Entity;


public abstract class DaoGenerico<T> {
	
	private Class<T> entityClass;
	
	
	public DaoGenerico(Class<T> entityClass){
		this.entityClass=entityClass;
	}
	
	protected abstract <EntityManager> EntityManager  getEntityManager();
	
	
	public void insertar(T entity){
		getEntityManager().persi(entity);
	}
	
public void actualizar(T entity){
	getEntityManager().merge(entity);
}	

	
	public T buscar(Object id){


return getEntityManager().find(emityClass, id);

		//or 
	}
	
public void guardar( T entity,Object id)	{
	if (id==null || id ==""){
		insertar(entity);
	}else {
		if (buscar(id))==null {
			insertar(entity);
			
		}else {
			actualizar(entity);
		}
	}
}
public void eliminar(T entity){
	getEntityManager().remove(getEntityManager().contais(entity)?
		entity:getEntityManager().merge(entity)
		);
}
 public List<T> buscarTodos() {
	return getEntityManager().createdQuery("from"+entityClass.getSimpleName(),entityClass);
}
}
