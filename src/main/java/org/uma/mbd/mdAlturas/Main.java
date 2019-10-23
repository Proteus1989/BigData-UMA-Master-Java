package org.uma.mbd.mdAlturas;

import org.uma.mbd.mdAlturas.alturas.EnContinente;
import org.uma.mbd.mdAlturas.alturas.MenoresQue;
import org.uma.mbd.mdAlturas.alturas.Mundo;
import org.uma.mbd.mdAlturas.alturas.Pais;

import java.io.FileNotFoundException;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");
        System.out.println("Paises con altura menor a 1.70");
        for (Pais pais : paises.selecciona(new MenoresQue(1.70))) {
            System.out.println(pais);
        }
        System.out.println();
        System.out.println("Paises europeos");
        for (Pais pais : paises.selecciona(new EnContinente("Europe"))) {
            System.out.println(pais);
        }

        // Esto no lo pide el ejercicio pero con ilustra como funcionan los operaciones funcionales
        System.out.println();
        System.out.println("Paises con altura menor a 1.70");
        for (Pais pais : paises.selecciona((Pais p) -> p.getAltura() < 1.70)) {
            System.out.println(pais);
        }

        // Otro ejemplo de operaciones funcionales
        System.out.println();
        System.out.println("Paises cuyo nombre empieza por S");
        for (Pais pais : paises.selecciona((Pais p) -> p.getNombre().toUpperCase().startsWith("S"))) {
            System.out.println(pais);
        }

        // Streams
        System.out.println();
        System.out.println("Paises con altura inferior a 1.65");
        paises.selecciona((Pais p) -> p.getAltura() < 1.65).forEach(p -> System.out.println(p));

        System.out.println();
        System.out.println("Paises con altura inferior a 1.65");
        paises.selecciona((Pais p) -> p.getAltura() < 1.65).forEach(System.out::println);

        System.out.println();
        System.out.println("Paises con altura inferior a 1.65");
        paises.getPaises().stream().filter((p) -> p.getAltura() < 1.65).forEach(System.out::println);

    }
}
