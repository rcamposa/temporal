/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoPartidaRequestDTO.java
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

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoPartidaRequestDTO {
    @NotNull(message = "El idContrato no puede ser nulo")    
    private Long idContrato;
    @NotNull(message = "El idPartida no puede ser nulo")    
    private Integer idPartida;
    @NotNull(message = "La cantidadMin no puede ser nulo")    
    private BigDecimal cantidadMin;
    private BigDecimal cantidadMax;
    @NotBlank(message = "La unidadMedida no puede ser vacía")    
    private String unidadMedida;
    @NotNull(message = "El costoUnitario no puede ser nulo")    
    private BigDecimal costoUnitario;
    @NotNull(message = "El montoMin no puede ser nulo")    
    private BigDecimal montoMin;
    private BigDecimal montoMax;
    @NotNull(message = "El idTipoMoneda no puede ser nulo")    
    private Integer idTipoMoneda;
    @NotNull(message = "El opcionCompra no puede ser nulo")    
    private Boolean opcionCompra;
}
