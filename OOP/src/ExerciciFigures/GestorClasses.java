package ExerciciFigures;

import ExerciciFigures.Figures.Cercle;
import ExerciciFigures.Figures.Figura;
import ExerciciFigures.Figures.Quadrat;
import ExerciciFigures.Figures.Rectangle;
import java.util.Arrays;

public class GestorClasses
{
    public static void sort (Figura[] v)
    {
        Arrays.sort(v, (o1, o2) -> (int)(o1.area() - o2.area()));
        Arrays.sort(v, (o1, o2) -> (o1.getClass().getSimpleName().split("")[0].compareTo(o2.getClass().getSimpleName().split("")[0])));
    }

    public static double suma (Figura[] v)
    {
        double ret = 0;
        for (Figura f: v)
        {
            ret += f.area();
        }
        return ret;
    }

    public static void main(String[] args)
    {
        Figura[] v = new Figura[5];
        v[0] = new Cercle(3);
        v[1] = new Quadrat(3);
        v[2] = new Rectangle(4,1);
        v[3] = new Quadrat(4);
        v[4] = new Cercle(3.5);

        double r = GestorClasses.suma(v);

        System.out.println("Resultat de la suma d'arees: " + r);

        System.out.println("Figures sense ordenar: " + Arrays.asList(v));
        GestorClasses.sort(v);
        System.out.println("Figures ordenades per nom i area: " + Arrays.asList(v));
    }
}
