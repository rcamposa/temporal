/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoGarantiaResource.java
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
import mx.ine.microservicios.bescine.contrato.aplicacion.servicios.ContratoGarantiaService;
import mx.ine.microservicios.bescine.contrato.dominio.dto.*;
import mx.ine.microservicios.bescine.contrato.dominio.excepciones.GeneralException;

import java.util.List;

@RequiredArgsConstructor
@Path("api/contratos/garantia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContratoGarantiaResource {
    @Inject
    ContratoGarantiaService contratoGarantiaService;

    @POST
    public Response agregarGarantia(@HeaderParam("datoOperacion") String datoOperacion, ContratoGarantiaRequestDTO contratoGarantiaRequestDTO)
            throws GeneralException {

        ContratoGarantiaResponseDTO contratoGarantiaResponseDTO = contratoGarantiaService.agregarGarantia(contratoGarantiaRequestDTO, datoOperacion);
        return Response.status(Response.Status.OK).entity(contratoGarantiaResponseDTO).build();
    }
    @PUT
    @Path("/{id}")
    @Transactional
    public Response modificarGarantia(@PathParam("id") Long id, ContratoGarantiaRequestDTO contratoGarantiaRequestDTO)
            throws GeneralException {

        ContratoGarantiaResponseDTO contratoGarantiaResponseDTO = contratoGarantiaService.modificarGarantia(id,contratoGarantiaRequestDTO);
        return Response.status(Response.Status.OK).entity(contratoGarantiaResponseDTO).build();
    }
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response removerGarantia(@PathParam("id") Long id) throws GeneralException {
        contratoGarantiaService.removerGarantia(id);
        return Response.noContent().build();
    }
    @GET
    @Path("/list/{idContrato}")
    public Response getGarantiasDelContrato(@PathParam("idContrato") Long idContrato) {
        List<ContratoGarantiaResponseDTO> contratoGarantiaResponseDTOList = contratoGarantiaService.obtenerGarantiaDelContrato(idContrato);
        return Response.ok(contratoGarantiaResponseDTOList).build();
    }


}
