package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    String fileName = "C:/Users/Michi/Desktop/Temp/Test.xml";
    XML_Export.exportXML(fileName);

    List<Player> players = XML_Import.parseXML(fileName);
    for(Player plr : players){
        System.out.println(plr.toString());
    }
    }
}
