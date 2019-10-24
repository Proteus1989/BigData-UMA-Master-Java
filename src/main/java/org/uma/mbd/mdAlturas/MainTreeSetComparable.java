package org.uma.mbd.mdAlturas;

import org.uma.mbd.mdAlturas.alturas.EnContinente;
import org.uma.mbd.mdAlturas.alturas.MenoresQue;
import org.uma.mbd.mdAlturas.alturas.Mundo;
import org.uma.mbd.mdAlturas.alturas.Pais;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MainTreeSetComparable {

    public static void main(String[] args) throws FileNotFoundException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");

        // Creando comparator
        Comparator<Pais> cC = (p1, p2) -> p1.getContinente().compareTo(p2.getContinente());
        Comparator<Pais> cA = (p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura());
        Comparator<Pais> cN = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());

        // #################
        System.out.println("Paises con altura menor a 1.70");
        Set<Pais> set1 = new TreeSet<>(cC.thenComparing(cA).thenComparing(cN));
        set1.addAll(paises.selecciona(new MenoresQue(1.70)));

        for (Pais pais : set1) {
            System.out.println(pais);
        }

        // #################
        System.out.println();
        System.out.println("Paises europeos");

        Set<Pais> set2 = new TreeSet<>(cA.reversed().thenComparing(cN));
        set2.addAll(paises.selecciona(new EnContinente("Europe")));
        for (Pais pais : set2) {
            System.out.println(pais);
        }

        // #################
        System.out.println();
        System.out.println("Paises con altura menor a 1.65");
        Set<Pais> set3 = new TreeSet<>(paises.selecciona((Pais p) -> p.getAltura() < 1.65));
        for (Pais pais : set3) {
            System.out.println(pais);
        }

    }
}
