package app;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Gemeinsamer Logger für alle Komponenten. Schreib die Ausgabe des Logs in das Logfile log.txt.
 */
public enum Log {
    ;
    private static Logger _logger;
    private static FileHandler _fileHandler;

    private static void createLogger() {
        try {
            _fileHandler = new FileHandler("log.txt", true);
            _logger = Logger.getLogger("Log");
            _logger.addHandler(_fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            _fileHandler.setFormatter(formatter);
        } catch (SecurityException | IOException e) {
            System.err.println("Fehler beim Erstellen der Logdatei...");
            e.printStackTrace();
        }
    }
    public static Logger getLogger() {
        if (_logger == null) createLogger();
        return _logger;
    }
}
