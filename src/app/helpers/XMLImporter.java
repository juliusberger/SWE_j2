package app.helpers;

import app.models.implementation.Project;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Michi on 03.06.2017.
 */
public class XMLImporter {
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    private String fileName = "";

    public XMLImporter(String fileName) {
        this.fileName = fileName;
    }

    /*public void importFromXML()
    {
        try {
            XMLStreamReader xmlReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));

            //TODO: RemoveAllExisitingData

            int event = xmlReader.getEventType();
            while (xmlReader.hasNext()) {
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (xmlReader.getLocalName().equals("ProjectProperties")) {
                        Project.getInstance().importFromXML(xmlReader);
                    } else if (xmlReader.getLocalName().equals("ProjectDataProperties")){
                        Project.getInstance().getProjectData().importFromXML(xmlReader);
                    }
                    else if (xmlReader.getLocalName().equals("Customer")){
                        Project.getInstance().getProjectData().getCustomer().importFromXML(xmlReader);
                    }
                    else if (xmlReader.getLocalName().equals("ProjectEditor")){
                        Project.getInstance().getProjectData().getProjectEditor().importFromXML(xmlReader);
                    }
                    else if (xmlReader.getLocalName().equals("StateAnalysisEntry")){
                        //Project.getInstance().getStateAnalysis().importFromXML(xmlReader);
                    }
                    else if (xmlReader.getLocalName().equals("FutureAnalysisEntry")){
                        //Project.getInstance().getFutureAnalysis().importFromXML(xmlReader);
                    }
                    else if (xmlReader.getLocalName().equals("RequirementsProperties")){
                        Project.getInstance().getRequirements().importFromXML(xmlReader);
                    }
                    else if (xmlReader.getLocalName().equals("FunctionalRequirementsEntry")){
                        Project.getInstance().getRequirements().getFunctionalRequirements().importFromXML(xmlReader);
                    }
                    else if (xmlReader.getLocalName().equals("NonFunctionalRequirementsEntry")){
                        Project.getInstance().getRequirements().getNonFunctionalRequirements().importFromXML(xmlReader);
                    }
                    else if (xmlReader.getLocalName().equals("QualityRequirementsEntry")){
                        //TODO: Vorgang für Import der QualityRequirements überlegen
                    }
                    else if (xmlReader.getLocalName().equals("CommentEntry")){
                        Project.getInstance().getRequirements().getComments().importFromXML(xmlReader);
                    }
                    else if (xmlReader.getLocalName().equals("GlossaryEntry")){
                        Project.getInstance().getGlossary().importFromXML(xmlReader);
                    }
                    //TODO: CostEstimation
                }

                event = xmlReader.next();
            }

            System.out.println("XML-Datei erfolgreich eingelesen");
            LogWriter.writeLog("XML-Export wurde erfolgreich eingelesen. Pfad zur Datei: " + fileName);
            InfoDialog dialog = new InfoDialog("XML-Import erfolgreich",
                    "XML-Import erfolgreich abgeschlossen");
        }
        catch (FileNotFoundException ex)
        {
            LogWriter.writeLog("XML-Import nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + ex.getMessage());
            InfoDialog dialog = new InfoDialog("XML-Import nicht erfolgreich",
                    "XML-Import nicht erfolgreich abgeschlossen. Folgender Fehler trat auf:\n" + ex.getMessage());
        }
        catch (XMLStreamException ex)
        {
            LogWriter.writeLog("XML-Import nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + ex.getMessage());
            InfoDialog dialog = new InfoDialog("XML-Import nicht erfolgreich",
                    "XML-Import nicht erfolgreich abgeschlossen. Folgender Fehler trat auf:\n" + ex.getMessage());
        }
    }*/
}
