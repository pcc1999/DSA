import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;

import java.text.DateFormat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;



public class TestBrote
{
    Brote brote;

    @Before
    public void setUp() throws Exception
    {
        this.brote = new Brote();
        Caso caso0 = new Caso("Ákos", "Schneider", "1998/11/21", "2020/11/21", "Medio", "Hombre", "akos.schneider@estudiantat.upc.edu", 928363722, "Resi", "Confirmado");
        Caso caso1 = new Caso("Toni", "Mur García", "1999/2/26", "2020/11/17", "Alto", "Hombre", "toni.tur@estudiantat.upc.edu", 826382627, "Badal", "No Caso");
        Caso caso2 = new Caso("Marc", "Roldán Gómez", "1999/4/21", "2020/11/12", "Bajo", "Hombre", "marc.roldan.gomez@estudiantat.upc.edu", 628362726, "Esplugues", "Confirmado");
        Caso caso3 = new Caso("Pol", "Casana Cabrerizo", "1999/6/21", "2020/11/09", "Alto", "Hombre", "pol.casana@estudiantat.upc.edu", 826382627, "La Mina", "Sospechoso");
        Caso caso4 = new Caso("Axel", "Rodriguez Guillen", "1999/7/18", "2020/11/05", "Medio", "Hombre", "axel.rodriguez@estudiantat.upc.edu", 826836196, "Rocafonda", "Sospechoso");
        Caso caso5 = new Caso("Miguel", "Marin Vicente", "1999/3/4", "2020/10/04", "Bajo", "Hombre", "miguel.marin@estudiantat.upc.edu", 819273627, "Castefa", "Confirmado");
        brote.addCaso(caso5);
        brote.addCaso(caso0);
        brote.addCaso(caso1);
        brote.addCaso(caso2);
        brote.addCaso(caso3);
        brote.addCaso(caso4);
    }
    @After
    public void tearDown() throws Exception
    {

    }
    @Test
    public void testBorrar() throws Exception
    {
        brote.borrarCaso(30);
        Assert.assertEquals(40, brote.listaCasos.get(2).getID());
    }
    @Test
    public void crearBrote() throws Exception
    {
        Brote nuevoBrote = new Brote();

    }
    @Test
    public void testOrdenar() throws Exception
    {
        sort(brote.listaCasos);
        brote.ordenarClasificacion();
        System.out.println(brote);
    }
}
