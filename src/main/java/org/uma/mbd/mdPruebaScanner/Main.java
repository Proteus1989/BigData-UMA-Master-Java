package org.uma.mbd.mdPruebaScanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) // System.in va a cerrarse y generara futuros problemas
        {
            System.out.println(sc.nextLine());
        }


        try(Scanner sc = new Scanner(System.in)) {
            System.out.println(sc.nextLine()); // Aqui fallara
        }
    }
}
