package mx.ine.microservicios.bescine.contrato.aplicacion.convertidores;

import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.dominio.constantes.GeneralConstantes;
import mx.ine.microservicios.bescine.contrato.dominio.dto.*;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.Contrato;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.TipoContratacion;

@ApplicationScoped
public class ContratoMapper {
    public void toContratoEntity(ContratoDatosGeneralesRequestDTO contratoDgDTO, Contrato contratoEntity) {

        if(contratoDgDTO == null){
            return;
        }
        contratoEntity.setIdExpediente(contratoDgDTO.getIdExpediente());
        contratoEntity.setIdTipoContratacion(contratoDgDTO.getIdTipoContratacion());
        contratoEntity.setNumeroContrato(contratoDgDTO.getNumeroContrato());
        contratoEntity.setObjetoContrato(contratoDgDTO.getObjetoContrato());
        contratoEntity.setFechaFormalizacion(contratoDgDTO.getFechaFormalizacion());
        contratoEntity.setFechaInicio(contratoDgDTO.getFechaInicio());
        contratoEntity.setFechaFin(contratoDgDTO.getFechaFin());
        contratoEntity.setEjercicioFiscal(contratoDgDTO.getEjercicioFiscal());
        contratoEntity.setTipoPresupuesto(contratoDgDTO.getTipoPresupuesto());
        contratoEntity.setClaveProyecto(contratoDgDTO.getClaveProyecto());
        contratoEntity.setContratoMarco(contratoDgDTO.getContratoMarco());
        contratoEntity.setNumeroContratoMarco(contratoDgDTO.getNumeroContratoMarco());
        contratoEntity.setContratoAbierto(contratoDgDTO.getContratoAbierto());
        contratoEntity.setContratoPlurianual(contratoDgDTO.getContratoPlurianual());
    }
    public ContratoDatosGeneralesResponseDTO toContratoDatosGeneralesResponseDTO(Contrato contratoEntity) {
        if(contratoEntity == null){
            return null;
        }
        ContratoDatosGeneralesResponseDTO contratoDGResponseDTO = new ContratoDatosGeneralesResponseDTO();
        contratoDGResponseDTO.setIdContrato(contratoEntity.getId());
        contratoDGResponseDTO.setIdExpediente(contratoEntity.getIdExpediente());

        contratoDGResponseDTO.setIdTipoContratacion(contratoEntity.getIdTipoContratacion());

        TipoContratacion tipoContratacion = TipoContratacion.findById(contratoEntity.getIdTipoContratacion());
        contratoDGResponseDTO.setTipoContratacionDesc(tipoContratacion.getDescripcion());

        contratoDGResponseDTO.setNumeroContrato(contratoEntity.getNumeroContrato());
        contratoDGResponseDTO.setObjetoContrato(contratoEntity.getObjetoContrato());
        contratoDGResponseDTO.setFechaFormalizacion(contratoEntity.getFechaFormalizacion());
        contratoDGResponseDTO.setFechaInicio(contratoEntity.getFechaInicio());
        contratoDGResponseDTO.setFechaFin(contratoEntity.getFechaFin());
        contratoDGResponseDTO.setEjercicioFiscal(contratoEntity.getEjercicioFiscal());
        contratoDGResponseDTO.setTipoPresupuesto(contratoEntity.getTipoPresupuesto());

        String tipoPresupuestoDesc = (contratoEntity.getTipoPresupuesto()? GeneralConstantes.TIPO_PRESUPUESTO_BASE
                                  :GeneralConstantes.TIPO_PRESUPUESTO_CARTERA);
        contratoDGResponseDTO.setTipoPresupuestoDesc(tipoPresupuestoDesc);
        contratoDGResponseDTO.setClaveProyecto(contratoEntity.getClaveProyecto());
        contratoDGResponseDTO.setContratoMarco(contratoEntity.getContratoMarco());
        contratoDGResponseDTO.setNumeroContratoMarco(contratoEntity.getNumeroContratoMarco());
        contratoDGResponseDTO.setContratoAbierto(contratoEntity.getContratoAbierto());
        contratoDGResponseDTO.setContratoPlurianual(contratoEntity.getContratoPlurianual());
        contratoDGResponseDTO.setIdEstatus(contratoEntity.getIdEstatus());

        return contratoDGResponseDTO;
    }
    public ContratoDatosFinancieroResponseDTO toContratoDatosFinancieroResponseDTO(Contrato contratoEntity) {
        if (contratoEntity == null) {
            return null;
        }
        ContratoDatosFinancieroResponseDTO contratoDatFinResponseDTO = new ContratoDatosFinancieroResponseDTO();

        contratoDatFinResponseDTO.setIdContrato(contratoEntity.getId());
        contratoDatFinResponseDTO.setSubtotalMin(contratoEntity.getSubtotalMin());
        contratoDatFinResponseDTO.setIvaSubtotalMin(contratoEntity.getIvaSubtotalMin());
        contratoDatFinResponseDTO.setSubtotalMax(contratoEntity.getSubtotalMax());
        contratoDatFinResponseDTO.setIvaSubtotalMax(contratoEntity.getIvaSubtotalMax());
        contratoDatFinResponseDTO.setTotalMin(contratoEntity.getTotalMin());
        contratoDatFinResponseDTO.setTotalMax(contratoEntity.getTotalMax());
        contratoDatFinResponseDTO.setNumeroPagos(contratoEntity.getNumeroPagos());
        contratoDatFinResponseDTO.setTotalAnticipo(contratoEntity.getTotalAnticipo());
        contratoDatFinResponseDTO.setIdEstatus(contratoEntity.getIdEstatus());

        return contratoDatFinResponseDTO;

    }
    public void toContratoEntity(ContratoDatosFinancieroRequestDTO contratoResFinRequestDTO, Contrato contratoEntity) {

        if(contratoResFinRequestDTO == null){
            return;
        }
        contratoEntity.setSubtotalMin(contratoResFinRequestDTO.getSubtotalMin());
        contratoEntity.setIvaSubtotalMin(contratoResFinRequestDTO.getIvaSubtotalMin());
        contratoEntity.setSubtotalMax(contratoResFinRequestDTO.getSubtotalMax());
        contratoEntity.setIvaSubtotalMax(contratoResFinRequestDTO.getIvaSubtotalMax());
        contratoEntity.setTotalMin(contratoResFinRequestDTO.getTotalMin());
        contratoEntity.setTotalMax(contratoResFinRequestDTO.getTotalMax());
        contratoEntity.setNumeroPagos(contratoResFinRequestDTO.getNumeroPagos());
        contratoEntity.setTotalAnticipo(contratoResFinRequestDTO.getTotalAnticipo());
    }

