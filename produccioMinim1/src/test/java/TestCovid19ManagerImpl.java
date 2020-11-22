import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestCovid19ManagerImpl
{
    Covid19Manager manager;
    @Before
    public void setUp() throws Exception
    {
        this.manager = Covid19ManagerImpl.getInstance();
    }
    @After
    public void tearDown()
    {
        this.manager.clear();
    }
    @Test
    public void anadirBrote() throws Exception
    {
        Brote nuevo = new Brote();
        Brote nuevo2 = new Brote();
        Caso caso0 = new Caso("Ákos", "Schneider", "1998/11/21", "2020/11/21", "Medio", "Hombre", "akos.schneider@estudiantat.upc.edu", 928363722, "Resi", "Confirmado");
        Caso caso1 = new Caso("Toni", "Mur García", "1999/2/26", "2020/11/17", "Alto", "Hombre", "toni.tur@estudiantat.upc.edu", 826382627, "Badal", "No Caso");
        Caso caso2 = new Caso("Marc", "Roldán Gómez", "1999/4/21", "2020/11/12", "Bajo", "Hombre", "marc.roldan.gomez@estudiantat.upc.edu", 628362726, "Esplugues", "Confirmado");
        Caso caso3 = new Caso("Pol", "Casana Cabrerizo", "1999/6/21", "2020/11/09", "Alto", "Hombre", "pol.casana@estudiantat.upc.edu", 826382627, "La Mina", "Sospechoso");
        Caso caso4 = new Caso("Axel", "Rodriguez Guillen", "1999/7/18", "2020/11/05", "Medio", "Hombre", "axel.rodriguez@estudiantat.upc.edu", 826836196, "Rocafonda", "Sospechoso");
        Caso caso5 = new Caso("Miguel", "Marin Vicente", "1999/3/4", "2020/10/04", "Bajo", "Hombre", "miguel.marin@estudiantat.upc.edu", 819273627, "Castefa", "Confirmado");
        nuevo.addCaso(caso0);
        nuevo.addCaso(caso1);
        nuevo.addCaso(caso2);
        nuevo2.addCaso(caso3);
        nuevo2.addCaso(caso4);
        nuevo2.addCaso(caso5);

        this.manager.anadirBrote(nuevo);
        this.manager.anadirBrote(nuevo2);

        Assert.assertEquals(2, this.manager.size());
    }
    @Test
    public void anadirCaso() throws Exception
    {
        Caso caso0 = new Caso("Ákos", "Schneider", "1998/11/21", "2020/11/21", "Medio", "Hombre", "akos.schneider@estudiantat.upc.edu", 928363722, "Resi", "Confirmado");
        Caso caso1 = new Caso("Toni", "Mur García", "1999/2/26", "2020/11/17", "Alto", "Hombre", "toni.tur@estudiantat.upc.edu", 826382627, "Badal", "No Caso");
        Brote nuevo = new Brote();
        nuevo.addCaso(caso0);
        this.manager.anadirBrote(nuevo);
        this.manager.anadirCasoBrote(0, caso1);
        Assert.assertEquals(2, this.manager.getBrote(0).getNumCasos());
    }
    @Test
    public void testBorrar() throws Exception
    {
        Caso caso0 = new Caso("Ákos", "Schneider", "1998/11/21", "2020/11/21", "Medio", "Hombre", "akos.schneider@estudiantat.upc.edu", 928363722, "Resi", "Confirmado");
        Caso caso1 = new Caso("Toni", "Mur García", "1999/2/26", "2020/11/17", "Alto", "Hombre", "toni.tur@estudiantat.upc.edu", 826382627, "Badal", "No Caso");
        Brote nuevo = new Brote();
        nuevo.addCaso(caso0);
        this.manager.anadirBrote(nuevo);
        this.manager.borrarBrote(0);
        Assert.assertEquals(0, this.manager.size());
    }
    @Test
    public void testMostrarLista() throws Exception
    {
        Caso caso0 = new Caso("Ákos", "Schneider", "1998/11/21", "2020/11/21", "Medio", "Hombre", "akos.schneider@estudiantat.upc.edu", 928363722, "Resi", "Confirmado");
        Caso caso1 = new Caso("Toni", "Mur García", "1999/2/26", "2020/11/17", "Alto", "Hombre", "toni.tur@estudiantat.upc.edu", 826382627, "Badal", "No Caso");
        Caso caso2 = new Caso("Marc", "Roldán Gómez", "1999/4/21", "2020/11/12", "Bajo", "Hombre", "marc.roldan.gomez@estudiantat.upc.edu", 628362726, "Esplugues", "Confirmado");
        Brote nuevo = new Brote();
        Brote nuevo2= new Brote();
        nuevo.addCaso(caso0);
        nuevo.addCaso(caso2);
        nuevo2.addCaso(caso1);
        this.manager.anadirBrote(nuevo);
        this.manager.anadirBrote(nuevo2);
        List<Brote> listaBrotes = this.manager.findAll();
        Assert.assertEquals(0,0);
    }
}
