package mx.ine.microservicios.bescine.contrato.aplicacion.servicios;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import mx.ine.microservicios.bescine.contrato.dominio.constantes.GeneralConstantes;
import mx.ine.microservicios.bescine.contrato.dominio.dto.*;
import mx.ine.microservicios.bescine.contrato.dominio.entidades.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de servicio para gestionar los catálogos de contratos.
 * @author Ríos Campos Aníbal (anibal.rios@ine.mx)
 * @version 1.0
 * @since 10/Nov/2025
 */

@ApplicationScoped
public class CatalogoService {

    public List<PartidaResponseDTO> obtenerAllPartidas(){

        // Obtener todas las partidas del catálogo partida.
        PanacheQuery<Partida> query = Partida.findAll();
        List<Partida> lstPartida = query.list();

        // llena la lista de tipo partida con sus objetos response
        List<PartidaResponseDTO> partidaResponseDTOList = new ArrayList<>();
        for(Partida item : lstPartida) {
            partidaResponseDTOList.add(PartidaResponseDTO.builder().id(item.getId()).capitulo(item
                                         .getCapitulo()).cvePartida(item.getCvePartida())
                                         .descripcion(item.getDescripcion())
                                         .estatus(item.getEstatus()).build());
        }
        return partidaResponseDTOList;
    }

    public List<TipoGarantiaResponseDTO> obtenerAllTiposGarantia(){

        // Obtiene los tipos garantía del catálogo tipogarantia.
        PanacheQuery<TipoGarantia> query = TipoGarantia.findAll();
        List<TipoGarantia> lstTipoGarantia = query.list();

        // llena los objetos response de la lista de tipó garantía
        List<TipoGarantiaResponseDTO> tipoGarantiaResponseDTOList = new ArrayList<>();
        for(TipoGarantia item : lstTipoGarantia) {
            tipoGarantiaResponseDTOList.add(TipoGarantiaResponseDTO.builder().id(item.getId())
                                  .descripcion(item.getDescripcion()).estatus(item.getEstatus()).build());
        }
        return tipoGarantiaResponseDTOList;
    }

    public List<TipoMonedaResponseDTO> obtenerAllTiposMoneda(){

        // Obtiene los registros del catalogo tipomoneda
        PanacheQuery<TipoMoneda> query = TipoMoneda.findAll();

        List<TipoMoneda> lstTipoMoneda = query.list();

        // llena el objeto response de tipo moneda
        List<TipoMonedaResponseDTO> tipoMonedaResponseDTOList = new ArrayList<>();
        for(TipoMoneda item : lstTipoMoneda) {
            tipoMonedaResponseDTOList.add(TipoMonedaResponseDTO.builder().id(item.getId()).cveMoneda(item.getCveMoneda())
                    .descripcion(item.getDescripcion()).estatus(item.getEstatus()).build());

        }
        return tipoMonedaResponseDTOList;
    }
    public List<TipoContratacionResponseDTO> obtenerAllTiposContratacion(){

        // Obtiene los ragistros de catálogo tipo contratación.
        PanacheQuery<TipoContratacion> query = TipoContratacion.findAll();
        List<TipoContratacion> lstTipoContratacion = query.list();

        // llena la lista de  objeto response de tipo contratación
        List<TipoContratacionResponseDTO> tipoContratacionResponseDTOList = new ArrayList<>();
        for(TipoContratacion item : lstTipoContratacion) {
            tipoContratacionResponseDTOList.add(TipoContratacionResponseDTO.builder().id(item.getId())
                              .descripcion(item.getDescripcion()).estatus(item.getEstatus()).build());
        }
        return tipoContratacionResponseDTOList;
    }
    public List<TipoPresupuestoResponseDTO> obtenerAllTiposPresupuesto(){

        // llenar la lista de tipo presupuesto conde objeto response
        List<TipoPresupuestoResponseDTO> tipoPresupuestoResponseDTOList = new ArrayList<>();
        tipoPresupuestoResponseDTOList.add(TipoPresupuestoResponseDTO.builder()
                           .tipoPresuesto(true).descripcion(GeneralConstantes.TIPO_PRESUPUESTO_BASE)
                           .estatus(true).build());

        tipoPresupuestoResponseDTOList.add(TipoPresupuestoResponseDTO.builder()
                .tipoPresuesto(false).descripcion(GeneralConstantes.TIPO_PRESUPUESTO_CARTERA)
                .estatus(true).build());

        return tipoPresupuestoResponseDTOList;
    }

}
