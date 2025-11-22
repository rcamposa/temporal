package mx.ine.microservicios.bescine.contrato.infraestructura.adaptadores.repositorios;

import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IExpedienteRepository;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.Expediente;

/**
 * Clase que implementa los accesos de la base de datos para expediente.
 * @author Ríos Campos Aníbal (anibal.rios@ine.mx)
 * @version 1.0
 * @since 10/Nov/2025
 */
@ApplicationScoped
public class ExpedienteRepositoryImpl implements IExpedienteRepository {

    @Override
    public Expediente findById(Long id) {
        return find("id",id).firstResult();
    }
}
