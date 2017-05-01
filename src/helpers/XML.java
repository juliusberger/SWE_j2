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
import java.util.List;

/**
 * Created by Michi on 01.05.2017.
 */
public class XML
{
    public static void exportXML(String fileName)
    {
        XMLStreamWriter writer;

        try {
            ArrayList<String> projectProperties = getProjectProperties();
            ArrayList<String> projectDataProperties = getProjectDataProperties();
            ArrayList<String> stateAnalysisProperties = getStateAnalysisProperties();
            ArrayList<String> futureAnalysisProperties = getFutureAnalysisProperties();
            ArrayList<ArrayList<String>> requirementsProperties = getRequirementsProperties();
            ArrayList<String> glossaryProperties = getGlossaryProperties();

            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            writer = factory.createXMLStreamWriter( new FileOutputStream(fileName));

            // Der XML-Header wird erzeugt
            writer.writeStartDocument();
            writer.writeCharacters("\n");

            //<editor-fold desc="Exportiert die Properties der Klasse "Project"">
            writer.writeStartElement( "Project_Properties" );
            writer.writeAttribute( "name", projectProperties.get(0).toString() );
            writer.writeAttribute("fileLocation", projectProperties.get(1).toString());
            writer.writeEndElement();
            writer.writeCharacters("\n");
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "ProjectData"">
            writer.writeStartElement("Project_Data_Properties");
            writer.writeAttribute( "projectDataName", projectDataProperties.get(0).toString() );
            writer.writeAttribute( "projectDataDueDate", projectDataProperties.get(1).toString() );
            writer.writeAttribute( "projectEditorSurname", projectDataProperties.get(2).toString() );
            writer.writeAttribute( "projectEditorName", projectDataProperties.get(3).toString() );
            writer.writeAttribute( "customerSurname", projectDataProperties.get(4).toString() );
            writer.writeAttribute( "customerName", projectDataProperties.get(5).toString() );
            writer.writeAttribute( "customerTelephone", projectDataProperties.get(6).toString() );
            writer.writeAttribute( "customerEmail", projectDataProperties.get(7).toString() );
            writer.writeAttribute( "customerCompanyName", projectDataProperties.get(8).toString() );
            writer.writeAttribute( "customerCompanyStreet", projectDataProperties.get(9).toString() );
            writer.writeAttribute( "customerCompanyPLZ", projectDataProperties.get(10).toString() );
            writer.writeAttribute( "customerCompanyLocation", projectDataProperties.get(11).toString() );
            writer.writeEndElement();
            writer.writeCharacters("\n");
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "StateAnalysis"">
            writer.writeStartElement("State_Analysis_Properties");
            writer.writeAttribute("numberOfStateAnalysisEntries", String.valueOf(stateAnalysisProperties.size()));
            for(int stateAnalysisEntriesIndex = 0; stateAnalysisEntriesIndex < stateAnalysisProperties.size(); stateAnalysisEntriesIndex++)
            {
                writer.writeAttribute("entryName", stateAnalysisProperties.get(stateAnalysisEntriesIndex).toString());
                writer.writeAttribute("description", stateAnalysisProperties.get(stateAnalysisEntriesIndex + 1).toString());
            }
            writer.writeEndElement();
            writer.writeCharacters("\n");
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "FutureAnalysis"">
            writer.writeStartElement("Future_Analysis_Properties");
            writer.writeAttribute("numberOfFutureAnalysisEntries", String.valueOf(futureAnalysisProperties.size()));
            for(int futureAnalysisEntriesIndex = 0; futureAnalysisEntriesIndex < futureAnalysisProperties.size(); futureAnalysisEntriesIndex++)
            {
                writer.writeAttribute("entryName", futureAnalysisProperties.get(futureAnalysisEntriesIndex).toString());
                writer.writeAttribute("description", futureAnalysisProperties.get(futureAnalysisEntriesIndex + 1).toString());
            }
            writer.writeEndElement();
            writer.writeCharacters("\n");
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "Requirements"">
            writer.writeStartElement("Requirements_Properties");
            writer.writeAttribute("projectGoal", requirementsProperties.get(0).get(0).toString());
            writer.writeAttribute("fieldOfApplication", requirementsProperties.get(0).get(1).toString());

            writer.writeAttribute("numberOfFunctionalRequirementsEntries", String.valueOf(requirementsProperties.get(1).size()));
            for(int functionalRequirementsEntriesIndex = 0; functionalRequirementsEntriesIndex < requirementsProperties.get(1).size(); functionalRequirementsEntriesIndex++)
            {
                writer.writeAttribute("function", requirementsProperties.get(1).get(functionalRequirementsEntriesIndex).toString());
                writer.writeAttribute("descritpion", requirementsProperties.get(1).get(functionalRequirementsEntriesIndex + 1).toString());
                writer.writeAttribute("stakeholder", requirementsProperties.get(1).get(functionalRequirementsEntriesIndex + 2).toString());
            }

            writer.writeAttribute("numberOfNonFunctionalRequirementsEntries", String.valueOf(requirementsProperties.get(2).size()));
            for(int nonFunctionalRequirementsEntriesIndex = 0; nonFunctionalRequirementsEntriesIndex < requirementsProperties.get(2).size(); nonFunctionalRequirementsEntriesIndex++)
            {
                writer.writeAttribute("businessProcess", requirementsProperties.get(2).get(nonFunctionalRequirementsEntriesIndex).toString());
                writer.writeAttribute("description", requirementsProperties.get(2).get(nonFunctionalRequirementsEntriesIndex + 1).toString());
            }

            writer.writeAttribute("numberOfQualityRequirementsEntries", String.valueOf(requirementsProperties.get(3).size()));
            for (int qualityRequirementsEntriesIndex = 0; qualityRequirementsEntriesIndex < requirementsProperties.get(3).size(); qualityRequirementsEntriesIndex++)
            {
                writer.writeAttribute("priority", requirementsProperties.get(3).get(qualityRequirementsEntriesIndex).toString());
            }

            writer.writeAttribute("numberOfCommentsEntries", String.valueOf(requirementsProperties.get(4).size()));
            for (int commentsEntriesIndex = 0; commentsEntriesIndex < requirementsProperties.get(4).size(); commentsEntriesIndex++)
            {
                writer.writeAttribute("keyword", requirementsProperties.get(4).get(commentsEntriesIndex).toString());
                writer.writeAttribute("description", requirementsProperties.get(4).get(commentsEntriesIndex + 1).toString());
            }

            writer.writeEndElement();
            writer.writeCharacters("\n");
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "Glossary"">
            writer.writeStartElement("Glossary_Properties");
            writer.writeAttribute("numberOfGlossaryEntries", String.valueOf(glossaryProperties.size()));
            for(int glossaryEntriesIndex = 0; glossaryEntriesIndex < glossaryProperties.size(); glossaryEntriesIndex++)
            {
                writer.writeAttribute("item", glossaryProperties.get(glossaryEntriesIndex).toString());
                writer.writeAttribute("definition", glossaryProperties.get(glossaryEntriesIndex + 1).toString());
            }
            writer.writeEndElement();
            writer.writeCharacters("\n");
            //</editor-fold>


            // Die XML-Datei wird abgeschlossen
            writer.writeEndDocument();

        } catch (Exception exp) {
            // TODO: Logfile erzeugen
            // TODO: Nutzer warnen oder Datei löschen
        }
    }

