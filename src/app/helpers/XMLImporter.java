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
public class XmlImporter {
    private final String PROPERTIES_TAG = "Properties";
    private final String PROPERTY_TAG = "Property";
    private final String CHILDREN_TAG = "Children";

    private String _fileName = "";
    private XMLStreamReader _reader;

    public XmlImporter(String fileName) {
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

    private String getName() {
        return _reader.getName().toString();
    }

    private boolean isStartElem() {
        return _reader.getEventType() == XMLStreamConstants.START_ELEMENT;
    }

    private boolean isEndElem() {
        return _reader.getEventType() == XMLStreamConstants.END_ELEMENT;
    }

    private ArrayList<String> processProperties() throws XMLStreamException {
        ArrayList<String> properties = new ArrayList<>();
        _reader.nextTag();
        while (getName().equals(PROPERTY_TAG)) {
            if (_reader.getEventType() != XMLStreamConstants.END_ELEMENT && _reader.getAttributeCount() > 0 && _reader
                    .getAttributeName(0)
                    .toString()
                    .equals("data")) {
                properties.add(_reader.getAttributeValue(0));
            }
            _reader.nextTag();
        }
        return properties;
    }

    private void readXmlRecursively(I_XmlModelEntity model) throws XMLStreamException {
        if (_reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
            String rootName = getName();

            _reader.nextTag();

            while (!(getName().equals(rootName) && isEndElem())) {
                String name = getName();
                switch (name) {
                    case CHILDREN_TAG:
                        if (model != null && model.getChildren() != null) {
                            if (model.getChildren().size() > 0) {
                                for (I_XmlModelEntity entity : model.getChildren()) {
                                    _reader.nextTag();
                                    if (isStartElem()) {
                                        readXmlRecursively(entity);
                                    }
                                }
                                _reader.nextTag();
                            } else {
                                while (!(getName().equals(name) && isEndElem())) {
                                    _reader.nextTag();
                                    if (isStartElem() && getName().equals(PROPERTIES_TAG)) {
                                        model.addEntryWithProperties(processProperties());
                                    }
                                }
                            }
                        }
                        break;
                    case PROPERTIES_TAG:
                        if (model != null) {
                            model.setAllProperties(processProperties());
                        }
                        break;
                    default:
                        _reader.nextTag();
                        readXmlRecursively(model);
                        _reader.nextTag();
                        break;
                }

                _reader.nextTag();
            }
        }
    }


    public void importXml() {
        try {
            I_Project project = Project.getInstance();

            _reader.nextTag();
            readXmlRecursively(project);

            Log.getLogger().info("XML-Import wurde erfolgreich eingelesen. Pfad zur Datei: " + _fileName);
            InfoDialog.show("XML-Import erfolgreich",
                    "XML-Import erfolgreich abgeschlossen");
        } catch (XMLStreamException ex) {
            Log.getLogger()
                    .info("XML-Import nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + ex.getMessage());
            InfoDialog.show("XML-Import nicht erfolgreich",
                    "XML-Import nicht erfolgreich abgeschlossen. Folgender Fehler trat auf:\n" + ex.getMessage());
        }
    }
}
