package app.model.implementation.CostEstimation;

import app.model.interfaces.CostEstimation.I_ClassificationEntry;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthias on 24.06.2017.
 */
public class ClassificationEntry implements I_ClassificationEntry {
    private final SimpleStringProperty _function = new SimpleStringProperty("");
    private final SimpleStringProperty _description = new SimpleStringProperty("");
    private final SimpleStringProperty _stakeholder = new SimpleStringProperty("");
    private final SimpleStringProperty _category = new SimpleStringProperty("");
    private final SimpleStringProperty _classification = new SimpleStringProperty("");

    public ClassificationEntry() {
    }

    @Override
    public String getFunction() {
        return _function.get();
    }

    @Override
    public void setFunction(String function) {
        _function.set(function);
    }

    @Override
    public SimpleStringProperty functionProperty() {
        return _function;
    }

    @Override
    public String getStakeholder() {
        return _stakeholder.get();
    }

    @Override
    public void setStakeholder(String stakeholder) {
        _stakeholder.set(stakeholder);
    }

    @Override
    public SimpleStringProperty stakeholderProperty() {
        return _stakeholder;
    }

    @Override
    public String getWeight() {
        return null;
    }

    @Override
    public void setWeight(String weight) {

    }

    @Override
    public SimpleStringProperty getWeightProperty() {
        return null;
    }

    @Override
    public String getDescription() {
        return _description.get();
    }

    @Override
    public void setDescription(String description) {
        _description.set(description);
    }

    @Override
    public SimpleStringProperty descriptionProperty() {
        return _description;
    }

    @Override
    public String getCategory() {
        return _category.get();
    }

    @Override
    public void setCategory(String category) {
        _category.set(category);
    }

    @Override
    public SimpleStringProperty categoryProperty() {
        return _category;
    }

    @Override
    public String getClassification() {
        return _classification.get();
    }

    @Override
    public void setClassification(String classification) {
        _classification.set(classification);
    }

    @Override
    public SimpleStringProperty classificationProperty() {
        return _classification;
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return null;
    }

    @Override
    public void addEntryWithProperties(ArrayList<String> properties) {

    }

    @Override
    public String getTag() {
        return "ClassificationEntry";
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(getFunction());
        stringProperties.add(getDescription());
        stringProperties.add(getStakeholder());
        stringProperties.add(getCategory());
        stringProperties.add(getClassification());

        return stringProperties;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            setFunction(propertyStrings.get(0));
            setDescription(propertyStrings.get(1));
            setStakeholder(propertyStrings.get(2));
            setCategory(propertyStrings.get(3));
            setClassification(propertyStrings.get(4));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

}
