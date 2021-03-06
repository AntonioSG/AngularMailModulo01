package angularmail.modelo.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import angularmail.modelo.Nacionalidad;




public class NacionalidadControlador extends Controlador {

	private static NacionalidadControlador controller = null; // Instancia para Singleton
	
	/**
	 * Constructor, que inicializa al Super Controlador con la clase Usuario.class
	 */
	public NacionalidadControlador() {
		super(Nacionalidad.class);
	}

	/**
	 * Método para obtener la instancia Singleton
	 * @return
	 */
	public static NacionalidadControlador getControlador () {
		if (controller == null) {
			controller = new NacionalidadControlador();
		}
		return controller;
	}

	/**
	 * Para hacer un "find sencillo" llamo al método find del Super Controlador. Ese
	 * método devuelve una entidad y en este método hacemos un casting para convertir
	 * en la entidad que controla este controlador
	 */
	public Nacionalidad find (int id) {
		return (Nacionalidad) super.find(id);
	}



	
	/**
	 * Método para hacer un "findAll", devolver un listado con todas las entidades del 
	 * tipo de la clase controlada por este controlador.
	 * @return
	 * @throws NoResultException
	 */
	@SuppressWarnings("unchecked")
	public List<Nacionalidad> findAll () {
		List<Nacionalidad> entities = new ArrayList<Nacionalidad>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {			
			Query q = em.createQuery("SELECT o FROM Nacionalidad o", Nacionalidad.class);
			entities = (List<Nacionalidad>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}

}
