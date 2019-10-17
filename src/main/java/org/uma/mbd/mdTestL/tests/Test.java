package org.uma.mbd.mdTestL.tests;

public class Test {

    private int errores;
    private int aciertos;
    private String alumno;

    public Test(String alumno, int aciertos, int errores)
    {
        this.alumno = alumno;
        this.aciertos = aciertos;
        this.errores = errores;
    }

    public double calificacion(double valAc, double valErr)
    {
        if(valAc <= 0)
            throw new IllegalArgumentException("El valor del acierto debe ser positivo");

        if(valErr > 0)
            throw new IllegalArgumentException("El valor del error debe ser negativo o 0");

        return aciertos*valAc + errores*valErr;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = obj instanceof Test;
        Test test = res ? (Test) obj : null;
        return res && alumno.equalsIgnoreCase(test.alumno);
    }

    @Override
    public int hashCode() {
        return alumno.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(alumno.toUpperCase());
        sb.append(" [");
        sb.append(aciertos);
        sb.append(",");
        sb.append(errores);
        sb.append("]");
        return super.toString();
    }

    public int getErrores() {
        return errores;
    }

    public int getAciertos() {
        return aciertos;
    }

    public String getAlumno() {
        return alumno;
    }
}
