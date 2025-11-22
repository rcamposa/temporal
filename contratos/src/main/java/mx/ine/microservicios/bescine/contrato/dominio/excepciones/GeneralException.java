
/**
 * Copyright (c) 2025 INE, UTSI, México.
 * Todos los derechos reservados.
 *
 * GeneralExcepciones.java
 * Fecha de creación: 10 sept 2025, 15:05:29
 *
 * Este software es información confidencial, propiedad del
 * INE (Instituto Nacional Electoral). Esta información
 * no deberá ser divulgada y solo se podrá utilizar con base
 * en los términos que el propio Instituto determine.
 */

package mx.ine.microservicios.bescine.contrato.dominio.excepciones;

/**
 * Clase GeneralException
 * @version 1.0
 * @since 
 */
public class GeneralException extends Exception {
	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = -933821271505823803L;

	/**
	 *atributo para  mostrar la causa
	 */
	private static final String 	CAUSED_BY="\nCaused by: ";

	/**
	 * variable que guarda la excepcion
	 */
	private final Throwable cause;


	/**
	 *  constructor con el mensaje por argumento
	 *  @author Arquitectura
	 *  @param message
	 */
	public GeneralException(String message) {
		super(message);
		this.cause=null;
	}

	/**
	 *  Constructor con la excepci�n por argumento
	 *  @author Arquitectura
	 *  @param cause
	 */

	public GeneralException(Throwable cause) {
		super();
		this.cause=cause;
	}

	/**
	 *  constructor con el mensaje por argumento y excepcion
	 *  @author Arquitectura
	 *  @param message
	 *  @param cause
	 */
	public GeneralException(String message, Throwable cause) {
		super(message);
		this.cause=cause;
	}

	/**
	 * m�todo par abtener la causa de la excepcion
	 * @author Arquitectura
	 * @return {@link Throwable} 
	 */
	@Override
	public Throwable getCause(){
		return cause;
	}

	/* La documentaci�n de este m�todo se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if(cause==null){
			return super.toString();
		}else{
			StringBuilder sb= new StringBuilder();
			sb.append(super.toString())
			.append(CAUSED_BY)
			.append(cause.toString());
			return sb.toString();	
		}	
	}

}