package app.models.implementation.Requirements;

import app.models.implementation.ObservableEntryHolder;
import app.models.interfaces.Requirements.I_NonFunctionalRequirementEntry;
import app.models.interfaces.Requirements.I_NonFunctionalRequirements;

/**
 * Created by Michi on 23.04.2017.
 */
class NonFunctionalRequirements extends ObservableEntryHolder<I_NonFunctionalRequirementEntry> implements I_NonFunctionalRequirements {
    @Override
    public I_NonFunctionalRequirementEntry createEntry() {
        return new NonFunctionalRequirementEntry();
    }
}
