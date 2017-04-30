package models.Requirements;

/**
 * Created by Michi on 23.04.2017.
 */
class QualityRequirementEntry implements I_QualityRequirementEntry {
    private Priority _priority;

    @Override
    public Priority getPriority() {
        return this._priority;
    }

    @Override
    public void setPriority(Priority priority) {
        this._priority = priority;
    }
}
