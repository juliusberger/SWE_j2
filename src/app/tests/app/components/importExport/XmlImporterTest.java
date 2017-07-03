package app.components.importExport;

import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für {@link XmlImporter}
 */
class XmlImporterTest {

    /**
     * Testmethode für {@link XmlImporter#importXml()}
     * Erwartetes Ergebnis: Nicht erfolgreicher Import, da XML ungültig.
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testImportXML0() throws Exception {
        I_XmlImporter xmlImporter = new XmlImporter();
        xmlImporter.setFileName("importTest0.xml");
        boolean successfulImport = xmlImporter.importXml();
        assertFalse(successfulImport);
    }

    /**
     * Testmethode für {@link XmlImporter#importXml()}
     * Erwartetes Ergebnis: Nicht erfolgreicher Import, da Model- nicht zu XML-Tag passt.
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testImportXML1() throws Exception {
        class RootModel implements I_XmlModelEntity {
            @Override
            public String getTag() {
                return "Root";
            }

            @Override
            public ArrayList<String> getAllProperties() {
                return null;
            }

            @Override
            public List<I_XmlModelEntity> getChildren() {
                return null;
            }

            @Override
            public void setAllProperties(ArrayList<String> propertyStrings) {

            }

            @Override
            public void addEntryWithProperties(ArrayList<String> properties) {

            }
        }
        I_XmlModelEntity model = new RootModel();

        I_XmlImporter xmlImporter = new XmlImporter();
        xmlImporter.setFileName("importTest1.xml");
        xmlImporter.setRootModel(model);

        boolean successfulImport = xmlImporter.importXml();
        assertFalse(successfulImport);
    }

    /**
     * Testmethode für {@link XmlImporter#importXml()}
     * Erwartetes Ergebnis: Erfolgreicher Import, Properties entsprechend gesetzt.
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testImportXML2() throws Exception {
        class Model implements I_XmlModelEntity {
            @Override
            public String getTag() {
                return "Child1";
            }

            @Override
            public ArrayList<String> getAllProperties() {
                return null;
            }

            @Override
            public List<I_XmlModelEntity> getChildren() {
                return null;
            }

            @Override
            public void setAllProperties(ArrayList<String> propertyStrings) {

            }

            @Override
            public void addEntryWithProperties(ArrayList<String> properties) {

            }
        }
        class RootModel implements I_XmlModelEntity {
            private final I_XmlModelEntity _child1 = new Model();

            private final SimpleStringProperty _property1 = new SimpleStringProperty("");
            private final SimpleStringProperty _property2 = new SimpleStringProperty("");

            String getProperty1() {
                return _property1.get();
            }

            public SimpleStringProperty property1Property() {
                return _property1;
            }

            void setProperty1(String property1) {
                _property1.set(property1);
            }

            String getProperty2() {
                return _property2.get();
            }

            public SimpleStringProperty property2Property() {
                return _property2;
            }

            void setProperty2(String property2) {
                _property2.set(property2);
            }

            @Override
            public String getTag() {
                return "Root";
            }

            @Override
            public ArrayList<String> getAllProperties() {
                ArrayList<String> properties = new ArrayList<>();
                properties.add(getProperty1());
                properties.add(getProperty2());
                return properties;
            }

            @Override
            public List<I_XmlModelEntity> getChildren() {
                List<I_XmlModelEntity> children = new ArrayList<>();
                children.add(_child1);
                return children;
            }

            @Override
            public void setAllProperties(ArrayList<String> propertyStrings) {
                try {
                    _property1.set(propertyStrings.get(0));
                    _property2.set(propertyStrings.get(1));
                } catch (ArrayIndexOutOfBoundsException ignored) {

                }
            }

            @Override
            public void addEntryWithProperties(ArrayList<String> properties) {

            }
        }
        RootModel rootModel = new RootModel();

        I_XmlImporter xmlImporter = new XmlImporter();
        xmlImporter.setFileName("importTest2.xml");
        xmlImporter.setRootModel(rootModel);

        boolean successfulImport = xmlImporter.importXml();
        assertTrue(successfulImport);
        assertEquals("test", rootModel.getProperty1());
        assertEquals("test2", rootModel.getProperty2());
    }

    /**
     * Testmethode für {@link XmlImporter#importXml()}
     * Erwartetes Ergebnis: Erfolgreicher Import, Einträge hinzugefügt und deren Properties richtig gesetzt.
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testImportXML3() throws Exception {
        class Entry implements I_XmlModelEntity {
            private final SimpleStringProperty _property1 = new SimpleStringProperty("");
            private final SimpleStringProperty _property2 = new SimpleStringProperty("");

            String getProperty1() {
                return _property1.get();
            }

            void setProperty1(String property1) {
                _property1.set(property1);
            }

            public SimpleStringProperty property1Property() {
                return _property1;
            }

            String getProperty2() {
                return _property2.get();
            }

            void setProperty2(String property2) {
                _property2.set(property2);
            }

            public SimpleStringProperty property2Property() {
                return _property2;
            }

            @Override
            public String getTag() {
                return "Entry";
            }

            @Override
            public ArrayList<String> getAllProperties() {
                ArrayList<String> properties = new ArrayList<>();
                properties.add(getProperty1());
                properties.add(getProperty2());
                return properties;
            }

            @Override
            public List<I_XmlModelEntity> getChildren() {
                return null;
            }

            @Override
            public void setAllProperties(ArrayList<String> propertyStrings) {
                try {
                    _property1.set(propertyStrings.get(0));
                    _property2.set(propertyStrings.get(1));
                } catch (ArrayIndexOutOfBoundsException ignored) {

                }
            }

            @Override
            public void addEntryWithProperties(ArrayList<String> properties) {

            }
        }
        class RootModel implements I_XmlModelEntity {
            private final List<I_XmlModelEntity> _entries = new ArrayList<>();

            @Override
            public String getTag() {
                return "Root";
            }

            @Override
            public ArrayList<String> getAllProperties() {
                return null;
            }

            @Override
            public List<I_XmlModelEntity> getChildren() {
                return Collections.unmodifiableList(_entries);
            }

            @Override
            public void setAllProperties(ArrayList<String> propertyStrings) {

            }

            @Override
            public void addEntryWithProperties(ArrayList<String> properties) {
                Entry entry = new Entry();
                entry.setProperty1(properties.get(0));
                entry.setProperty2(properties.get(1));
                _entries.add(entry);
            }
        }
        RootModel rootModel = new RootModel();

        I_XmlImporter xmlImporter = new XmlImporter();
        xmlImporter.setFileName("importTest3.xml");
        xmlImporter.setRootModel(rootModel);

        boolean successfulImport = xmlImporter.importXml();
        assertTrue(successfulImport);
        assertEquals("test1", rootModel.getChildren().get(0).getAllProperties().get(0));
        assertEquals("test2", rootModel.getChildren().get(0).getAllProperties().get(1));
        assertEquals("test3", rootModel.getChildren().get(1).getAllProperties().get(0));
        assertEquals("test4", rootModel.getChildren().get(1).getAllProperties().get(1));
    }

    /**
     * Testmethode für {@link XmlImporter#importXml()}
     * Erwartetes Ergebnis: Erfolgreicher Import, leeres Model.
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testImportXML4() throws Exception {
        class RootModel implements I_XmlModelEntity {
            @Override
            public String getTag() {
                return "Root";
            }

            @Override
            public ArrayList<String> getAllProperties() {
                return null;
            }

            @Override
            public void setAllProperties(ArrayList<String> propertyStrings) {

            }

            @Override
            public List<I_XmlModelEntity> getChildren() {
                return null;
            }

            @Override
            public void addEntryWithProperties(ArrayList<String> properties) {

            }
        }
        I_XmlModelEntity model = new RootModel();

        I_XmlImporter xmlImporter = new XmlImporter();
        xmlImporter.setFileName("importTest4.xml");
        xmlImporter.setRootModel(model);

        boolean successfulImport = xmlImporter.importXml();
        assertTrue(successfulImport);
    }
}