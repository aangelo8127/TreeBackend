package com.mo.infraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mo.infraestructura.adaptador.entidad.ArbolEntidad;

public interface RepositorioArbolH2 extends JpaRepository<ArbolEntidad, Integer>{

	@Query(value="select count(1) from arbol a where a.id = :id AND a.valor = :valor AND a.padre = :padre", nativeQuery = true)
	Integer existe(@Param("id") Integer id, @Param("valor") Integer valor,  @Param("padre") Integer padre);
	
	@Query(value="select count(1) from arbol a where a.id = :id AND a.padre = :padre", nativeQuery = true)
	Integer cantidadHijos(@Param("id") Integer id, @Param("padre") Integer padre);
	
	@Query(value="select count(1) from arbol a where a.id = :id AND a.valor = :valor", nativeQuery = true)
	Integer existeNodo(@Param("id") Integer id, @Param("valor") Integer valor);
	
	@Query(value="select padre from arbol a where a.id = :id AND a.valor = :valor", nativeQuery = true)
	Integer consultaPadre(@Param("id") Integer id, @Param("valor") Integer padre);
	
}
