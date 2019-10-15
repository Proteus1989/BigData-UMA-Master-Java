package org.uma.mbd.mdLibreriaV3L.libreria;

public class LibreriaOfertaFlexible extends Libreria{
    private OfertaFlex ofertaFlexible;

    public LibreriaOfertaFlexible(OfertaFlex of)
    {
        ofertaFlexible = of;
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro = new Libro(autor, titulo, precioBase);
        double descuento = ofertaFlexible.getDescuento(libro);
        if(descuento > 0)
            libro = new LibroOferta(autor, titulo, precioBase, descuento);

        addLibro(libro);

    }
}
