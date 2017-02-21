package com.ipartek.formacion.service.interfaces;

public interface TrabajadorService<T> extends PersonaService<T>{
	public T getByNss(String nss);
}
