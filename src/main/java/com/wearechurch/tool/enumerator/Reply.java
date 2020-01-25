package com.wearechurch.tool.enumerator;

public enum Reply {

	OK(0, "OK"),

	EXCEPTION(5, "Tenemos un problema interno, intentalo más tarde."),

	BIND(14, "Los errores vinculantes se consideran fatales."),

	CODEC(22, "Problema al codificar y decodificar hacia y desde una secuencia de objetos"),

	CONNECT(22, "La conexión se rechazó de forma remota."),

	RUNTIME(48, "Tenemos un problema interno."),

	NUMBER_FORMAT(75, "Se intentó convertir una cadena a un tipo numérico, pero no tuvo el formato apropiado."),

	PREMATURE_CLOSE(75, "La conexión se cerró prematuramente."),

	ILLEGAL_STATE(102, "No se está en un estado apropiado para la operación solicitada."),

	UNKNOWN_HOST(105, "No se pudo determinar la dirección IP de un host"),

	NULL_POINTER(108, "Se intenta usar <null> en un caso donde se requiere un objeto."),

	SUCH_ELEMENT(176, "No hay más elementos en la enumeración."),

	CLIENT_RESPONSE(204, "Se contienen datos de respuesta HTTP reales."),

	SSL_RECORD(228, "Se intenta usar una conexión segura y otra conexión simple."),

	INDEX_BOUNDS(240, "El índice está fuera de rango."),

	METHOD_ARGUMENT(275, "La validación de un argumento falló."),

	MESSAGE_READABLE(295, "El método falló."),

	REQUEST_SUPPORTED(474, "El controlador de solicitudes no admitió el método de solicitud específico."),

	VERSION_OUTDATED(0, "Hay una nueva versión de la app, la que tienes dejó de ser compatible."),

	VERSION_UPGRADABLE(0, "Hay una nueva versión de la app.");

	private Integer code;

	private String message;

	private Reply(final Integer code, final String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}