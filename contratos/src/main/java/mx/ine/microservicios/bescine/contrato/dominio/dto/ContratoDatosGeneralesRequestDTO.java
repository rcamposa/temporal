/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoDatosGeneralesRequestDTO.java
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
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDatosGeneralesRequestDTO {
    @NotNull(message = "El idExpediente no puede ser nulo")    
    private Long idExpediente;
    @NotNull(message = "El idTipoContratacion no puede ser nulo")    
    private Integer idTipoContratacion;
    @NotBlank(message = "El numeroContrato no puede ser vacío")    
    private String numeroContrato;
    @NotBlank(message = "El objetoContrato no puede ser vacío")    
    private String objetoContrato;
    @NotBlank(message = "La fechaFormalizacion no puede ser vacía")    
    private LocalDate fechaFormalizacion;
    @NotBlank(message = "La fechaInicio no puede ser vacía")    
    private LocalDate fechaInicio;
    @NotBlank(message = "La fechaFin no puede ser vacía")    
    private LocalDate fechaFin;
    @NotNull(message = "El contratoPlurianual no puede ser nulo")    
    private Boolean contratoPlurianual;
    @NotNull(message = "El ejercicioFiscal no puede ser nulo")    
    private List<Integer> ejercicioFiscal;
    @NotNull(message = "El tipoPresupuesto no puede ser nulo")    
    private Boolean tipoPresupuesto;
    @NotBlank(message = "La claveProyecto no puede ser vacía")    
    private String claveProyecto;
    @NotNull(message = "El contratoMarco no puede ser nulo")    
    private Boolean contratoMarco;
    private String numeroContratoMarco;
    @NotNull(message = "El contratoAbierto no puede ser nulo")    
    private Boolean contratoAbierto;

}
