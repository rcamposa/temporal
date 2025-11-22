package mx.ine.microservicios.bescine.contrato.dominio.entidades;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "expedientes", schema = "expedientes")
@Entity
public class Expediente extends PanacheEntityBase {
    /**
     * TODO [Agregar documentacion al método]
     *
     * @author Arquitectura
     */

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_expediente")
    private Long id;

    //@NotEmpty(message = "El número expediente es obligatorio")
    @Column(name="numero_expediente")
    private String numeroExpediente;

    @NotNull(message = "El tipo de adjudicación es obligatorio")
    @Column(name="id_tipo_adjudicacion")
    private Integer idTipoAdjudicacion;

    @NotEmpty(message = "El número de procedimiento es obligatorio")
    @NotNull(message = "El número de procedimiento es obligatorio")
    @Column(name="numero_procedimiento")
    private String numeroProcedimiento;

    @NotEmpty(message = "El nombre de procedimiento es obligatorio")
    @NotNull(message = "El nombre de procedimiento es obligatorio")
    @Column(name="nombre_procedimiento")
    private String nombreProcedimiento;

    @NotNull(message = "El id de responsable uno es obligatorio")
    @Column(name="id_responsable_uno")
    private Integer idResponsableUno;

    //@NotNull(message = "El id de responsable dos es obligatorio")
    @Column(name="id_responsable_dos")
    private Integer idResponsableDos;

    @Column(name = "id_auditor")
    private Integer idAuditor;

    @NotNull(message = "La unidad responsable es obligatorio")
    //@NotBlank(message = "La unidad responsable es obligatorio")
    @Column(name="id_unidad_responsable")
    private Integer idUnidadResponsable;

    @Column(name = "id_usuario_creador")
    private Integer idUsuarioCreador;

    //@NotEmpty(message = "El estatus expediente es obligatorio")
    @Column(name="id_estatus")
    private Integer idEstatus;

    @Column(name="usuario")
    private String usuario;

    @Column(name="creado")
    private LocalDateTime creado;

    @Column(name="actualizado")
    private LocalDateTime actualizado;

    @Column(name="eliminado")
    private LocalDateTime eliminado;

}
