package app.helpers;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Erstellt von Michi am 05.05.2017.
 */
public final class LogWriter
{
    private static String fileName = "";
    private static BufferedWriter fileWriter = null;
    private static boolean canWrite = false;

    // Klasse soll nicht-instanziierbar sein
    private LogWriter(){
    }

    public static void writeLog(String toWrite){
        if (canWrite && fileWriter != null)
        {
            try{
                fileWriter.write(toWrite);
                fileWriter.newLine();
            }
            catch (Exception ex){
                //TODO MessageBox an User
            }
        }
    }

    private static boolean createLogFile(){
        try{
            fileWriter = new BufferedWriter(new FileWriter(fileName));
            //TODO Startinformation in Datei schreiben (z.B. Logfile für Projekt "Test":)
            return true;
        }
        catch (Exception ex) {
            //TODO MessageBox als Info für User einfügen
            System.out.println("Fehler beim Erstellen des Logfiles:\n" + ex.toString());
            return false;
        }

    }

    public static String getFileName(){
        return fileName;
    }

    public static void setFileName(String fileName){
        LogWriter.fileName = fileName;
        canWrite = createLogFile();
    }

}
