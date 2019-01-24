
package Aufgabe_5;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Nummer_5
{

    public static void startCounter()
    {
        char enter = JOptionPane.showInputDialog("Geben Sie einen char ein").charAt(0);
        JOptionPane.showMessageDialog(null, "Anzahl and [" + enter + "] = " +checkForAmount(enter));

    }

    private static String readBytes()
    {
        String ergebnis = "";

        try
        {
            BufferedReader bR = new BufferedReader(new FileReader("text.txt"));
            String len;

            while ((len = bR.readLine()) != null);
            {
                ergebnis += len;
            }

            return ergebnis;

        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            e.getMessage();
        }

        return null;
    }

    private static int checkForAmount(char c)
    {
        //Hier ist mein Zähler
        int counter = 0;
        //Geh durch das Dokument und gib es aus
        String text = readBytes();

        for (int i=0; i < text.length(); i ++)
        {
            if (text.charAt(i) == c)
            {
                counter ++;
            }
        }

        return counter;
    }
}
