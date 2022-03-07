package com.mo.infraestructura.adaptador.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mo.dominio.puerto.dao.DaoArbol;
import com.mo.infraestructura.adaptador.repositorio.RepositorioArbolH2;

@Component
public class ImplementacionDaoArbol implements DaoArbol{

	@Autowired
	private RepositorioArbolH2 repositorioArbolH2;
	
	@Override
	public boolean existeArbol(Integer id) {
		return repositorioArbolH2.findById(id).orElse(null) != null;
	}

	@Override
	public boolean existeNodo(Integer id, Integer nodo) {
		return repositorioArbolH2.existeNodo(id, nodo) > 0;
	}

	@Override
	public Integer consultaPadre(Integer id, Integer valor) {
		return repositorioArbolH2.consultaPadre(id, valor);
	}

}
