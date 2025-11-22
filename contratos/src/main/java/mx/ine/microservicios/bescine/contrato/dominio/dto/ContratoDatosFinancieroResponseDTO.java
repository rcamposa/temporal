/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoDatosFinancierosResponseDTO.java
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
public class ContratoDatosFinancieroResponseDTO {
    private Long idContrato;
    private BigDecimal subtotalMin;
    private BigDecimal subtotalMax;
    private BigDecimal ivaSubtotalMin;
    private BigDecimal ivaSubtotalMax;
    private BigDecimal totalMin;
    private BigDecimal totalMax;
    private Integer numeroPagos;
    private BigDecimal totalAnticipo;
    private Integer idEstatus;
}
