package org.uma.mbd.mdBusV1L.buses;

@FunctionalInterface
public interface Criterio {
    public boolean esSeleccionable(Bus bus);
}
