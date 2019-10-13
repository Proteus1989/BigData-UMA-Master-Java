/**
 * Author: Ruben
 **/

package org.uma.mbd.mdRelojArena;

import org.uma.mbd.mdRelojArena.reloj.MedidorTiempo;
import org.uma.mbd.mdRelojArena.reloj.RelojArena;

public class Main {
    public static void main(String[] args) {

        RelojArena r1 = new RelojArena(7);
        RelojArena r2 = new RelojArena(5);

        MedidorTiempo medidor = new MedidorTiempo(7, 5);
        System.out.println(medidor.toString() + ". Tiempo = " + medidor.getTiempoTotal());
        medidor.giraAmbos();
        System.out.println(medidor.toString() + ". Tiempo = " + medidor.getTiempoTotal());
        medidor.girarDerecho();
        System.out.println(medidor.toString() + ". Tiempo = " + medidor.getTiempoTotal());
        medidor.girarIzquierdo();
        System.out.println(medidor.toString() + ". Tiempo = " + medidor.getTiempoTotal());
        medidor.girarDerecho();
        System.out.println(medidor.toString() + ". Tiempo = " + medidor.getTiempoTotal());
        medidor.girarIzquierdo();
        System.out.println(medidor.toString() + ". Tiempo Acumulado = " + medidor.getTiempoTotal());
    }
}

