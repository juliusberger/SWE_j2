package app.helpers;

import app.model.implementation.Project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Erstellt von Michi am 05.05.2017.
 */

/**
 * Logmeldungen, die aufgrund eines IO-Fehlers nicht direkt in der Datei gespeichert werden können, gehen verloren.
 */

public final class LogWriter
{
    private static String fileName = "";
    private static BufferedWriter fileWriter = null;
    private static boolean canWrite = false;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd - HH:mm:ss");

    // Klasse soll nicht-instanziierbar sein
    private LogWriter(){
    }

    public static void writeLog(String toWrite){
        if (canWrite && fileWriter != null)
        {
            try{
                File logFile = new File(fileName);

                //Exception wird geworfen, falls Datei nicht zugreifbar oder freier Festplattenplatz < 1MB
                if (!logFile.canRead() || !logFile.canWrite() || logFile.getFreeSpace() < 1048576)
                {
                    throw new Exception();
                }
                else {
                    //Datum und Uhrzeit eigentlichem Ereignis voranstellen
                    fileWriter.write(dateFormat.format(new Date()));
                    fileWriter.write(": ");
                    fileWriter.write(toWrite);
                    fileWriter.newLine();
                }
            }
            catch (Exception ex){
                //tritt auf, wenn Datei nicht erstellt oder geöffnet werden kann
                InfoDialog errorDialog = new InfoDialog("Fehler beim Zugriff auf Logdatei", "Auf die Logdatei konnte nicht erfolgreich zugegriffen werden. Sie können ANTool trotzdem weiterbenutzen.");
            }
        }
        else{
            InfoDialog errorDialog = new InfoDialog("Fehler beim Zugriff auf Logdatei", "Auf die Logdatei konnte nicht erfolgreich zugegriffen werden. Sie können ANTool trotzdem weiterbenutzen.");
        }
    }

    private static boolean createLogFile(){
        try{
            File logFile = new File(fileName);

            if (!logFile.exists()) {
                logFile.createNewFile();

                //Exception wird geworfen, falls Datei nicht zugreifbar oder freier Festplattenplatz < 1MB
                if (!logFile.canRead() || !logFile.canWrite() || logFile.getFreeSpace() < 1048576) {
                    throw new Exception();
                }
                else {
                    fileWriter = new BufferedWriter(new FileWriter(fileName));
                    fileWriter.write("Logfile für Projekt \"" + Project.getInstance() + "\":");
                    fileWriter.newLine();
                    return true;
                }
            }
            else {
                fileWriter = new BufferedWriter(new FileWriter(fileName, true));
                return true;
            }
        }
        catch (Exception ex) {
            //tritt auf, wenn Datei nicht erstellt oder geöffnet werden kann
            InfoDialog errorDialog = new InfoDialog("Fehler beim Zugriff auf Logdatei", "Auf die Logdatei konnte nicht erfolgreich zugegriffen werden. Sie können ANTool trotzdem weiterbenutzen.");
            return false;
        }

    }

    public static boolean closeFileWriter()
    {
        try{
            fileWriter.close();
            return true;
        }
        catch (Exception ex) {
            //tritt auf, wenn Datei nicht geschlossen werden kann
            InfoDialog errorDialog = new InfoDialog("Fehler beim Schließen auf Logdatei", "Die Logdatei konnte nicht erfolgreich geeschlossen werden. Möglicherweise wurden nicht alle Daten erfolgreich gespeichert.");
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
