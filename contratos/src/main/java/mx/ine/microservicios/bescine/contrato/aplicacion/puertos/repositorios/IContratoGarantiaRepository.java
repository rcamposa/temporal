package mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.ContratoGarantia;

import java.util.List;
/**
 * Interfaz que define las operaciones para acceder a la base de datos para garantías.
 * @author Ríos Campos Aníbal (anibal.rios@ine.mx)
 * @version 1.0
 * @since 10/Nov/2025
 */
public interface IContratoGarantiaRepository extends PanacheRepository<ContratoGarantia> {
    ContratoGarantia findById(Long id);
    List<ContratoGarantia> findByIdContrato(Long idContrato);
    ContratoGarantia findByIdContratoAndIdTipoGarantia(Long idContrato, Integer idTipoGarantia);
}
