package mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ContratoDataGridResponseDTO;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.Contrato;

import java.util.List;

@ApplicationScoped
public interface IContratoRepository extends PanacheRepository<Contrato> {
    Contrato findById(Long id);
    Contrato findByNumeroContrato(String numeroContrato);
    Contrato findByIdExpediente(Long idExpediente);
    Contrato findByNumeroExpediente(String numeroExpediente);
    Boolean updateEstatusContrato(Long id, Integer idEstatus);
    List<ContratoDataGridResponseDTO> findContratosByPagina( Integer pageIndex, Integer pageSize);
    Integer countContratosDelPaginado();

}
