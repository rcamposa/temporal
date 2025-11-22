package mx.ine.microservicios.bescine.contrato.aplicacion.servicios;


import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mx.ine.microservicios.bescine.contrato.aplicacion.convertidores.ContratoPartidaMapper;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IContratoPartidaRepository;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IContratoRepository;
import mx.ine.microservicios.bescine.contrato.dominio.constantes.GeneralConstantes;
import mx.ine.microservicios.bescine.contrato.dominio.dto.*;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.*;
import mx.ine.microservicios.bescine.contrato.dominio.excepciones.GeneralException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de servicio para gestionar los partidas de contratos.
 * @author Ríos Campos Aníbal (anibal.rios@ine.mx)
 * @version 1.0
 * @since 10/Nov/2025
 */

@ApplicationScoped
public class ContratoPartidaService {

    @Inject
    IContratoRepository iContratoRepository;
    @Inject
    IContratoPartidaRepository iContratoPartidaRepository;
    @Inject
    ContratoPartidaMapper contratoPartidaMapper;
    public ContratoPartidaResponseDTO agregarPartida(ContratoPartidaRequestDTO contratoPartidaRequestDTO, String userName)
            throws GeneralException {

        // Verifica que contrato exista
        Contrato foundContrato = iContratoRepository.findById(contratoPartidaRequestDTO.getIdContrato());
        if (foundContrato == null) {
            throw new GeneralException(
                    "El contrato dado, IdContrato  " + contratoPartidaRequestDTO.getIdContrato() + ", no existe.");
        }

        // Verifica que no este registrada ya la partida
        ContratoPartida foundContratoPartida = iContratoPartidaRepository.findByIdContratoAndIdPartida(contratoPartidaRequestDTO.getIdContrato()
                                                       , contratoPartidaRequestDTO.getIdPartida());
        if (foundContratoPartida != null) {
            throw new GeneralException(
                    "La partida que se quiere agregar, idPartida  " + contratoPartidaRequestDTO.getIdPartida() + ", ya existe en el contrato.");
        }

        // Asigna  partida
        ContratoPartida contratoPartida = new ContratoPartida();
        contratoPartidaMapper.toContratoPartidaEntity(contratoPartidaRequestDTO,contratoPartida);
        contratoPartida.setUsuario(userName);
        contratoPartida.setCreado(LocalDateTime.now());
        iContratoPartidaRepository.persist(contratoPartida);

        // Verifica el estatus del contrato
        if(foundContrato.getIdEstatus().equals(GeneralConstantes.PARTIDA_CONTRATO)){
            foundContrato.setIdEstatus(GeneralConstantes.FINANCIERA_CONTRATO);
            iContratoRepository.persist(foundContrato);
        }

        // Prepara el objeto retorno
        return contratoPartidaMapper.toContratoPartidaResponseDTO(contratoPartida);
    }

    public ContratoPartidaResponseDTO modificarPartida(Long id,ContratoPartidaRequestDTO contratoPartidaRequestDTO)
            throws GeneralException {
        // Verifica que contrato exista
        Contrato foundContrato = iContratoRepository.findById(contratoPartidaRequestDTO.getIdContrato());
        if (foundContrato == null) {
            throw new GeneralException(
                    "El contrato dado, IdContrato  " + contratoPartidaRequestDTO.getIdContrato() + ", no existe.");
        }

        // Verifica que partida exista
        ContratoPartida foundContratoPartida = iContratoPartidaRepository.findById(id);
        if (foundContratoPartida == null) {
            throw new GeneralException(
                    "La partida que se quiere modificar, idContratoPartida  " + id.toString() + ", no existe en el contrato.");
        }
        // modifica partida
        contratoPartidaMapper.toContratoPartidaEntity(contratoPartidaRequestDTO,foundContratoPartida);
        foundContratoPartida.setActualizado(LocalDateTime.now());
        iContratoPartidaRepository.persist(foundContratoPartida);

        // Prepara el objeto retorno
        return contratoPartidaMapper.toContratoPartidaResponseDTO(foundContratoPartida);


    }

    public void removerPartida(Long id) throws GeneralException {

        // Verifica que partida exista
        ContratoPartida foundContratoPartida = iContratoPartidaRepository.findById(id);
        if (foundContratoPartida == null) {
            throw new GeneralException(
                    "La partida que se quiere borrar, idContratoPartida  " + id.toString() + ", no existe en el contrato.");
        }
        // borrar partida
        iContratoPartidaRepository.delete(foundContratoPartida);

    }
    public List<ContratoPartidaResponseDTO> obtenerPartidasDelContrato(Long idContrato){

        // Busca las partidas por idContrato.
        List<ContratoPartida> lstContratoPartida = iContratoPartidaRepository.findByIdContrato(idContrato);

        // llena el objeto response de partidas
        List<ContratoPartidaResponseDTO> contratoPartidaResponseDTOList = new ArrayList<>();
        for(ContratoPartida item : lstContratoPartida) {
            ContratoPartidaResponseDTO contratoPartidaDTO = contratoPartidaMapper.toContratoPartidaResponseDTO(item);
           contratoPartidaResponseDTOList.add(contratoPartidaDTO);
        }

        return contratoPartidaResponseDTOList;
    }
    public List<PartidaResponseDTO> buscarPartidasDelCatalogoByCapitulo(Integer capitulo){

        // Busca el partidas por capitulo.
        PanacheQuery<Partida> query = Partida.find("capitulo = :capitulo", Parameters.with("capitulo",capitulo));

        List<Partida> lstPartida = query.list();


        // llena el objeto response de partidas
        List<PartidaResponseDTO> partidaResponseDTOList = new ArrayList<>();
        for(Partida item : lstPartida) {
            PartidaResponseDTO partidaResponseDTO = new PartidaResponseDTO();
            partidaResponseDTO.setId(item.getId());
            partidaResponseDTO.setCapitulo(item.getCapitulo());
            partidaResponseDTO.setCvePartida(item.getCvePartida());
            partidaResponseDTO.setDescripcion(item.getDescripcion());
            partidaResponseDTO.setEstatus(item.getEstatus());
            partidaResponseDTOList.add(partidaResponseDTO);
        }
        return partidaResponseDTOList;
    }

}
