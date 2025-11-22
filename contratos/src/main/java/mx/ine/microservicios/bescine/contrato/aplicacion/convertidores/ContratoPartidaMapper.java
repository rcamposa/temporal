package mx.ine.microservicios.bescine.contrato.aplicacion.convertidores;

import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ContratoPartidaRequestDTO;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ContratoPartidaResponseDTO;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.ContratoPartida;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.Partida;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.TipoMoneda;

@ApplicationScoped
public class ContratoPartidaMapper {
    public void toContratoPartidaEntity(ContratoPartidaRequestDTO contratoPartidaRequestDTO, ContratoPartida contratoPartidaEntity) {
        if (contratoPartidaRequestDTO == null){
            return;
        }
        // Llena los datos de objeto entity con valores del objeto DTO
        contratoPartidaEntity.setIdContrato(contratoPartidaRequestDTO.getIdContrato());
        contratoPartidaEntity.setIdPartida(contratoPartidaRequestDTO.getIdPartida());
        contratoPartidaEntity.setCantidadMax(contratoPartidaRequestDTO.getCantidadMax());
        contratoPartidaEntity.setCantidadMin(contratoPartidaRequestDTO.getCantidadMin());
        contratoPartidaEntity.setUnidadMedida(contratoPartidaRequestDTO.getUnidadMedida());
        contratoPartidaEntity.setCostoUnitario(contratoPartidaRequestDTO.getCostoUnitario());
        contratoPartidaEntity.setMontoMax(contratoPartidaRequestDTO.getMontoMax());
        contratoPartidaEntity.setMontoMin(contratoPartidaRequestDTO.getMontoMin());
        contratoPartidaEntity.setIdTipoMoneda(contratoPartidaRequestDTO.getIdTipoMoneda());
        contratoPartidaEntity.setOpcionCompra(contratoPartidaRequestDTO.getOpcionCompra());
        //contratoPartidaEntity.setUsuario(contratoPartidaRequestDTO.getUsuario());
    }

    public ContratoPartidaResponseDTO toContratoPartidaResponseDTO(ContratoPartida contratoPartidaEntity) {

        if(contratoPartidaEntity == null){
            return null;
        }
        ContratoPartidaResponseDTO contratoPartidaResponseDTO = new ContratoPartidaResponseDTO();
        // Llena el objeto DTO con los valores del objeto entity
        contratoPartidaResponseDTO.setId(contratoPartidaEntity.getId());
        contratoPartidaResponseDTO.setIdContrato(contratoPartidaEntity.getIdContrato());
        contratoPartidaResponseDTO.setIdPartida(contratoPartidaEntity.getIdPartida());
        Partida foundPartida = Partida.findById(contratoPartidaEntity.getIdPartida());
        contratoPartidaResponseDTO.setCapitulo(foundPartida.getCapitulo());
        contratoPartidaResponseDTO.setCvePartida(foundPartida.getCvePartida());
        contratoPartidaResponseDTO.setDescripcion(foundPartida.getDescripcion());
        contratoPartidaResponseDTO.setCantidadMax(contratoPartidaEntity.getCantidadMax());
        contratoPartidaResponseDTO.setCantidadMin(contratoPartidaEntity.getCantidadMin());
        contratoPartidaResponseDTO.setUnidadMedida(contratoPartidaEntity.getUnidadMedida());
        contratoPartidaResponseDTO.setCostoUnitario(contratoPartidaEntity.getCostoUnitario());
        contratoPartidaResponseDTO.setMontoMax(contratoPartidaEntity.getMontoMax());
        contratoPartidaResponseDTO.setMontoMin(contratoPartidaEntity.getMontoMin());
        contratoPartidaResponseDTO.setIdTipoMoneda(contratoPartidaEntity.getIdTipoMoneda());
        TipoMoneda tipoMoneda = TipoMoneda.findById(contratoPartidaEntity.getIdTipoMoneda());
        contratoPartidaResponseDTO.setTipoMonedaDesc(tipoMoneda.getDescripcion());
        contratoPartidaResponseDTO.setOpcionCompra(contratoPartidaEntity.getOpcionCompra());

        return contratoPartidaResponseDTO;
    }
}
