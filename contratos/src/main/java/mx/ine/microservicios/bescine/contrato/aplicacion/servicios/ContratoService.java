package mx.ine.microservicios.bescine.contrato.aplicacion.servicios;

import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mx.ine.microservicios.bescine.contrato.aplicacion.convertidores.ContratoMapper;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IContratoRepository;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IExpedienteRepository;
import mx.ine.microservicios.bescine.contrato.dominio.constantes.GeneralConstantes;
import mx.ine.microservicios.bescine.contrato.dominio.dto.*;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.*;
import mx.ine.microservicios.bescine.contrato.dominio.excepciones.GeneralException;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase de servicio para gestionar los contratos.
 * @author Ríos Campos Aníbal (anibal.rios@ine.mx)
 * @version 1.0
 * @since 10/Nov/2025
 */

@ApplicationScoped
public class ContratoService {
    @Inject
    IContratoRepository iContratoRepository;
    @Inject
    IExpedienteRepository iExpedienteRepository;
    @Inject
    ContratoMapper contratoMapper;
    public ContratoDatosGeneralesResponseDTO crearContrato(ContratoDatosGeneralesRequestDTO contratoDgRequestDTO, String userName)
            throws GeneralException {

        // Verifica que expediente exista y este cerrado
        Expediente foundExpediente = iExpedienteRepository.findById(contratoDgRequestDTO.getIdExpediente());
        if(foundExpediente == null || !foundExpediente.getIdEstatus().equals(GeneralConstantes.CLOSE_EXPEDIENTE)){
            throw new GeneralException(
                    "El expediente con ID " + contratoDgRequestDTO.getIdExpediente() + " no existe o no esta cerrado.");
        }
        // Verifica que no haya ya un contrato registrado con idExpediente dado
        Contrato foundContrato = iContratoRepository.findByIdExpediente(contratoDgRequestDTO.getIdExpediente());
        if(foundContrato != null){
            throw new GeneralException(
                    "El expediente dado para crear contrato con IdExpediente  " + contratoDgRequestDTO.getIdExpediente() + " ya esta asignado a otro contrato.");
        }


        // Guarda contrato
        Contrato nuevoContrato = new Contrato();
        contratoMapper.toContratoEntity(contratoDgRequestDTO,nuevoContrato);
        nuevoContrato.setUsuario(userName);
        nuevoContrato.setCreado(LocalDateTime.now());
        nuevoContrato.setIdEstatus(GeneralConstantes.PROVEEDOR_CONTRATO);
        iContratoRepository.persist(nuevoContrato);

        return contratoMapper.toContratoDatosGeneralesResponseDTO(nuevoContrato);

    }

    public ContratoDatosGeneralesResponseDTO modificarDatosGeneralesContrato(Long id, ContratoDatosGeneralesRequestDTO contratoDgDTO)
            throws GeneralException {

        // Verifica que expediente exista y este cerrado
        Expediente foundExpediente = iExpedienteRepository.findById(contratoDgDTO.getIdExpediente());
        if(foundExpediente == null || !foundExpediente.getIdEstatus().equals(GeneralConstantes.CLOSE_EXPEDIENTE)){
            throw new GeneralException(
                    "El expediente con ID " + contratoDgDTO.getIdExpediente() + " no existe o no esta cerrado.");
        }

        // Verifica que contrato exista
        Contrato foundContrato = iContratoRepository.findById(id);
        if(foundContrato == null){
            throw new GeneralException(
                    "El contrato dado con IdContrato  " + id.toString() + " no existe.");
        }

        // Modifica datos generales del contrato
        contratoMapper.toContratoEntity(contratoDgDTO,foundContrato);
        foundContrato.setActualizado(LocalDateTime.now());
        iContratoRepository.persist(foundContrato);

        return contratoMapper.toContratoDatosGeneralesResponseDTO(foundContrato);

    }

    public ContratoDatosGeneralesResponseDTO obtenerDatosGeneralesDelContrato(Long id)
            throws GeneralException {

        Contrato foundContrato = iContratoRepository.findById(id);
        if(foundContrato == null){
            throw new GeneralException(
                    "El ID contrato dado para obtener los datos generales " + id.toString() + " no existe.");
        }

        return contratoMapper.toContratoDatosGeneralesResponseDTO(foundContrato);
    }

    public ContratoResponseDTO obtenerContratoXId(Long id) throws GeneralException {


        Contrato foundContrato = iContratoRepository.findById(id);
        if(foundContrato == null){
            throw new GeneralException(
                    "El ID de contrato dado para obtener los datos de contrato " + id.toString() + " no existe.");
        }

        return contratoMapper.toContratoResponseDTO(foundContrato);
    }
    public ContratoResponseDTO obtenerContratoXIdExpediente(Long idExpediente) throws GeneralException {


        Contrato foundContrato = iContratoRepository.findByIdExpediente(idExpediente);
        if(foundContrato == null){
            throw new GeneralException(
                    "El ID de expediente dado para obtener los datos de contrato " + idExpediente.toString() + " no existe.");
        }

        return contratoMapper.toContratoResponseDTO(foundContrato);
    }

    public ContratoPaginadoResponseDTO obtenerContratosPorPagina(Integer pageIndex,Integer pageSize){


        List<ContratoDataGridResponseDTO> contratoDataGridResponseDTOList = iContratoRepository.findContratosByPagina(pageIndex,pageSize);
        Integer totalItems = iContratoRepository.countContratosDelPaginado();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        return ContratoPaginadoResponseDTO.builder()
                .contratoDatosGeneralesResponseDTOList(contratoDataGridResponseDTOList)
                .pageIndex(pageIndex).pageSize(pageSize).totalItems(totalItems).totalPages(totalPages).build();
    }

    public Boolean cerrarContrato(Long idContrato) throws GeneralException {

        // Verifica que contrato exista y este en el paso de documentos
        Contrato foundContrato = iContratoRepository.findById(idContrato);
        if(foundContrato == null){
            throw new GeneralException(
                    "El contrato dado para cerrar contrato " + idContrato.toString() + " no existe.");
        }
        // verifica que proveedor haya sido asignado a contrato
        if(foundContrato.getIdProveedor() ==null){
            throw new GeneralException(
                    "El ID contrato que se quiere cerrar,  " + idContrato.toString() + ", no tiene proveedor asignado.");
        }
        // Verifica que haya sigo asignada al menos una partida al contrato
        ContratoPartida foundContratoPartida = ContratoPartida.find("idContrato = :idContrato", Parameters.with("idContrato",foundContrato.getId())).firstResult();
        if(foundContratoPartida == null){
            throw new GeneralException(
                    "El ID contrato que se quiere cerrar,  " + idContrato.toString() + ", no tiene partidas asignadas.");
        }
        // Verifica que haya sido al menos una garantia al contrato
        ContratoGarantia foundContratoGarantia = ContratoGarantia.find("idContrato = :idContrato", Parameters.with("idContrato",foundContrato.getId())).firstResult();
        if(foundContratoGarantia == null){
            throw new GeneralException(
                    "El ID contrato que se quiere cerrar,  " + idContrato.toString() + ", no tiene garantías asignadas.");
        }

        return iContratoRepository.updateEstatusContrato(idContrato,GeneralConstantes.COMPROBACION_GASTO_CONTRATO);
    }


}
