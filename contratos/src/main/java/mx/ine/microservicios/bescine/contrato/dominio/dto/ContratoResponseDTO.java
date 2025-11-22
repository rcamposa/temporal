/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoResponseDTO.java
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
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContratoResponseDTO {
    private Long id;
    private Long idExpediente;
    private Integer idTipoContratacion;
    private String numeroContrato;
    private String objetoContrato;
    private LocalDate fechaFormalizacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean contratoPlurianual;
    private List<Integer> ejercicioFiscal;
    private Boolean tipoPresupuesto;
    private String claveProyecto;
    private Boolean contratoMarco;
    private String numeroContratoMarco;
    private Boolean contratoAbierto;
    private Integer idProveedor;
    private String representanteLegal;
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
