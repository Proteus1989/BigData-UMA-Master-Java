package org.uma.mbd.mdBusV1L.buses;

public class PorLinea implements Criterio {

    private int codLinea;

    public PorLinea(int linea)
    {
        codLinea = linea;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        return bus.getCodLinea() == codLinea;
    }

    @Override
    public String toString() {
        return "Autobuses de la linea " + codLinea;
    }
}
