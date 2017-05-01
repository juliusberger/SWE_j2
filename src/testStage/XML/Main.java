package testStage.XML;

import helpers.XML;
import models.implementation.Project;

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
        Project.getInstance().setName("Testprojekt");
        XML.exportXML("C:/Users/Michi/Desktop/Temp/Test.xml");

    }
}
