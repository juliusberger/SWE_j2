package app.helpers;


import app.model.implementation.Project;
import app.model.interfaces.I_Project;
import app.model.interfaces.I_XmlModelEntity;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Julius on 25.06.17.
 */
public class XmlImporter_new {
    private final String PROPERTIES_TAG = "Properties";
    private final String PROPERTY_TAG = "Property";
    private final String CHILDREN_TAG = "Children";

    private String _fileName = "";
    private XMLStreamReader _reader;

    public XmlImporter_new(String fileName) {
        _fileName = fileName;
        try {
            _reader = XMLInputFactory.newFactory().createXMLStreamReader(new FileInputStream(_fileName));
        } catch (XMLStreamException e) {
            Log.getLogger()
                    .info("XML-Import nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + e.getMessage());
            InfoDialog.show("XML-Import nicht erfolgreich",
                    "XML-Import nicht erfolgreich abgeschlossen. Folgender Fehler trat auf:\n" + e.getMessage());
        } catch (FileNotFoundException e) {
            Log.getLogger()
                    .info("XML-Import nicht erfolgreich abgeschlossen. Datei konnte nicht geladen werden. " + e.getMessage());
            InfoDialog.show("XML-Import nicht erfolgreich",
                    "XML-Import nicht erfolgreich abgeschlossen. Datei konnte nicht geladen werden. \n" + e.getMessage());
        }
    }


    private void readXmlRecursively(I_XmlModelEntity model) throws XMLStreamException {
        _reader.nextTag();
        if (model == null) return;
        print("For model: " + model.getTag());
        if (_reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
            while (_reader.getEventType() != XMLStreamConstants.END_ELEMENT) {

                String name = _reader.getName().toString();
                if (name.equals(CHILDREN_TAG) && model.getChildren() != null) {
                    print("IN-Children");
                    for (I_XmlModelEntity entity : model.getChildren()) {
                        print("IN-Child(" + _reader.getName().toString() + ")");
                        readXmlRecursively(entity);
                        print("OUT-Child(" + _reader.getName().toString() + ")");
                    }
                    print("OUT-Children (" + _reader.getName().toString() + ")");
                } else if (name.equals(PROPERTIES_TAG)) {
                    print("IN-Properties");
                    ArrayList<String> properties = new ArrayList<>();

                    _reader.nextTag();
                    while (_reader.getName().toString().equals(PROPERTY_TAG)) {
                        if (_reader.getEventType() != XMLStreamConstants.END_ELEMENT && _reader.getAttributeCount() > 0 && _reader
                                .getAttributeName(0)
                                .toString()
                                .equals("data")) {
                            properties.add(_reader.getAttributeValue(0));
                            print("Property: " + _reader.getAttributeValue(0));
                        }
                        _reader.nextTag();
                    }

                    model.setAllProperties(properties);
                    print("OUT-Properties (" + _reader.getName().toString() + ")");
                } else {
                    print("IN-'" + name + "'");
                    readXmlRecursively(model);
                    _reader.nextTag();
                    print("OUT-'" + _reader.getName().toString() + "'");
                }

            }
            print("End of element??: " + _reader.getName().toString());
        }

    }

    int indentionLevel = 0;

    void print(String text) {
        if (text.contains("OUT")) indentionLevel--;
        for (int i = 0; i < indentionLevel; i++) {
            System.out.print("-");
        }
        System.out.println(text);
        if (text.contains("IN")) indentionLevel++;

    }

    public void importXml() {
        try {
            I_Project project = Project.getInstance();

            _reader.nextTag();
            readXmlRecursively(project);

            /*Log.getLogger().info("XML-Import wurde erfolgreich eingelesen. Pfad zur Datei: " + _fileName);
            InfoDialog.show("XML-Import erfolgreich",
                    "XML-Import erfolgreich abgeschlossen");*/
        } catch (XMLStreamException ex) {
            Log.getLogger()
                    .info("XML-Import nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + ex.getMessage());
            InfoDialog.show("XML-Import nicht erfolgreich",
                    "XML-Import nicht erfolgreich abgeschlossen. Folgender Fehler trat auf:\n" + ex.getMessage());
        }
    }
}
