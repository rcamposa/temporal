package mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ContratoDataGridResponseDTO;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.Contrato;

import java.util.List;
/**
 * Interfaz que define las operaciones para acceder a la base de datos para entidad principal contrato.
 * @author Ríos Campos Aníbal (anibal.rios@ine.mx)
 * @version 1.0
 * @since 10/Nov/2025
 */
@ApplicationScoped
public interface IContratoRepository extends PanacheRepository<Contrato> {
    Contrato findById(Long id);
    Contrato findByIdExpediente(Long idExpediente);
    Boolean updateEstatusContrato(Long id, Integer idEstatus);
    List<ContratoDataGridResponseDTO> findContratosByPagina( Integer pageIndex, Integer pageSize);
    Integer countContratosDelPaginado();

}
