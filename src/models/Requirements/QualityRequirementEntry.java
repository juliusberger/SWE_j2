package models.Requirements;

/**
 * Created by Michi on 23.04.2017.
 */
public class QualityRequirementEntry {
    // TODO: name erforderlich?
    private Priority priority;

    public enum Priority {
        HIGH, MEDIUM, LOW, IRRELEVANT
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
