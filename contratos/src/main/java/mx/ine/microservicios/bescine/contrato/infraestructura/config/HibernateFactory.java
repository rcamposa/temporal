package mx.ine.microservicios.bescine.contrato.infraestructura.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

/**
 * TODO [Agregar documentacion de la clase]
 * 
 * @author Arquitectura
 * @version 1.0
 * @since
 * * 
 ********************en caso de que sea requerido este tipo de configuración********
 ********************caso de uso para balanceo de peticiones a BBDD*****************
 */
@ApplicationScoped
public class HibernateFactory {

	@Inject
	DatasourceConfig config;

	@Inject
	EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	public <T> void persist(T entity) {
		em.persist(entity);
	}

}
