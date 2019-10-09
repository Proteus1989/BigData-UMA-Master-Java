package org.uma.mbd.mdRectas.rectas;

public class Segmento {

    private Punto origen;
    private Punto extremo;

    public Segmento(double x1, double y1, double x2, double y2)
    {
        origen = new Punto(x1, y1);
        extremo = new Punto(x2, y2);
    }

    public Segmento(Punto p1, Punto p2)
    {
        origen = p1;
        extremo = p2;
    }

    public void trasladar(double a, double b)
    {
        origen.trasladar(a, b);
        extremo.trasladar(a, b);
    }

    public double longitud()
    {
        return origen.distancia(extremo);
    }

    @Override
    public String toString() {
        return "S(" + origen + ", " + extremo + ")";
    }
}
