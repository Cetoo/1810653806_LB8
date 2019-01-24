package Aufgabe_1;

import javax.swing.*;
import java.io.*;

    public class Geheimnis{
        public static void main(String[] args)
        {

            int choose = Integer.parseInt(JOptionPane.showInputDialog("Press 1 to sign in, Press 2 to create an account, Press 3 to Cancel"));
            //Dem Nutzer werden hier 3 Auswahlmöglichkeiten gegeben
            while (true)
            {
            //Wenn die Eingabe bzw. die Bedingung true ist wird im Block weitergemacht
                if (choose == 1)
                //Wenn der Nutzer die Funktion 1 wählt in diesem Fall to sign in wird hier reingegangen
                {
                    String user = JOptionPane.showInputDialog("Enter Username");
                    String pw = JOptionPane.showInputDialog("Enter Password");
                    //Es werden dem Nutzer zwei Fenster geöffnet für die Eingabe seiner Benutzerdaten

                    try
                    {
                        System.out.println(login(user, pw));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally
                    {
                        break;
                    }


                }
                else if (choose == 2)
                {
                    //Wenn der Nutzer die Eingabe 2 tätigt werden ihm die folgenden zwei Fenster eingeblendet
                    String user = JOptionPane.showInputDialog("What's your name");
                    String pw = JOptionPane.showInputDialog("Choose a Password");

                    try
                    {
                        createUser(user, pw);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        break;
                    }
                }
                else break;
                }

            }

        public static void createUser(String user, String pw) throws IOException {
            File store = new File("C:\\Users\\dc201\\Desktop\\IntelliJ\\Leistungsbeurteilung zu Ue 8\\Textdatei" + user + ".txt");
            //Hier wird eine neue Datei für den User mit seinem Usernamen als .txt datei in folgendem Pfad erzeugt

            if (store.exists())
            {
                System.out.println("This nickname is already used please try again");
                //Wenn es eine solche Datei mit dem gleichen Nutzernamen gibt wird folgendes ausgegeben

            } else
                {
                    //Wenn diese Datei noch nicht angelegt ist oder existiert wird eine neue erzeugt und darin das Passwort des Nutzers
                    // über bw.write(pw) gespeichert

                store.createNewFile();
                FileWriter fw = new FileWriter(store);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(pw);
                bw.close();
                System.out.println("Good job you created an account. Please start again and log in if you want to know my secret");
            }
        }


        public static String login(String user, String pw) throws IOException
        {
            File store = new File("C:\\Users\\dc201\\Desktop\\IntelliJ\\Leistungsbeurteilung zu Ue 8\\Textdatei" + user + ".txt");
            //Es wird wieder im selben Pfad nach der Datei gesucht

            if (!store.exists()) return "Sorry you dont have an account yet. Please start again and create an account.";
            //Wenn beim login die Datei mit seinem Benutzernamen fehlt wird der return ausgegeben

            FileReader fr = new FileReader(store);
            BufferedReader br = new BufferedReader(fr);
            String pwc = br.readLine();
            br.close();

            if ((pwc.equals(pw)))
                //Hier wird mit equals überprüft ob das zuvor in die Datei gespeicherte pw dem pw der Eingabe entspricht

                return "My secret is: Excercise 1 fu**cked me hard!";
            //Wenn das pw richtig ist dann soll mein Geheimnis ausgegeben werden

            else return "Wrong password please try again";
            //Wenn das pw nicht dem gespeicherten Wert entspricht wird else return ausgegeben

        }
    }

