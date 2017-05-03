package helpers;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import models.implementation.Project;
import models.interfaces.Analysis.I_Analysis;
import models.interfaces.Analysis.I_AnalysisEntry;
import models.interfaces.Glossary.I_Glossary;
import models.interfaces.Glossary.I_GlossaryEntry;
import models.interfaces.I_Project;
import models.interfaces.ProjectData.I_Customer;
import models.interfaces.ProjectData.I_ProjectData;
import models.interfaces.ProjectData.I_ProjectEditor;
import models.interfaces.Requirements.*;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
            writer = new IndentingXMLStreamWriter(factory.createXMLStreamWriter( new FileOutputStream(fileName)));

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
            writer.writeStartElement("ProjectDataProperties");
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
            writer.writeStartElement("StateAnalysisProperties");
            for(int stateAnalysisEntriesIndex = 0; (stateAnalysisEntriesIndex + 1) < stateAnalysisProperties.size(); stateAnalysisEntriesIndex += 2)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("StateAnalysisEntry");
                writer.writeAttribute("entryName", stateAnalysisProperties.get(stateAnalysisEntriesIndex).toString());
                writer.writeAttribute("description", stateAnalysisProperties.get(stateAnalysisEntriesIndex + 1).toString());
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeCharacters("\n");
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "FutureAnalysis"">
            writer.writeStartElement("FutureAnalysisProperties");
            for(int futureAnalysisEntriesIndex = 0; (futureAnalysisEntriesIndex + 1) < futureAnalysisProperties.size(); futureAnalysisEntriesIndex += 2)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("FutureAnalysisEntry");
                writer.writeAttribute("entryName", futureAnalysisProperties.get(futureAnalysisEntriesIndex).toString());
                writer.writeAttribute("description", futureAnalysisProperties.get(futureAnalysisEntriesIndex + 1).toString());
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeCharacters("\n");
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "Requirements"">
            writer.writeStartElement("RequirementsProperties");
            writer.writeAttribute("projectGoal", requirementsProperties.get(0).get(0).toString());
            writer.writeAttribute("fieldOfApplication", requirementsProperties.get(0).get(1).toString());
            writer.writeCharacters("\t");

            writer.writeStartElement("FunctionalRequirements");
            for(int functionalRequirementsEntriesIndex = 0; (functionalRequirementsEntriesIndex + 2) < requirementsProperties.get(1).size(); functionalRequirementsEntriesIndex += 3)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("FunctionalRequirementsEntry");
                writer.writeAttribute("function", requirementsProperties.get(1).get(functionalRequirementsEntriesIndex).toString());
                writer.writeAttribute("descritpion", requirementsProperties.get(1).get(functionalRequirementsEntriesIndex + 1).toString());
                writer.writeAttribute("stakeholder", requirementsProperties.get(1).get(functionalRequirementsEntriesIndex + 2).toString());
                writer.writeEndElement();
            }
            writer.writeEndElement();

            writer.writeStartElement("NonFunctionalRequirements");
            for(int nonFunctionalRequirementsEntriesIndex = 0; (nonFunctionalRequirementsEntriesIndex + 1) < requirementsProperties.get(2).size(); nonFunctionalRequirementsEntriesIndex += 2)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("NonFunctionalRequirementsEntry");
                writer.writeAttribute("businessProcess", requirementsProperties.get(2).get(nonFunctionalRequirementsEntriesIndex).toString());
                writer.writeAttribute("description", requirementsProperties.get(2).get(nonFunctionalRequirementsEntriesIndex + 1).toString());
                writer.writeEndElement();
            }
            writer.writeEndElement();

            writer.writeStartElement("QualityRequirements");
            for (int qualityRequirementsEntriesIndex = 0; qualityRequirementsEntriesIndex < requirementsProperties.get(3).size(); qualityRequirementsEntriesIndex++)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("QualityRequirementsEntry");
                writer.writeAttribute("priority", requirementsProperties.get(3).get(qualityRequirementsEntriesIndex).toString());
                writer.writeEndElement();
            }
            writer.writeEndElement();

            writer.writeStartElement("Comments");
            for (int commentsEntriesIndex = 0; (commentsEntriesIndex + 1) < requirementsProperties.get(4).size(); commentsEntriesIndex += 2)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("CommentEntry");
                writer.writeAttribute("keyword", requirementsProperties.get(4).get(commentsEntriesIndex).toString());
                writer.writeAttribute("description", requirementsProperties.get(4).get(commentsEntriesIndex + 1).toString());
                writer.writeEndElement();
            }
            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeCharacters("\n");
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "Glossary"">
            writer.writeStartElement("GlossaryProperties");
            for(int glossaryEntriesIndex = 0; (glossaryEntriesIndex + 1) < glossaryProperties.size(); glossaryEntriesIndex += 2)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("GlossaryEntry");
                writer.writeAttribute("item", glossaryProperties.get(glossaryEntriesIndex).toString());
                writer.writeAttribute("definition", glossaryProperties.get(glossaryEntriesIndex + 1).toString());
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeCharacters("\n");
            //</editor-fold>


            // XML-Datei wird abgeschlossen
            writer.writeEndDocument();

            System.out.println("XML-Datei erfolgreich erstellt");

        } catch (Exception exp) {
            // TODO: Logfile erzeugen
            // TODO: Nutzer warnen oder Datei löschen
        }
    }


    public static void importXML(String fileName)
    {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try
        {
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
            I_Project project = Project.getInstance();
            I_ProjectData projectData = project.getProjectData();
            I_ProjectEditor projectEditor = projectData.getProjectEditor();
            I_Customer customer = projectData.getCustomer();
            I_Analysis stateAnalysis = project.getStateAnalysis();
            I_Analysis futureAnalysis = project.getFutureAnalysis();
            I_Requirements requirements = project.getRequirements();
            I_FunctionalRequirements functionalRequirements = requirements.getFunctionalRequirements();
            I_NonFunctionalRequirements nonFunctionalRequirements = requirements.getNonFunctionalRequirements();
            I_Comments comments = requirements.getComments();
            List<I_QualityRequirementEntry> qualityRequirements = requirements.getQualityRequirementEntries();

            // Da die QualityRequirements eine vorgegebene Liste sind, wird über diesen Counter der akutell zu verändernde QualityRequirementEntry angesprochen
            int qualityRequirmentsCounter = 0;

            int event = xmlStreamReader.getEventType();
            while(true){
                switch(event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if(xmlStreamReader.getLocalName().equals("ProjectProperties")){
                            project.setName(xmlStreamReader.getAttributeValue(0));
                            project.setFileLocation(xmlStreamReader.getAttributeValue(1));
                        }
                        else if (xmlStreamReader.getLocalName().equals("ProjectDataProperties")){
                            projectData.setName(xmlStreamReader.getAttributeValue(0));
                            projectData.setDueDate(xmlStreamReader.getAttributeValue(1));
                            projectEditor.setSurname(xmlStreamReader.getAttributeValue(2));
                            projectEditor.setName(xmlStreamReader.getAttributeValue(3));
                            customer.setSurname(xmlStreamReader.getAttributeValue(4));
                            customer.setName(xmlStreamReader.getAttributeValue(5));
                            customer.setTelephone(xmlStreamReader.getAttributeValue(6));
                            customer.setEmail(xmlStreamReader.getAttributeValue(7));
                            customer.setCompanyName(xmlStreamReader.getAttributeValue(8));
                            customer.setCompanyStreet(xmlStreamReader.getAttributeValue(9));
                            customer.setCompanyPLZ(xmlStreamReader.getAttributeValue(10));
                            customer.setCompanyLocation(xmlStreamReader.getAttributeValue(11));
                        }
                        else if (xmlStreamReader.getLocalName().equals("StateAnalysisEntry")){
                            ArrayList<String> stateAnalysisEntryArguments = new ArrayList<String>();
                            stateAnalysisEntryArguments.add(xmlStreamReader.getAttributeValue(0));
                            stateAnalysisEntryArguments.add(xmlStreamReader.getAttributeValue(1));
                            stateAnalysis.addEntryWithProperties(stateAnalysisEntryArguments);
                        }
                        else if (xmlStreamReader.getLocalName().equals("FutureAnalysisEntry")){
                            ArrayList<String> futureAnalysisEntryArguments = new ArrayList<String>();
                            futureAnalysisEntryArguments.add(xmlStreamReader.getAttributeValue(0));
                            futureAnalysis.addEntryWithProperties(futureAnalysisEntryArguments);
                        }
                        else if (xmlStreamReader.getLocalName().equals("RequirementsProperties")) {
                            requirements.setProjectGoal(xmlStreamReader.getAttributeValue(0));
                            requirements.setFieldOfApplication(xmlStreamReader.getAttributeValue(1));
                        }
                        else if (xmlStreamReader.getLocalName().equals("FunctionalRequirementsEntry")){
                            ArrayList<String> functionalRequirementsEntryArguments = new ArrayList<String>();
                            functionalRequirementsEntryArguments.add(xmlStreamReader.getAttributeValue(0));
                            functionalRequirementsEntryArguments.add(xmlStreamReader.getAttributeValue(1));
                            functionalRequirementsEntryArguments.add(xmlStreamReader.getAttributeValue(2));
                            functionalRequirements.addEntryWithProperties(functionalRequirementsEntryArguments);
                        }
                        else if (xmlStreamReader.getLocalName().equals("NonFunctionalRequirementsEntry")){
                            ArrayList<String> nonFunctionalRequirementsEntryArguments = new ArrayList<String>();
                            nonFunctionalRequirementsEntryArguments.add(xmlStreamReader.getAttributeValue(0));
                            nonFunctionalRequirementsEntryArguments.add(xmlStreamReader.getAttributeValue(1));
                            functionalRequirements.addEntryWithProperties(nonFunctionalRequirementsEntryArguments);
                        }
                        else if (xmlStreamReader.getLocalName().equals("QualityRequirementsEntry")){
                            int qualityRequirementsEntryPriority = Integer.parseInt(xmlStreamReader.getAttributeValue(0));
                            qualityRequirements.get(qualityRequirmentsCounter).setPriority(qualityRequirementsEntryPriority);
                            qualityRequirmentsCounter++;
                        }
                        else if (xmlStreamReader.getLocalName().equals("CommentEntry")){
                            ArrayList<String> commentEntryArguments = new ArrayList<String>();
                            commentEntryArguments.add(xmlStreamReader.getAttributeValue(0));
                            commentEntryArguments.add(xmlStreamReader.getAttributeValue(1));
                            comments.addEntryWithProperties(commentEntryArguments);
                        }


                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if(xmlStreamReader.getLocalName().equals("Player")){
                            players.add(plr);
                        }
                        break;
                }
                if (!xmlStreamReader.hasNext())
                    break;

                event = xmlStreamReader.next();
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return players;
    }


    private static ArrayList<String> getProjectProperties()
    {
        // Alle Properties der Klasse "Project" hinzufügen
        ArrayList<String> currentProjectProperties = new ArrayList<String>();
        currentProjectProperties = Project.getInstance().getAllProperties();
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
