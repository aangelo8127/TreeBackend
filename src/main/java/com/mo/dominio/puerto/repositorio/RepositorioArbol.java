package com.mo.dominio.puerto.repositorio;

import com.mo.dominio.modelo.entidad.Arbol;

public interface RepositorioArbol {
	
	Integer crear(Arbol arbol);
	boolean existe(Integer id, Integer valor, Integer padre);
	int cantidadHijos(Integer id, Integer padre);
}
