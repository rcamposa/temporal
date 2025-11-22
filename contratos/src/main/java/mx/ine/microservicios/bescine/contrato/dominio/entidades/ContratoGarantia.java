/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoGarantia.java
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
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contratos_garantia", schema = "contratos")
@Entity
public class ContratoGarantia extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_garantia")
    private Long id;
    @Column(name="id_contrato")
    private Long idContrato;
    @Column(name="id_tipo_garantia")
    private Integer idTipoGarantia;
    @Column(name="numero_fianza")
    private String numeroFianza;
    @Column(name="fecha_emision")
    private LocalDate fechaEmision;
    @Column(name="afianzadora")
    private String afianzadora;
    @Column(name="fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name="fecha_fin")
    private LocalDate fechaFin;
    @Column(name="condiciones_reparacion")
    private String condicionesReparacion;
    @Column(name="observaciones")
    private String observaciones;
    @Column(name="usuario")
    private String usuario;
    @Column(name="creado")
    private LocalDateTime creado;
    @Column(name="actualizado")
    private LocalDateTime actualizado;
    @Column(name="eliminado")
    private LocalDateTime eliminado;

}
