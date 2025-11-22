/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoPartida.java
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

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contratos_partida", schema = "contratos")
@Entity
public class ContratoPartida extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato_partida")
    private Long id;
    @Column(name = "id_contrato")
    private Long idContrato;
    @Column(name = "id_partida")
    private Integer idPartida;
    @Column(name = "cantidad_min")
    private BigDecimal cantidadMin;
    @Column(name = "cantidad_max")
    private BigDecimal cantidadMax;
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Column(name = "costo_unitario")
    private BigDecimal costoUnitario;
    @Column(name = "monto_min")
    private BigDecimal montoMin;
    @Column(name = "monto_max")
    private BigDecimal montoMax;
    @Column(name = "id_tipo_moneda")
    private Integer idTipoMoneda;
    @Column(name = "opcion_compra")
    private Boolean opcionCompra;
    @Column(name = "usuario")
    private String usuario;
    @Column(name="creado")
    private LocalDateTime creado;

    @Column(name="actualizado")
    private LocalDateTime actualizado;

    @Column(name="eliminado")
    private LocalDateTime eliminado;



}
