/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoFinancieraResource.java
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
import mx.ine.microservicios.bescine.contrato.aplicacion.servicios.ContratoFinancieraService;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ContratoDatosFinancieroRequestDTO;
import mx.ine.microservicios.bescine.contrato.dominio.dto.ContratoDatosFinancieroResponseDTO;
import mx.ine.microservicios.bescine.contrato.dominio.excepciones.GeneralException;
/**
 * Recurso REST para gestionar las operaciones relacionadas para el manejo de información financiera del contrato.
 * @author Ríos Campos Aníbal (anibal.rios@ine.mx)
 * @version 1.0
 * @since 10/Nov/2025
 */
@RequiredArgsConstructor
@Path("api/contratos/financiera")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContratoFinancieraResource {
    @Inject
    ContratoFinancieraService contratoFinancieraService;

    @PUT
    @Path("/{idContrato}")
    @Transactional
    public Response actualizarDatosFinancieros(@PathParam("idContrato") Long idContrato, ContratoDatosFinancieroRequestDTO contratoDatFinRequestDTO)
            throws GeneralException {

        ContratoDatosFinancieroResponseDTO contratoDatFinResponseDTO = contratoFinancieraService.actualizarDatosFinancierosContrato(idContrato,contratoDatFinRequestDTO);
        return Response.ok(contratoDatFinResponseDTO).build();
    }
    @GET
    @Path("/{idContrato}")
    public Response getDatosFinancieros(@PathParam("idContrato") Long idContrato, ContratoDatosFinancieroRequestDTO contratoDatFinRequestDTO)
            throws GeneralException {

        ContratoDatosFinancieroResponseDTO contratoDatFinResponseDTO = contratoFinancieraService.obtenerDatosFinancierosDelContrato(idContrato);
        return Response.ok(contratoDatFinResponseDTO).build();
    }

}
