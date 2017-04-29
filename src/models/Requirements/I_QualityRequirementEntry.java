package models.Requirements;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_QualityRequirementEntry {
    Priority getPriority();

    void setPriority(Priority priority);

    enum Priority {
        HIGH, MEDIUM, LOW, IRRELEVANT
    }
}
