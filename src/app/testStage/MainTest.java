package app.testStage;

import app.helpers.LogWriter;

/**
 * Created by Michi on 03.06.2017.
 */
public class MainTest {
    public static void main(String args[])
    {
        LogWriter.setFileName("D:\\Testfile.log");
        LogWriter.writeLog("Test1");
        LogWriter.writeLog("Test2");
        LogWriter.closeFileWriter();
    }
}
