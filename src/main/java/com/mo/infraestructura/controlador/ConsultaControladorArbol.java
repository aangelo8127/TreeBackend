package com.mo.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mo.aplicacion.consulta.ManejadorConsultarArbol;

@RestController
@RequestMapping("/consultas/LowestCommonAncestor")
public class ConsultaControladorArbol {
	
	@Autowired
	private ManejadorConsultarArbol manejadorConsultarArbol;
	
	@GetMapping
	public Integer listarAncestro(@RequestParam(value="id") Integer id, 
								  @RequestParam(value="nodo1") Integer primerNodo, 
								  @RequestParam(value="nodo2") Integer segundoNodo) {
		return manejadorConsultarArbol.consultarAncestro(id, primerNodo, segundoNodo);
	}
	

}
