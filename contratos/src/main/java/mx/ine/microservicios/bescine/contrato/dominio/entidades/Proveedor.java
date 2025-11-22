/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * Proveedor.java
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
@Table(name = "c_proveedores", schema = "contratos")
@Entity
public class Proveedor extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_proveedor")
    private Integer id;
    @Column(name="rfc")
    private String rfc;
    @Column(name="razon_social")
    private String razonSocial;
    @Column(name="correo_electronico")
    private String correo;
    @Column(name="domicilio")
    private String domicilio;
    @Column(name="entidad_federativa")
    private String entidadFederativa;
    @Column(name="articulo_servicio")
    private String articuloServicio;
    @Column(name="estatus")
    private Boolean estatus;

}
