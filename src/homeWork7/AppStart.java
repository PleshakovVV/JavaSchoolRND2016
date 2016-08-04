package homeWork7;

import java.net.MalformedURLException;

/**
 * Created by Master on 03.08.2016.
 */
public class AppStart {
    public static void main(String[] args) {
        PluginManager pluginManager = new PluginManager("C:/Users/Master/IdeaProjects/JavaSchoolRND2016/ext");
        try {
            Plugin plugin = pluginManager.load("PluginName","homeWork7.PluginImpl");
            plugin.doUsefil();
        } catch (MalformedURLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
