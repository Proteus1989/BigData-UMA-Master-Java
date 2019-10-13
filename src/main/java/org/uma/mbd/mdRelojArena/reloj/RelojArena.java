/**
 * Author: Ruben
 **/

package org.uma.mbd.mdRelojArena.reloj;

public class RelojArena {

    private int tiempoTotal;
    private int tiempoRestante = 0;

    public RelojArena(int ttotal)
    {
        if(ttotal <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0");
        }
        tiempoTotal = ttotal;
        tiempoRestante = 0;
    }

    public void gira()
    {
        int tgiro = tiempoRestante;
        tiempoRestante = tiempoTotal - tgiro;
    }

    public void pasatiempo(){
        tiempoRestante = 0;

    }

    public int getTiempoRestante(){

        return tiempoRestante;
    }

    public int getTiempoTotal(){

        return tiempoTotal;
    }

    public void pasatiempo(RelojArena reloj)
    {
        if(reloj.tiempoRestante <= tiempoRestante)
            tiempoRestante = tiempoRestante - reloj.tiempoRestante;
        else
            tiempoRestante = 0;

        reloj.tiempoRestante = 0;
    }


    @Override
    public String toString() {
        return "R(" + tiempoRestante + "/" + (tiempoTotal-tiempoRestante) + ")";
    }
}

