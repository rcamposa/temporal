/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * CatalogoResource.java
 * Fecha de creación: 12/11/2025, 12:12:12
 *
 * Este software es información confidencial, propiedad del
 * INE (Instituto Nacional Electoral). Esta información
 * no deberá ser divulgada y solo se podrá utilizar con base
 * en los términos que el propio Instituto determine.
 */

package mx.ine.microservicios.bescine.contrato.infraestructura.adaptadores.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import mx.ine.microservicios.bescine.contrato.aplicacion.servicios.CatalogoService;
import mx.ine.microservicios.bescine.contrato.dominio.dto.*;

import java.util.List;

/**
 * Recurso REST para gestionar las operaciones relacionadas con los catálogos del contrato.
 * @author Ríos Campos Aníbal (anibal.rios@ine.mx)
 * @version 1.0
 * @since 10/Nov/2025
 */
@RequiredArgsConstructor
@Path("api/contratos/catalogo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CatalogoResource {
    @Inject
    CatalogoService catalogoService;

    @GET
    @Path("/partida")
    public Response getAllPartidas() {
        List<PartidaResponseDTO> partidaResponseDTOList = catalogoService.obtenerAllPartidas();
        return Response.ok(partidaResponseDTOList).build();
    }
    @GET
    @Path("/tipocontratacion")
    public Response getAllTiposContratacion() {
        List<TipoContratacionResponseDTO> tipoContratacionResponseDTOList = catalogoService.obtenerAllTiposContratacion();
        return Response.ok(tipoContratacionResponseDTOList).build();
    }
    @GET
    @Path("/tipogarantia")
    public Response getAllTiposGarantia() {
        List<TipoGarantiaResponseDTO> tipoGarantiaResponseDTOList = catalogoService.obtenerAllTiposGarantia();
        return Response.ok(tipoGarantiaResponseDTOList).build();
    }
    @GET
    @Path("/tipomoneda")
    public Response getAllTiposMoneda() {
        List<TipoMonedaResponseDTO> tipoMonedaResponseDTOList = catalogoService.obtenerAllTiposMoneda();
        return Response.ok(tipoMonedaResponseDTOList).build();
    }
    @GET
    @Path("/tipopresupuesto")
    public Response getAllTiposPresupuesto() {
        List<TipoPresupuestoResponseDTO> tipoPresupuestoResponseDTOList = catalogoService.obtenerAllTiposPresupuesto();
        return Response.ok(tipoPresupuestoResponseDTOList).build();
    }

}