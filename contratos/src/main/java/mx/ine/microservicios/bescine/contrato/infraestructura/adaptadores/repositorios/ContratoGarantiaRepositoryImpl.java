/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoGarantiaRepositoryImpl.java
 * Fecha de creación: 12/11/2025, 12:12:12
 *
 * Este software es información confidencial, propiedad del
 * INE (Instituto Nacional Electoral). Esta información
 * no deberá ser divulgada y solo se podrá utilizar con base
 * en los términos que el propio Instituto determine.
 */

package mx.ine.microservicios.bescine.contrato.infraestructura.adaptadores.repositorios;

import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IContratoGarantiaRepository;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.ContratoGarantia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ContratoGarantiaRepositoryImpl implements IContratoGarantiaRepository {

    @Override
    public ContratoGarantia findById(Long id) {
        return find("id",id).firstResult();    }

    @Override
    public List<ContratoGarantia> findByIdContrato(Long idContrato) {

        return find("idContrato",idContrato).list();
    }

    @Override
    public ContratoGarantia findByIdContratoAndIdTipoGarantia(Long idContrato, Integer idTipoGarantia) {
        Map<String, Object> params = new HashMap<>();
        params.put("idContrato", idContrato);
        params.put("idTipoGarantia", idTipoGarantia);

        List<ContratoGarantia> lstTempo =find("idContrato = :idContrato and idTipoGarantia = :idTipoGarantia", params).list();
        if(lstTempo.isEmpty()){
            return null;
        }
        else{
            return lstTempo.get(0);
        }
    }
}
