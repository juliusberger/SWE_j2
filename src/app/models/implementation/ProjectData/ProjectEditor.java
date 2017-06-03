package app.models.implementation.ProjectData;

import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.ProjectData.I_ProjectEditor;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.util.ArrayList;

/**
 * Erstellt von Julius am 23/04/2017.
 */
class ProjectEditor implements I_ProjectEditor {
    private final SimpleStringProperty _surname = new SimpleStringProperty("");
    private final SimpleStringProperty _name = new SimpleStringProperty("");

    ProjectEditor() {

    }

    @Override
    public String getSurname() {
        return this._surname.get();
    }

    @Override
    public SimpleStringProperty surnameProperty() {
        return this._surname;
    }

    @Override
    public void setSurname(String surname) {
        this._surname.set(surname);
    }

    @Override
    public String getName() {
        return this._name.get();
    }

    @Override
    public SimpleStringProperty nameProperty() {
        return this._name;
    }

    @Override
    public void setName(String name) {
        this._name.set(name);
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            this.setSurname(propertyStrings.get(0));
            this.setName(propertyStrings.get(1));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(this.getSurname());
        stringProperties.add(this.getName());

        return stringProperties;
    }

    @Override
    public void exportAsXML(XMLStreamWriter xmlWriter) throws XMLStreamException {
        xmlWriter.writeStartElement("ProjectEditor");
        xmlWriter.writeAttribute( "projectEditorSurname",
                this.getSurname());
        xmlWriter.writeAttribute( "projectEditorName",
                this.getName());
        xmlWriter.writeEndElement();
    }

    @Override
    public void importFromXML(XMLStreamReader xmlReader) throws XMLStreamException {
        this.setSurname(xmlReader.getAttributeValue(0));
        this.setName(xmlReader.getAttributeValue(1));
    }
}
