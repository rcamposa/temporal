package mx.ine.microservicios.bescine.contrato.dominio.entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "c_unidades_responsables")
@Entity
public class UnidadResponsable extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_unidad_responsable")
    private Integer id;
    @Column(name="id_estado")
    private Integer idEstado;
    @Column(name = "id_distrito")
    private Integer idDistrito;
    @Column(name="siglas_unidad")
    private String siglasUnidad;
    @Column(name="clave_unidad")
    private String claveUnidad;
    @Column(name="nombre_unidad")
    private String nombreUnidad;
    @Column(name="estatus")
    private Boolean estatus;
}
