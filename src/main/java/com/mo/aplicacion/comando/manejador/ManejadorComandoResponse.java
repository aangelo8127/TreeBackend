package com.mo.aplicacion.comando.manejador;

import javax.transaction.Transactional;

public interface ManejadorComandoResponse<C, R>{

	@Transactional
	R ejecutar(C comando);
	
}
