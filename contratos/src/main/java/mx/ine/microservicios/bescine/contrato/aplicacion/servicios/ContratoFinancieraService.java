package mx.ine.microservicios.bescine.contrato.aplicacion.servicios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mx.ine.microservicios.bescine.contrato.aplicacion.convertidores.ContratoMapper;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IContratoRepository;
import mx.ine.microservicios.bescine.contrato.dominio.constantes.GeneralConstantes;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ContratoDatosFinancieroRequestDTO;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ContratoDatosFinancieroResponseDTO;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.Contrato;
import mx.ine.microservicios.bescine.contrato.dominio.excepciones.GeneralException;

import java.time.LocalDateTime;

@ApplicationScoped
public class ContratoFinancieraService {
    @Inject
    IContratoRepository iContratoRepository;
    @Inject
    ContratoMapper contratoMapper;

    public ContratoDatosFinancieroResponseDTO actualizarDatosFinancierosContrato(Long idContrato, ContratoDatosFinancieroRequestDTO contratoResFinRequestTO)
            throws GeneralException {

        // Verifica que contrato exista y su estatus este en información financiera o adjuntar documentos
        Contrato foundContrato = iContratoRepository.findById(idContrato);
        if(foundContrato == null){
            throw new GeneralException(
                    "El contrato dado, IdContrato  " + idContrato.toString() + ", no existe.");
        }

        // Modifica datos generales del contrato
        contratoMapper.toContratoEntity(contratoResFinRequestTO,foundContrato);
        foundContrato.setActualizado(LocalDateTime.now());
        // Verifica el estatus de contrato para ser movido a garantia
        if(foundContrato.getIdEstatus().equals(GeneralConstantes.FINANCIERA_CONTRATO)){
            foundContrato.setIdEstatus(GeneralConstantes.GARANTIA_CONTRATO);
        }
        iContratoRepository.persist(foundContrato);

        return contratoMapper.toContratoDatosFinancieroResponseDTO(foundContrato);

    }

    public ContratoDatosFinancieroResponseDTO obtenerDatosFinancierosDelContrato(Long idContrato)
            throws GeneralException {

        // Verifica que contrato exista
        Contrato foundContrato = iContratoRepository.findById(idContrato);
        if(foundContrato == null){
            throw new GeneralException(
                    "El contrato dado, IdContrato  " + idContrato.toString() + ", no existe.");
        }

        return contratoMapper.toContratoDatosFinancieroResponseDTO(foundContrato);

    }


}
