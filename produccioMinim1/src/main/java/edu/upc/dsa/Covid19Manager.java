package edu.upc.dsa;
import edu.upc.dsa.models.Brote;

import java.util.List;

public interface Covid19Manager
{
    public Brote anadirBrote(Brote nuevo);
    public Brote getBrote(int ID);
    public List<Brote> findAll();
    public void borrarBrote(int ID);
    public Brote updateBrote(Brote nuevo);
    public int size();
}
