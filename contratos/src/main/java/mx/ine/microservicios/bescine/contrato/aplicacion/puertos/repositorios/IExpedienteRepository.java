package mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.Expediente;

import java.util.List;

@ApplicationScoped
public interface IExpedienteRepository extends PanacheRepository<Expediente> {
/*
    Expediente create(Expediente expediente);
    Expediente update(Long id, Expediente expediente);
*/
    Boolean updateEstatusExpediente(Long id,Integer idEstatusExpediente);
    Expediente findById(Long id);
    Expediente findByNumeroExpediente(String numeroExpediente);
    List<Expediente> findListaExpediente();

}
