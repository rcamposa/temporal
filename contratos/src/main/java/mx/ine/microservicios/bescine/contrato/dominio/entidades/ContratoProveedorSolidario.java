/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * ContratoProveedorSolidario.java
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

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contratos_proveedor_solidario", schema = "contratos")
@Entity
public class ContratoProveedorSolidario extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato_proveedor_solidario")
    private Long id;

    @Column(name="id_contrato")
    private Long idContrato;
    @Column(name="id_proveedor")
    private Integer idProveedor;
    @Column(name = "usuario")
    private String usuario;
    @Column(name="creado")
    private LocalDateTime creado;
    @Column(name="actualizado")
    private LocalDateTime actualizado;

    @Column(name="eliminado")
    private LocalDateTime eliminado;


}
