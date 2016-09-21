package homeWorks.homeWork5;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by Master on 26.07.2016.
 */
public class AppStart {
    public static void main(String[] args) {
        boolean isConnect = false;
        URL url = null;
        while (!isConnect) {
            try {
                System.out.println("Please, enter URL address to show content(or enter 'exit' for end): ");
                Scanner scanner = new Scanner(System.in);
                String address = scanner.nextLine();
                if (address.trim().toLowerCase().equals("exit")) {
                    System.out.println("The user enter 'exit'.");
                    System.exit(0);
                }
                url = new URL(address);
                readContent(url);

                isConnect = true;
            }
            catch (MalformedURLException | RuntimeException e) {
                System.out.println("An error occur during trying to find address: " + e.getMessage());
            }

            System.out.println("The program end.");
        }
    }

    private static void readContent(URL url) {
        try (BufferedReader BR = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream(), Charset.forName("UTF-8")))) {
            String tempString;
            while ((tempString = BR.readLine()) != null) {
                System.out.println(tempString);
            }
            System.out.println("\n---END---");
        }
        catch (IOException e) {
            System.out.println("An error occur during get content: " + e.getMessage());
        }
    }
}
