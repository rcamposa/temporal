package mx.ine.microservicios.bescine.contrato.aplicacion.servicios;

import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mx.ine.microservicios.bescine.contrato.aplicacion.convertidores.ProveedorMapper;
import mx.ine.microservicios.bescine.contrato.aplicacion.convertidores.ProveedorSolidarioMapper;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IContratoProveedorSolidarioRepository;
import mx.ine.microservicios.bescine.contrato.aplicacion.puertos.repositorios.IContratoRepository;
import mx.ine.microservicios.bescine.contrato.dominio.constantes.GeneralConstantes;
import mx.ine.microservicios.bescine.contrato.dominio.dto.*;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.*;
import mx.ine.microservicios.bescine.contrato.dominio.excepciones.GeneralException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase de servicio para gestionar los provedores de contratos.
 * @author Ríos Campos Aníbal (anibal.rios@ine.mx)
 * @version 1.0
 * @since 10/Nov/2025
 */

@ApplicationScoped
public class ContratoProveedorService {

    @Inject
    IContratoRepository iContratoRepository;
    @Inject
    IContratoProveedorSolidarioRepository iContratoProvSolidRepository;
    @Inject
    ProveedorMapper proveedorMapper;
    @Inject
    ProveedorSolidarioMapper proveedorSolidarioMapper;
    public ProveedorResponseDTO asignarProveedor(ContratoProveedorRequestDTO contratoProveedorRequestDTO)
            throws GeneralException {

        // Verifica que contrato exista
        Contrato foundContrato = iContratoRepository.findById(contratoProveedorRequestDTO.getIdContrato());
        if(foundContrato == null){
            throw new GeneralException(
                    "El contrato dado, IdContrato  " + contratoProveedorRequestDTO.getIdContrato() + ", no existe.");
        }
        // Verifica que proveedor exista
        Proveedor foundProveedor = Proveedor.find("id = :id", Parameters.with("id",contratoProveedorRequestDTO.getIdProveedor())).firstResult();
        if(foundProveedor == null){
            throw new GeneralException(
                    "El proveedor a ser asignado al contrato " + contratoProveedorRequestDTO.getIdProveedor() + " no existe.");
        }
        // Asigna el proveedor responsable al contrato y pone el estatus en financiera si previo estaba en estatus en proveedor
        foundContrato.setIdProveedor(contratoProveedorRequestDTO.getIdProveedor());
        foundContrato.setRepresentanteLegal(contratoProveedorRequestDTO.getRepresentanteLegal());
        foundContrato.setActualizado(LocalDateTime.now());
        if(foundContrato.getIdEstatus().equals(GeneralConstantes.PROVEEDOR_CONTRATO)){
            foundContrato.setIdEstatus(GeneralConstantes.FINANCIERA_CONTRATO);
        }
        iContratoRepository.persist(foundContrato);

        // Prepara el retorno.
        ProveedorResponseDTO proveedorResponseDTO = proveedorMapper.toProveedorResponseDTO(foundProveedor);
        proveedorResponseDTO.setIdContrato(contratoProveedorRequestDTO.getIdContrato());
        proveedorResponseDTO.setRepresentanteLegal(contratoProveedorRequestDTO.getRepresentanteLegal());
        return proveedorResponseDTO;

    }

    public ProveedorSolidarioResponseDTO agregarProveedorSolidario(ProveedorSolidarioRequestDTO proveedorSolidarioRequestDTO, String userName)
            throws GeneralException {
        // Verifica que contrato exista
        Contrato foundContrato = iContratoRepository.findById(proveedorSolidarioRequestDTO.getIdContrato());
        if(foundContrato == null){
            throw new GeneralException(
                    "El contrato dado con IdContrato  " + proveedorSolidarioRequestDTO.getIdContrato() + " no existe.");
        }

        // Verifica que proveedor exista
        Proveedor foundProveedor = Proveedor.find("id = :id", Parameters.with("id",proveedorSolidarioRequestDTO.getIdProveedor())).firstResult();

        if(foundProveedor == null){
            throw new GeneralException(
                    "El proveedor solidario a ser registrado al contrato " + proveedorSolidarioRequestDTO.getIdProveedor() + " no existe.");
        }

        ContratoProveedorSolidario contratoProSoli = ContratoProveedorSolidario.builder()
                .idContrato(proveedorSolidarioRequestDTO.getIdContrato())
                .idProveedor(proveedorSolidarioRequestDTO.getIdProveedor())
                .usuario(userName).build();
        contratoProSoli.setCreado(LocalDateTime.now());
        iContratoProvSolidRepository.persist(contratoProSoli);

        // Prepara el retorno.
        ProveedorSolidarioResponseDTO proveedorSolidarioResponseDTO = new ProveedorSolidarioResponseDTO();
        proveedorSolidarioResponseDTO.setId(contratoProSoli.getId());
        proveedorSolidarioResponseDTO.setIdContrato(proveedorSolidarioRequestDTO.getIdContrato());
        proveedorSolidarioResponseDTO.setIdProveedor(proveedorSolidarioRequestDTO.getIdProveedor());
        proveedorSolidarioMapper.toContratoProveedorSolidarioResponseDTO(foundProveedor,proveedorSolidarioResponseDTO);
        return proveedorSolidarioResponseDTO;

    }
    public void removerProveedorSolidario(Long id) throws GeneralException {
        // Verifica que proveedor solidario exista
        ContratoProveedorSolidario foundContratoProSoli = iContratoProvSolidRepository.findById(id);
        if(foundContratoProSoli == null){
            throw new GeneralException(
                    "El proveedor solidario a ser removido del contrato " + id.toString() + " no existe.");
        }

        iContratoProvSolidRepository.delete(foundContratoProSoli);

    }