    public static void importXML()
    {

    }

    private static ArrayList<String> getProjectProperties()
    {
        // Alle Properties der Klasse "Project" hinzufügen
        ArrayList<String> currentProjectProperties = new ArrayList<String>();
        currentProjectProperties = Project.getInstance().getAllProperties();
        for (String projectProperty : currentProjectProperties)
        {
            currentProjectProperties.add(projectProperty);
        }

        return currentProjectProperties;
    }

    private static ArrayList<String> getProjectDataProperties()
    {
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
        return projectDataProperties;
        //</editor-fold>
    }

    private static ArrayList<String> getStateAnalysisProperties()
    {
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
        return stateAnalysisProperties;
        //</editor-fold>
    }

    private static ArrayList<String> getFutureAnalysisProperties()
    {
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
        return futureAnalysisProperties;
        //</editor-fold>
    }

    private static ArrayList<ArrayList<String>> getRequirementsProperties()
    {
        //<editor-fold desc="Alle Properties der Klasse "Requirements" hinzufügen">
        ArrayList<ArrayList<String>> requirementsProperties = new ArrayList<ArrayList<String>>();

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

        return requirementsProperties;
        //</editor-fold>
    }

    // TODO: Interface für Aufwandsschätzung einbinden

    private static ArrayList<String> getGlossaryProperties()
    {
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
        return glossaryProperties;
        //</editor-fold>
    }
}
