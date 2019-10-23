package org.uma.mbd.mdAlturas.alturas;

public class MayoresQue implements Seleccion {

    private double altura;

    public MayoresQue(double altura)
    {
        this.altura = altura;
    }

    @Override
    public boolean test(Pais pais) {
        return pais.getAltura() >= altura;
    }
}
