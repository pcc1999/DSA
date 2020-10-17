import org.junit.Assert;
import org.junit.Test;

public class TestIdiomes
{

    @Test
    public void testIdiomes() throws Exception
    {
        Assert.assertEquals("arrivederci", i18NManager.getInstance("it").getText("it", "l2"));
        Assert.assertEquals("adéu", i18NManager.getInstance("ca").getText("ca", "l2"));
        Assert.assertEquals("maj", i18NManager.getInstance("kli").getText("kli", "l2"));
        Assert.assertEquals("adéu", i18NManager.getInstance("ca").getText("ca", "l2"));
        Assert.assertEquals("bye", i18NManager.getInstance("en").getText("en", "l2"));
        Assert.assertEquals("adiós", i18NManager.getInstance("es").getText("es", "l2"));
    }
    @Test
    public void testNoIdioma() throws Exception
    {
        Assert.assertEquals("ade", i18NManager.getInstance("de").getText("de", "l2"));
    }
}
