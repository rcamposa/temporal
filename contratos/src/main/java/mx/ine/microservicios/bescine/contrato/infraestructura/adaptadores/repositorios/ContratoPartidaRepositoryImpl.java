/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoPartidaRepositoryImpl.java
 * Fecha de creación: 12/11/2025, 12:12:12
 *
 * Este software es información confidencial, propiedad del
 * INE (Instituto Nacional Electoral). Esta información
 * no deberá ser divulgada y solo se podrá utilizar con base
 * en los términos que el propio Instituto determine.
 */

package mx.ine.microservicios.bescine.contrato.infraestructura.adaptadores.repositorios;

import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IContratoPartidaRepository;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.ContratoPartida;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ContratoPartidaRepositoryImpl implements IContratoPartidaRepository {

    @Override
    public ContratoPartida findById(Long id) {
        return find("id",id).firstResult();    }

    @Override
    public List<ContratoPartida> findByIdContrato(Long idContrato) {
        return find("idContrato",idContrato).list();
    }

    @Override
    public ContratoPartida findByIdContratoAndIdPartida(Long idContrato, Integer idPartida) {
        Map<String, Object> params = new HashMap<>();
        params.put("idContrato", idContrato);
        params.put("idPartida", idPartida);

        List<ContratoPartida> lstTempo =find("idContrato = :idContrato and idPartida = :idPartida", params).list();
        if(lstTempo.isEmpty()){
            return null;
        }
        else{
            return lstTempo.get(0);
        }
    }
}
