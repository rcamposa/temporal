/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoProveedorResource.java
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
import mx.ine.microservicios.bescine.contrato.aplicacion.servicios.ContratoProveedorService;
import mx.ine.microservicios.bescine.contrato.dominio.dto.*;
import mx.ine.microservicios.bescine.contrato.dominio.excepciones.GeneralException;

import java.util.List;

/**
 * Recurso REST para gestionar las operaciones de proveedor en el contrato
 * @author uthor Aníbal Ríos Campos (anibal.rios@ine.mx)
 * @version 1.0
 * @since 12/11/2025
 */
@RequiredArgsConstructor
@Path("api/contratos/proveedor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContratoProveedorResource {
    @Inject
    ContratoProveedorService contratoProveedorService;

    @POST
    @Transactional
    public Response asignarProveedor(ContratoProveedorRequestDTO contratoProveedorRequestDTO) throws GeneralException {
        ProveedorResponseDTO proveedorResponseDTO = contratoProveedorService.asignarProveedor(contratoProveedorRequestDTO);
        return Response.status(Response.Status.OK).entity(proveedorResponseDTO).build();
    }

    @GET
    @Path("/{idContrato}")
    public Response getProveedorDelContrato(@PathParam("idContrato") Long idContrato) throws GeneralException{
        ProveedorResponseDTO proveedorResponseDTO = contratoProveedorService.obtenerProveedorDelContrato(idContrato);
        return Response.ok(proveedorResponseDTO).build();
    }

    @GET
    @Path("/rfc/{rfc}")
    public Response getProveedorDelCatalogoByRFC(@PathParam("rfc") String rfc) throws GeneralException{
        ProveedorResponseDTO proveedorResponseDTO = contratoProveedorService.buscarProveedorEnCatalogoXRfc(rfc);
        return Response.ok(proveedorResponseDTO).build();
    }
    @GET
    @Path("/id/{id}")
    public Response getProveedorDelCatalogoById(@PathParam("id") Integer id) throws GeneralException{
        ProveedorResponseDTO proveedorResponseDTO = contratoProveedorService.buscarProveedorEnCatalogoXId(id);
        return Response.ok(proveedorResponseDTO).build();
    }

    @POST
    @Path("/prosol")
    @Transactional
    public Response agregarProveedorSolidario(@HeaderParam("datoOperacion") String datoOperacion, ProveedorSolidarioRequestDTO proveedorSolidarioRequestDTO)
            throws GeneralException{

        ProveedorSolidarioResponseDTO proveedorSolidarioResponseDTO = contratoProveedorService.agregarProveedorSolidario(proveedorSolidarioRequestDTO, datoOperacion);
        return Response.status(Response.Status.CREATED).entity(proveedorSolidarioResponseDTO).build();
    }

    @DELETE
    @Path("/prosol/{id}")
    @Transactional
    public Response removerProveedorSolidario(@PathParam("id") Long id) throws GeneralException {
        contratoProveedorService.removerProveedorSolidario(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/prosol/{idContrato}")
    public Response getProveedoresSolidarioDelContrato(@PathParam("idContrato") Long idContrato) {
        List<ProveedorSolidarioResponseDTO> lstProveSolidResponseDTO = contratoProveedorService.obtenerProveedoresSolidarioDelContrato(idContrato);
        return Response.ok(lstProveSolidResponseDTO).build();
    }

}
