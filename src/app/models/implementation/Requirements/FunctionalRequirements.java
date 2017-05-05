package app.models.implementation.Requirements;

import app.models.implementation.ObservableEntryHolder;
import app.models.interfaces.Requirements.I_FunctionalRequirementEntry;
import app.models.interfaces.Requirements.I_FunctionalRequirements;

/**
 * Created by Michi on 23.04.2017.
 */
class FunctionalRequirements extends ObservableEntryHolder<I_FunctionalRequirementEntry> implements I_FunctionalRequirements {
    @Override
    public I_FunctionalRequirementEntry createEntry() {
        return new FunctionalRequirementEntry();
    }
}
