package org.uma.mbd.mdRectas;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdRectas.rectas.Recta;
import org.uma.mbd.mdRectas.rectas.Segmento;
import org.uma.mbd.mdRectas.rectas.Vector;

public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto(1,-2);
        p1.trasladar(1,4);
        System.out.println(p1);

        Punto p2 = new Punto(1,-3);
        Segmento s = new Segmento(p1,p2);
        System.out.println(s.longitud());
        System.out.println(s);

        Punto p3 = new Punto(1, 1);
        Punto origen = new Punto(0, 0);
        Vector vector1 = new Vector(origen, p3);
        System.out.println(vector1);
        System.out.println("Vector ortogonal: " + vector1.ortogonal());
        System.out.println("Módulo del vector: " + vector1.modulo());
        System.out.println(vector1.paraleloA(new Vector(2,2)));
        System.out.println(vector1.paraleloA(new Vector(2,3)));
        System.out.println("El punto extremo del vector desde: " + p3 + " es: " + vector1.extremoDesde(p3));


        Recta recta1 = new Recta(vector1, origen);
        System.out.println(recta1);

        try {
            recta1.interseccionCon(recta1.paralelaPor(new Punto(0,1)));
        }
        catch (RuntimeException e)
        {
            System.out.println("Las rectas son paralelas");
        }

        System.out.println("Punto de intersección: " + recta1.interseccionCon(new Recta(new Vector(0,5), new Punto(0,1))));
        System.out.println("Recta perpendicular que pase por el eje de coordenadas: " + recta1.perpendicularPor(new Punto()));
        System.out.println("Distancia del eje de coordenadas a la recta: " + recta1.distanciaDesde(new Punto()));
        System.out.println("Distancia de la recta a un punto dado: " + recta1.distanciaDesde(new Punto(2,1)));
        System.out.println("Es paralela? " + recta1.paralelaA(recta1.paralelaPor(new Punto(10, 3))));
        System.out.println("Es paralela? " + recta1.paralelaA(recta1.perpendicularPor(new Punto(10, 3))));
        System.out.println("La recta contiene el punto " + new Punto() + "? " + recta1.pasaPor(new Punto()));
        System.out.println("La recta contiene el punto " + p2 + "? " + recta1.pasaPor(p2));

    }
}