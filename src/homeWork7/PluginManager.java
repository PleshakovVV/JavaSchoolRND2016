package homeWork7;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

/**
 * Created by Master on 03.08.2016.
 */
public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName)
            throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String path = pluginRootDirectory + "/" + pluginName + "/";
        File file = new File(path);

        URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {file.toURL()}, null);
        Class cl = urlClassLoader.loadClass(pluginClassName);
        if (!Arrays.asList(cl.getInterfaces()).contains(Plugin.class)) {
            throw new ClassNotFoundException("The class doesn't implements Plugin interface!");
        }
        return (Plugin)cl.newInstance();
    }
}
