import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Master on 16.08.2016.
 */
public class ThreadingPool {
    private static int threadNumber = 1;
    public static int getThreadNumber() {
        return threadNumber;
    }
    private static void setThreadNumber(int number) {
        threadNumber = number;
    }
    /**
        Read properties from a file and set (@code threadNumber) to read value from file

        If any exception occur((@code IOException) or (@code NumberFormatException)) it set (@code threadNumber)
        to default value(equals number of processors)
     */
    public static void readConfiguration(String path) {
        Properties properties = new Properties();
        try (FileReader FR = new FileReader(new File(path))) {
            properties.load(FR);
            setThreadNumber(Integer.parseInt(properties.getProperty("NumberOfThreads")));
        }
        catch (IOException|NumberFormatException e) {
            System.out.println("Cannot read properties from a file: " + path);
            System.out.println("Exception is: " + e.getMessage() + " Cause is: " + e.getCause());
            int numberOfProcessor = Runtime.getRuntime().availableProcessors();
            setThreadNumber(numberOfProcessor);
            System.out.println("Set Number of thread to: " + numberOfProcessor);
        }
    }
}
