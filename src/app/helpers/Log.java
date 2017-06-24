package app.helpers;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by Julius on 24.06.17.
 */
public class Log {
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
            System.out.println("Fehler beim Erstellen der Logdatei...");
            e.printStackTrace();
        }
    }
    public static Logger getLogger() {
        if (_logger == null) createLogger();
        return _logger;
    }
}
