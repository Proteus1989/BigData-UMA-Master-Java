package org.uma.mbd.mdTestL.tests;

import java.util.LinkedList;
import java.util.List;

public class TestAsignatura {
    private String nombre;
    private double valorAciertos;
    private double valorErrores;
    private List<Test> examenes = new LinkedList<>();
    private static final double APROBADO = 5;

    public TestAsignatura(String nombre, List<String> lista) {
        this(nombre, 1, 0, lista);
    }

    public TestAsignatura(String nombre, double valAc, double valErr, List<String> lista) {
        this.nombre = nombre;
        valorAciertos = valAc;
        valorErrores = valErr;
        extraerDatos(lista);
    }

    private void extraerDatos(List<String> datos) {

        for(String dato : datos)
        {
            String[] tokens = dato.split("[:+]+");
            String nombreAlumno = tokens[0];
            int aciertos = Integer.parseInt(tokens[1]);
            int errores = Integer.parseInt(tokens[2]);

            examenes.add(new Test(nombreAlumno, aciertos, errores));
        }

    }

    public double notaMedia() {
        double media = 0;
        for (Test test : examenes)
            media += test.calificacion(valorAciertos, valorErrores);

        return media / examenes.size();
    }

    public int aprobados() {
        int aprobados = 0;

        for (Test test : examenes)
            if (test.calificacion(valorAciertos, valorErrores) >= APROBADO)
                aprobados++;
        return aprobados;
    }

    public String getNombre() {
        return nombre;
    }
}
