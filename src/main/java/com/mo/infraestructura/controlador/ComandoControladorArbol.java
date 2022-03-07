package com.mo.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mo.aplicacion.comando.ComandoArbol;
import com.mo.aplicacion.comando.ComandoResponse;
import com.mo.aplicacion.comando.manejador.ManejadorCrearArbol;

@RestController
@RequestMapping("/registrar/nodo")
public class ComandoControladorArbol {
	
	@Autowired
	private ManejadorCrearArbol manejadorCrearArbol;
	
	@PostMapping
	public ResponseEntity<ComandoResponse<Integer>> crear(@RequestBody ComandoArbol comandoArbol){
		return new ResponseEntity<ComandoResponse<Integer>>(manejadorCrearArbol.ejecutar(comandoArbol), HttpStatus.OK);
	}

}
