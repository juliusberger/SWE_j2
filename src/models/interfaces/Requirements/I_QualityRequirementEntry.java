package models.interfaces.Requirements;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_QualityRequirementEntry {
    Priority getPriority();

    void setPriority(Priority priority);

    void setPriority(int priority);

    enum Priority {
        HIGH, MEDIUM, LOW, IRRELEVANT
    }
}
