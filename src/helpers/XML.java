package helpers;

import models.implementation.Project;
import models.interfaces.Analysis.I_Analysis;
import models.interfaces.Analysis.I_AnalysisEntry;
import models.interfaces.Glossary.I_Glossary;
import models.interfaces.Glossary.I_GlossaryEntry;
import models.interfaces.ProjectData.I_ProjectData;
import models.interfaces.ProjectData.I_ProjectEditor;
import models.interfaces.Requirements.*;

import java.util.ArrayList;

/**
 * Created by Michi on 01.05.2017.
 */
public class XML
{
    public static void exportXML()
    {
        ArrayList<String> allProperties = getAllProperties();
        int i = 5;
    }

    public static void importXML()
    {

    }

    private static ArrayList<String> getAllProperties()
    {
        ArrayList<String> allProjectProperties = new ArrayList<String>();

        // Alle Properties der Klasse "Project" hinzufügen
        allProjectProperties = Project.getInstance().getAllProperties();



        //<editor-fold desc="Alle Properties der Klasse "ProjectData" hinzufügen">
        I_ProjectData currentProjectData = Project.getInstance().getProjectData();
        for(String projectDataProperty : currentProjectData.getAllProperties())
        {
            allProjectProperties.add(projectDataProperty);
        }

        for(String projectEditorProperty : currentProjectData.getProjectEditor().getAllProperties())
        {
            allProjectProperties.add(projectEditorProperty);
        }

        for(String projectCustomerProperty : currentProjectData.getCustomer().getAllProperties())
        {
            allProjectProperties.add(projectCustomerProperty);
        }
        //</editor-fold>


        //<editor-fold desc="Alle Properties der Klasse "StateAnalysis" hinzufügen">
        I_Analysis currentStateAnalysis = Project.getInstance().getStateAnalysis();
        for(I_AnalysisEntry currentEntry : currentStateAnalysis.getEntries())
        {
            for(String stateAnalysisProperty : currentEntry.getAllProperties())
            {
                allProjectProperties.add(stateAnalysisProperty);
            }
        }
        //</editor-fold>

        //<editor-fold desc="Alle Properties der Klasse "FutureAnalysis" hinzufügen">
        I_Analysis currentFutureAnalysis = Project.getInstance().getFutureAnalysis();
        for(I_AnalysisEntry currentEntry : currentFutureAnalysis.getEntries())
        {
            for(String futureAnalysisProperty : currentEntry.getAllProperties())
            {
                allProjectProperties.add(futureAnalysisProperty);
            }
        }
        //</editor-fold>

        //<editor-fold desc="Alle Properties der Klasse "Requirements" hinzufügen">
        I_Requirements currentRequirements = Project.getInstance().getRequirements();
        for(String requirementsProperty : currentRequirements.getAllProperties())
        {
            allProjectProperties.add(requirementsProperty);
        }

        for(I_FunctionalRequirementEntry currentEntry : currentRequirements.getFunctionalRequirements().getEntries())
        {
            for(String functionalRequirementProperty : currentEntry.getAllProperties())
            {
                allProjectProperties.add(functionalRequirementProperty);
            }
        }

        for(I_NonFunctionalRequirementEntry currentEntry : currentRequirements.getNonFunctionalRequirements().getEntries())
        {
            for(String nonFunctionalRequirementProperty : currentEntry.getAllProperties())
            {
                allProjectProperties.add(nonFunctionalRequirementProperty);
            }
        }

        for(I_QualityRequirementEntry currentEntry : currentRequirements.getQualityRequirementEntries())
        {
            if (currentEntry.getPriority() != null) {
                allProjectProperties.add(currentEntry.getPriority().toString());
            }
            else {
                allProjectProperties.add("null");
            }

        }
        //</editor-fold>

        // TODO: Interface für Aufwandsschätzung einbinden

        //<editor-fold desc="Alle Properties der Klasse "Glossary" hinzufügen"">
        I_Glossary currentGlossary = Project.getInstance().getGlossary();
        for(I_GlossaryEntry currentEntry : currentGlossary.getEntries())
        {
            for(String glossaryProperty : currentEntry.getAllProperties())
            {
                allProjectProperties.add(glossaryProperty);
            }
        }
        //</editor-fold>

        return allProjectProperties;
    }
}
