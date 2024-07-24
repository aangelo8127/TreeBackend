package com.mo.aplicacion.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mo.dominio.servicio.ServicioConsultaArbol;

@Component
public class ManejadorConsultarArbol {

	/* eslint-disable @typescript-eslint/no-unused-vars */

	@Autowired
	private ServicioConsultaArbol servicioConsultaArbol;
	
	public Integer consultarAncestro(Integer id, Integer primerNodo, Integer segundoNodo) {
		
		return servicioConsultaArbol.ejecutar(id, primerNodo, segundoNodo);
	}
	
	
	

}
