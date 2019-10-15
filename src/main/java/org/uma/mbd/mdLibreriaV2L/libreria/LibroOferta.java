package org.uma.mbd.mdLibreriaV2L.libreria;

public class LibroOferta extends Libro {

    private double descuento;

    public LibroOferta(String autor, String titulo, double precioBase, double d) {
        super(autor, titulo, precioBase);
        this.descuento = d;
    }

    public double getDescuento()
    {
        return descuento;
    }

    @Override
    public double getPrecioFinal()
    {
        double px = getPrecioBase() - getPrecioBase()*descuento/100;
        return px + px*getIVA()/100;

        // return super.getPrecioFinal * getIVA();
    }

    @Override
    public String toString() {
        return "L(" + String.join("; ", new String[]{
                getAutor(),
                getTitulo(),
                getPrecioBase()+"",
                descuento+"%",
                (getPrecioBase() - getPrecioBase()+descuento/100)+"",
                getIVA()+"%",
                getPrecioFinal()+""
        }) + ")";
    }
}
