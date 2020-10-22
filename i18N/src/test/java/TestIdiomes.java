import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.MissingResourceException;

public class TestIdiomes
{
    I18NManager i18n;

    @Before
    public void setUp() throws Exception
    {
        this.i18n = I18NManager.getInstance();
    }

    @After
    public void tearDown() throws Exception
    {
        this.i18n.getInstance().clear();
    }

    @Test
    public void testIdiomes() throws Exception
    {
        Assert.assertEquals("arrivederci", I18NManager.getInstance().getText("it", "l2"));
        Assert.assertEquals("adéu", I18NManager.getInstance().getText("ca", "l2"));
        Assert.assertEquals("maj", I18NManager.getInstance().getText("kli", "l2"));
        Assert.assertEquals("bye", I18NManager.getInstance().getText("en", "l2"));
        Assert.assertEquals("adiós", I18NManager.getInstance().getText("es", "l2"));
    }
    @Test(expected = MissingResourceException.class)
    public void testNoIdioma() throws Exception
    {
        Assert.assertEquals("ade", I18NManager.getInstance().getText("de", "l2"));
    }
}
