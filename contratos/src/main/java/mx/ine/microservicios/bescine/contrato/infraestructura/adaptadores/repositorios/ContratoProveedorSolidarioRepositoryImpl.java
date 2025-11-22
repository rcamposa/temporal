/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoProveedorRepositoryImpl.java
 * Fecha de creación: 12/11/2025, 12:12:12
 *
 * Este software es información confidencial, propiedad del
 * INE (Instituto Nacional Electoral). Esta información
 * no deberá ser divulgada y solo se podrá utilizar con base
 * en los términos que el propio Instituto determine.
 */

package mx.ine.microservicios.bescine.contrato.infraestructura.adaptadores.repositorios;

import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IContratoProveedorSolidarioRepository;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.ContratoProveedorSolidario;
import java.util.List;

/**
 * Clase que implementa los accesos de la base de datos para proveedores.
 * @author Ríos Campos Aníbal (anibal.rios@ine.mx)
 * @version 1.0
 * @since 10/Nov/2025
 */

@ApplicationScoped
public class ContratoProveedorSolidarioRepositoryImpl implements IContratoProveedorSolidarioRepository {
    @Override
    public ContratoProveedorSolidario findById(Long id) {
        return find("id",id).firstResult();
    }

    @Override
    public List<ContratoProveedorSolidario> findByIdContrato(Long idContrato) {
        return find("idContrato",idContrato).list();
    }

}
