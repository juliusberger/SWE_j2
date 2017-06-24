package app.model.interfaces;

import java.util.List;

/**
 * Created by Julius on 18.06.17.
 */
public interface I_XmlModelEntity extends I_ModelPropertyAdaptor {
    List<I_XmlModelEntity> getChildren();
    String getTag();
}
