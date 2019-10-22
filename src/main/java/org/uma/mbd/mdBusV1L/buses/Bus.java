package org.uma.mbd.mdBusV1L.buses;

public class Bus {

    private String matricula;
    private int codBus;
    private int codLinea;

    public Bus(int cod, String mat)
    {
        codBus = cod;
        matricula = mat;
    }

    @Override
    public String toString() {
        return "Bus(" + codBus + "," + matricula + "," + codLinea + ")";
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(codBus) + matricula.toLowerCase().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = (obj instanceof Bus);
        Bus bus = res ? (Bus) obj : null;
        return res && matricula.equalsIgnoreCase(bus.matricula) && codBus == bus.codBus;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getCodBus() {
        return codBus;
    }

    public int getCodLinea() {
        return codLinea;
    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }
}
