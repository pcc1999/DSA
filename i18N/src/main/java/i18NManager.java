//Singleton

import javax.naming.ldap.PagedResultsResponseControl;
import java.util.HashMap;
import java.util.ResourceBundle;

public class i18NManager
{
    private static i18NManager manager;
    //data
    HashMap<String, ResourceBundle> data;
    private i18NManager(String language)
    {
        this.data = new HashMap<String, ResourceBundle>();
        ResourceBundle recursos = ResourceBundle.getBundle(language);
        this.data.put(language, recursos);
    }

    public static i18NManager getInstance(String language)
    {
        manager = new i18NManager(language);
        return manager;
    }

    public String getText(String language, String key)
    {
        String resultat = null;
        resultat = this.data.get(language).getString(key);
        return resultat;
    }
    
}
