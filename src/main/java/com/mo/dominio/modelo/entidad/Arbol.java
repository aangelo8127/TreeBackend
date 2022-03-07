package com.mo.dominio.modelo.entidad;

import lombok.Getter;

@Getter
public class Arbol {
	
	private Integer id;
	private Integer valor;
	private Integer padre;
	
	public Arbol(Integer id, Integer valor, Integer padre) {
		this.id = id;
		this.valor = valor;
		this.padre = padre;
	}
	
}
