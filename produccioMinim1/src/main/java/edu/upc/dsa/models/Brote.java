package edu.upc.dsa.models;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.sort;

public class Brote
{
    public List<Caso> listaCasos;

    public Brote()
    {
        this.listaCasos = new LinkedList<>();
    }

    public void addCaso(Caso nuevo)
    {
        this.listaCasos.add(nuevo);
    }
    public void borrarCaso(int ID)
    {
        int i;
        for (i = 0; i < listaCasos.size(); i++)
        {
            if(listaCasos.get(i).getID() == ID)
            {
                break;
            }
        }
        listaCasos.remove(i);
    }
    public void ordenarClasificacion()
    {
        //sort(this.listaCasos);
        Caso prov;
        int contador = 0;
        String[] opciones = new String[3];
        opciones[0] = "Confirmado";
        opciones[1] = "Sospechoso";
        opciones[2] = "No Caso";
        int grupo = 0;
        for(int j = 0; j < 3; j++)
        {
            for (int i = contador; i < this.listaCasos.size(); i++)
            {
                if (listaCasos.get(i).clasificacion.equals(opciones[j]))
                {
                    prov = listaCasos.get(contador);
                    listaCasos.set(contador, listaCasos.get(i));
                    listaCasos.set(i, prov);
                    contador++;
                }
            }
        }
    }
    @Override
    public String toString() {
        return "Brote{" +
                "listaCasos = " + listaCasos +
                '}';
    }
    //ESTO DEBERIA IR AL TEST PERO ME LA SUDA GORDA
    public static void main(String[] args)
    {
        Brote brote = new Brote();
        Caso caso0 = new Caso("Ákos", "Schneider", "1998/11/21", "2020/11/21", "Medio", "Hombre", "akos.schneider@estudiantat.upc.edu", 928363722, "Resi", "Confirmado");
        Caso caso1 = new Caso("Toni", "Mur García", "1999/2/26", "2020/11/17", "Alto", "Hombre", "toni.tur@estudiantat.upc.edu", 826382627, "Badal", "No Caso");
        Caso caso2 = new Caso("Marc", "Roldán Gómez", "1999/4/21", "2020/11/12", "Bajo", "Hombre", "marc.roldan.gomez@estudiantat.upc.edu", 628362726, "Esplugues", "Confirmado");
        Caso caso3 = new Caso("Pol", "Casana Cabrerizo", "1999/6/21", "2020/11/9", "Alto", "Hombre", "pol.casana@estudiantat.upc.edu", 826382627, "La Mina", "Sospechoso");
        Caso caso4 = new Caso("Axel", "Rodriguez Guillen", "1999/7/18", "2020/11/5", "Medio", "Hombre", "axel.rodriguez@estudiantat.upc.edu", 826836196, "Rocafonda", "Sospechoso");
        Caso caso5 = new Caso("Miguel", "Marin Vicente", "1999/3/4", "2020/10/4", "Bajo", "Hombre", "miguel.marin@estudiantat.upc.edu", 819273627, "Castefa", "Confirmado");
        caso5.setID(0);
        brote.addCaso(caso5);
        caso0.setID(10);
        brote.addCaso(caso0);
        caso1.setID(20);
        brote.addCaso(caso1);
        caso2.setID(30);
        brote.addCaso(caso2);
        caso3.setID(40);
        brote.addCaso(caso3);
        caso4.setID(50);
        brote.addCaso(caso4);
        sort(brote.listaCasos);
        brote.ordenarClasificacion();
        System.out.println(brote);
    }
}
