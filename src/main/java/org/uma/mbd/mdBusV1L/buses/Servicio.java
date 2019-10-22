package org.uma.mbd.mdBusV1L.buses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Servicio {
    private List<Bus> buses;
    private String ciudad;

    public Servicio(String ciudad)
    {
        this.ciudad = ciudad;
        buses = new LinkedList<>();
    }

    public void leeBuses(String ruta) throws FileNotFoundException
    {
        try(Scanner sc1 = new Scanner(new File(ruta)))
        {
            leeBuses(sc1);
        }
    }

    private void leeBuses(Scanner sc1)
    {
        while (sc1.hasNextLine())
        {
            stringToBus(sc1.nextLine());
        }

    }

    private void stringToBus(String line)
    {
        try(Scanner sc2 = new Scanner(line))
        {
            sc2.useDelimiter(",");

            int codBus = sc2.nextInt();
            String matricula = sc2.next();
            int codLinea = sc2.nextInt();

            Bus bus = new Bus(codBus, matricula);
            bus.setCodLinea(codLinea);
            buses.add(bus);

        } catch (InputMismatchException e)
        {
            System.out.println("Dato incorrecto en " + line);
        } catch (NoSuchElementException e)
        {
            System.out.println("Faltan datos en " + line);
        }
    }

    public List<Bus> filtra(Criterio criterio)
    {
        List<Bus> lista = new LinkedList<>();
        for(Bus bus : buses)
            if(criterio.esSeleccionable(bus))
                lista.add(bus);
        return lista;
    }

    public void guarda(String ruta, Criterio criterio) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(ruta))
        {
            guarda(pw, criterio);
        }
    }

    public void guarda(PrintWriter pw, Criterio criterio)
    {
       List<Bus> lista = filtra(criterio);
       for(Bus bus : lista)
       {
           pw.println(bus);
       }

    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Bus> getBuses() {
        return buses;
    }
}