    public ContratoResponseDTO toContratoResponseDTO(Contrato contratoEntity) {
        if (contratoEntity == null) {
            return null;
        }
        ContratoResponseDTO contratoResponseDTO = new ContratoResponseDTO();

        contratoResponseDTO.setId(contratoEntity.getId());
        contratoResponseDTO.setIdExpediente(contratoEntity.getIdExpediente());
        contratoResponseDTO.setIdTipoContratacion(contratoEntity.getIdTipoContratacion());
        contratoResponseDTO.setNumeroContrato(contratoEntity.getNumeroContrato());
        contratoResponseDTO.setObjetoContrato(contratoEntity.getObjetoContrato());
        contratoResponseDTO.setFechaFormalizacion(contratoEntity.getFechaFormalizacion());
        contratoResponseDTO.setFechaInicio(contratoEntity.getFechaInicio());
        contratoResponseDTO.setFechaFin(contratoEntity.getFechaFin());
        contratoResponseDTO.setContratoPlurianual(contratoEntity.getContratoPlurianual());
        contratoResponseDTO.setEjercicioFiscal(contratoEntity.getEjercicioFiscal());
        contratoResponseDTO.setTipoPresupuesto(contratoEntity.getTipoPresupuesto());
        contratoResponseDTO.setClaveProyecto(contratoEntity.getClaveProyecto());
        contratoResponseDTO.setContratoMarco(contratoEntity.getContratoMarco());
        contratoResponseDTO.setNumeroContratoMarco(contratoEntity.getNumeroContratoMarco());
        contratoResponseDTO.setContratoAbierto(contratoEntity.getContratoAbierto());
        contratoResponseDTO.setIdProveedor(contratoEntity.getIdProveedor());
        contratoResponseDTO.setRepresentanteLegal(contratoEntity.getRepresentanteLegal());

        contratoResponseDTO.setSubtotalMin(contratoEntity.getSubtotalMin());
        contratoResponseDTO.setIvaSubtotalMin(contratoEntity.getIvaSubtotalMin());
        contratoResponseDTO.setSubtotalMax(contratoEntity.getSubtotalMax());
        contratoResponseDTO.setIvaSubtotalMax(contratoEntity.getIvaSubtotalMax());
        contratoResponseDTO.setTotalMin(contratoEntity.getTotalMin());
        contratoResponseDTO.setTotalMax(contratoEntity.getTotalMax());
        contratoResponseDTO.setNumeroPagos(contratoEntity.getNumeroPagos());
        contratoResponseDTO.setTotalAnticipo(contratoEntity.getTotalAnticipo());
        contratoResponseDTO.setIdEstatus(contratoEntity.getIdEstatus());

        return contratoResponseDTO;

    }

}
