package com.mo.aplicacion.comando;

public class ComandoResponse<T> {

	private T valor;

	public ComandoResponse(T valor) {
		this.valor = valor;
	}
	
	 public T getValor() {
	     return valor;
	 }
	
}
