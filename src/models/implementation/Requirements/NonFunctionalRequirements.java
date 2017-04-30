package models.implementation.Requirements;

import models.implementation.ObservableEntryHolder;
import models.interfaces.Requirements.I_NonFunctionalRequirementEntry;
import models.interfaces.Requirements.I_NonFunctionalRequirements;

/**
 * Created by Michi on 23.04.2017.
 */
class NonFunctionalRequirements extends ObservableEntryHolder<I_NonFunctionalRequirementEntry> implements I_NonFunctionalRequirements {
    @Override
    public I_NonFunctionalRequirementEntry createEntry() {
        return new NonFunctionalRequirementEntry();
    }
}
