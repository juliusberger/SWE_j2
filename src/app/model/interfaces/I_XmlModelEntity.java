package app.model.interfaces;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Repräsentiert ein exportierbares Model. Wird von {@link app.components.importExport.I_XmlImporter} und {@link app.components.importExport.I_XmlExporter} benutzt.
 */
public interface I_XmlModelEntity extends I_ModelPropertyAdaptor {
    /**
     * @return Gibt die String Repräsentation des später in der XML-Datei zu stehenden Tags zurück. Für Import und Export benoetigt.
     */
    String getTag();

    /**
     * @return Liefert alle in der Klasse gehaltenen Kind-Models, die dann beim Import/Export rekursiv durchlaufen werden. s. {@link app.components.importExport.I_XmlImporter} und {@link app.components.importExport.I_XmlExporter}
     */
    @Nullable
    List<I_XmlModelEntity> getChildren();

    /**
     * s. Factory-Methode aus {@link I_ObservableDataAdaptor#addEntryWithProperties(ArrayList)}
     *
     * @param properties s. {@link I_ObservableDataAdaptor#addEntryWithProperties(ArrayList)}
     */
    void addEntryWithProperties(ArrayList<String> properties);
}
