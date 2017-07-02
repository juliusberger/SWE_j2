package app.helpers.importExport;

import app.model.implementation.ProjectRegistry;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für {@link XmlExporter}
 */
class XmlExporterTest {
    /**
     * Testmethode für {@link XmlExporter#exportXml()}
     * Erwartetes Ergebnis: false
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testExportXML0() throws Exception
    {
        XmlExporter xmlExporter = new XmlExporter();
        boolean result = xmlExporter.exportXml();
        assertFalse(result);
    }

    /**
     * Testmethode für {@link XmlExporter#exportXml()}
     * Erwartetes Ergebnis: false
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testExportXML1() throws Exception
    {
        XmlExporter xmlExporter = new XmlExporter();
        xmlExporter.setFileName("Test.xml");
        boolean result = xmlExporter.exportXml();
        assertFalse(result);
    }

    /**
     * Testmethode für {@link XmlExporter#exportXml()}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testExportXML2() throws Exception
    {
        XmlExporter xmlExporter = new XmlExporter();
        xmlExporter.setFileName("Test.xml");
        xmlExporter.setRootModel(ProjectRegistry.getInstance());
        boolean result = xmlExporter.exportXml();
        assertTrue(result);
    }

    /**
     * Methode löscht durch {@link XmlExporter#exportXml()} erstellte Testdatei nach Beendigung aller Tests
     *
     * @throws Exception Wird geworfen, falls Datei nicht gelöscht werden kann
     */
    @AfterAll
    public static void clean() throws Exception
    {
        File testFile = new File("Test.xml");
        if (testFile.exists())
        {
            testFile.delete();
        }
    }
}