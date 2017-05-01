package helpers;

import models.implementation.Project;
import models.interfaces.Analysis.I_Analysis;
import models.interfaces.Analysis.I_AnalysisEntry;
import models.interfaces.Glossary.I_Glossary;
import models.interfaces.Glossary.I_GlossaryEntry;
import models.interfaces.ProjectData.I_ProjectData;
import models.interfaces.ProjectData.I_ProjectEditor;
import models.interfaces.Requirements.*;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by Michi on 01.05.2017.
 */
public class XML
{
    public static void exportXML(String fileName)
    {
        XMLStreamWriter writer;

        try {
            ArrayList<ArrayList> allProperties = getAllProperties();

            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            writer = factory.createXMLStreamWriter( new FileOutputStream(fileName));

            // Der XML-Header wird erzeugt
            writer.writeStartDocument();
            // Zuerst wird das Wurzelelement mit Attribut geschrieben
            writer.writeStartElement( "Project Properties" );
            writer.writeAttribute( "name", allProperties.get(0).get(0).toString() );
            writer.writeAttribute("fileLocation", allProperties.get(0).get(1).toString());
            writer.writeEndElement();

            writer.writeEndDocument();

        } catch (Exception exp) {
            // TODO: Logfile erzeugen
            // TODO: Nutzer warnen oder Datei löschen
        }
    }

    public static void importXML()
    {

    }

    private static ArrayList<ArrayList> getAllProperties()
    {
        ArrayList<ArrayList> allProjectProperties = new ArrayList<ArrayList>();

        // Alle Properties der Klasse "Project" hinzufügen
        ArrayList<String> projectProperties = new ArrayList<String>();
        projectProperties = Project.getInstance().getAllProperties();
        allProjectProperties.add(projectProperties);

        //<editor-fold desc="Alle Properties der Klasse "ProjectData" hinzufügen">
        ArrayList<String> projectDataProperties = new ArrayList<String>();
        I_ProjectData currentProjectData = Project.getInstance().getProjectData();
        for(String projectDataProperty : currentProjectData.getAllProperties())
        {
            projectDataProperties.add(projectDataProperty);
        }

        for(String projectEditorProperty : currentProjectData.getProjectEditor().getAllProperties())
        {
            projectDataProperties.add(projectEditorProperty);
        }

        for(String projectCustomerProperty : currentProjectData.getCustomer().getAllProperties())
        {
            projectDataProperties.add(projectCustomerProperty);
        }
        allProjectProperties.add(projectDataProperties);
        //</editor-fold>


        //<editor-fold desc="Alle Properties der Klasse "StateAnalysis" hinzufügen">
        ArrayList<String> stateAnalysisProperties = new ArrayList<String>();
        I_Analysis currentStateAnalysis = Project.getInstance().getStateAnalysis();
        for(I_AnalysisEntry currentEntry : currentStateAnalysis.getEntries())
        {
            for(String stateAnalysisProperty : currentEntry.getAllProperties())
            {
                stateAnalysisProperties.add(stateAnalysisProperty);
            }
        }
        allProjectProperties.add(stateAnalysisProperties);
        //</editor-fold>

        //<editor-fold desc="Alle Properties der Klasse "FutureAnalysis" hinzufügen">
        ArrayList<String> futureAnalysisProperties = new ArrayList<String>();
        I_Analysis currentFutureAnalysis = Project.getInstance().getFutureAnalysis();
        for(I_AnalysisEntry currentEntry : currentFutureAnalysis.getEntries())
        {
            for(String futureAnalysisProperty : currentEntry.getAllProperties())
            {
                futureAnalysisProperties.add(futureAnalysisProperty);
            }
        }
        allProjectProperties.add(futureAnalysisProperties);
        //</editor-fold>

        //<editor-fold desc="Alle Properties der Klasse "Requirements" hinzufügen">
        ArrayList<ArrayList> requirementsProperties = new ArrayList<ArrayList>();

        ArrayList<String> requirementProperties = new ArrayList<String>();
        I_Requirements currentRequirements = Project.getInstance().getRequirements();
        for(String requirementsProperty : currentRequirements.getAllProperties())
        {
            requirementProperties.add(requirementsProperty);
        }
        requirementsProperties.add(requirementProperties);

        ArrayList<String> functionalRequirements = new ArrayList<String>();
        for(I_FunctionalRequirementEntry currentEntry : currentRequirements.getFunctionalRequirements().getEntries())
        {
            for(String functionalRequirementProperty : currentEntry.getAllProperties())
            {
                functionalRequirements.add(functionalRequirementProperty);
            }
        }
        requirementsProperties.add(functionalRequirements);

        ArrayList<String> nonFunctionalRequirements = new ArrayList<String>();
        for(I_NonFunctionalRequirementEntry currentEntry : currentRequirements.getNonFunctionalRequirements().getEntries())
        {
            for(String nonFunctionalRequirementProperty : currentEntry.getAllProperties())
            {
                nonFunctionalRequirements.add(nonFunctionalRequirementProperty);
            }
        }
        requirementsProperties.add(nonFunctionalRequirements);

        ArrayList<String> qualityRequirements = new ArrayList<String>();
        for(I_QualityRequirementEntry currentEntry : currentRequirements.getQualityRequirementEntries())
        {
            if (currentEntry.getPriority() != null) {
                qualityRequirements.add(currentEntry.getPriority().toString());
            }
            else {
                qualityRequirements.add("null");
            }

        }
        requirementsProperties.add(qualityRequirements);

        ArrayList<String> comments = new ArrayList<String>();
        for(I_CommentEntry currentComment : currentRequirements.getComments().getEntries())
        {
            for(String commentProperty : currentComment.getAllProperties())
            {
                comments.add(commentProperty);
            }
        }
        requirementsProperties.add(comments);

        allProjectProperties.add(requirementsProperties);
        //</editor-fold>

        // TODO: Interface für Aufwandsschätzung einbinden

        //<editor-fold desc="Alle Properties der Klasse "Glossary" hinzufügen"">
        ArrayList<String> glossaryProperties = new ArrayList<String>();
        I_Glossary currentGlossary = Project.getInstance().getGlossary();
        for(I_GlossaryEntry currentEntry : currentGlossary.getEntries())
        {
            for(String glossaryProperty : currentEntry.getAllProperties())
            {
                glossaryProperties.add(glossaryProperty);
            }
        }
        allProjectProperties.add(glossaryProperties);
        //</editor-fold>

        return allProjectProperties;
    }
}
