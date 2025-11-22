package mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.ContratoGarantia;

import java.util.List;

public interface IContratoGarantiaRepository extends PanacheRepository<ContratoGarantia> {
    ContratoGarantia findById(Long id);
    List<ContratoGarantia> findByIdContrato(Long idContrato);
    ContratoGarantia findByIdContratoAndIdTipoGarantia(Long idContrato, Integer idTipoGarantia);
}
