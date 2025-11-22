
/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * DatasourceConfig.java
 * Fecha de creación: 10 sept 2025, 15:59:47
 *
 * Este software es información confidencial, propiedad del
 * INE (Instituto Nacional Electoral). Esta información
 * no deberá ser divulgada y solo se podrá utilizar con base
 * en los términos que el propio Instituto determine.
 */

package mx.ine.microservicios.bescine.contrato.infraestructura.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Arquitectura
 * @version 1.0
 * @since
 * 
 ********************en caso de que sea requerido este tipo de configuración********
 ********************caso de uso para balanceo de peticiones a BBDD*****************
 */
@ApplicationScoped
public class DatasourceConfig {

	 //Fuente de escritura
  @ConfigProperty(name = "quarkus.datasource.default.jdbc.url")
  String jdbcEscritura;

  @ConfigProperty(name = "quarkus.datasource.default.username")
  String usuarioEscritura;

  @ConfigProperty(name = "quarkus.datasource.default.password")
  String claveEscritura;

  //Fuente de solo lectura
  @ConfigProperty(name = "quarkus.datasource.readonly.jdbc.url")
  String jdbcLectura;

  @ConfigProperty(name = "quarkus.datasource.readonly.username")
  String usuarioLectura;

  @ConfigProperty(name = "quarkus.datasource.readonly.password")
  String claveLectura;

  // Métodos públicos para trazabilidad
  public String getJdbcEscritura() {
      return jdbcEscritura;
  }

  public String getUsuarioEscritura() {
      return usuarioEscritura;
  }

  public String getClaveEscritura() {
      return claveEscritura;
  }

  public String getJdbcLectura() {
      return jdbcLectura;
  }

  public String getUsuarioLectura() {
      return usuarioLectura;
  }

  public String getClaveLectura() {
      return claveLectura;
  }



}
