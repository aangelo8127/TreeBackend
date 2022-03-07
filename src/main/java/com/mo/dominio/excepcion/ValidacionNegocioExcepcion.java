package com.mo.dominio.excepcion;

public class ValidacionNegocioExcepcion extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValidacionNegocioExcepcion(String mensaje) {
        super(mensaje);
    }
}

