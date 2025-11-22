package mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.ContratoPartida;

import java.util.List;

@ApplicationScoped
public interface IContratoPartidaRepository extends PanacheRepository<ContratoPartida> {
    ContratoPartida findById(Long id);
    List<ContratoPartida> findByIdContrato(Long idContrato);
    ContratoPartida findByIdContratoAndIdPartida(Long idContrato, Integer idPartida);

}
