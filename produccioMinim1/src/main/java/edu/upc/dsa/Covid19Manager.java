package edu.upc.dsa;
import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;

import java.util.List;

public interface Covid19Manager
{
    public List<Brote> findAll();
    public Brote anadirBrote(Brote nuevo);
    public void anadirCasoBrote(int ID, Caso Introducir);
    public Brote getBrote(int ID);
    public void borrarBrote(int ID);
    public Brote updateBrote(int ID, Brote nuevo);
    public void clear();
    public int size();
}
