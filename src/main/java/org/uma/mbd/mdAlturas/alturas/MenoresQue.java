package org.uma.mbd.mdAlturas.alturas;

public class MenoresQue implements Seleccion {

    private double altura;

    public MenoresQue(double altura)
    {
        this.altura = altura;
    }

    @Override
    public boolean test(Pais pais) {
        return pais.getAltura() < altura;
    }
}
