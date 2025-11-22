package mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.ContratoProveedorSolidario;

import java.util.List;

/**
 * Interfaz que define las operaciones para acceder a la base de datos para proveedores solidarios.
 * @author Ríos Campos Aníbal (anibal.rios@ine.mx)
 * @version 1.0
 * @since 10/Nov/2025
 */
@ApplicationScoped
public interface IContratoProveedorSolidarioRepository extends PanacheRepository<ContratoProveedorSolidario> {
    ContratoProveedorSolidario findById(Long id);
    List<ContratoProveedorSolidario> findByIdContrato(Long idContrato);
}
