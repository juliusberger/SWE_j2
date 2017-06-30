package app.model.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julius on 25.06.17.
 */
public interface I_XmlModelEntity extends I_ModelPropertyAdaptor {
    String getTag();
    List<I_XmlModelEntity> getChildren();
    void addEntryWithProperties(ArrayList<String> properties);
}
