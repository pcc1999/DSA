package ExerciciFigures.Figures;

public class Quadrat extends Rectangle
{

    public Quadrat(int l)
    {
        super(l,l);
    }

    @Override

    public String toString()
    {
        return "Quadrat l: " + super.getL1() + " area: ((" + this.area() + "))";
    }
}
