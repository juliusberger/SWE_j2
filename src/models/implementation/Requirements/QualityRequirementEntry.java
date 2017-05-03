package models.implementation.Requirements;

import models.interfaces.Requirements.I_QualityRequirementEntry;

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

    @Override
    public void setPriority(int priority)
    {
        switch (priority){
            case 0:
                this._priority = Priority.IRRELEVANT;
                break;
            case 1:
                this._priority = Priority.LOW;
                break;
            case 2:
                this._priority = Priority.MEDIUM;
                break;
            case 3:
                this._priority = Priority.HIGH;
                break;
        }
    }
}
