package org.uma.mbd.mdAlturas;

import org.uma.mbd.mdAlturas.alturas.Mundo;
import org.uma.mbd.mdAlturas.alturas.Pais;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

public class MainCompute {

    public static void main(String[] args) throws FileNotFoundException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");

        Map<String, Set<Pais>> map = paises.paisesPorContinente();
        for(String key : map.keySet())
        {
            System.out.println(key);
            Set<Pais> set = map.get(key);
            for(Pais pais : set)
                System.out.println("\t" + pais);
        }

    }
}
