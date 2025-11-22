package mx.ine.microservicios.bescine.contrato.aplicacion.servicios;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mx.ine.microservicios.bescine.contrato.aplicacion.convertidores.ContratoGarantiaMapper;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IContratoGarantiaRepository;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IContratoRepository;
import mx.ine.microservicios.bescine.contrato.dominio.constantes.GeneralConstantes;
import mx.ine.microservicios.bescine.contrato.dominio.dto.*;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.*;
import mx.ine.microservicios.bescine.contrato.dominio.excepciones.GeneralException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ContratoGarantiaService {

    @Inject
    IContratoRepository iContratoRepository;
    @Inject
    IContratoGarantiaRepository iContratoGarantiaRepository;
    @Inject
    ContratoGarantiaMapper contratoGarantiaMapper;

    public ContratoGarantiaResponseDTO agregarGarantia(ContratoGarantiaRequestDTO contratoGarantiaRequestDTO, String userName)
            throws GeneralException {

        // Verifica que contrato exista
        Contrato foundContrato = iContratoRepository.findById(contratoGarantiaRequestDTO.getIdContrato());
        if (foundContrato == null) {
            throw new GeneralException(
                    "El contrato dado, IdContrato  " + contratoGarantiaRequestDTO.getIdContrato() + ", no existe.");
        }

        // Verifica que no este registrada ya la garantía
        ContratoGarantia foundContratoGarantia = iContratoGarantiaRepository.findByIdContratoAndIdTipoGarantia(contratoGarantiaRequestDTO.getIdContrato()
                                                       , contratoGarantiaRequestDTO.getIdTipoGarantia());
        if (foundContratoGarantia != null) {
            throw new GeneralException(
                    "La garantía que se quiere agregar, idGarantia  " + contratoGarantiaRequestDTO.getIdTipoGarantia() + ", ya existe en el contrato.");
        }
        // Asigna  garantía
        ContratoGarantia contratoGarantia = new ContratoGarantia();
        contratoGarantiaMapper.toContratoGarantiaEntity(contratoGarantiaRequestDTO,contratoGarantia);
        contratoGarantia.setUsuario(userName);
        contratoGarantia.setCreado(LocalDateTime.now());
        iContratoGarantiaRepository.persist(contratoGarantia);

        // Verifica el estatus del contrato
        if(foundContrato.getIdEstatus().equals(GeneralConstantes.GARANTIA_CONTRATO)){
            foundContrato.setIdEstatus(GeneralConstantes.DOCUMENTOS_CONTRATO);
            iContratoRepository.persist(foundContrato);
        }
        // Prepara el objeto retorno
        return contratoGarantiaMapper.toContratoGarantiaResponseDTO(contratoGarantia);
    }
    public ContratoGarantiaResponseDTO modificarGarantia(Long id,ContratoGarantiaRequestDTO contratoGarantiaRequestDTO)
            throws GeneralException {

        // Verifica que contrato exista
        Contrato foundContrato = iContratoRepository.findById(contratoGarantiaRequestDTO.getIdContrato());
        if (foundContrato == null) {
            throw new GeneralException(
                    "El contrato dado, IdContrato  " + contratoGarantiaRequestDTO.getIdContrato() + ", no existe.");
        }

        // Verifica que garantía exista
        ContratoGarantia foundContratoGarantia = iContratoGarantiaRepository.findById(id);
        if (foundContratoGarantia == null) {
            throw new GeneralException(
                    "La garantía que se quiere modificar, idContratoGarantia  " + id.toString() + ", no existe en el contrato.");
        }
        // modifica garantía
        contratoGarantiaMapper.toContratoGarantiaEntity(contratoGarantiaRequestDTO,foundContratoGarantia);
        foundContratoGarantia.setActualizado(LocalDateTime.now());
        iContratoGarantiaRepository.persist(foundContratoGarantia);

        // Prepara el objeto retorno
        return contratoGarantiaMapper.toContratoGarantiaResponseDTO(foundContratoGarantia);


    }

    public void removerGarantia(Long id) throws GeneralException {

        // Verifica que garantía exista
        ContratoGarantia foundContratoGarantia = iContratoGarantiaRepository.findById(id);
        if (foundContratoGarantia == null) {
            throw new GeneralException(
                    "La garantía que se quiere borrar, idContratoGarantia  " + id.toString() + ", no existe en el contrato.");
        }
        // borra la garantía
        iContratoGarantiaRepository.delete(foundContratoGarantia);
    }
    public List<ContratoGarantiaResponseDTO> obtenerGarantiaDelContrato(Long idContrato){

        // Busca el partidas por idContrato.
        List<ContratoGarantia> lstContratoGarantia = iContratoGarantiaRepository.findByIdContrato(idContrato);

        // llena el objeto response de partidas
        List<ContratoGarantiaResponseDTO> contratoGarantiaResponseDTOList = new ArrayList<>();
        for(ContratoGarantia item : lstContratoGarantia) {
           ContratoGarantiaResponseDTO contratoGarantiaDTO = contratoGarantiaMapper.toContratoGarantiaResponseDTO(item);
           contratoGarantiaResponseDTOList.add(contratoGarantiaDTO);
        }

        return contratoGarantiaResponseDTOList;
    }

}
