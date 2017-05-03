package testStage.XML;

import helpers.XML;
import models.implementation.Project;
import models.interfaces.Glossary.I_Glossary;
import models.interfaces.I_Project;
import models.interfaces.ProjectData.I_Customer;
import models.interfaces.ProjectData.I_ProjectData;
import models.interfaces.ProjectData.I_ProjectEditor;
import models.interfaces.Requirements.*;
import models.implementation.Project;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
    /*

    // write your code here
    String fileName = "C:/Users/Michi/Desktop/Temp/Test.xml";
    com.company.XML_Export.exportXML(fileName);

    List<com.company.Player> players = com.company.XML_Import.parseXML(fileName);
    for(com.company.Player plr : players){
        System.out.println(plr.toString());
    }

    */

        I_Project project = Project.getInstance();
        I_ProjectData projectData = Project.getInstance().getProjectData();
        I_ProjectEditor projectEditor = projectData.getProjectEditor();
        I_Customer customer = projectData.getCustomer();
        I_Requirements requirements = Project.getInstance().getRequirements();
        I_FunctionalRequirements functionalRequirements = requirements.getFunctionalRequirements();
        I_NonFunctionalRequirements nonFunctionalRequirements = requirements.getNonFunctionalRequirements();
        List<I_QualityRequirementEntry> qualityRequirements = requirements.getQualityRequirementEntries();
        I_Comments comments = requirements.getComments();
        I_Glossary glossar = project.getGlossary();

        project.setName("Testprojekt1");
        project.setFileLocation("C:/Users/Michi/Desktop/Temp/");

        projectData.setDueDate("01.01.1970");
        projectData.setName("Musterprojekt");

        projectEditor.setName("John");
        projectEditor.setSurname("Doe");

        customer.setCompanyLocation("Musterstadt");
        customer.setCompanyName("Mustermann GmbH & Co. KG");
        customer.setCompanyPLZ("12345");
        customer.setCompanyStreet("Musterstraße");
        customer.setEmail("max@mustermann.de");
        customer.setName("Max");
        customer.setSurname("Mustermann");
        customer.setTelephone("12345 123456789");

        requirements.setFieldOfApplication("Testgebiet");
        requirements.setProjectGoal("Alles Testen, was man testen kann");

        ArrayList<String> func1 = new ArrayList<String>();
        func1.add("Funktion 1");
        func1.add("Das ist Test Nr. 1");
        func1.add("Teststakeholder");
        functionalRequirements.addEntryWithProperties(func1);
        ArrayList<String> func2 = new ArrayList<String>();
        func2.add("Funktion 2");
        func2.add("Das ist Test Nr. 2");
        func2.add("Teststakeholder");
        functionalRequirements.addEntryWithProperties(func2);
        ArrayList<String> func3 = new ArrayList<String>();
        func3.add("Funktion 3");
        func3.add("Das ist Test Nr. 3");
        func3.add("Teststakeholder");
        functionalRequirements.addEntryWithProperties(func3);

        ArrayList<String> nonFunc1 = new ArrayList<String>();
        nonFunc1.add("NonFunktion 1");
        nonFunc1.add("Das ist Test Nr. 1");
        nonFunctionalRequirements.addEntryWithProperties(nonFunc1);
        ArrayList<String> nonFunc2 = new ArrayList<String>();
        nonFunc2.add("NonFunktion 2");
        nonFunc2.add("Das ist Test Nr. 2");
        nonFunctionalRequirements.addEntryWithProperties(nonFunc2);

        qualityRequirements.get(0).setPriority(I_QualityRequirementEntry.Priority.HIGH);
        qualityRequirements.get(1).setPriority(I_QualityRequirementEntry.Priority.MEDIUM);
        qualityRequirements.get(2).setPriority(I_QualityRequirementEntry.Priority.LOW);
        qualityRequirements.get(3).setPriority(I_QualityRequirementEntry.Priority.IRRELEVANT);

        ArrayList<String> comment1 = new ArrayList<String>();
        comment1.add("Kommentar 1");
        comment1.add("Das ist Test Nr. 1");
        comments.addEntryWithProperties(comment1);
        ArrayList<String> comment2 = new ArrayList<String>();
        comment2.add("Kommentar 2");
        comment2.add("Das ist Test Nr. 2");
        comments.addEntryWithProperties(comment2);
        ArrayList<String> comment3 = new ArrayList<String>();
        comment3.add("Kommentar 3");
        comment3.add("Das ist Test Nr. 3");
        comments.addEntryWithProperties(comment3);

        ArrayList<String> glossary1 = new ArrayList<String>();
        glossary1.add("Glossareintrag 1");
        glossary1.add("Das ist Test Nr. 1");
        glossar.addEntryWithProperties(glossary1);
        ArrayList<String> glossary2 = new ArrayList<String>();
        glossary2.add("Glossareintrag 2");
        glossary2.add("Das ist Test Nr. 2");
        glossar.addEntryWithProperties(glossary2);

        XML.exportXML("C:/Users/Michi/Desktop/Temp/Test_Auto1.xml");

    }
}
