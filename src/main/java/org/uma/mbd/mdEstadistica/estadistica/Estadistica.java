/**
 * Author: Ruben
 **/

package org.uma.mbd.mdEstadistica.estadistica;

import java.util.Arrays;

public class Estadistica {
    private int numElementos;
    private double sumaX;
    private double sumaX2;
    private double[] SerieEstadis;
    private static final int TAM_DEFECTO = 5;

    public Estadistica (){
        SerieEstadis = new double[TAM_DEFECTO];
        numElementos = 0;
        sumaX = 0;
        sumaX2 = 0;
    }

    public void agrega (double dat){
        chequearTamaño();
        SerieEstadis[numElementos] = dat;
        numElementos ++;
        sumaX += dat;
        sumaX2 += (dat*dat);
    }

    private void chequearTamaño(){
        if (numElementos == SerieEstadis.length) {
            SerieEstadis = Arrays.copyOf(SerieEstadis, numElementos * 2);
        }
    }

    public void agrega(double dat, int n){
        for (int i = 1; i<= n; i++){
            agrega(dat);
        }
    }

    public double media(){
        return sumaX/numElementos;
    }

    public double varianza(){
        return sumaX2/numElementos - media()*media();
    }

    public double desviacionTipica(){
        return Math.sqrt(varianza());

    }


}
