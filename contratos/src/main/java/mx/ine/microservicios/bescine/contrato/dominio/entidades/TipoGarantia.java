/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * TipoGarantia.java
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

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "c_tipos_garantia", schema = "contratos")
@Entity
public class TipoGarantia extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_tipo_garantia")
    private Integer id;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="estatus")
    private Boolean estatus;
    @Column(name="orden")
    private Integer orden;
}
