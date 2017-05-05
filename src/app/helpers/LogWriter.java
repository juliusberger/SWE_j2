package app.helpers;

/**
 * Erstellt von Michi am 05.05.2017.
 */
public final class LogWriter
{
    private static String fileName;

    // Klasse soll nicht-instanziierbar sein
    private LogWriter()
    {
    }

    public static void writeLog(String toWrite){

    }

    public static String getFileName(){
        return fileName;
    }

    public static void setFileName(String fileName){
        LogWriter.fileName = fileName;
    }

}
