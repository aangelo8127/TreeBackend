package com.mo.dominio.puerto.dao;

public interface DaoArbol {
	
	boolean existeArbol(Integer id);
	
	boolean existeNodo(Integer id, Integer nodo);
	
	Integer consultaPadre(Integer id, Integer valor);

}
