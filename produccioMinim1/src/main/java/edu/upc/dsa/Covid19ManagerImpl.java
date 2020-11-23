package edu.upc.dsa;

import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Covid19ManagerImpl implements Covid19Manager
{
    private static Covid19Manager instance;
    protected HashMap<Integer,Brote> tablaBrotes;
    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);

    private Covid19ManagerImpl()
    {
        this.tablaBrotes = new HashMap<Integer, Brote>();
    }

    public static Covid19Manager getInstance()
    {
        if(instance==null)
        {
            instance = new Covid19ManagerImpl();
        }
        return instance;
    }

    @Override
    public List<Brote> findAll() {
        List<Brote> list = new LinkedList<Brote>(tablaBrotes.values());
        logger.info(list);
        return list;
    }

    @Override
    public Brote anadirBrote(Brote nuevo)
    {
        int ID = tablaBrotes.size();
        logger.info("El ID del nuevo brote es " + ID);
        this.tablaBrotes.put(ID, nuevo);
        logger.info("Brote añadido: " + nuevo);
        return nuevo;
    }

    @Override
    public void anadirCasoBrote(int ID, Caso introducir) {
        Brote modificar = this.getBrote(0);
        modificar.addCaso(introducir);
        this.updateBrote(0, modificar);
    }

    @Override
    public Brote getBrote(int ID)
    {
        Brote encontrado = this.tablaBrotes.get(ID);
        logger.info("Brote encontrado: " + encontrado);
        return encontrado;
    }


    @Override
    public void borrarBrote(int ID)
    {
        this.tablaBrotes.remove(ID);
    }

    @Override
    public Brote updateBrote(int ID, Brote nuevo)
    {
        this.tablaBrotes.remove(ID);
        this.tablaBrotes.put(ID, nuevo);
        return nuevo;
    }

    @Override
    public int size()
    {
        int ret = tablaBrotes.size();
        logger.info("size " + ret);
        return ret;
    }
    public void clear()
    {
        tablaBrotes.clear();
        instance = null;
    }
}
