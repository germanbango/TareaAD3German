package com.german.tarea3AD2024base.utiles;

public class Sesion {
	private static Long id;

	private Sesion() {

	}

	public static Long getId() {
		return id;
	}

	public static void setId(Long id) {
		Sesion.id = id;
	}

}
