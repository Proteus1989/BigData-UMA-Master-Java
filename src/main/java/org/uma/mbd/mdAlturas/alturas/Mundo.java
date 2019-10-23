package org.uma.mbd.mdAlturas.alturas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mundo {

    List<Pais> paises = new LinkedList<>();

    public void leePaises(String ruta) throws FileNotFoundException {
        try(Scanner sc = new Scanner(new File(ruta)))
        {
            leePaises(sc);
        }
    }

    private void leePaises(Scanner sc) {
        while (sc.hasNextLine())
        {
            leePais(sc.nextLine());
        }
    }

    private void leePais(String line)
    {
        try(Scanner sc = new Scanner(line))
        {
            sc.useLocale(Locale.ENGLISH);
            sc.useDelimiter(",");
            paises.add(new Pais(sc.next(), sc.next(), sc.nextDouble()));
        } catch (InputMismatchException e)
        {
            System.out.println("Tipo de datos incorrecto en " + line);
        } catch (NoSuchElementException e)
        {
            System.out.println("Faltan datos en " + line);
        }
    }

    public List<Pais> selecciona(Seleccion sel) {
        List<Pais> lista = new LinkedList<>();
        for (Pais pais : paises)
            if (sel.test(pais))
                lista.add(pais);
        return lista;
    }

    public List<Pais> getPaises() {
        return paises;
    }
}
