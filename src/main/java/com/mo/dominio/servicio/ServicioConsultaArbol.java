package com.mo.dominio.servicio;

import org.springframework.stereotype.Service;

import com.mo.dominio.excepcion.ValidacionNegocioExcepcion;
import com.mo.dominio.puerto.dao.DaoArbol;

@Service
public class ServicioConsultaArbol {
	
	private static final String EL_ARBOL_NO_SE_ENCUENTRA_CREADO="El arbol no se encuentra creado con ese identificador";
	private static final String EL_NODO_NO_SE_ENCUENTRA="El nodo no se encuentra creado en el arbol indicado";
/* eslint-disable @typescript-eslint/no-unused-vars */
	private final DaoArbol daoArbol;
	
	public ServicioConsultaArbol(DaoArbol daoArbol) {
		this.daoArbol = daoArbol;
	}

	public Integer ejecutar(Integer id, Integer primerNodo, Integer segundoNodo) {
		validarExistenciaPreviaArbol(id);
		validarExistenciaPreviaNodo(id, primerNodo);
		validarExistenciaPreviaNodo(id, segundoNodo);
		return consultarAncestro(id, primerNodo, segundoNodo);
	}
	
	private void validarExistenciaPreviaArbol(Integer id) {
		
		boolean existe = this.daoArbol.existeArbol(id);
		if(!existe) {
			throw new ValidacionNegocioExcepcion(EL_ARBOL_NO_SE_ENCUENTRA_CREADO);
		}
	}
	
	private void validarExistenciaPreviaNodo(Integer id, Integer nodo) {
		
		boolean existe = this.daoArbol.existeNodo(id, nodo);
		if(!existe) {
			throw new ValidacionNegocioExcepcion(EL_NODO_NO_SE_ENCUENTRA);
		}
	}
	
	private Integer consultarAncestro(Integer id, Integer primerNodo, Integer segundoNodo) {
		
		Integer padreTemp1 = this.daoArbol.consultaPadre(id, primerNodo);
		
		if (padreTemp1 == 0) {
			padreTemp1 = primerNodo;
		}
		
		if(padreTemp1.equals(segundoNodo)) {
			return segundoNodo;
		}		
		
		Integer padreTemp2 = this.daoArbol.consultaPadre(id, segundoNodo);
		
		if(padreTemp2.equals(primerNodo)) {
			return primerNodo;
		}	
		
		if (padreTemp2 == 0) {
			padreTemp2 = segundoNodo;
		}
		
		return padreTemp1.equals( padreTemp2 )? padreTemp1 : consultarAncestro(id, padreTemp1, padreTemp2);
		
	}
	
	
}
