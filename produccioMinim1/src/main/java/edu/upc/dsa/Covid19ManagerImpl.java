package edu.upc.dsa;

import edu.upc.dsa.models.Brote;
import org.apache.log4j.Logger;

import java.util.HashMap;
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
    public Brote getBrote(int ID)
    {
        Brote encontrado = this.tablaBrotes.get(ID);
        logger.info("Brote encontrado: " + encontrado);
        return encontrado;
    }

    @Override
    public List<Brote> findAll()
    {
        return null;
    }

    @Override
    public void borrarBrote(int ID)
    {
        this.tablaBrotes.remove(ID);
    }

    @Override
    public Brote updateBrote(Brote nuevo)
    {
        return null;
    }

    @Override
    public int size()
    {
        int ret = tablaBrotes.size();
        logger.info("size " + ret);
        return ret;
    }
}
