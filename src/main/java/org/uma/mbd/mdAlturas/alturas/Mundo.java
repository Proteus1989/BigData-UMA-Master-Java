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

    public Map<String, Integer> numPaisesPorContinente()
    {
        Map<String, Integer> map = new HashMap<>();
        for(Pais pais : paises)
        {
            int veces = map.getOrDefault(pais.getContinente(), 0);
            map.put(pais.getContinente(), veces + 1);
        }

        return map;
    }

    public Map<String, Set<Pais>> paisesPorContinente()
    {
        Comparator<String> compS = Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder());
        Map<String, Set<Pais>> map = new TreeMap<>(compS);
        /* Version inicial
        Comparator<Pais> comA = (p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura());
        Comparator<Pais> comN = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());
         */
        /* Version mejorada
        // Comparator<Pais> comA = Comparator.comparing(p -> p.getAltura()); // Igualmente funciona
        Comparator<Pais> comA = Comparator.comparingDouble(p -> p.getAltura());
        Comparator<Pais> comN = Comparator.comparing(p -> p.getNombre());
         */
        // Version final
        Comparator<Pais> comA = Comparator.comparing(Pais::getAltura);
        Comparator<Pais> comN = Comparator.comparing(Pais::getNombre);

        Comparator<Pais> comp = comA.thenComparing(comN);
        for(Pais pais : paises)
        {
            String continente = pais.getContinente();
            Set<Pais> set = map.computeIfAbsent(continente, c -> new TreeSet<>(comp));
            set.add(pais);
        }
        return map;
    }
}
