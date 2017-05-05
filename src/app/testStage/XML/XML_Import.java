package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Created by Michi on 21.04.2017.
 * realized with Java StAX Pattern
 */
public class XML_Import
{

    public static List<Player> parseXML(String fileName) {
        List<Player> players = new ArrayList<>();
        Player plr = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try
        {
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
            int event = xmlStreamReader.getEventType();
            while(true){
                switch(event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if(xmlStreamReader.getLocalName().equals("Player")){
                            plr = new Player();
                            plr.setId(Integer.parseInt(xmlStreamReader.getAttributeValue(0)));
                            plr.setName(xmlStreamReader.getAttributeValue(1));
                            plr.setPosition(xmlStreamReader.getAttributeValue(2));
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
}

