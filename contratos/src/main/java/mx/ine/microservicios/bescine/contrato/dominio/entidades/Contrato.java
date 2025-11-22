/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * Contrato.java
 * Fecha de creación: 12/11/2025, 12:12:12
 *
 * Este software es información confidencial, propiedad del
 * INE (Instituto Nacional Electoral). Esta información
 * no deberá ser divulgada y solo se podrá utilizar con base
 * en los términos que el propio Instituto determine.
 */

package mx.ine.microservicios.bescine.contrato.dominio.entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contratos", schema = "contratos")
@Entity
public class Contrato extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato")
    private Long id;
    @Column(name = "id_expediente")
    private Long idExpediente;
    @Column(name = "id_tipo_contratacion")
    private Integer idTipoContratacion;
    @Column(name = "numero_contrato")
    private String numeroContrato;
    @Column(name = "objeto_contrato")
    private String objetoContrato;
    @Column(name = "fecha_formalizacion")
    private LocalDate fechaFormalizacion;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    @Column(name = "contrato_plurianual")
    private Boolean contratoPlurianual;

    @Column(name = "ejercicio_fiscal")
    private List<Integer> ejercicioFiscal;

    @Column(name = "tipo_presupuesto")
    private Boolean tipoPresupuesto;
    @Column(name = "clave_proyecto")
    private String claveProyecto;
    @Column(name = "contrato_marco")
    private Boolean contratoMarco;
    @Column(name = "numero_contrato_marco")
    private String numeroContratoMarco;
    @Column(name = "contrato_abierto")
    private Boolean contratoAbierto;
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    @Column(name = "representante_legal")
    private String representanteLegal;
    @Column(name = "subtotal_min")
    private BigDecimal subtotalMin;
    @Column(name = "subtotal_max")
    private BigDecimal subtotalMax;
    @Column(name = "iva_subtotal_min")
    private BigDecimal ivaSubtotalMin;
    @Column(name = "iva_subtotal_max")
    private BigDecimal ivaSubtotalMax;
    @Column(name = "total_min")
    private BigDecimal totalMin;
    @Column(name = "total_max")
    private BigDecimal totalMax;
    @Column(name = "numero_pagos")
    private Integer numeroPagos;
    @Column(name = "total_anticipo")

    private BigDecimal totalAnticipo;
    @Column(name = "id_estatus")
    private Integer idEstatus;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "creado")
    private LocalDateTime creado;
    @Column(name = "actualizado")
    private LocalDateTime actualizado;
    @Column(name = "eliminado")
    private LocalDateTime eliminado;

}
