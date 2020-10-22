//Singleton

import javax.naming.ldap.PagedResultsResponseControl;
import java.util.HashMap;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;


public class I18NManager
{
    final static Logger logger = Logger.getLogger(I18NManager.class);

    private static I18NManager manager;
    //data
    HashMap<String, ResourceBundle> data;
    private I18NManager()
    {
        this.data = new HashMap<String, ResourceBundle>();
    }

    public static I18NManager getInstance()
    {
        manager = new I18NManager();
        return manager;
    }

    public String getText(String language, String key)
    {
        logger.info("language: " + language + ". key: " + key);
        String resultat = null;
        ResourceBundle rb = this.data.get(language);
        if (rb==null)
        {
            logger.warn("Bundle '" + language + ".properties' no existeix en la memòria cau de textos");
            rb = ResourceBundle.getBundle(language);
            this.data.put(language, rb);
            logger.info("S'afegeix bundle a memòria cau de textos");
        }
        else
        {
            logger.info("Bundle '" + language + ".properties' ja existeix en la memòria cau de textos");
        }
        resultat = rb.getString(key);
        return resultat;
    }
    public void clear()
    {
        this.data.clear();
    }

}

