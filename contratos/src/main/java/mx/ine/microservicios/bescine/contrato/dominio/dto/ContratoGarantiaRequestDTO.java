/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoGarantiaRequestDTO.java
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

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoGarantiaRequestDTO {
    @NotNull(message = "El idContrato no puede ser nulo")    
    private Long idContrato;
    @NotNull(message = "El idTipoGarantia no puede ser nulo")    
    private Integer idTipoGarantia;
    @NotBlank(message = "El numeroFianza no puede ser vacía")    
    private String numeroFianza;
    @NotBlank(message = "La fechaEmision no puede ser vacía")    
    private LocalDate fechaEmision;
    @NotBlank(message = "La afianzadora no puede ser vacía")    
    private String afianzadora;
    @NotBlank(message = "La fechaInicio no puede ser vacía")    
    private LocalDate fechaInicio;
    @NotBlank(message = "La fechaFin no puede ser vacía")    
    private LocalDate fechaFin;
    private String condicionesReparacion;
    @NotBlank(message = "La observaciones no puede ser vacía")    
    private String observaciones;
}
