package com.mo.arbol.servicio.testdatabuilder;

import com.mo.dominio.modelo.entidad.Arbol;

public class ArbolTestDataBuilder {

	private Integer id;
	private Integer valor;
	private Integer padre;
	
	public ArbolTestDataBuilder() {
		id=2;
		valor=21;
		padre=0;
	}
	
	public ArbolTestDataBuilder withId(Integer id) {
		this.id = id;
		return this;
	}
	
	public ArbolTestDataBuilder withValor(Integer valor) {
		this.valor = valor;
		return this;
	}
	
	public ArbolTestDataBuilder withPadre(Integer padre) {
		this.padre = padre;
		return this;
	}
	
	public Arbol build() {
		return new Arbol(id, valor, padre);
	}
	
	
}
