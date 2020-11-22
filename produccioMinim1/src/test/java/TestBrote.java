import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;

import java.text.DateFormat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class TestBrote
{
    Brote brote;

    @Before
    public void setUp() throws Exception
    {
        this.brote = new Brote();
    }
    @After

    @Test
    public void testBorrar() throws Exception
    {
        Caso caso0 = new Caso("Ákos", "Schneider", "1998/11/21", "2020/11/21", "Medio", "Hombre", "akos.schneider@estudiantat.upc.edu", 928363722, "Resi", "Confirmado");
        Caso caso1 = new Caso("Toni", "Mur García", "1999/2/26", "2020/11/17", "Alto", "Hombre", "toni.tur@estudiantat.upc.edu", 826382627, "Badal", "No caso");
        Caso caso2 = new Caso("Marc", "Roldán Gómez", "1999/4/21", "2020/11/12", "Bajo", "Hombre", "marc.roldan.gomez@estudiantat.upc.edu", 628362726, "Esplugues", "Confirmado");
        Caso caso3 = new Caso("Pol", "Casana Cabrerizo", "1999/6/21", "2020/11/9", "Alto", "Hombre", "pol.casana@estudiantat.upc.edu", 826382627, "La Mina", "No Confirmado");
        caso0.setID(10);
        brote.addCaso(caso0);
        caso1.setID(20);
        brote.addCaso(caso1);
        caso2.setID(30);
        brote.addCaso(caso2);
        caso3.setID(40);
        brote.addCaso(caso3);
        brote.borrarCaso(30);
        Assert.assertEquals(40, brote.listaCasos.get(2).getID());
    }
}
