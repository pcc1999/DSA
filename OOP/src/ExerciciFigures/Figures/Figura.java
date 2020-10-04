package ExerciciFigures.Figures;

import ExerciciFigures.Figures.Quadrat;


public abstract class Figura implements Comparable<Figura>
{
    public abstract double area();

    //@Override
    public int compareTo(Figura o)
    {
        int diff = 0;
        diff = (int) (this.area() - o.area());
        return diff;
    }
}
