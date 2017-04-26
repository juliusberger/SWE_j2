package com.company;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Michi on 21.04.2017.
 * realized with Java StAX Pattern
 */
public class XML_Export {

    public static void exportXML(String fileName)
    {
        try
        {
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter( new FileOutputStream(fileName));

            // Der XML-Header wird erzeugt
            writer.writeStartDocument();
            // Zuerst wird das Wurzelelement mit Attribut geschrieben
            writer.writeStartElement( "Players" );
            // Unter dieses Element das Element gast mit einem Attribut erzeugen
            writer.writeStartElement("Player");
            writer.writeAttribute( "id", "1" );
            writer.writeAttribute("name", "Manuel Neuer");
            writer.writeAttribute("position", "Goalkeeper");
            writer.writeEndElement();

            writer.writeStartElement("Player");
            writer.writeAttribute( "id", "2" );
            writer.writeAttribute("name", "Thomas Müller");
            writer.writeAttribute("position", "Midfielder");
            writer.writeEndElement();

            writer.writeStartElement("Player");
            writer.writeAttribute( "id", "3" );
            writer.writeAttribute("name", "Arjen Robben");
            writer.writeAttribute("position", "Midfielder");
            writer.writeEndElement();

            writer.writeEndElement(); //Ende

            writer.writeEndDocument();
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }
}
