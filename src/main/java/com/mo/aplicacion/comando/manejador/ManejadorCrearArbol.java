package com.mo.aplicacion.comando.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mo.aplicacion.comando.ComandoArbol;
import com.mo.aplicacion.comando.ComandoResponse;
import com.mo.dominio.modelo.dto.DtoArbol;
import com.mo.dominio.modelo.entidad.Arbol;
import com.mo.dominio.servicio.ServicioCrearArbol;


@Component
public class ManejadorCrearArbol implements ManejadorComandoResponse<ComandoArbol, ComandoResponse<Integer>>{

	private final ServicioCrearArbol servicioCrearArbol;
	
	public ManejadorCrearArbol(ServicioCrearArbol servicioCrearArbol) {
		this.servicioCrearArbol = servicioCrearArbol;
	}

	@Override
	public ComandoResponse<Integer> ejecutar(ComandoArbol comandoArbol) {
		
		int contador = 0;
		List<DtoArbol> listaArbol = comandoArbol.getArbol(); 
		for(int i=0; i<listaArbol.size(); i++) {
			Arbol arbol = new Arbol( listaArbol.get(i).getId(), listaArbol.get(i).getValor(), listaArbol.get(i).getPadre() );
			contador += servicioCrearArbol.ejecutar(arbol);
		}
		
		Integer resultado= new Integer(contador); 
		
		return new ComandoResponse<>(resultado);
	}
	
	

}