    public ProveedorResponseDTO buscarProveedorEnCatalogoXId(Integer id) throws GeneralException {

        Proveedor foundProveedor = Proveedor.find("id = :id", Parameters.with("id",id)).firstResult();
        if(foundProveedor == null){
            throw new GeneralException(
                    "El proveedor con ID " + id.toString() + " no existe.");
        }

        // retorna el objeto encontrado
        return proveedorMapper.toProveedorResponseDTO(foundProveedor);
    }

    public ProveedorResponseDTO obtenerProveedorDelContrato(Long idContrato) throws GeneralException {

        // Verifica que contrato exista y este en un estatus con proveedor asignado.
        Contrato foundContrato = iContratoRepository.findById(idContrato);
        if(foundContrato == null){
            throw new GeneralException(
                    "El contrato dado con IdContrato  " + idContrato.toString() + " no existe.");
        }

        if(foundContrato.getIdProveedor() == null){
            throw new GeneralException(
                    "El proveedor no ha sido asignado en contrato dado  " + idContrato.toString());
        }
        Proveedor foundProveedor = Proveedor.find("id = :id", Parameters.with("id",foundContrato.getIdProveedor())).firstResult();
        if(foundProveedor == null){
            throw new GeneralException(
                    "El proveedor asignado no existe en catálogo  " + foundContrato.getIdProveedor().toString());
        }

        // llena el objeto response de proveedor
        ProveedorResponseDTO proveedorResponseDTO = proveedorMapper.toProveedorResponseDTO(foundProveedor);
        proveedorResponseDTO.setIdContrato(idContrato);
        proveedorResponseDTO.setRepresentanteLegal(foundContrato.getRepresentanteLegal());
        return proveedorResponseDTO;
    }

    public ProveedorResponseDTO buscarProveedorEnCatalogoXRfc(String rfc) throws GeneralException {

        // Buscar el proveedor por rfc.
        Proveedor foundProveedor = Proveedor.find("rfc = :rfc", Parameters.with("rfc",rfc)).firstResult();
        if(foundProveedor == null){
            throw new GeneralException(
                    "El proveedor con RFC dado no existe en catálogo  " + rfc);
        }

        // retorna el objeto encontrado
        return proveedorMapper.toProveedorResponseDTO(foundProveedor);
    }

    public List<ProveedorSolidarioResponseDTO> obtenerProveedoresSolidarioDelContrato(Long idContrato){

        // Busca el proveedores solidarios por idContrato.
        List<ContratoProveedorSolidario> lstProveSolid = iContratoProvSolidRepository.findByIdContrato(idContrato);

        // llena el objeto response de proveedor solidario
        List<ProveedorSolidarioResponseDTO> proveSolidResponseDTOList = new ArrayList<>();
        for(ContratoProveedorSolidario item : lstProveSolid) {
            ProveedorSolidarioResponseDTO proSolResponseDTO = new ProveedorSolidarioResponseDTO();
            proSolResponseDTO.setId(item.getId());
            proSolResponseDTO.setIdContrato(idContrato);
            proSolResponseDTO.setIdProveedor(item.getIdProveedor());
            Proveedor foundProveedor = Proveedor.find("id = :id", Parameters.with("id",item.getId())).firstResult();

            if (foundProveedor != null) {
                proveedorSolidarioMapper.toContratoProveedorSolidarioResponseDTO(foundProveedor, proSolResponseDTO);
            }
            proveSolidResponseDTOList.add(proSolResponseDTO);
        }

        return proveSolidResponseDTOList;
    }

}