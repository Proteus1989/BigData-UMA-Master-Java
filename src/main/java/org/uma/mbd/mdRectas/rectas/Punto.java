package org.uma.mbd.mdRectas.rectas;

public class Punto {

    private double x,y;

    public Punto()
    {
        this(0,0);
    }

    public Punto(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void trasladar(double x, double y)
    {
        this.x += x;
        this.y += y;
    }

    public double distancia(Punto pto)
    {
        return Math.sqrt(Math.pow(x - pto.x,2) + Math.pow(y - pto.y, 2));
    }

    @Override
    public String toString() {
        return "P(" + x + ", " + y + ")";
    }
}
