package homeWork7.temp;

/**
 * Created by Master on 04.08.2016.
 */
public class PluginImpl implements homeWork7.Plugin{
    @Override
    public void doUsefil() {
        System.out.println("This is very useful method from: " + this.getClass().getName());
    }
}
