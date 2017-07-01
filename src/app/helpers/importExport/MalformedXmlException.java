package app.helpers.importExport;

/**
 * Diese Exception ist bei nicht wohl geformten XML-Strukturen zu verwenden, z.B. falls die zu verarbeitende Datei eine nicht valide Struktur enthält (also nicht durch ANTool exportiert, oder nachträglich verändert wurde).
 */
class MalformedXmlException extends Exception {
    MalformedXmlException() {
        super();
    }

    public MalformedXmlException(String msg) {
        super(msg);
    }
}
