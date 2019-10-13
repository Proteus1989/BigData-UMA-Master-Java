/**
 * Author: Ruben
 **/

package org.uma.mbd.mdEstadistica;

import java.util.Random;

import org.uma.mbd.mdEstadistica.estadistica.Estadistica;

public class Main {
    public static void main(String [] args) {
        Estadistica est = new Estadistica();
        Random ran = new Random();
        for (int i = 0; i < 10 ; i++) {
            est.agrega(ran.nextGaussian());
        }
        System.out.println("Media = "+est.media());
        System.out.println("Desviacion tipica = "+est.desviacionTipica());
    }
}
