/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoDatosFinancierosRequestDTO.java
 * Fecha de creación: 12/11/2025, 12:12:12
 *
 * Este software es información confidencial, propiedad del
 * INE (Instituto Nacional Electoral). Esta información
 * no deberá ser divulgada y solo se podrá utilizar con base
 * en los términos que el propio Instituto determine.
 */

package mx.ine.microservicios.bescine.contrato.dominio.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDatosFinancieroRequestDTO {
    @NotNull(message = "El subtotalMin no puede ser nulo")
    private BigDecimal subtotalMin;
    private BigDecimal subtotalMax;
    @NotNull(message = "El ivaSubtotalMin no puede ser nulo")
    private BigDecimal ivaSubtotalMin;
    private BigDecimal ivaSubtotalMax;
    @NotNull(message = "El totalMin no puede ser nulo")
    private BigDecimal totalMin;
    private BigDecimal totalMax;
    @NotNull(message = "El numeroPagos no puede ser nulo")
    private Integer numeroPagos;
    private BigDecimal totalAnticipo;
}
