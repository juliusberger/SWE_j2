package app.helpers;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import app.models.implementation.Project;
import app.models.interfaces.Analysis.I_Analysis;
import app.models.interfaces.Analysis.I_AnalysisEntry;
import app.models.interfaces.Glossary.I_Glossary;
import app.models.interfaces.Glossary.I_GlossaryEntry;
import app.models.interfaces.I_Project;
import app.models.interfaces.ProjectData.I_Customer;
import app.models.interfaces.ProjectData.I_ProjectData;
import app.models.interfaces.ProjectData.I_ProjectEditor;
import app.models.interfaces.Requirements.*;

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
            writer.writeStartElement("ProjectExport");

            //<editor-fold desc="Exportiert die Properties der Klasse "Project"">
            writer.writeStartElement( "ProjectProperties" );
            writer.writeAttribute( "name",
                    projectProperties.get(0));
            writer.writeAttribute("fileLocation",
                    projectProperties.get(1));
            writer.writeEndElement();
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "ProjectData"">
            writer.writeStartElement("ProjectDataProperties");
            writer.writeAttribute( "projectDataName",
                    projectDataProperties.get(0));
            writer.writeAttribute( "projectDataDueDate",
                    projectDataProperties.get(1));
            writer.writeAttribute( "projectEditorSurname",
                    projectDataProperties.get(2));
            writer.writeAttribute( "projectEditorName",
                    projectDataProperties.get(3));
            writer.writeAttribute( "customerSurname",
                    projectDataProperties.get(4));
            writer.writeAttribute( "customerName",
                    projectDataProperties.get(5));
            writer.writeAttribute( "customerTelephone",
                    projectDataProperties.get(6));
            writer.writeAttribute( "customerEmail",
                    projectDataProperties.get(7));
            writer.writeAttribute( "customerCompanyName",
                    projectDataProperties.get(8));
            writer.writeAttribute( "customerCompanyStreet",
                    projectDataProperties.get(9));
            writer.writeAttribute( "customerCompanyPLZ",
                    projectDataProperties.get(10));
            writer.writeAttribute( "customerCompanyLocation",
                    projectDataProperties.get(11));
            writer.writeEndElement();
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "StateAnalysis"">
            writer.writeStartElement("StateAnalysisProperties");
            for(int stateAnalysisEntriesIndex = 0; (stateAnalysisEntriesIndex + 1) < stateAnalysisProperties.size(); stateAnalysisEntriesIndex += 2)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("StateAnalysisEntry");
                writer.writeAttribute("entryName",
                        stateAnalysisProperties.get(stateAnalysisEntriesIndex));
                writer.writeAttribute("description",
                        stateAnalysisProperties.get(stateAnalysisEntriesIndex + 1));
                writer.writeEndElement();
            }
            writer.writeEndElement();
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "FutureAnalysis"">
            writer.writeStartElement("FutureAnalysisProperties");
            for(int futureAnalysisEntriesIndex = 0; (futureAnalysisEntriesIndex + 1) < futureAnalysisProperties.size(); futureAnalysisEntriesIndex += 2)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("FutureAnalysisEntry");
                writer.writeAttribute("entryName",
                        futureAnalysisProperties.get(futureAnalysisEntriesIndex));
                writer.writeAttribute("description",
                        futureAnalysisProperties.get(futureAnalysisEntriesIndex + 1));
                writer.writeEndElement();
            }
            writer.writeEndElement();
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "Requirements"">
            writer.writeStartElement("RequirementsProperties");
            writer.writeAttribute("projectGoal",
                    requirementsProperties.get(0).get(0));
            writer.writeAttribute("fieldOfApplication",
                    requirementsProperties.get(0).get(1));
            writer.writeCharacters("\t");

            writer.writeStartElement("FunctionalRequirements");
            for(int functionalRequirementsEntriesIndex = 0; (functionalRequirementsEntriesIndex + 2) < requirementsProperties.get(1).size(); functionalRequirementsEntriesIndex += 3)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("FunctionalRequirementsEntry");
                writer.writeAttribute("function",
                        requirementsProperties.get(1).get(functionalRequirementsEntriesIndex));
                writer.writeAttribute("descritpion",
                        requirementsProperties.get(1).get(functionalRequirementsEntriesIndex + 1));
                writer.writeAttribute("stakeholder",
                        requirementsProperties.get(1).get(functionalRequirementsEntriesIndex + 2));
                writer.writeEndElement();
            }
            writer.writeEndElement();

            writer.writeStartElement("NonFunctionalRequirements");
            for(int nonFunctionalRequirementsEntriesIndex = 0; (nonFunctionalRequirementsEntriesIndex + 1) < requirementsProperties.get(2).size(); nonFunctionalRequirementsEntriesIndex += 2)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("NonFunctionalRequirementsEntry");
                writer.writeAttribute("businessProcess",
                        requirementsProperties.get(2).get(nonFunctionalRequirementsEntriesIndex));
                writer.writeAttribute("description",
                        requirementsProperties.get(2).get(nonFunctionalRequirementsEntriesIndex + 1));
                writer.writeEndElement();
            }
            writer.writeEndElement();

            writer.writeStartElement("QualityRequirements");
            for (int qualityRequirementsEntriesIndex = 0; qualityRequirementsEntriesIndex < requirementsProperties.get(3).size(); qualityRequirementsEntriesIndex++)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("QualityRequirementsEntry");
                writer.writeAttribute("priority", requirementsProperties.get(3).get(qualityRequirementsEntriesIndex));
                writer.writeEndElement();
            }
            writer.writeEndElement();

            writer.writeStartElement("Comments");
            for (int commentsEntriesIndex = 0; (commentsEntriesIndex + 1) < requirementsProperties.get(4).size(); commentsEntriesIndex += 2)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("CommentEntry");
                writer.writeAttribute("keyword",
                        requirementsProperties.get(4).get(commentsEntriesIndex));
                writer.writeAttribute("description",
                        requirementsProperties.get(4).get(commentsEntriesIndex + 1));
                writer.writeEndElement();
            }
            writer.writeEndElement();

            writer.writeEndElement();
            //</editor-fold>

            //<editor-fold desc="Exportiert die Properties der Klasse "Glossary"">
            writer.writeStartElement("GlossaryProperties");
            for(int glossaryEntriesIndex = 0; (glossaryEntriesIndex + 1) < glossaryProperties.size(); glossaryEntriesIndex += 2)
            {
                writer.writeCharacters("\t");
                writer.writeStartElement("GlossaryEntry");
                writer.writeAttribute("item",
                        glossaryProperties.get(glossaryEntriesIndex));
                writer.writeAttribute("definition",
                        glossaryProperties.get(glossaryEntriesIndex + 1));
                writer.writeEndElement();
            }
            writer.writeEndElement();
            //</editor-fold>


            // XML-Datei wird abgeschlossen
            writer.writeEndElement();
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
            List<I_QualityRequirementEntry> qualityRequirements = requirements.getQualityRequirementEntries();
            I_Comments comments = requirements.getComments();
            I_Glossary glossary = project.getGlossary();

            removeAllExistingData();

            // Da die QualityRequirements eine vorgegebene Liste sind, wird über diesen Counter der akutell zu verändernde QualityRequirementEntry angesprochen
            int qualityRequirmentsCounter = 0;

            int event = xmlStreamReader.getEventType();
            while(xmlStreamReader.hasNext()){
                if (event == XMLStreamConstants.START_ELEMENT) {
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
                        ArrayList<String> stateAnalysisEntryArguments = new ArrayList<>();
                        stateAnalysisEntryArguments.add(xmlStreamReader.getAttributeValue(0));
                        stateAnalysisEntryArguments.add(xmlStreamReader.getAttributeValue(1));
                        stateAnalysis.addEntryWithProperties(stateAnalysisEntryArguments);
                    }
                    else if (xmlStreamReader.getLocalName().equals("FutureAnalysisEntry")){
                        ArrayList<String> futureAnalysisEntryArguments = new ArrayList<>();
                        futureAnalysisEntryArguments.add(xmlStreamReader.getAttributeValue(0));
                        futureAnalysisEntryArguments.add(xmlStreamReader.getAttributeValue(1));
                        futureAnalysis.addEntryWithProperties(futureAnalysisEntryArguments);
                    }
                    else if (xmlStreamReader.getLocalName().equals("RequirementsProperties")) {
                        requirements.setProjectGoal(xmlStreamReader.getAttributeValue(0));
                        requirements.setFieldOfApplication(xmlStreamReader.getAttributeValue(1));
                    }
                    else if (xmlStreamReader.getLocalName().equals("FunctionalRequirementsEntry")){
                        ArrayList<String> functionalRequirementsEntryArguments = new ArrayList<>();
                        functionalRequirementsEntryArguments.add(xmlStreamReader.getAttributeValue(0));
                        functionalRequirementsEntryArguments.add(xmlStreamReader.getAttributeValue(1));
                        functionalRequirementsEntryArguments.add(xmlStreamReader.getAttributeValue(2));
                        functionalRequirements.addEntryWithProperties(functionalRequirementsEntryArguments);
                    }
                    else if (xmlStreamReader.getLocalName().equals("NonFunctionalRequirementsEntry")){
                        ArrayList<String> nonFunctionalRequirementsEntryArguments = new ArrayList<>();
                        nonFunctionalRequirementsEntryArguments.add(xmlStreamReader.getAttributeValue(0));
                        nonFunctionalRequirementsEntryArguments.add(xmlStreamReader.getAttributeValue(1));
                        nonFunctionalRequirements.addEntryWithProperties(nonFunctionalRequirementsEntryArguments);
                    }
                    else if (xmlStreamReader.getLocalName().equals("QualityRequirementsEntry")){
                        if (!xmlStreamReader.getAttributeValue(0).equals("null"))
                        {
                            int qualityRequirementsEntryPriorityInteger = Integer.parseInt(xmlStreamReader.getAttributeValue(0));
                            I_QualityRequirementEntry.Priority qualityRequirementsEntryPriority = I_QualityRequirementEntry.Priority.values()[qualityRequirementsEntryPriorityInteger];
                            qualityRequirements.get(qualityRequirmentsCounter).setPriority(qualityRequirementsEntryPriority);
                        }
                        qualityRequirmentsCounter++;
                    }
                    else if (xmlStreamReader.getLocalName().equals("CommentEntry")){
                        ArrayList<String> commentEntryArguments = new ArrayList<>();
                        commentEntryArguments.add(xmlStreamReader.getAttributeValue(0));
                        commentEntryArguments.add(xmlStreamReader.getAttributeValue(1));
                        comments.addEntryWithProperties(commentEntryArguments);
                    }
                    else if (xmlStreamReader.getLocalName().equals("GlossaryEntry"))
                    {
                        ArrayList<String> glossaryEntryArguments = new ArrayList<>();
                        glossaryEntryArguments.add(xmlStreamReader.getAttributeValue(0));
                        glossaryEntryArguments.add(xmlStreamReader.getAttributeValue(1));
                        glossary.addEntryWithProperties(glossaryEntryArguments);
                    }
                }

                event = xmlStreamReader.next();
            }

            System.out.println("XML-Import erfolgreich abgeschlossen");

        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println(e);
        }
    }

    public static void removeAllExistingData(){
        I_Project project = Project.getInstance();
        I_ProjectData projectData = project.getProjectData();
        I_ProjectEditor projectEditor = projectData.getProjectEditor();
        I_Customer customer = projectData.getCustomer();
        I_Analysis stateAnalysis = project.getStateAnalysis();
        I_Analysis futureAnalysis = project.getFutureAnalysis();
        I_Requirements requirements = project.getRequirements();
        I_Glossary glossary = project.getGlossary();

        //<editor-fold desc="Project Members löschen">
        project.setFileLocation("");
        project.setName("");
        //</editor-fold>

        //<editor-fold desc="ProjectData Members löschen">
        projectData.setName("");
        projectData.setDueDate("");
        projectEditor.setSurname("");
        projectEditor.setName("");
        customer.setSurname("");
        customer.setName("");
        customer.setTelephone("");
        customer.setEmail("");
        customer.setCompanyName("");
        customer.setCompanyStreet("");
        customer.setCompanyPLZ("");
        customer.setCompanyLocation("");
        //</editor-fold>

        //<editor-fold desc="StateAnalysis Einträge löschen">
        stateAnalysis.getEntries().clear();
        //</editor-fold>

        //<editor-fold desc="FutureAnalysis Einträge löschen">
        futureAnalysis.getEntries().clear();
        //</editor-fold>

        //<editor-fold desc="Requirements Einträge löschen">
        requirements.setFieldOfApplication("");
        requirements.setProjectGoal("");
        requirements.getFunctionalRequirements().getEntries().clear();
        requirements.getNonFunctionalRequirements().getEntries().clear();
        requirements.getComments().getEntries().clear();
        //</editor-fold>

        //<editor-fold desc="Glossary Members löschen">
        glossary.getEntries().clear();
        //</editor-fold>
    }

    private static ArrayList<String> getProjectProperties()
    {
        // Alle Properties der Klasse "Project" hinzufügen
        ArrayList<String> currentProjectProperties;
        currentProjectProperties = Project.getInstance().getAllProperties();
        return currentProjectProperties;
    }

    private static ArrayList<String> getProjectDataProperties()
    {
        //<editor-fold desc="Alle Properties der Klasse "ProjectData" hinzufügen">
        ArrayList<String> projectDataProperties = new ArrayList<>();
        I_ProjectData currentProjectData = Project.getInstance().getProjectData();
        projectDataProperties.addAll(currentProjectData.getAllProperties());

        projectDataProperties.addAll(currentProjectData.getProjectEditor().getAllProperties());

        projectDataProperties.addAll(currentProjectData.getCustomer().getAllProperties());
        return projectDataProperties;
        //</editor-fold>
    }

    private static ArrayList<String> getStateAnalysisProperties()
    {
        //<editor-fold desc="Alle Properties der Klasse "StateAnalysis" hinzufügen">
        ArrayList<String> stateAnalysisProperties = new ArrayList<>();
        I_Analysis currentStateAnalysis = Project.getInstance().getStateAnalysis();
        for(I_AnalysisEntry currentEntry : currentStateAnalysis.getEntries())
        {
            stateAnalysisProperties.addAll(currentEntry.getAllProperties());
        }
        return stateAnalysisProperties;
        //</editor-fold>
    }

    private static ArrayList<String> getFutureAnalysisProperties()
    {
        //<editor-fold desc="Alle Properties der Klasse "FutureAnalysis" hinzufügen">
        ArrayList<String> futureAnalysisProperties = new ArrayList<>();
        I_Analysis currentFutureAnalysis = Project.getInstance().getFutureAnalysis();
        for(I_AnalysisEntry currentEntry : currentFutureAnalysis.getEntries())
        {
            futureAnalysisProperties.addAll(currentEntry.getAllProperties());
        }
        return futureAnalysisProperties;
        //</editor-fold>
    }

    private static ArrayList<ArrayList<String>> getRequirementsProperties()
    {
        //<editor-fold desc="Alle Properties der Klasse "Requirements" hinzufügen">
        ArrayList<ArrayList<String>> requirementsProperties = new ArrayList<>();

        ArrayList<String> requirementProperties = new ArrayList<>();
        I_Requirements currentRequirements = Project.getInstance().getRequirements();
        requirementProperties.addAll(currentRequirements.getAllProperties());
        requirementsProperties.add(requirementProperties);

        ArrayList<String> functionalRequirements = new ArrayList<>();
        for(I_FunctionalRequirementEntry currentEntry : currentRequirements.getFunctionalRequirements().getEntries())
        {
            functionalRequirements.addAll(currentEntry.getAllProperties());
        }
        requirementsProperties.add(functionalRequirements);

        ArrayList<String> nonFunctionalRequirements = new ArrayList<>();
        for(I_NonFunctionalRequirementEntry currentEntry : currentRequirements.getNonFunctionalRequirements().getEntries())
        {
            nonFunctionalRequirements.addAll(currentEntry.getAllProperties());
        }
        requirementsProperties.add(nonFunctionalRequirements);

        ArrayList<String> qualityRequirements = new ArrayList<>();
        for(I_QualityRequirementEntry currentEntry : currentRequirements.getQualityRequirementEntries())
        {
            if (currentEntry.getPriority() != null) {
                qualityRequirements.add(Integer.toString(currentEntry.getPriority().ordinal()));
            }
            else {
                qualityRequirements.add("null");
            }

        }
        requirementsProperties.add(qualityRequirements);

        ArrayList<String> comments = new ArrayList<>();
        for(I_CommentEntry currentComment : currentRequirements.getComments().getEntries())
        {
            comments.addAll(currentComment.getAllProperties());
        }
        requirementsProperties.add(comments);

        return requirementsProperties;
        //</editor-fold>
    }

    // TODO: Interface für Aufwandsschätzung einbinden

    private static ArrayList<String> getGlossaryProperties()
    {
        //<editor-fold desc="Alle Properties der Klasse "Glossary" hinzufügen"">
        ArrayList<String> glossaryProperties = new ArrayList<>();
        I_Glossary currentGlossary = Project.getInstance().getGlossary();
        for(I_GlossaryEntry currentEntry : currentGlossary.getEntries())
        {
            glossaryProperties.addAll(currentEntry.getAllProperties());
        }
        return glossaryProperties;
        //</editor-fold>
    }
}
