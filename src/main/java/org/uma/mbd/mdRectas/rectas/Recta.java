package org.uma.mbd.mdRectas.rectas;

public class Recta {

    private Vector direccion;
    private Punto pto;

    public Recta(Vector vector, Punto punto)
    {
        direccion = vector;
        pto = punto;
    }

    public Recta(Punto a, Punto b)
    {
        this(new Vector(a,b), a);
    }

    public boolean pasaPor(Punto p)
    {
        return direccion.paraleloA(new Vector(pto, p));
    }

    public boolean paralelaA(Recta r)
    {
        return direccion.paraleloA(r.direccion);
    }

    public Recta paralelaPor(Punto p)
    {
        return new Recta(direccion, p);
    }

    public Recta perpendicularPor(Punto p)
    {
        return new Recta(direccion.ortogonal(), p);
    }

    public Punto interseccionCon(Recta r) {
        double d = direccion.getComponenteX() * r.direccion.getComponenteY() - r.direccion.getComponenteX() * direccion.getComponenteY();

        if(d == 0)
            throw new RuntimeException(this + " y " + r + " son rectas paralelas");

        double d1 = direccion.getComponenteX() * pto.getY() - direccion.getComponenteY() * pto.getX();
        double d2 = r.direccion.getComponenteX() * r.pto.getY() - r.direccion.getComponenteY() * r.pto.getX();

        double ox = d1 * r.direccion.getComponenteX() - d2 * direccion.getComponenteX();
        double oy = d1 * r.direccion.getComponenteY() - d2 * direccion.getComponenteY();

        return new Punto(ox/d, oy/d);
    }

    public double distanciaDesde(Punto p) {
        return perpendicularPor(p).interseccionCon(this).distancia(p);
    }

    @Override
    public String toString() {
        return "R(" + direccion + ", " + pto + ")";
    }
}
