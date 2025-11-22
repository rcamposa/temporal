/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoResource.java
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
import mx.ine.microservicios.bescine.contrato.dominio.dto.*;
import mx.ine.microservicios.bescine.contrato.aplicacion.servicios.ContratoService;
import mx.ine.microservicios.bescine.contrato.dominio.excepciones.GeneralException;

@RequiredArgsConstructor
@Path("api/contratos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContratoResource {
    @Inject
    ContratoService contratoService;

    @POST
    @Transactional
    public Response crearContrato(
            @HeaderParam("datoOperacion") String datoOperacion, ContratoDatosGeneralesRequestDTO contratoDgRequest)
            throws GeneralException {

        ContratoDatosGeneralesResponseDTO contratoDgDTO;
        contratoDgDTO = contratoService.crearContrato(contratoDgRequest,datoOperacion);
        return Response.status(Response.Status.CREATED).entity(contratoDgDTO).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response actualizarDatosGenerales(@PathParam("id") Long id,ContratoDatosGeneralesRequestDTO contratoDgRequest)
            throws GeneralException{

        ContratoDatosGeneralesResponseDTO contratoDgDTO;
        contratoDgDTO = contratoService.modificarDatosGeneralesContrato(id,contratoDgRequest);
        return Response.ok(contratoDgDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response getContratoById(String datoOperacion,@PathParam("id") Long id) throws GeneralException{
        ContratoResponseDTO contratoResponseDTO = contratoService.obtenerContratoXId(id);
        return Response.ok(contratoResponseDTO).build();
    }

    @GET
    @Path("/expediente/{idExpediente}")
    public Response getContratoByIdExpediente(@PathParam("idExpediente") Long idExpediente) throws GeneralException{
        ContratoResponseDTO contratoResponseDTO = contratoService.obtenerContratoXIdExpediente(idExpediente);
        return Response.ok(contratoResponseDTO).build();
    }
    @GET
    @Path("/datgen/{id}")
    public Response getDatosGeneralesDelContrato(@PathParam("id") Long id) throws GeneralException {
        ContratoDatosGeneralesResponseDTO contratoDGResponseDTO = contratoService.obtenerDatosGeneralesDelContrato(id);
        return Response.ok(contratoDGResponseDTO).build();
    }
    @GET
    @Path("/page")
    public Response getContratosByPagina(@DefaultValue("0") @QueryParam("pageIndex") int pageIndex
                    ,@DefaultValue("10") @QueryParam("pageSize") int pageSize) {

        ContratoPaginadoResponseDTO contratoPaginadoResponseDTOList = contratoService.obtenerContratosPorPagina(pageIndex,pageSize);
        return Response.ok(contratoPaginadoResponseDTOList).build();
    }

    @PUT
    @Path("/cierra/{idContrato}")
    @Transactional
    public Response cerrarContrato(@PathParam("idContrato") Long idContrato) throws GeneralException {
        contratoService.cerrarContrato(idContrato);
        return Response.noContent().build();
    }

}
