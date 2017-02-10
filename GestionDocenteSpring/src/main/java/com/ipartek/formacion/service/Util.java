package com.ipartek.formacion.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Util {
	private Util() {

	}

	public static boolean validarDni(String dni) {
		boolean valido = false;
		final String REGEX = "[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKET]";
		final Pattern pattern = Pattern.compile(REGEX);
		final Matcher matcher = pattern.matcher(dni);
		if (matcher.matches() && comprobarLetraDni(dni)) {
			valido = true;
		}
		return valido;
	}

	private static boolean comprobarLetraDni(String dni) {
		boolean valido = false;
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

		try {
			int dniNum = Integer.parseInt(dni.substring(0, dni.length() - 2));
			char letra = letras.charAt(dniNum % 23);
			if (letra == dni.charAt(dni.length() - 2)) {
				valido = true;
			}
		} catch (Exception e) {
			valido = false;
		}

		return valido;

	}
}