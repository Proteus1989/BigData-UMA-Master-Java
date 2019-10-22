package org.uma.mbd.mdEjemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscrituraLectura2 {
    public static void main(String[] args) throws IOException {
        // crear un fichero de palabras
        String fichero = "src/main/java/org/uma/mbd/mdEjemplo/datos.txt";
        try (PrintWriter pw = new PrintWriter(fichero)) {
            pw.println("amor roma mora ramo");
            pw.println("rima mira");
            pw.println("rail liar");
        }

        try(Scanner sc = new Scanner(new File(fichero)))
        {
            while(sc.hasNextLine())
                try(Scanner sc2 = new Scanner(sc.nextLine()))
                {
                    while(sc2.hasNext())
                        System.out.println(sc2.next());
                }
        }
    }
}
