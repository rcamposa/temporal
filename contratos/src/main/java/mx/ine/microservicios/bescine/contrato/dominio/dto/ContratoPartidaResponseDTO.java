/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoPartidaResponseDTO.java
 * Fecha de creación: 12/11/2025, 12:12:12
 *
 * Este software es información confidencial, propiedad del
 * INE (Instituto Nacional Electoral). Esta información
 * no deberá ser divulgada y solo se podrá utilizar con base
 * en los términos que el propio Instituto determine.
 */

package mx.ine.microservicios.bescine.contrato.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoPartidaResponseDTO {
    private Long id;
    private Long idContrato;
    private Integer idPartida;
    private Integer capitulo;
    private Integer cvePartida;
    private String descripcion;
    private BigDecimal cantidadMin;
    private BigDecimal cantidadMax;
    private String unidadMedida;
    private BigDecimal costoUnitario;
    private BigDecimal montoMin;
    private BigDecimal montoMax;
    private Integer idTipoMoneda;
    private String tipoMonedaDesc;
    private Boolean opcionCompra;
}
