/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoGarantiaResponseDTO.java
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

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoGarantiaResponseDTO {
    private Long id;
    private Long idContrato;
    private Integer idTipoGarantia;
    private String tipoGarantiaDesc;
    private String numeroFianza;
    private LocalDate fechaEmision;
    private String afianzadora;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String condicionesReparacion;
    private String observaciones;
}
