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

        try {
            int nb = Integer.parseInt(args[0]);
            int nn = Integer.parseInt(args[1]);

            System.out.println("Numero de bolas blancas: " + nb);
            System.out.println("Numero de bolas negras: " + nn);

            Urna u = new Urna(nb, nn);
            while (u.totalBolas() > 1) {
                Urna.ColorBola b1 = u.extraerBola();
                Urna.ColorBola b2 = u.extraerBola();
                if (b1 == b2)
                    u.ponerBlanca();
                else
                    u.ponerNegras();
            }

            System.out.println(u.extraerBola());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error en la entrada de datos. Introduce 2 argumentos");
        } catch (NumberFormatException e)
        {
            System.err.println("Algun dato no es numerico " + e.getMessage());
        } catch (IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        } finally {
            System.err.println("No se como habra ido pero adios");
        }

    }
}
