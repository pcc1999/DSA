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

    public static void main(String[] args)
    {
        String msg1 = i18NManager.getInstance("it").getText("it", "l2");
        //String msg2 = i18NManager.getInstance("es").getText("es", "l2");
/*        String msg3 = i18NManager.getInstance().getText("en", "l1");

        String msg4 = i18NManager.getInstance().getText("ca", "l2");
        String msg5 = i18NManager.getInstance().getText("es", "l2");
        String msg6 = i18NManager.getInstance().getText("en", "l2");*/

        System.out.println(msg1);
        //System.out.println(msg2);
    }
}
