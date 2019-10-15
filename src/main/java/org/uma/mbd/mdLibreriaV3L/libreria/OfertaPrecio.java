package org.uma.mbd.mdLibreriaV3L.libreria;

public class OfertaPrecio implements OfertaFlex {

    private double umbralPrecio;
    private double porDescuento;

    public OfertaPrecio(double desc, double umbral)
    {
        umbralPrecio = umbral;
        porDescuento = desc;
    }

    @Override
    public double getDescuento(Libro libro) {
        return libro.getPrecioBase() > umbralPrecio ? porDescuento : 0;
    }
}
