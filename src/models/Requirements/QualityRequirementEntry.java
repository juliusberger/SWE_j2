package models.Requirements;

/**
 * Created by Michi on 23.04.2017.
 */
public class QualityRequirementEntry implements I_QualityRequirementEntry {
    // TODO: name erforderlich?
    private Priority priority;

    @Override
    public Priority getPriority() {
        return this.priority;
    }

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
