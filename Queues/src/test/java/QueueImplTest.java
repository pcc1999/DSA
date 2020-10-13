package test.java;
import main.java.Queue;
import main.java.QueueImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueImplTest
{
    Queue<String> q;

    @Before
    public void setUp() throws Exception
    {
        this.q = new QueueImpl<String>(5);
        this.q.push("1");
        this.q.push("2");
        this.q.push("3");

    }

    @After
    public void tearDown()
    {
        this.q = null;
    }

    @Test
    public void testPush1() throws Exception
    {
        Assert.assertEquals(3, this.q.size());
        this.q.push("4");
        Assert.assertEquals(4,this.q.size());
    }

    @Test
    public void TestPush2() throws Exception
    {
        Assert.assertEquals(3, this.q.size());
    }

}
