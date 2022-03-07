package com.mo.aplicacion.comando;

import java.util.List;

import com.mo.dominio.modelo.dto.DtoArbol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoArbol {

	private List<DtoArbol> arbol;
	
}
