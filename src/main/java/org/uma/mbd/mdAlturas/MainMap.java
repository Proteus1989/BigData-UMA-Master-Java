package org.uma.mbd.mdAlturas;

import org.uma.mbd.mdAlturas.alturas.Mundo;

import java.io.FileNotFoundException;

public class MainMap {
    public static void main(String[] args) throws FileNotFoundException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");
        paises.numPaisesPorContinente().forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}
