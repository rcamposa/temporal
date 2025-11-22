/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoPartidaResource.java
 * Fecha de creación: 12/11/2025, 12:12:12
 *
 * Este software es información confidencial, propiedad del
 * INE (Instituto Nacional Electoral). Esta información
 * no deberá ser divulgada y solo se podrá utilizar con base
 * en los términos que el propio Instituto determine.
 */

package mx.ine.microservicios.bescine.contrato.infraestructura.adaptadores.rest;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import mx.ine.microservicios.bescine.contrato.aplicacion.servicios.ContratoPartidaService;
import mx.ine.microservicios.bescine.contrato.dominio.dto.*;
import mx.ine.microservicios.bescine.contrato.dominio.excepciones.GeneralException;

import java.util.List;
/**
 * Recurso REST para gestionar las operaciones relacionadas para el manejo de partidas del contrato.
 * @author Ríos Campos Aníbal (anibal.rios@ine.mx)
 * @version 1.0
 * @since 10/Nov/2025
 */
@RequiredArgsConstructor
@Path("api/contratos/partida")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContratoPartidaResource {
    @Inject
    ContratoPartidaService contratoPartidaService;
    @POST
    @Transactional
    public Response agregarPartida(@HeaderParam("datoOperacion") String datoOperacion, ContratoPartidaRequestDTO contratoPartidaRequestDTO)
            throws GeneralException {
        ContratoPartidaResponseDTO contratoPartidaResponseDTO = contratoPartidaService.agregarPartida(contratoPartidaRequestDTO,datoOperacion);
        return Response.status(Response.Status.CREATED).entity(contratoPartidaResponseDTO).build();
    }
    @PUT
    @Path("/{id}")
    @Transactional
    public Response modificarPartida(@PathParam("id") Long id, ContratoPartidaRequestDTO contratoPartidaRequestDTO) throws GeneralException {
        ContratoPartidaResponseDTO contratoPartidaResponseDTO = contratoPartidaService.modificarPartida(id,contratoPartidaRequestDTO);
        return Response.status(Response.Status.OK).entity(contratoPartidaResponseDTO).build();
    }
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response removerPartida(@PathParam("id") Long id) throws GeneralException {
        contratoPartidaService.removerPartida(id);
        return Response.noContent().build();
    }
    @GET
    @Path("/list/{idContrato}")
    public Response getPartidasDelContrato(@PathParam("idContrato") Long idContrato) {
        List<ContratoPartidaResponseDTO> contratoPartidaResponseDTOList = contratoPartidaService.obtenerPartidasDelContrato(idContrato);
        return Response.ok(contratoPartidaResponseDTOList).build();
    }

    @GET
    @Path("/catalogo/{capitulo}")
    public Response getPartidasDelCatalogoByCapitulo(@PathParam("capitulo") Integer capitulo) {
        List<PartidaResponseDTO> partidaResponseDTOList = contratoPartidaService.buscarPartidasDelCatalogoByCapitulo(capitulo);
        return Response.ok(partidaResponseDTOList).build();
    }

}
