package py.edu.facitec.hibernatespringtaller.dao;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class DaoGenerico<T> {


	private Class<T> entityClass;

	public DaoGenerico(Class<T> entityClass) {

		this.entityClass=entityClass;

	}
	//acceso protegido, solo accesible desde 
	//la clase hija
	protected abstract EntityManager getEntityManager();	


	//Metodo para insertar

	public void insertar(T entity){

		getEntityManager().persist(entity);

	}

	//Actualizar

	public void actualizar(T entity){

		getEntityManager().merge(entity);

	}
	//Eliminar
	public void eliminar(T entity){

		getEntityManager().remove(getEntityManager().contains(entity)?
				entity:getEntityManager().merge(entity)

				);

	}


	public T buscar(Object id){

		return getEntityManager().find(entityClass, id);

	}
	//Retorna una lista de cualquier entidad
	public List<T> buscarTodos(){

		return getEntityManager().createQuery("from "+entityClass.getSimpleName(), entityClass).getResultList();
	}


	//Para saber cuando insertar y actualizar
	public void guardar(T entity,Object id){

		if(id==""||id==null){
			insertar(entity);
		}else{

			if(buscar(entity)==null){
				insertar(entity);
			}else{
				actualizar(entity);
			}


		}



	}















}
