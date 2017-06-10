package app.models.implementation.Requirements;

import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.Requirements.*;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Requirements implements I_Requirements {
    private final SimpleStringProperty _projectGoal = new SimpleStringProperty("");
    private final SimpleStringProperty _fieldOfApplication = new SimpleStringProperty("");

    private final I_FunctionalRequirements _functionalRequirements = new FunctionalRequirements();
    private final I_NonFunctionalRequirements _nonFunctionalRequirements = new NonFunctionalRequirements();

    private final List<I_QualityRequirementEntry> _qualityRequirementEntries = new ArrayList<>(5);

    private final I_Comments _comments = new Comments();

    public Requirements() {
        for (int i = 0; i < 5; i++) {
            this._qualityRequirementEntries.add(new QualityRequirementEntry());
        }
    }

    @Override
    public String getProjectGoal() {
        return this._projectGoal.get();
    }

    @Override
    public SimpleStringProperty projectGoalProperty() {
        return this._projectGoal;
    }

    @Override
    public void setProjectGoal(String projectGoal) {
        this._projectGoal.set(projectGoal);
    }

    @Override
    public String getFieldOfApplication() {
        return this._fieldOfApplication.get();
    }

    @Override
    public SimpleStringProperty fieldOfApplicationProperty() {
        return this._fieldOfApplication;
    }

    @Override
    public void setFieldOfApplication(String fieldOfApplication) {
        this._fieldOfApplication.set(fieldOfApplication);
    }

    @Override
    public I_FunctionalRequirements getFunctionalRequirements() {
        return this._functionalRequirements;
    }

    @Override
    public I_NonFunctionalRequirements getNonFunctionalRequirements() {
        return this._nonFunctionalRequirements;
    }

    @Override
    public List<I_QualityRequirementEntry> getQualityRequirementEntries() {
        return this._qualityRequirementEntries;
    }

    @Override
    public I_Comments getComments() {
        return this._comments;
    }


    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        this.setProjectGoal(propertyStrings.get(0));
        this.setFieldOfApplication(propertyStrings.get(1));
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(this.getProjectGoal());
        stringProperties.add(this.getFieldOfApplication());

        return stringProperties;
    }

    @Override
    public void exportAsXML(XMLStreamWriter xmlWriter) throws XMLStreamException {
        xmlWriter.writeStartElement("RequirementsProperties");
        xmlWriter.writeAttribute("projectGoal",
                this.getProjectGoal());
        xmlWriter.writeAttribute("fieldOfApplication",
                this.getFieldOfApplication());
        xmlWriter.writeCharacters("\t");

        this._functionalRequirements.exportAsXML(xmlWriter);
        this._nonFunctionalRequirements.exportAsXML(xmlWriter);
        this._comments.exportAsXML(xmlWriter);

        xmlWriter.writeStartElement("QualityRequirements");
        for (I_QualityRequirementEntry currentEntry : this.getQualityRequirementEntries())
        {
            xmlWriter.writeCharacters("\t");
            xmlWriter.writeStartElement("QualityRequirementsEntry");
            if (currentEntry.getPriority() != null){
                xmlWriter.writeAttribute("priority", Integer.toString(currentEntry.getPriority().ordinal()));
            }
            else {
                xmlWriter.writeAttribute("priority", "");
            }
            xmlWriter.writeEndElement();
        }
        xmlWriter.writeEndElement();

        xmlWriter.writeEndElement();
    }

    @Override
    public void importFromXML(XMLStreamReader xmlReader) throws XMLStreamException {
        this.setProjectGoal(xmlReader.getAttributeValue(0));
        this.setFieldOfApplication(xmlReader.getAttributeValue(1));
    }

    @Override
    public void removeExistingData() {
        this.setProjectGoal("");
        this.setFieldOfApplication("");
    }
}
