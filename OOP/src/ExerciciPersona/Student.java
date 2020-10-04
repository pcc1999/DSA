import java.util.Date;

public class Student extends Person
{
    private Date data;
    private int num;
    public Student(String name, Date dataN)
    {
        super(name);
        this.setData(dataN);

    }
    public Student(String name, Date dataN, int num)
    {
        this(name, dataN);
        this.setNum(num);
    }
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return super.toString()+"data: "+this.data+"\n";
    }

    public static void main(String[] args) {
        System.out.println(new Student("Jordi",new Date()));
    }
}
