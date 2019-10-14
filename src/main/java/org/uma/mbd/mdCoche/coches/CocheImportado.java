package org.uma.mbd.mdCoche.coches;

public class CocheImportado extends Coche{
    private double homologacion;

    public CocheImportado(String n, double p, double h)
    {
        super(n,p);
        homologacion = h;
    }

    @Override
    public double precioTotal() {
        return super.precioTotal() + homologacion;
    }
}
