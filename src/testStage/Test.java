package testStage;

import models.Requirements.CommentEntry;
import models.Requirements.I_Requirements;
import models.Requirements.Requirements;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Test {
    public static void write(I_Requirements f,
                             String filename) throws Exception {
        XMLEncoder encoder =
                new XMLEncoder(
                        new BufferedOutputStream(
                                new FileOutputStream(filename)));
        encoder.writeObject(f);
        encoder.close();
    }

    public static I_Requirements read(String filename) throws Exception {
        XMLDecoder decoder =
                new XMLDecoder(new BufferedInputStream(
                        new FileInputStream(filename)));
        I_Requirements o = (I_Requirements) decoder.readObject();
        decoder.close();
        return o;
    }

    public static void main(String[] args) {
        I_Requirements a = new Requirements("test1",
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
