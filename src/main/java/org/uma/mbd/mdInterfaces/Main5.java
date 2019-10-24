package org.uma.mbd.mdInterfaces;

import org.uma.mbd.mdInterfaces.caso4.Persona;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Set<Persona> set = new HashSet<>();
        set.add(new Persona("Juan", 25));
        set.add(new Persona("Pedro", 12));
        set.add(new Persona("Juan", 25));
        set.add(new Persona("Luisa", 18));
        set.add(new Persona("Andres", 12));
        System.out.println(set);


        Set<Persona> setO = new TreeSet<>();
        setO.add(new Persona("Juan", 25));
        setO.add(new Persona("Pedro", 12));
        setO.add(new Persona("Juan", 25));
        setO.add(new Persona("Luisa", 18));
        setO.add(new Persona("Andres", 12));
        System.out.println(setO);


        Comparator<Persona> oE = (p1,p2) -> Integer.compare(p1.getEdad(), p2.getEdad());
        Comparator<Persona> oN = (p1,p2) -> p1.getNombre().compareTo(p2.getNombre());
        Set<Persona> setA = new TreeSet<>(oE.reversed().thenComparing(oN).reversed());
        setA.addAll(setO);
        System.out.println(setA);

        Set<String> setS = new TreeSet<>(List.of("hola", "antonio", "que", "tal", "estas", "hoy"));
        System.out.println(setS);

        Comparator<String> cL = (p1, p2) -> Integer.compare(p1.length(), p2.length());
        Set<String> setSC = new TreeSet<>(cL.thenComparing(Comparator.naturalOrder()));
        setSC.addAll(setS);
        System.out.println(setSC);

    }
}
