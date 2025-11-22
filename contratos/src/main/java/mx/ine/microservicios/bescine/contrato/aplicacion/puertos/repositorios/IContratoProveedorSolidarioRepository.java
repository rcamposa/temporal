package mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.ContratoProveedorSolidario;

import java.util.List;

@ApplicationScoped
public interface IContratoProveedorSolidarioRepository extends PanacheRepository<ContratoProveedorSolidario> {
    ContratoProveedorSolidario findById(Long id);
    List<ContratoProveedorSolidario> findByIdContrato(Long idContrato);
    ContratoProveedorSolidario findByIdContratoAndIdProveedorSolidario(Long idContrato, Integer idProveSolid);

}
