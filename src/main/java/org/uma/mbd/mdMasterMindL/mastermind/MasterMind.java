package org.uma.mbd.mdMasterMindL.mastermind;

import java.util.Random;

public class MasterMind {

    private final static int TAMANO_POR_DEFECTO = 4;
    private final static Random alea = new Random();
    private int longitud;
    private String secreto;

    public MasterMind()
    {
        this(TAMANO_POR_DEFECTO);
    }

    public MasterMind(int nCifras)
    {
        if(nCifras < 1 || nCifras > 9)
            throw new MasterMindException("Tamanio de juego ilegal " + nCifras);

        longitud = nCifras;
        generaCombinacionSecreta(longitud);
    }

    public MasterMind(String cifras)
    {
        longitud = cifras.length();
        if(validaCombinacion(cifras))
            throw new MasterMindException("");
        secreto = cifras;
    }

    public int getLongitud() {
        return longitud;
    }

    public String getSecreto() {
        return secreto;
    }

    private void generaCombinacionSecreta(int longitud)
    {
        secreto = "";
        while(secreto.length() < longitud)
        {
            int cifra = alea.nextInt(10);
            String cifraStr = Integer.toString(cifra);
            if(!secreto.contains(cifraStr))
                secreto += cifraStr;
        }
    }

    private boolean validaCombinacion(String cifras)
    {
        boolean valido = cifras.length() == longitud;
        if(valido)
            valido = cifras.matches("[0-9]+");
        if(valido)
        {
            int i = 0;
            while (valido && i < longitud-1) {
                String cifraStr = cifras.charAt(i) + "";
                valido = !cifras.substring(i + 1).contains(cifraStr);
                i++;
            }
        }

        return valido;
    }

    public Movimiento intento(String cifras)
    {
        if(!validaCombinacion(cifras))
            throw new MasterMindException("Cifras no validas");

        int col = 0;
        int des = 0;

        for (int i = 0; i < longitud; i++) {
            if(cifras.charAt(i) == secreto.charAt(i))
                col++;
            else if(secreto.indexOf(cifras.charAt(i) ) >= 0)
                des++;
        }

        return new Movimiento(cifras, col, des);
    }

}
