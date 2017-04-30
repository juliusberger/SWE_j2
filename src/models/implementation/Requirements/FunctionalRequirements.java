package models.implementation.Requirements;

import models.implementation.ObservableEntryHolder;
import models.interfaces.Requirements.I_FunctionalRequirementEntry;
import models.interfaces.Requirements.I_FunctionalRequirements;

/**
 * Created by Michi on 23.04.2017.
 */
class FunctionalRequirements extends ObservableEntryHolder<I_FunctionalRequirementEntry> implements I_FunctionalRequirements {
    @Override
    public I_FunctionalRequirementEntry createEntry() {
        return new FunctionalRequirementEntry();
    }
}
