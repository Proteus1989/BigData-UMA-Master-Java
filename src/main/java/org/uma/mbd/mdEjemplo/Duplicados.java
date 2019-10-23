package org.uma.mbd.mdEjemplo;

import java.util.HashSet;
import java.util.Set;

public class Duplicados {
    public static void main(String[] args) {

        args = new String[]{"hola","que","tal","hola","tal","adios","adios"};
        Set<String> s = new HashSet<>();
        for (String arg : args) {
            if (!s.add(arg)) {
                System.out.println("duplicado: " + arg);
            }
        }
        System.out.println(
                s.size() + " palabras detectadas: " + s);
    }
}
