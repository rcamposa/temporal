package mx.ine.microservicios.bescine.contrato.aplicacion.convertidores;

import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ContratoGarantiaRequestDTO;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ContratoGarantiaResponseDTO;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.*;

@ApplicationScoped
public class ContratoGarantiaMapper {
    public void toContratoGarantiaEntity(ContratoGarantiaRequestDTO contratoGarantiaRequestDTO, ContratoGarantia contratoGarantiaEntity) {
        if (contratoGarantiaRequestDTO == null){
            return;
        }
        // Llena los datos de objeto entity con valores del objeto DTO
        contratoGarantiaEntity.setIdContrato(contratoGarantiaRequestDTO.getIdContrato());
        contratoGarantiaEntity.setIdTipoGarantia(contratoGarantiaRequestDTO.getIdTipoGarantia());
        contratoGarantiaEntity.setNumeroFianza(contratoGarantiaRequestDTO.getNumeroFianza());
        contratoGarantiaEntity.setFechaEmision(contratoGarantiaRequestDTO.getFechaEmision());
        contratoGarantiaEntity.setAfianzadora(contratoGarantiaRequestDTO.getAfianzadora());
        contratoGarantiaEntity.setFechaInicio(contratoGarantiaRequestDTO.getFechaInicio());
        contratoGarantiaEntity.setFechaFin(contratoGarantiaRequestDTO.getFechaFin());
        contratoGarantiaEntity.setCondicionesReparacion(contratoGarantiaRequestDTO.getCondicionesReparacion());
        contratoGarantiaEntity.setObservaciones(contratoGarantiaRequestDTO.getObservaciones());
    }

    public ContratoGarantiaResponseDTO toContratoGarantiaResponseDTO(ContratoGarantia contratoGarantiaEntity) {

        if(contratoGarantiaEntity == null){
            return null;
        }
        ContratoGarantiaResponseDTO contratoGarantiaResponseDTO = new ContratoGarantiaResponseDTO();
        // Llena el objeto DTO con los valores del objeto entity
        contratoGarantiaResponseDTO.setId(contratoGarantiaEntity.getId());
        contratoGarantiaResponseDTO.setIdContrato(contratoGarantiaEntity.getIdContrato());
        contratoGarantiaResponseDTO.setIdTipoGarantia(contratoGarantiaEntity.getIdTipoGarantia());
        TipoGarantia foundTipoGarantia = TipoGarantia.findById(contratoGarantiaEntity.getIdTipoGarantia());
        contratoGarantiaResponseDTO.setTipoGarantiaDesc(foundTipoGarantia.getDescripcion());
        contratoGarantiaResponseDTO.setNumeroFianza(contratoGarantiaEntity.getNumeroFianza());
        contratoGarantiaResponseDTO.setFechaEmision(contratoGarantiaEntity.getFechaEmision());
        contratoGarantiaResponseDTO.setAfianzadora(contratoGarantiaEntity.getAfianzadora());
        contratoGarantiaResponseDTO.setFechaInicio(contratoGarantiaEntity.getFechaInicio());
        contratoGarantiaResponseDTO.setFechaFin(contratoGarantiaEntity.getFechaFin());
        contratoGarantiaResponseDTO.setCondicionesReparacion(contratoGarantiaEntity.getCondicionesReparacion());
        contratoGarantiaResponseDTO.setObservaciones(contratoGarantiaEntity.getObservaciones());

        return contratoGarantiaResponseDTO;
    }
}
