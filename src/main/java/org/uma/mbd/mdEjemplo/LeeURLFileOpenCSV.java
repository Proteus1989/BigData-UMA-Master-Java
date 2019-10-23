package org.uma.mbd.mdEjemplo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class LeeURLFileOpenCSV {
    public static void main(String[] args) throws IOException, CsvException {
        String urlPath = "http://datosabiertos.malaga.eu/recursos/transporte" + "/EMT/EMTLineasUbicaciones/lineasyubicaciones.csv";
        URL url = new URL(urlPath);
        try (InputStream fs = url.openStream();
             InputStreamReader isr = new InputStreamReader(fs);
             BufferedReader br = new BufferedReader(isr);
             CSVReader csv = new CSVReader(br)) {

            /*
            csv.readNext();
            String[] datosBus = csv.readNext();
            while (datosBus != null) {
                System.out.print("CodBus: " + datosBus[0]);
                System.out.print(", CodLin: " + datosBus[1]);
                System.out.print(", Lon: " + datosBus[3]);
                System.out.println(", Lat: " + datosBus[4]);
                datosBus = csv.readNext();
             */

            csv.readNext();
            for (String[] datosBus : csv.readAll()) {
                System.out.print("CodBus: " + datosBus[0]);
                System.out.print(", CodLin: " + datosBus[1]);
                System.out.print(", Lon: " + datosBus[3]);
                System.out.println(", Lat: " + datosBus[4]);
            }

        }
    }
}
