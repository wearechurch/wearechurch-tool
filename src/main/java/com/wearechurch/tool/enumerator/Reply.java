package com.wearechurch.tool.enumerator;

public enum Reply {
	OK(0, "OK"), EXCEPTION(5, "Tenemos un problema interno, intentalo más tarde."),
	BIND(14, "Los errores vinculantes se consideran fatales."),
	CODEC_CODEC(22, "Problema al codificar y decodificar hacia y desde una secuencia de objetos"),
	NET_CONNECT(44, "La conexión se rechazó de forma remota."), RUNTIME(48, "Tenemos un problema interno."),
	NUMBER_FORMAT(75, "Se intentó convertir una cadena a un tipo numérico, pero no tuvo el formato apropiado."),
	VERSION_OUTDATED(78, "Hay una nueva versión de la app, la que tienes dejó de ser compatible."),
	VERSION_UPGRADABLE(90, "Hay una nueva versión de la app."),
	CLIENT_RESPONSE(204, "Se contienen datos de respuesta HTTP reales."),
	INDEX_BOUNDS(240, "El índice está fuera de rango."), METHOD_ARGUMENT(280, "La validación de un argumento falló."),
	MESSAGE_READABLE(295, "El método falló."),
	REQUEST_SUPPORTED(474, "El controlador de solicitudes no admitió el método de solicitud específico.");

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