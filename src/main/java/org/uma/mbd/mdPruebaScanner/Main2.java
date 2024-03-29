package org.uma.mbd.mdPruebaScanner;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        //String datos = "Juan García,23.Pedro González:15.Luisa López-19.Andrés Molina-22";
        String datos = "Juan García,23.Pedro González#15.Luisa López-1y.Andrés Molina-22";
        try (Scanner sc = new Scanner(datos)) {
            sc.useDelimiter("[.]"); // Exactamente un punto
            while (sc.hasNext()) {
                String datoPersona = sc.next();
                try (Scanner scPersona = new Scanner(datoPersona)) {
                    scPersona.useDelimiter("[,:-]");
                    String nombre = scPersona.next();
                    int edad = scPersona.nextInt();
                    Persona persona = new Persona(nombre, edad);
                    System.out.println(persona);
                }
                catch (InputMismatchException e)
                {
                    System.err.println("Dato no numerico en " + datoPersona);
                }
                catch (NoSuchElementException e)
                {
                    System.err.println("Faltan datos en " + datoPersona);
                }
            }
        }
    }
}