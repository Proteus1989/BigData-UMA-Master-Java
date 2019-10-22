package org.uma.mbd.mdEjemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeeScanner {
    public static void main(String[] args) throws FileNotFoundException {
        String fichero = "src/main/java/org/uma/mbd/mdEjemplo/MainOperacionesFuncionales.java";
        try(Scanner sc = new Scanner(new File(fichero)))
        {
            while(sc.hasNextLine())
                System.out.println(sc.nextLine());
        }
    }
}
