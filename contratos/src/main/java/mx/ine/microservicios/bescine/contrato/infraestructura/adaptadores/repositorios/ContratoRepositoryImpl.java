/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoRepositoryImpl.java
 * Fecha de creación: 12/11/2025, 12:12:12
 *
 * Este software es información confidencial, propiedad del
 * INE (Instituto Nacional Electoral). Esta información
 * no deberá ser divulgada y solo se podrá utilizar con base
 * en los términos que el propio Instituto determine.
 */

package mx.ine.microservicios.bescine.contrato.infraestructura.adaptadores.repositorios;

import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IContratoRepository;
import mx.ine.microservicios.bescine.contrato.dominio.constantes.GeneralConstantes;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ContratoDataGridResponseDTO;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.Contrato;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class ContratoRepositoryImpl implements IContratoRepository {
    @Inject
    EntityManager entityManager;

    @Override
    public Contrato findById(Long id) {
        return find("id",id).firstResult();
    }

    @Override
    public Contrato findByNumeroContrato(String numeroContrato) {
        return find("numeroContrato",numeroContrato).firstResult();
    }

    @Override
    public Contrato findByIdExpediente(Long idExpediente) {
        return find("idExpediente",idExpediente).firstResult();
    }

    @Override
    public Contrato findByNumeroExpediente(String numeroExpediente) {
        return find("numeroExpediente",numeroExpediente).firstResult();
    }

    @Override
    public Boolean updateEstatusContrato(Long id, Integer idEstatus) {

        int valorRet = update("IdEstatus = :valor WHERE id = :id",
                Parameters.with("valor", idEstatus).and("id", id));
        if(valorRet == 0){
            return false;
        }
        return true;
    }

    @Override
    public List<ContratoDataGridResponseDTO> findContratosByPagina(Integer pageIndex, Integer pageSize) {

        Integer offset = pageIndex*pageSize;
        Query q = entityManager.createNativeQuery(
                        " SELECT c.id_contrato As idContrato, c.id_expediente As idExpediente  " +
                                ", c.id_tipo_contratacion As idTipoContratacion, tc.descripcion As tipoContratacionDesc "+
                                ", c.numero_contrato As numeroContrato, c.objeto_contrato as objetoContrato "+
                                ", c.fecha_formalizacion As fechaFormalizacion, c.fecha_inicio As fechaInicio " +
                                ", c.fecha_fin As fechaFin, c.contrato_plurianual As contratoPlurianual "+
                                ", c.ejercicio_fiscal As ejercicioFiscal, c.tipo_presupuesto as tipoPresupuesto "+
                                ", CASE WHEN c.tipo_presupuesto THEN '"+GeneralConstantes.TIPO_PRESUPUESTO_BASE + "' "+
                                "      WHEN c.tipo_presupuesto = false THEN '"+GeneralConstantes.TIPO_PRESUPUESTO_CARTERA +"' "+
                                "     ELSE '' END As tipoPresupuestoDesc " +
                                ", c.clave_proyecto As claveProyecto, c.contrato_marco As contratoMarco "+
                                ", c.numero_contrato_marco As numeroContratoMarco, c.contrato_abierto As contratoAbierto " +
                                ", c.id_estatus As idEstatus " +
                                ", CASE WHEN c.id_estatus < 6 THEN 'En captura' " +
                                "  ELSE 'Capturado' END AS estatusProceso " +
                        " FROM contratos.contratos c "+
                        "   INNER JOIN contratos.c_tipos_contratacion tc ON tc.id_tipo_contratacion = c.id_tipo_contratacion "+
                        " ORDER BY c.id_expediente OFFSET :offset LIMIT :limit");
                        q.setParameter("offset",offset)
                        .setParameter("limit",pageSize);
        List<Object[]> lstObjects = q.getResultList();
        List<ContratoDataGridResponseDTO> lstResults = new ArrayList<>();
        for(Object[] obj : lstObjects ){
            ContratoDataGridResponseDTO contratoResponseDTO = new ContratoDataGridResponseDTO();
            contratoResponseDTO.setIdContrato((Long) obj[0]);
            contratoResponseDTO.setIdExpediente((Long) obj[1]);
            contratoResponseDTO.setIdTipoContratacion((Integer)obj[2]);
            contratoResponseDTO.setTipoContratacionDesc((String)obj[3]);
            contratoResponseDTO.setNumeroContrato((String)obj[4]);
            contratoResponseDTO.setObjetoContrato((String)obj[5]);
            contratoResponseDTO.setFechaFormalizacion((LocalDate) obj[6]);
            contratoResponseDTO.setFechaInicio((LocalDate) obj[7]);
            contratoResponseDTO.setFechaFin((LocalDate) obj[8]);
            contratoResponseDTO.setContratoPlurianual((Boolean)obj[9]);
            Integer[] intArray = (obj[10] !=null? (Integer[]) obj[10]:null);
            List<Integer> integerList = new ArrayList<>();
            if(intArray !=null){
                integerList.addAll(Arrays.asList(intArray));
            }
            contratoResponseDTO.setEjercicioFiscal(integerList);
            contratoResponseDTO.setTipoPresupuesto((Boolean)obj[11]);
            contratoResponseDTO.setTipoPresupuestoDesc((String)obj[12]);
            contratoResponseDTO.setClaveProyecto((String)obj[13]);
            contratoResponseDTO.setContratoMarco((Boolean) obj[14]);
            contratoResponseDTO.setNumeroContratoMarco((String)obj[15]);
            contratoResponseDTO.setContratoAbierto((Boolean) obj[16]);
            contratoResponseDTO.setIdEstatus((Integer) obj[17]);
            contratoResponseDTO.setEstatusProceso((String)obj[18]);
            lstResults.add(contratoResponseDTO);

        }
        return lstResults;

    }

    @Override
    public Integer countContratosDelPaginado() {
        Query q =  entityManager.createNativeQuery(
                        " SELECT count(*) As conta " +
                           " FROM contratos.contratos c "+
                           "   INNER JOIN contratos.c_tipos_contratacion tc ON tc.id_tipo_contratacion = c.id_tipo_contratacion "
                            ,Integer.class);
        return (Integer) q.getSingleResult();
    }

}
