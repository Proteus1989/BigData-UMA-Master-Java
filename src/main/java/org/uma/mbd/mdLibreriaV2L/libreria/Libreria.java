package org.uma.mbd.mdLibreriaV2L.libreria;

import java.util.LinkedList;
import java.util.List;

public class Libreria {
    private List<Libro> libros = new LinkedList<>();

    public void addLibro(String autor, String titulo, double precioBase)
    {
        Libro libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }

    protected void addLibro(Libro libro)
    {
        int i = posicionLibro(libro.getAutor(), libro.getTitulo());
        if (i<0)
            libros.add(libro);
        else
            libros.set(i, libro);

    }

    private int posicionLibro(String autor, String titulo)
    {
        int pos = 0;
        while (pos < libros.size() && !(autor.equalsIgnoreCase(libros.get(pos).getAutor()) &&
                titulo.equalsIgnoreCase(libros.get(pos).getTitulo())))
        {
            pos++;
        }

        return pos == libros.size() ? -1 : pos;
    }

    public void remLibro(String autor, String titulo)
    {
        int posicion = posicionLibro(autor, titulo);

        if(posicion >= 0)
        {
            libros.remove(posicion);
        }
    }

    public double getPrecioBase(String autor, String titulo)
    {
        int pos = posicionLibro(autor,titulo);
        return (pos >= 0) ? libros.get(pos).getPrecioBase() : 0;
    }

    public double getPrecioFinal(String autor, String titulo)
    {
        int pos = posicionLibro(autor,titulo);
        return (pos >= 0) ? libros.get(pos).getPrecioFinal() : 0;
    }

    @Override
    public String toString() {
        return libros.toString();
    }
}
