package org.uma.mbd.mdUrna.urna;

import java.util.NoSuchElementException;
import java.util.Random;

public class Urna {
    public static enum ColorBola {BLANCA, NEGRA}
    private static Random alea = new Random();
    public int blancas;
    public int negras;

    public Urna(int nb, int nn)
    {
        if(nb >= 0 && nn >= 0 && nb + nn >= 0)
        {
            blancas = nb;
            negras = nn;
        }
        else
            throw new IllegalArgumentException("Bolas invalidas");
    }

    public int totalBolas()
    {
        return blancas + negras;
    }

    public void ponerBlanca()
    {
        blancas++;
    }

    public void ponerNegras()
    {
        negras++;
    }

    public ColorBola extraerBola()
    {
        int t = totalBolas();
        if(t==0)
        {
            throw new NoSuchElementException("No quedan bolas");
        }

        int va = alea.nextInt(t);
        ColorBola bola;
        if(va < blancas)
            {
                bola = ColorBola.BLANCA;
                blancas--;
            }
        else
            {
                bola = ColorBola.NEGRA;
                negras--;
            }

        return bola;
    }

    @Override
    public String toString() {
        return "U(" + blancas + ", " + negras + ")";
    }
}
