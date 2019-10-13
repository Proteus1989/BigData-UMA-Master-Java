package org.uma.mbd.mdJarras.jarras;

public class Jarra {

    private final int capacidad;
    private int contenido = 0;

    public Jarra(int valor)
    {
        if(valor <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0");
        }
        capacidad = valor;
    }

    public void llena()
    {
        contenido = capacidad;
    }

    public void vacia()
    {
        contenido = 0;
    }
    public void llenaDesde(Jarra jarra)
    {
        if(jarra.contenido <= capacidad - contenido)
        {
            contenido += jarra.contenido;
            jarra.contenido = 0;
        }
        else
        {
            jarra.contenido -= capacidad - contenido;
            contenido = capacidad;
        }
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return "La jarra contiene " + contenido + "/" + capacidad;
    }
}
