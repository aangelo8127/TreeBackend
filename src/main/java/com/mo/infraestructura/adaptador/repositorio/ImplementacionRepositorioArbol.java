package com.mo.infraestructura.adaptador.repositorio;

import com.mo.dominio.modelo.entidad.Arbol;
import com.mo.dominio.puerto.repositorio.RepositorioArbol;
import com.mo.infraestructura.adaptador.entidad.ArbolEntidad;

public class ImplementacionRepositorioArbol implements RepositorioArbol{
	
	private final RepositorioArbolH2 repositorioArbolH2;

	/* eslint-disable @typescript-eslint/no-unused-vars */
	
	public ImplementacionRepositorioArbol(RepositorioArbolH2 repositorioArbolH2) {
		this.repositorioArbolH2 = repositorioArbolH2;
	}

	@Override
	public Integer crear(Arbol arbol) {
		
		ArbolEntidad arbolEntidad = new ArbolEntidad();
		
		arbolEntidad.setId(arbol.getId());
		arbolEntidad.setValor(arbol.getValor());
		arbolEntidad.setPadre(arbol.getPadre());
		
		ArbolEntidad arbolEntidadInsertado = repositorioArbolH2.save(arbolEntidad);
		return arbolEntidadInsertado.getId()>0 ? 1 : 0;
		
	}

	@Override
	public boolean existe(Integer id, Integer valor, Integer padre) {
		Integer existeRespuesta = repositorioArbolH2.existe(id, valor, padre);
		return existeRespuesta > 0;
	}

	@Override
	public int cantidadHijos(Integer id, Integer padre) {
		return repositorioArbolH2.cantidadHijos(id, padre);
	}

}
