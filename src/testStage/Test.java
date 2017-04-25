package testStage;

import models.Analysis.AnalysisEntry;
import models.Analysis.StateAnalysis;
import models.Requirements.CommentEntry;
import models.Requirements.Requirements;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Test {
    public static void write(Requirements f,
                             String filename) throws Exception {
        XMLEncoder encoder =
                new XMLEncoder(
                        new BufferedOutputStream(
                                new FileOutputStream(filename)));
        encoder.writeObject(f);
        encoder.close();
    }

    public static Requirements read(String filename) throws Exception {
        XMLDecoder decoder =
                new XMLDecoder(new BufferedInputStream(
                        new FileInputStream(filename)));
        Requirements o = (Requirements) decoder.readObject();
        decoder.close();
        return o;
    }

    public static void main(String[] args) {
        Requirements a = new Requirements("test1",
                "test2");

        a.getComments()
                .getEntries()
                .add(new CommentEntry("te",
                        "st"));

        try {
            write(a,
                    "foo.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*Requirements b;
        try {
            b = read("foo.xml");
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


    }
}
