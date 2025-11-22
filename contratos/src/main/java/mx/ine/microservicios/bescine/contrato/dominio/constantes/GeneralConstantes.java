
/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * GeneralConstantes.java
 * Fecha de creación: 10 sept 2025, 16:15:33
 *
 * Este software es información confidencial, propiedad del
 * INE (Instituto Nacional Electoral). Esta información
 * no deberá ser divulgada y solo se podrá utilizar con base
 * en los términos que el propio Instituto determine.
 */

package mx.ine.microservicios.bescine.contrato.dominio.constantes;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Arquitectura
 * @version 1.0
 * @since
 */

public class GeneralConstantes {

    /**
     * TODO [Agregar documentacion al método]
     *  @author Arquitectura
     */

    private GeneralConstantes() {
        // TODO Auto-generated constructor stub
    }

    public static final String USUARIO_EXISTENTE = "El usuario ya existe";
    public static final String FORMATO_FECHA = "yyyy-MM-dd";
    public static final String ROL_DEFAULT = "USUARIO";

    public static final Integer OPEN_EXPEDIENTE = 1;
    public static final Integer CLOSE_EXPEDIENTE = 2;
    public static final Integer DELETE_EXPEDIENTE = 3;

    public static final Integer PROVEEDOR_CONTRATO = 1;
    public static final Integer PARTIDA_CONTRATO = 2;

    public static final Integer FINANCIERA_CONTRATO = 3;
    public static final Integer GARANTIA_CONTRATO = 4;
    public static final Integer DOCUMENTOS_CONTRATO = 5;
    public static final Integer COMPROBACION_GASTO_CONTRATO = 6;

    public static final String PREFIJO_BESC = "BESC";

    public static final String TIPO_PRESUPUESTO_BASE ="Presupuesto Base";
    public static final String TIPO_PRESUPUESTO_CARTERA = "Cartera Institucional de Proyecto";


}
