package org.uma.mbd.mdLibreriaV3L.libreria;

public class OfertaAutor implements OfertaFlex {

    public String[] autores;
    public double descuento;

    public OfertaAutor(double d, String[] a)
    {
        descuento = d;
        autores = a;
    }

    @Override
    public double getDescuento(Libro libro) {
        return esAutorEnOferta(libro) ? descuento : 0;
    }

    private boolean esAutorEnOferta(Libro libro)
    {
        int i=0;
        while(i < autores.length && ! libro.getAutor().equalsIgnoreCase(autores[i]))
        {
            i++;
        }

        return i < autores.length;
    }
}
