package app.models.implementation.CostEstimation;

import app.models.interfaces.CostEstimation.I_ClassificationEntry;
import app.models.interfaces.I_XmlModelEntity;
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
        return this._function.get();
    }

    @Override
    public SimpleStringProperty functionProperty() {
        return this._function;
    }

    @Override
    public void setFunction(String function) {
        this._function.set(function);
    }

    @Override
    public String getStakeholder() {
        return this._stakeholder.get();
    }

    @Override
    public SimpleStringProperty stakeholderProperty() {
        return this._stakeholder;
    }

    @Override
    public void setStakeholder(String stakeholder) {
        this._stakeholder.set(stakeholder);
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
        return this._description.get();
    }

    @Override
    public SimpleStringProperty descriptionProperty() {
        return this._description;
    }

    @Override
    public void setDescription(String description) {
        this._description.set(description);
    }

    @Override
    public String getCategory() {
        return this._category.get();
    }

    @Override
    public SimpleStringProperty categoryProperty() {
        return this._category;
    }

    @Override
    public void setCategory(String category) {
        this._category.set(category);
    }

    @Override
    public String getClassification() {
        return this._classification.get();
    }

    @Override
    public SimpleStringProperty classificationProperty() {
        return this._classification;
    }

    @Override
    public void setClassification(String classification) {
        this._classification.set(classification);
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return null;
    }

    @Override
    public String getTag() {
        return "ClassificationEntry";
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            this.setFunction(propertyStrings.get(0));
            this.setDescription(propertyStrings.get(1));
            this.setStakeholder(propertyStrings.get(2));
            this.setCategory(propertyStrings.get(3));
            this.setClassification(propertyStrings.get(4));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(this.getFunction());
        stringProperties.add(this.getDescription());
        stringProperties.add(this.getStakeholder());
        stringProperties.add(this.getCategory());
        stringProperties.add(this.getClassification());

        return stringProperties;
    }
}
