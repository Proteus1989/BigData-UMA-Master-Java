package org.uma.mbd.mdRectas.rectas;

public class Vector {

    Punto extremo;

    public Vector(Punto punto)
    {
        extremo = punto;
    }

    public Vector(double x, double y)
    {
        this(new Punto(x, y));
    }

    public Vector(Punto a, Punto b)
    {
        this(new Punto(b.getX() - a.getX(), b.getY() - a.getY()));
    }

    public double getComponenteX()
    {
        return extremo.getX();
    }

    public double getComponenteY()
    {
        return extremo.getY();
    }

    public Vector ortogonal()
    {
        return new Vector(extremo.getY() * -1, extremo.getX());
    }

    public boolean paraleloA(Vector vector)
    {
        return extremo.getX() * vector.getComponenteY() == extremo.getY() * vector.getComponenteX();
    }

    public Punto extremoDesde(Punto org)
    {
        Punto nuevo = new Punto(org.getX(), org.getY());
        nuevo.trasladar(extremo.getX(), extremo.getY());
        return nuevo;
    }

    public double modulo()
    {
        return extremo.distancia(new Punto());
    }

    @Override
    public String toString() {
        return "V(" + extremo.getX() + ", " + extremo.getY() + ")";
    }
}
