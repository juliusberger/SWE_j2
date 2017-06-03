package app.models.implementation;

import javafx.beans.property.SimpleStringProperty;
import app.models.implementation.Analysis.FutureAnalysis;
import app.models.implementation.Analysis.StateAnalysis;
import app.models.implementation.CostEstimation.CostEstimation;
import app.models.implementation.Glossary.Glossary;
import app.models.implementation.ProjectData.ProjectData;
import app.models.implementation.Requirements.Requirements;
import app.models.interfaces.Analysis.I_Analysis;
import app.models.interfaces.CostEstimation.I_CostEstimation;
import app.models.interfaces.Glossary.I_Glossary;
import app.models.interfaces.I_Project;
import app.models.interfaces.ProjectData.I_ProjectData;
import app.models.interfaces.Requirements.I_Requirements;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.util.ArrayList;

/**
 *
 */
public class Project implements I_Project {
    private static I_Project _instance;

    public static I_Project getInstance() {
        if (Project._instance == null)
            Project._instance = new Project();
        return Project._instance;
    }



    private SimpleStringProperty _name = new SimpleStringProperty("");
    private SimpleStringProperty _fileLocation = new SimpleStringProperty("");

    private I_ProjectData _projectData = new ProjectData();
    private I_Analysis _stateAnalysis = new StateAnalysis();
    private I_Analysis _futureAnalysis = new FutureAnalysis();
    private I_Requirements _requirements = new Requirements();
    private I_CostEstimation _costEstimation = new CostEstimation();
    private I_Glossary _glossary = new Glossary();


    private Project() {
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
    public String getFileLocation() {
        return this._fileLocation.get();
    }

    @Override
    public SimpleStringProperty fileLocationProperty() {
        return this._fileLocation;
    }

    @Override
    public void setFileLocation(String fileLocation) {
        this._fileLocation.set(fileLocation);
    }

    @Override
    public I_ProjectData getProjectData() {
        return this._projectData;
    }

    @Override
    public I_Analysis getStateAnalysis() {
        return this._stateAnalysis;
    }

    @Override
    public I_Analysis getFutureAnalysis() {
        return this._futureAnalysis;
    }

    @Override
    public I_Requirements getRequirements() {
        return this._requirements;
    }

    @Override
    public I_CostEstimation getCostEstimation() {
        return this._costEstimation;
    }

    @Override
    public I_Glossary getGlossary() {
        return this._glossary;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        this.setName(propertyStrings.get(0));
        this.setFileLocation(propertyStrings.get(1));
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(this.getName());
        stringProperties.add(this.getFileLocation());

        return stringProperties;
    }


    @Override
    public void exportAsXML(XMLStreamWriter xmlWriter) throws XMLStreamException {
        xmlWriter.writeStartElement( "ProjectProperties" );
        xmlWriter.writeAttribute( "name", this.getName());
        xmlWriter.writeAttribute("fileLocation",
                this.getFileLocation());
        xmlWriter.writeEndElement();
    }

    @Override
    public void importFromXML(XMLStreamReader xmlReader) throws XMLStreamException {
        this.setName(xmlReader.getAttributeValue(0));
        this.setFileLocation(xmlReader.getAttributeValue(1));
    }
}
