package com.mo.arbol.servicio;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.mo.BasePrueba;
import com.mo.arbol.servicio.testdatabuilder.ArbolTestDataBuilder;
import com.mo.dominio.excepcion.ValidacionNegocioExcepcion;
import com.mo.dominio.modelo.entidad.Arbol;
import com.mo.dominio.puerto.dao.DaoArbol;
import com.mo.dominio.servicio.ServicioConsultaArbol;

public class ServicioConsultaArbolTest {
	
	@Test
	public void validarExistenciaPreviaArbolTest() {
		Arbol arbol = new ArbolTestDataBuilder().build();
		DaoArbol daoArbol = Mockito.mock(DaoArbol.class);
		Mockito.when(daoArbol.existeArbol(Mockito.anyInt())).thenReturn(false);
		ServicioConsultaArbol servicioConsultaArbol = new ServicioConsultaArbol(daoArbol);
		
		BasePrueba.assertThrows(() -> servicioConsultaArbol.ejecutar(arbol.getId(), arbol.getValor(), arbol.getPadre()), ValidacionNegocioExcepcion.class, "El arbol no se encuentra creado con ese identificador");
	}
	
	@Test
	public void validarExistenciaPreviaNodoTest() {
		Arbol arbol = new ArbolTestDataBuilder().build();
		DaoArbol daoArbol = Mockito.mock(DaoArbol.class);
		Mockito.when(daoArbol.existeArbol(Mockito.anyInt())).thenReturn(true);
		Mockito.when(daoArbol.existeNodo(Mockito.anyInt(), Mockito.anyInt())).thenReturn(false);
		ServicioConsultaArbol servicioConsultaArbol = new ServicioConsultaArbol(daoArbol);
		
		BasePrueba.assertThrows(() -> servicioConsultaArbol.ejecutar(arbol.getId(), 7, 8), ValidacionNegocioExcepcion.class, "El nodo no se encuentra creado en el arbol indicado");
	}

}
