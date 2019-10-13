package org.uma.mbd.mdUrna;

import org.uma.mbd.mdUrna.urna.Urna;

public class Main {

    public static void main(String[] args) {
        // Codigo original del profesor
        /*
            Urna u = new Urna(5,1);
            while(u.totalBolas() > 0){
            Urna.ColorBola b = u.extraerBola();
            System.out.println(b);
        }*/

        // Ejercicio
        int nb = Integer.parseInt(args[0]);
        int nn = Integer.parseInt(args[1]);

        System.out.println("Numero de bolas blancas: " + nb);
        System.out.println("Numero de bolas negras: " + nn);

        Urna u = new Urna(nb,nn);
        while(u.totalBolas() > 1){
            Urna.ColorBola b1 = u.extraerBola();
            Urna.ColorBola b2 = u.extraerBola();
            if(b1==b2)
                u.ponerBlanca();
            else
                u.ponerNegras();
        }

        System.out.println(u.extraerBola());
    }
}
