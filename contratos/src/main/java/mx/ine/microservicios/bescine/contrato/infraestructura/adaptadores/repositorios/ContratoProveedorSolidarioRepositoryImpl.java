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
import java.util.Map;
import java.util.HashMap;
import java.util.List;

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

    @Override
    public ContratoProveedorSolidario findByIdContratoAndIdProveedorSolidario(Long idContrato, Integer idProveSolid) {
        Map<String, Object> params = new HashMap<>();
        params.put("idContrato", idContrato);
        params.put("idProveedor", idProveSolid);
        List<ContratoProveedorSolidario> lstTempo = find("idContrato = :idContrato and idProveedor = :idProveedor", params).list();
        if(lstTempo.isEmpty())
            return null;
        else
           return lstTempo.get(0);
    }
}
