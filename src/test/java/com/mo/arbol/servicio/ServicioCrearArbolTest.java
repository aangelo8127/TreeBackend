package com.mo.arbol.servicio;



import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.mo.BasePrueba;
import com.mo.arbol.servicio.testdatabuilder.ArbolTestDataBuilder;
import com.mo.dominio.excepcion.ValidacionNegocioExcepcion;
import com.mo.dominio.modelo.entidad.Arbol;
import com.mo.dominio.puerto.repositorio.RepositorioArbol;
import com.mo.dominio.servicio.ServicioCrearArbol;

public class ServicioCrearArbolTest {

	@Test
	public void validarRespuestaExistenciaPreviaTest() {
		Arbol arbol = new ArbolTestDataBuilder().build();
		RepositorioArbol repositorioArbol = Mockito.mock(RepositorioArbol.class);
		Mockito.when(repositorioArbol.existe(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);
		ServicioCrearArbol servicioCrearArbol = new ServicioCrearArbol(repositorioArbol);
		
		BasePrueba.assertThrows(() -> servicioCrearArbol.ejecutar(arbol), ValidacionNegocioExcepcion.class, "El nodo ya se encuentra creado para el arbol");
		
	}
	
	@Test
	public void validarCantidadHijosTest() {
		Arbol arbol = new ArbolTestDataBuilder().build();
		RepositorioArbol repositorioArbol = Mockito.mock(RepositorioArbol.class);
		Mockito.when(repositorioArbol.cantidadHijos(Mockito.anyInt(), Mockito.anyInt())).thenReturn(2);
		ServicioCrearArbol servicioCrearArbol = new ServicioCrearArbol(repositorioArbol);
		
		BasePrueba.assertThrows(() -> servicioCrearArbol.ejecutar(arbol), ValidacionNegocioExcepcion.class, "El arbol es binario un nodo no puede tener mas de 2 hijos");
		
	}
	
}
