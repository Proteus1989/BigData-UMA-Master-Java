package org.uma.mbd.mdMasterMindL.mastermind;

public class Movimiento {

    private int colocadas;
    private int descolocadas;
    private String cifras;

    public Movimiento(String cifras, int colocadas, int descolocadas)
    {
        this.cifras = cifras;
        this.colocadas = colocadas;
        this.descolocadas = descolocadas;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = obj instanceof Movimiento;
        Movimiento m = res ? (Movimiento) obj : null;
        return res && m.cifras.equals(cifras);
    }

    @Override
    public int hashCode() {
        return cifras.hashCode();
    }

    @Override
    public String toString() {
        return "[" + cifras + ", " + colocadas + ", " + descolocadas + "]";
    }

    public int getColocadas() {
        return colocadas;
    }

    public int getDescolocadas() {
        return descolocadas;
    }

    public String getCifras() {
        return cifras;
    }
}
