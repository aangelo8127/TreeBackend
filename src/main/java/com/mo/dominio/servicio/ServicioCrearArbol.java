package com.mo.dominio.servicio;

import org.springframework.stereotype.Service;

import com.mo.dominio.excepcion.ValidacionNegocioExcepcion;
import com.mo.dominio.modelo.entidad.Arbol;
import com.mo.dominio.puerto.repositorio.RepositorioArbol;

@Service
public class ServicioCrearArbol {

	/* eslint-disable @typescript-eslint/no-unused-vars */
	
	private static final String EL_NODO_YA_SE_ENCUENTRA_CREADO = "El nodo ya se encuentra creado para el arbol";
	private static final String EL_ARBOL_ES_BINARIO = "El arbol es binario un nodo no puede tener mas de 2 hijos";
	
	private final RepositorioArbol repositorioArbol;

	public ServicioCrearArbol(RepositorioArbol repositorioArbol) {
		this.repositorioArbol = repositorioArbol;
	}
	
	public Integer ejecutar(Arbol arbol) {
		validarExistenciaPrevia(arbol);
		validarCantidadHijos(arbol);
		return this.repositorioArbol.crear(arbol);
		
	}
	
	private void validarCantidadHijos(Arbol arbol) {
		
		int cantidad = this.repositorioArbol.cantidadHijos(arbol.getId(), arbol.getPadre());
		if(cantidad == 2) {			
			throw new ValidacionNegocioExcepcion(EL_ARBOL_ES_BINARIO);
		}
		
	}
	
	private void validarExistenciaPrevia(Arbol arbol) {
		
		boolean existe = this.repositorioArbol.existe(arbol.getId(), arbol.getValor(), arbol.getPadre());
		if(existe) {
			throw new ValidacionNegocioExcepcion(EL_NODO_YA_SE_ENCUENTRA_CREADO);
		}
		
	}

}
