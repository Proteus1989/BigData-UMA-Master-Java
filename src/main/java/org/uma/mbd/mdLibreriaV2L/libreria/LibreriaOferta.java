package org.uma.mbd.mdLibreriaV2L.libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {

    public String[] oferta;
    public double descuento;

    public LibreriaOferta(double descuento, String[] autores)
    {
        setOferta(descuento,autores);
    }

    public void setOferta(double d, String[] auOf)
    {
        oferta = auOf;
        this.descuento = d;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public void addLibro(String a, String t, double p)
    {
        Libro libro;
        if(esAutorEnOferta(a))
            libro = new LibroOferta(a,t,p,descuento);
        else
            libro = new Libro(a,t,p);

        addLibro(libro);
    }

    private boolean esAutorEnOferta(String a) {
        int i=0;
        while(i < oferta.length && ! a.equalsIgnoreCase(oferta[i]))
        {
            i++;
        }

        return i < oferta.length;
    }

    @Override
    public String toString() {
        return descuento + "%;" + Arrays.toString(oferta) + super.toString();
    }
}
